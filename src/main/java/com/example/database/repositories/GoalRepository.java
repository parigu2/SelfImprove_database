package com.example.database.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.database.model.Goal;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Integer> {

	public Goal findById(int goal_id);
	public List<Goal> findByUserId(int user_id);
}
