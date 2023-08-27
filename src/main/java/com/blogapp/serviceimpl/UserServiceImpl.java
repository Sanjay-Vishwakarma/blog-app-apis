package com.blogapp.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogapp.payloads.UserDto;
import com.blogapp.entities.User;
import com.blogapp.exception.ResourceNotFoundException;
import com.blogapp.repositories.UserRepo;
import com.blogapp.services.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDto createUser(UserDto userDto) {

		User user = this.dtoToUser(userDto);
		User savedUser = this.userRepo.save(user);
		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {

		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		user.setName(userDto.getName());
		user.setAbout(userDto.getAbout());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());

		User updateUser = this.userRepo.save(user);
		UserDto userDto1 = this.userToDto(updateUser);
		return userDto1;
	}

	@Override
	public UserDto getUserById(Integer userId) {

		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id ", userId));

		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> userList = this.userRepo.findAll();

		List<UserDto> userDtos = userList.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());

		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		this.userRepo.delete(user);

	}
	// convert dto to user

	
	
	// here used model mapper  to conversion user to userDto and vice versa
	public User dtoToUser(UserDto userDto) {
		/*
		 * User user = new User(); user.setId(userDto.getId());
		 * user.setName(userDto.getName()); user.setEmail(userDto.getEmail());
		 * user.setPassword(userDto.getPassword()); user.setAbout(userDto.getAbout());
		 */
		User user = this.modelMapper.map(userDto, User.class);
		return user;
	}

	public UserDto userToDto(User user) {
		/*
		 * UserDto userDto = new UserDto();
		 * 
		 * userDto.setId(user.getId()); userDto.setAbout(user.getAbout());
		 * userDto.setEmail(user.getEmail()); userDto.setName(user.getName());
		 * userDto.setPassword(user.getPassword());
		 */
		
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		return userDto;

	}

}
