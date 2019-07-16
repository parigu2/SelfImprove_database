package com.example.database.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.database.beans.LoginResponse;
import com.example.database.model.Goal;
import com.example.database.model.User;
import com.example.database.services.UserServiceImpl;

//@Controller
@RestController
public class DatabaseController {

	@Autowired
	UserServiceImpl userService;
	
	
	//Data Table: User
	@RequestMapping("/getUser")
	@ResponseBody
	public List<User> getUser() {
		return userService.getAllUsers();
	}
	
	@PostMapping("/createUser")
	@ResponseBody
	public boolean createUser(@RequestBody User user) {
		LoginResponse response = userService.saveUser(user);
		return response.isResult();
	}
	
	@PutMapping("/editUser/{id}")
	@ResponseBody
	public User editUser(@RequestBody User user, @PathVariable int id) {
		User editUser = userService.editUser(user, id);
		return editUser;
	}
	
	@DeleteMapping("/deleteUser/{id}")
	@ResponseBody
	public User deleteUser(@PathVariable int id) {
		if (id == 1) return null;
		User deletedUser = userService.deleteUser(id);
		return deletedUser;
	}
	
	
	//Data Table Goal
	@RequestMapping("/goal/getGoalList/{user_id}")
	@ResponseBody
	public List<Goal> getUserGoalList(@PathVariable int user_id) {
		List<Goal> goals = userService.userGoalList(user_id);
		return goals;
	}
	
	@PostMapping("/goal/addGoal")
	@ResponseBody
	public Goal addGoal(@RequestBody Goal goal) {
		Goal newGoal = userService.userAddGoal(goal);
		return newGoal;
	}
}
