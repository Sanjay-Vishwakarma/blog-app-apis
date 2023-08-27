package com.blogapp.payloads;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	private int id;

	@NotEmpty
	@Size(min=4, message="user name must be min 4 characters")
	private String name;
	
	@Email(message="Your email is not correct")
	private String email;

	@NotEmpty
	@Pattern(regexp = "^[a-zA-Z]\\w{3,14}$" , message= "password should be 1 lower and  upper case")
	private String password;

	@NotEmpty
	private String about;
}
