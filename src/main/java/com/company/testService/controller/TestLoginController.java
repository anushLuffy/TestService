/**
 * 
 */
package com.company.testService.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.testService.dto.ResponseEntity;
import com.company.testService.model.User;
import com.company.testService.service.UserService;

/**
 * @author anush
 *
 */
@RestController
@RequestMapping("/loginservice")
public class TestLoginController {
	
	@Autowired
	UserService userService;
	 
	@PostMapping("/register")
	  public  ResponseEntity<User> createUpdateUser(@Valid @RequestBody User user) {
	    return userService.register(user);
	  }
	 
	 @PostMapping("/login")
	  public ResponseEntity<User> addContact(@Valid @RequestBody User user) {
	    return userService.login(user);
	  }

}
