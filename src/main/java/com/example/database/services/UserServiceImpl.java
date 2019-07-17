package com.example.database.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.database.beans.GoalAndTimeSheets;
import com.example.database.beans.LoginResponse;
import com.example.database.beans.Period;
import com.example.database.beans.ResultTable;
import com.example.database.model.Goal;
import com.example.database.model.QuaterTimeSheet;
import com.example.database.model.User;
import com.example.database.repositories.GoalRepository;
import com.example.database.repositories.QuaterTimeSheetRepository;
import com.example.database.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private GoalRepository goalRepository;
	@Autowired
	private QuaterTimeSheetRepository quaterTimeSheetRepository;
	
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
	public List<Goal> userAllGoalList() {
		return goalRepository.findAll();
	}

	@Override
	public List<Goal> userGoalList(int user_id) {
		return goalRepository.findByUserId(user_id);
	}

	@Override
	public Goal userAddGoal(Goal goal) {
		return goalRepository.save(goal);
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
		List<QuaterTimeSheet> timesheet = quaterTimeSheetRepository.findByGoalId(id);
		goalRepository.deleteById(id);
		for (QuaterTimeSheet time : timesheet) {
			quaterTimeSheetRepository.deleteById(time.getId());
		}
		return goalData;
	}
	
	@Override
	public List<QuaterTimeSheet> getAllResultByPeriod(Period period) {
		List<QuaterTimeSheet> timeList = quaterTimeSheetRepository.findAll();
		List<QuaterTimeSheet> periodTimeList = new ArrayList<>();
		for (QuaterTimeSheet timesheet : timeList) {
			if(timesheet.getDate() > period.getStart() && timesheet.getDate() < period.getEnd()) {
				periodTimeList.add(timesheet);
			}
		}
		return periodTimeList;
	}

	@Override
	public List<QuaterTimeSheet> getResultByPeriod(int goal_id, Period period) {
		List<QuaterTimeSheet> timeList = quaterTimeSheetRepository.findByGoalId(goal_id);
		List<QuaterTimeSheet> periodTimeList = new ArrayList<>();
		for (QuaterTimeSheet timesheet : timeList) {
			if(timesheet.getDate() > period.getStart() && timesheet.getDate() < period.getEnd()) {
				periodTimeList.add(timesheet);
			}
		}
		return periodTimeList;
	}

	@Override
	public QuaterTimeSheet addTimeSheet(QuaterTimeSheet quaterTimeSheet) {
		return quaterTimeSheetRepository.save(quaterTimeSheet);
	}

	@Override
	public QuaterTimeSheet editTimeSheet(QuaterTimeSheet quaterTimeSheet, int id) {
		QuaterTimeSheet timesheetData = quaterTimeSheetRepository.findById(id);
		timesheetData.setDate(quaterTimeSheet.getDate());
		timesheetData.setScore(quaterTimeSheet.getScore());
		quaterTimeSheetRepository.save(timesheetData);
		return timesheetData;
	}

	@Override
	public QuaterTimeSheet deleteTimeSheet(int timesheet_id) {
		QuaterTimeSheet timesheetData = quaterTimeSheetRepository.findById(timesheet_id);
		quaterTimeSheetRepository.deleteById(timesheet_id);
		return timesheetData;
	}
	
	@Override
	public List<GoalAndTimeSheets> getUsersAllTimeSheet(int user_id) {
		List<Goal> goals = goalRepository.findByUserId(user_id);
		List<GoalAndTimeSheets> result = new ArrayList<GoalAndTimeSheets>();
		for (Goal goal : goals) {
			result.add(new GoalAndTimeSheets(goal.getId(), user_id, goal.getGoal(), goal.getTarget(), quaterTimeSheetRepository.findByGoalId(goal.getId())));
		}
		return result;
	}
	
	@Override
	public List<ResultTable> getAllUsersDetails() {
		List<User> users = userRepository.findAll();
		List<ResultTable> result = new ArrayList<ResultTable>();
		for (User user : users) {
			result.add(new ResultTable(user.getId(), user.getName(), getUsersAllTimeSheet(user.getId())));
		}
		return result;
	}
}
