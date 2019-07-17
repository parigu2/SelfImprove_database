package com.example.database.beans;

import java.util.List;

import com.example.database.model.QuaterTimeSheet;

public class GoalAndTimeSheets {

	private int id;
	private int userId;
	private String goal;
	private double target;
	private List<QuaterTimeSheet> timesheet;
	
	public GoalAndTimeSheets() {
	}
	
	public GoalAndTimeSheets(int id, int userId, String goal, double target, List<QuaterTimeSheet> timesheet) {
		super();
		this.id = id;
		this.userId = userId;
		this.goal = goal;
		this.target = target;
		this.timesheet = timesheet;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	public double getTarget() {
		return target;
	}

	public void setTarget(double target) {
		this.target = target;
	}

	public List<QuaterTimeSheet> getTimesheet() {
		return timesheet;
	}

	public void setTimesheet(List<QuaterTimeSheet> timesheet) {
		this.timesheet = timesheet;
	}
}
