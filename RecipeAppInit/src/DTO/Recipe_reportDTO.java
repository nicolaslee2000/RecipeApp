package DTO;

import lombok.Data;

@Data
public class Recipe_reportDTO {
	private int recipe_id;
	private String reporting_user_id;
	private String reason_for_report;
	private UserDTO userDTO;
	private RecipeDTO recipeDTO;
	
	
}
