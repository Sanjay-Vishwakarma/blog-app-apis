package com.blogapp.payloads;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

// dto tell what will bew send to the server

	private Integer categoryId;
	
	@NotBlank
	@Size(min=4 , message = "Minimum size is title 4")
	private String categoryTitle;

	@Size(min=10 , message = "Minimum size is description 10")
	private String categoryDescription;
	
	
}
