package com.blogapp.dto;


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



	private Integer categoryId;
	
	@NotBlank
	@Size(min=4)
	private String categoryTitle;
	
	@Size(max=10)
	private String categoryDescription;
	
	
}
