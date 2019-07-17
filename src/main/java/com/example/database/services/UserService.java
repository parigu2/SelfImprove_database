package com.example.database.services;

import java.util.List;

import com.example.database.beans.GoalAndTimeSheets;
import com.example.database.beans.LoginResponse;
import com.example.database.beans.Period;
import com.example.database.beans.ResultTable;
import com.example.database.model.Goal;
import com.example.database.model.QuaterTimeSheet;
import com.example.database.model.User;

public interface UserService {
	
	public List<User> getAllUsers();
	public LoginResponse saveUser(User user);
	public User editUser(User user, int id);
	public User deleteUser(int id);
	
	public List<Goal> userAllGoalList();
	public List<Goal> userGoalList(int user_id);
	public Goal userAddGoal(Goal goal);
	public Goal userEditGoal(Goal goal, int id);
	public Goal userDeleteGoal(int goal_id);
	
	public List<QuaterTimeSheet> getAllResultByPeriod(Period period);
	public List<QuaterTimeSheet> getResultByPeriod(int goal_id, Period period);
	public QuaterTimeSheet addTimeSheet(QuaterTimeSheet quaterTimeSheet);
	public QuaterTimeSheet editTimeSheet(QuaterTimeSheet quaterTimeSheet, int id);
	public QuaterTimeSheet deleteTimeSheet(int timesheet_id);
	
	public List<GoalAndTimeSheets> getUsersAllTimeSheet(int user_id);
	public List<ResultTable> getAllUsersDetails();
}
