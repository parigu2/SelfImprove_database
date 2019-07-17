package com.example.database.beans;

import java.util.List;

public class ResultTable {

	private int id;
	private String name;
	private List<GoalAndTimeSheets> details;
	
	public ResultTable() {
	}
	
	public ResultTable(int id, String name, List<GoalAndTimeSheets> details) {
		super();
		this.id = id;
		this.name = name;
		this.details = details;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<GoalAndTimeSheets> getDetails() {
		return details;
	}

	public void setDetails(List<GoalAndTimeSheets> details) {
		this.details = details;
	}
}
