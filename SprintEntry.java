package com.stir.cscu9t4practical1;

public class SprintEntry extends Entry {
	
	public int recovSec;
	public int numRuns;
	public SprintEntry(String n, int d, int m, int y, int h, int min, int s, float dist, int runs, int recov) {
		super(n, d, m, y, h, min, s, dist);
		numRuns = runs;
		recovSec = recov;
	}
	
	public int getRepetitions() {
		return numRuns;
	}
	
	public int getRecovery() {
		return recovSec;
	}

	public String getEntry () {
		   String result = getName()+" sprinted " + getRepetitions() + "x" + getDistance() + "m in "
		             +getHour()+":"+getMin()+":"+ getSec() + " with " + getRecovery() + " minutes recovery" + " on "
		             +getDay()+"/"+getMonth()+"/"+getYear()+ "\n";
		   return result;
		  } //getEntry
}
