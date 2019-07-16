package com.example.database.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.database.model.QuaterTimeSheet;

@Repository
public interface QuaterTimeSheetRepository extends JpaRepository<QuaterTimeSheet, Integer> {

	public QuaterTimeSheet findById(int timesheet_id);
	public List<QuaterTimeSheet> findByGoalId(int goal_id);
}
