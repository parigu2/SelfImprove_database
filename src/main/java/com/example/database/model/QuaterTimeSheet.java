package com.example.database.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name ="timesheet")
public class QuaterTimeSheet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="timesheet_id")
	private int id;
	
	@Column(name="goal_id")
	private int goalId;
	
	@NotNull
	@Column(name="date")
	private double date;
	
	@NotNull
	@Column(name="score")
	private double score;
	
	public QuaterTimeSheet() {
	}
	
	public QuaterTimeSheet(int id, int goal_id, double date, double score) {
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

	public double getDate() {
		return date;
	}

	public void setDate(double date) {
		this.date = date;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
}
