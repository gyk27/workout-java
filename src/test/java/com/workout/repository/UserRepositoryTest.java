package com.workout.repository;

import static org.junit.Assert.assertNotEquals;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.workout.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@Rollback(false)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {
	 @Autowired
	 UserRepository userRepository;

	//private SessionFactory sessionFactory;
	 
	 @Test
	 public void testSaveUser() {
		 try {
			 User user= new User();
			 user.setName("admin111");
			 user.setPassword("admin111");
			 user.setEmail("a@a.com");
			 long userid = ((User) userRepository.save(user)).getId();
			 assertNotEquals(userid, 0);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception happened");
			e.printStackTrace();
		}
		 
		 System.out.println("user is saved");	     
	 }
	
	
}
