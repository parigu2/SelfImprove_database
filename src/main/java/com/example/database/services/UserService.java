package com.example.database.services;

import java.util.List;

import com.example.database.beans.LoginResponse;
import com.example.database.model.Goal;
import com.example.database.model.User;

public interface UserService {
	
	public List<User> getAllUsers();
	public LoginResponse saveUser(User user);
	public User editUser(User user, int id);
	public User deleteUser(int id);
	public List<Goal> userGoalList(int user_id);
	public Goal userAddGoal(Goal goal);
	public Goal userEditGoal(Goal goal, int id);
	public Goal userDeleteGoal(int goal_id);
}
