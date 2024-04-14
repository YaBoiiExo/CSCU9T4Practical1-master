package com.stir.cscu9t4practical1;

public class SwimEntry extends Entry {

	public String where;
	public SwimEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String inOut) {
		super(n, d, m, y, h, min, s, dist);
		where = inOut;

	}

	public String getWhere() {
		return where;
	}
	
	public String getEntry () {
		   String result = getName()+" swam " + getDistance() + " km " + getWhere() +" in "
		             +getHour()+":"+getMin()+":"+ getSec() + " on "
		             +getDay()+"/"+getMonth()+"/"+getYear()+"\n";
		   return result;
		  } //getEntry
}
