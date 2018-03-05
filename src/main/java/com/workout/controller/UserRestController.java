package com.workout.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.workout.entity.User;
import com.workout.service.UserService;

@RestController
public class UserRestController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ResponseEntity<String> persistPerson(@RequestBody User user) {

		userService.createUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).build();

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ResponseEntity login(String email,String password) {

		User validatedUser = userService.findUser(email,password);
		return new ResponseEntity<>(validatedUser, HttpStatus.OK);
		
		/*if (userList.size() > 0) {
			return new ResponseEntity<>(userList.get(0), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(" Invalid User Name / Password ...", HttpStatus.FORBIDDEN);
		}*/

	}

}
