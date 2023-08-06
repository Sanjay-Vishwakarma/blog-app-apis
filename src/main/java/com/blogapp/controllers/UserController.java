package com.blogapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogapp.dto.ApiResponse;
import com.blogapp.dto.UserDto;
import com.blogapp.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")

public class UserController {

	@Autowired
	private UserService userService ;



	// Post - create user

	@PostMapping("/new")
	public ResponseEntity<?> createUser (@RequestBody UserDto userDto)
	{

		UserDto createdUser = this.userService.createUser(userDto);

		return new ResponseEntity<>(createdUser, HttpStatus.CREATED);

	}


	// Put - Update user

	@PutMapping("/{userId}")
	public ResponseEntity<?> updateUser(@RequestBody UserDto userDto , @PathVariable ("userId") int uid )
	{
		UserDto updatedUser = userService.updateUser(userDto, uid);
		return ResponseEntity.ok(updatedUser);
	}


	// Get - Get all users
	@GetMapping("/allUsers")
	public ResponseEntity<?> getAllUsers()
	{
		List<UserDto> allUsers = this.userService.getAllUsers();
		return  ResponseEntity.ok(allUsers);
	}


	// get single user
	@GetMapping("/{userId}")
	public ResponseEntity<?> getSingleUser(@PathVariable int userId)
	{
		UserDto userById = userService.getUserById(userId);

		return ResponseEntity.ok(userById);
	}

	// delete - delete user
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable ("userId") int uid)
	{
		userService.deleteUser(uid);
		return new ResponseEntity<ApiResponse>( new ApiResponse("User deleted successfully ",true), HttpStatus.OK);
	}






}
