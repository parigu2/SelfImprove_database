package com.example.database.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name ="goals")
public class Goal {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="goal_id")
	private int id;
	
	@Column(name="user_id")
	private int userId;
	
	@NotNull
	@Column(name="goal")
	private String goal;
	
	@NotNull
	@Column(name="target")
	private double target;
	

	public Goal() {
	}
	
	public Goal(int id, int user_id, String goal, double target) {
		super();
		this.id = id;
		this.userId = user_id;
		this.goal = goal;
		this.target = target;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return userId;
	}

	public void setUser_id(int user_id) {
		this.userId = user_id;
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
}
