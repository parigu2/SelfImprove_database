package com.example.database.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="timesheet")
public class QuaterTimeSheet {

	@Id
	@Column(name="timesheet_id")
	private int id;
	@Column(name="goal_id")
	private int goalId;
	@Column(name="date")
	private Date date;
	@Column(name="score")
	private double score;
	
	public QuaterTimeSheet() {
	}
	
	public QuaterTimeSheet(int id, int goal_id, Date date, double score) {
		super();
		this.id = id;
		this.goalId = goal_id;
		this.date = date;
		this.score = score;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGoal_id() {
		return goalId;
	}

	public void setGoal_id(int goal_id) {
		this.goalId = goal_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
}
