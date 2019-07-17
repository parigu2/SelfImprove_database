package com.example.database.beans;

public class Period {

	private double start;
	private double end;
	
	public Period() {
	}
	
	public Period(double start, double end) {
		super();
		this.start = start;
		this.end = end;
	}

	public double getStart() {
		return start;
	}

	public void setStart(double start) {
		this.start = start;
	}

	public double getEnd() {
		return end;
	}

	public void setEnd(double end) {
		this.end = end;
	}
}
