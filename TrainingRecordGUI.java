// GUI and main program for the Training Record
package com.stir.cscu9t4practical1;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.AncestorListener;

import java.lang.Number;

public class TrainingRecordGUI extends JFrame implements ActionListener {

    private JTextField name = new JTextField(30);
    private JTextField day = new JTextField(2);
    private JTextField month = new JTextField(2);
    private JTextField year = new JTextField(4);
    private JTextField hours = new JTextField(2);
    private JTextField mins = new JTextField(2);
    private JTextField secs = new JTextField(2);
    private JTextField dist = new JTextField(4);
    // Cyclist stuff
    private JTextField terr = new JTextField(20);
    private JTextField tempo = new JTextField(20);
    // Sprinter stuff
    private JTextField reps = new JTextField(20);
    private JTextField recov = new JTextField(20);
    // Swimmer stuff
    private JTextField where = new JTextField(20);
    
    private JLabel labn = new JLabel(" Name:");
    private JLabel labd = new JLabel(" Day:");
    private JLabel labm = new JLabel(" Month:");
    private JLabel laby = new JLabel(" Year:");
    private JLabel labh = new JLabel(" Hours:");
    private JLabel labmm = new JLabel(" Mins:");
    private JLabel labs = new JLabel(" Secs:");
    private JLabel labdist = new JLabel(" Distance (km):");
    // Extra info fields
    private JLabel labterr = new JLabel(" Terrain:");
    private JLabel labtemp = new JLabel(" Tempo:");
    private JLabel labreps = new JLabel(" Repetitions:");
    private JLabel labrecov = new JLabel(" Recovery:");
    private JLabel labwhere = new JLabel(" Where:");
    
    private JButton addR = new JButton(" Add Generic");
    private JButton lookUpByDate = new JButton(" Look Up");
    private JButton fABD = new JButton(" Find all by date");

    private TrainingRecord myAthletes = new TrainingRecord();

    private JButton addCycle = new JButton(" Add Cyclist");
    private JButton addSprint = new JButton(" Add Sprinter");
    private JButton addSwim = new JButton(" Add Swimmer");
    private JTextArea outputArea = new JTextArea(5, 50);
    private JButton remove = new JButton(" Remove Entry");

    public static void main(String[] args) {
        TrainingRecordGUI applic = new TrainingRecordGUI();
    } // main

    // set up the GUI 
    public TrainingRecordGUI() {
        super("Training Record");
        setLayout(new FlowLayout());
        add(labn);
        add(name);
        name.setEditable(true);
        add(labd);
        add(day);
        day.setEditable(true);
        add(labm);
        add(month);
        month.setEditable(true);
        add(laby);
        add(year);
        year.setEditable(true);
        add(labh);
        add(hours);
        hours.setEditable(true);
        add(labmm);
        add(mins);
        mins.setEditable(true);
        add(labs);
        add(secs);
        secs.setEditable(true);
        add(labdist);
        add(dist);
        dist.setEditable(true);
        add(labterr);
        add(terr);
        terr.setEditable(true);
        add(labtemp);
        add(tempo);
        tempo.setEditable(true);
        add(labreps);
        add(reps);
        reps.setEditable(true);
        add(labrecov);
        add(recov);
        recov.setEditable(true);
        add(labwhere);
        add(where);
        where.setEditable(true);
        add(addR);
        addR.addActionListener(this);
        add(lookUpByDate);
        lookUpByDate.addActionListener(this);
        add(fABD);
        fABD.addActionListener(this);
        add(addCycle);
        addCycle.addActionListener(this);
        add(addSprint);
        addSprint.addActionListener(this);
        add(addSwim);
        addSwim.addActionListener(this);
        add(outputArea);
        outputArea.setEditable(false);
        add(remove);
        remove.addActionListener(this);
        setSize(720, 400);
        setVisible(true);
        blankDisplay();

        // To save typing in new entries while testing, uncomment
        // the following lines (or add your own test cases)
        
    } // constructor

