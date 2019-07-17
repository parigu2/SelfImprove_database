package com.example.database.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.database.beans.LoginResponse;
import com.example.database.model.Goal;
import com.example.database.model.User;
import com.example.database.repositories.GoalRepository;
import com.example.database.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private GoalRepository goalRepository;
	
	@Override
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	@Override
	public LoginResponse saveUser(User user) {
		User userData = userRepository.save(user);
		Boolean result = userRepository.existsById(userData.getId());
		return new LoginResponse(userData.getId(), result);
	}
	
	@Override
	public User editUser(User user, int id) {
		User userData = userRepository.findById(id);
		userData.setPassword(user.getPassword());
		userRepository.save(userData);
		return userData;
	}

	@Override
	public User deleteUser(int id) {
		User userData = userRepository.findById(id);
		List<Goal> goalList = goalRepository.findAll();
		userRepository.deleteById(id);
		for (Goal goal : goalList) {
			goalRepository.deleteById(goal.getId());
		}
		return userData;
	}

	@Override
	public List<Goal> userGoalList(int user_id) {
		return goalRepository.findByUserId(user_id);
//		return goals;
	}

	@Override
	public Goal userAddGoal(Goal goal) {
		return goalRepository.save(goal);
//		return goalData;
	}

	@Override
	public Goal userEditGoal(Goal goal, int id) {
		Goal goalData = goalRepository.findById(id);
		goalData.setGoal(goal.getGoal());
		goalData.setTarget(goal.getTarget());
		goalRepository.save(goalData);
		return goalData;
	}

	@Override
	public Goal userDeleteGoal(int id) {
		Goal goalData = goalRepository.findById(id);
		goalRepository.deleteById(id);
		return goalData;
	}
}
