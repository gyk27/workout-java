package com.workout.repository;

import static org.junit.Assert.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.workout.entity.UnitTime;
import com.workout.entity.Workout;
import com.workout.entity.WorkoutTransaction;
import com.workout.repository.WorkoutRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@Rollback(false)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class WorkoutTransactionRepositoryTest {
	
	@Autowired
	private WorkoutTransactionRepository workoutTransactionRepository;
	
	@Test
	public void testCreateWorkOut(){
        try {
    		WorkoutTransaction workoutTransaction=new WorkoutTransaction(1, LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(1), Duration.ofHours(1),444);
			
    		
    		long txnId=(workoutTransactionRepository.save(workoutTransaction)).getWorkoutId();
    		assertNotEquals(txnId, 0);			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error happened");
			e.printStackTrace();
		}

		
	}
	
	@Test
	public void testAllTransactions(){
        try {     		
    		List<WorkoutTransaction> transactions=workoutTransactionRepository.findAll();
    		System.out.println("No of transactions are "+transactions.size());
    		assertNotEquals(transactions.size(), 0);			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error happened");
			e.printStackTrace();
		}

		
	}

}
