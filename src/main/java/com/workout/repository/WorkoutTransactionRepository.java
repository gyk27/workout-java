package com.workout.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.workout.entity.User;
import com.workout.entity.Workout;
import com.workout.entity.WorkoutTransaction;


@Transactional
public interface WorkoutTransactionRepository extends JpaRepository<WorkoutTransaction,Long> {
	List<WorkoutTransaction> findAll();
}

