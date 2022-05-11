package DTO;

import lombok.Data;

@Data
public class Recipe_categoryDTO {
	private int recipe_id;
	private String category_name;
	private RecipeDTO recipeDTO;
	private CategoryDTO categoryDTO;
	
}
