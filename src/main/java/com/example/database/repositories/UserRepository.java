package com.example.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.database.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public User findById(int id);
	public Boolean existsById(int id);
}
