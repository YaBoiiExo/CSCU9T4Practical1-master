// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;




import java.util.*;


public class TrainingRecord {
    List<Entry> tr;
    
    public TrainingRecord() {
        tr = new ArrayList<Entry>();
    } //constructor
    
    // add a record to the list
   public void addEntry(Entry e){
       for (Entry entry : tr) {
    	   if (entry.getName().equals(e.getName()) && entry.getDay() == e.getDay() && entry.getMonth() == e.getMonth() && entry.getYear() == e.getYear()) {
    		   throw new IllegalArgumentException("Duplicate entry found");
    	   }
       }
	   tr.add(e);    
   } // addClass
   
   public void removeEntry(Entry e) {
	   tr.remove(e);
   }
   // look up the entry of a given day and month
   public String lookupEntry (int d, int m, int y) {
       ListIterator<Entry> iter = tr.listIterator();
       String result = "No entries found.";
       while (iter.hasNext()) {
          Entry current = iter.next();
          if (current.getDay()==d && current.getMonth()==m && current.getYear()==y) 
             result = current.getEntry();
            }
       return result;
   } // lookupEntry
   
   public String lookupEntries (int d, int m, int y) {
	   ListIterator<Entry> iter = tr.listIterator();
	    StringBuilder result = new StringBuilder("Sorry couldn't find anything for this date.");
	    boolean found = false;
	    while (iter.hasNext()) {
	        Entry current = iter.next();
	        if (current.getDay() == d && current.getMonth() == m && current.getYear() == y) {
	            if (!found) {
	                result.setLength(0); // Clear the "Sorry" message if an entry is found
	                found = true;
	            }
	            result.append(current.getEntry());
	        }
	    }
	    if (!found) {
	        result.setLength(0); // Clear the "Sorry" message if no entries are found
	        result.append("Sorry couldn't find anything for this date.");
	    }
	    return result.toString();
   } // find all entries for a certain date
   
   // Count the number of entries
   public int getNumberOfEntries(){
       return tr.size();
   }
   // Clear all entries
   public void clearAllEntries(){
       tr.clear();
   }
} // TrainingRecord