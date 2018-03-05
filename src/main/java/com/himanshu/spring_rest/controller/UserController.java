package com.himanshu.spring_rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.himanshu.spring_rest.entity.*;
import com.himanshu.spring_rest.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.himanshu.spring_rest.constants.*;

@ResponseBody
//@Controller
@RestController   //@ResponseBody and @Controller are combined in this one annotation @RestController
//I can also write ResponseBody right here, so all the methods in this class can have that type
//If you write /users right here, it means you don't need to mention it in the method's Request Mapping 
@RequestMapping(value=URI.BASE_URI)  //-- Even the / is not required before the user, so user and /user are the same things here 
@Api("users")   //Any annotation name starting with @Api is Swagger specific annotations for renaming
public class UserController {
 
	UserService userService;   //A @service is responsible for the business logic
	UserController(UserService userService){
		this.userService=userService;
	}
	
	@RequestMapping(method=RequestMethod.GET) 
	//produces is not required now but only kept here for understanding
	@ApiOperation(value="Find all Users",notes="This returns a list of all users in the database")
	public List<User> getAllUsers(){
		
		return userService.getAllUsers();
	}
	
	@RequestMapping(method=RequestMethod.GET,value=URI.ID_PATH_VAR) 
	public User getUser(@PathVariable("id") String userId) {
		return userService.getUser(userId);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value=URI.ID_PATH_VAR)
	public User updateUser(@PathVariable("id") String id, @RequestBody User user) {
		return userService.updateUser(id,user);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value=URI.ID_PATH_VAR)
	public void deleteUser(@PathVariable("id") User id) {
		userService.deleteUser(id);
	}
	
}
