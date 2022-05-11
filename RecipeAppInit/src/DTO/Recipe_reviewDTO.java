package DTO;

import lombok.Data;

@Data
public class Recipe_reviewDTO {
	private int recipe_id;
	private String user_id;
	private String review;
	private UserDTO userDTO;
	private RecipeDTO recipeDTO;
	
	
}
