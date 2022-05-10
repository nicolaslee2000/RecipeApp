package DTO;

import lombok.Data;

@Data
public class Recipe_bookmarkDTO {
	private int recipe_id;
	private String user_id;
	private UserDTO userDTO;
	private RecipeDTO recipeDTO;
	
	
}