    // listen for and respond to GUI events 
    public void actionPerformed(ActionEvent event) {
        String message = "";
        // Check to see where to add it
        if (event.getSource() == addR) {
            message = addEntry("generic");
        }
        if (event.getSource() == addCycle) {
        	message = addEntry("cyclist");
        }
        if (event.getSource() == addSprint) {
        	message = addEntry("sprinter");
        }
        if (event.getSource() == addSwim) {
        	message = addEntry("swimmer");
        }
        if (event.getSource() == lookUpByDate) {
            message = lookupEntry();
        }
        if (event.getSource() == fABD) {
        	message = lookupFABD();
        }
        if (event.getSource() == remove) {
        	// Get the entry to remove based on user input
            String n = name.getText();
            int m = Integer.parseInt(month.getText());
            int d = Integer.parseInt(day.getText());
            int y = Integer.parseInt(year.getText());
            Entry entryToRemove = findEntry(n, d, m, y);
            
            // Check if entry exists before removing it
            if (entryToRemove != null) {
                myAthletes.removeEntry(entryToRemove);
                message = "Entry removed from record";
            } else {
                message = "Entry not found in record";
            }
        }
        outputArea.setText(message);
        blankDisplay();
    } // actionPerformed

    public String addEntry(String what) {
        String message = "Record added\n";
        System.out.println("Adding "+what+" entry to the records");
        String n = name.getText();
        if(what == "generic") {
	        int m = Integer.parseInt(month.getText());
	        int d = Integer.parseInt(day.getText());
	        int y = Integer.parseInt(year.getText());
	        float km = java.lang.Float.parseFloat(dist.getText());
	        int h = Integer.parseInt(hours.getText());
	        int mm = Integer.parseInt(mins.getText());
	        int s = Integer.parseInt(secs.getText());
	        Entry e = new Entry(n, d, m, y, h, mm, s, km);
	        myAthletes.addEntry(e);
        }
        if(what.equals("cyclist")) {
        	int m = Integer.parseInt(month.getText());
	        int d = Integer.parseInt(day.getText());
	        int y = Integer.parseInt(year.getText());
	        float km = java.lang.Float.parseFloat(dist.getText());
	        int h = Integer.parseInt(hours.getText());
	        int mm = Integer.parseInt(mins.getText());
	        int s = Integer.parseInt(secs.getText());
	        String ter = terr.getText();
	        String temp = tempo.getText();
	        CycleEntry e = new CycleEntry(n, d, m, y, h, mm, s, km, ter, temp);
	        myAthletes.addEntry(e);
        }
        if(what.equals("sprinter")) {
        	int m = Integer.parseInt(month.getText());
	        int d = Integer.parseInt(day.getText());
	        int y = Integer.parseInt(year.getText());
	        float km = java.lang.Float.parseFloat(dist.getText());
	        int h = Integer.parseInt(hours.getText());
	        int mm = Integer.parseInt(mins.getText());
	        int s = Integer.parseInt(secs.getText());
	        int rep = Integer.parseInt(reps.getText());
	        int reco = Integer.parseInt(recov.getText());
	        SprintEntry e = new SprintEntry(n, d, m, y, h, mm, s, km, rep, reco);
	        myAthletes.addEntry(e);
        }
        if(what.equals("swimmer")) {
        	int m = Integer.parseInt(month.getText());
	        int d = Integer.parseInt(day.getText());
	        int y = Integer.parseInt(year.getText());
	        float km = java.lang.Float.parseFloat(dist.getText());
	        int h = Integer.parseInt(hours.getText());
	        int mm = Integer.parseInt(mins.getText());
	        int s = Integer.parseInt(secs.getText());
	        String whe = where.getText();
	        SwimEntry e = new SwimEntry(n, d, m, y, h, mm, s, km, whe);
	        myAthletes.addEntry(e);
        }
	    return message;
    }
    
    private Entry findEntry(String n, int d, int m, int y) {
        for (Entry entry : myAthletes.tr) {
            if (entry.getName().equals(n) && entry.getDay() == d && entry.getMonth() == m && entry.getYear() == y) {
                return entry;
            }
        }
        return null; // Entry not found
    }
    
    public String lookupEntry() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.lookupEntry(d, m, y);
        return message;
    }

    public String lookupFABD() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.lookupEntries(d, m, y);
        return message;
    }
    
    public void blankDisplay() {
        name.setText("");
        day.setText("");
        month.setText("");
        year.setText("");
        hours.setText("");
        mins.setText("");
        secs.setText("");
        dist.setText("");
        terr.setText("");
        tempo.setText("");
        reps.setText("");
        recov.setText("");
        where.setText("");

    }// blankDisplay
    // Fills the input fields on the display for testing purposes only
    public void fillDisplay(Entry ent) {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getDistance()));
    }

} // TrainingRecordGUI

