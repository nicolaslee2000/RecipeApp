package DTO;

import lombok.Data;

@Data
public class IngredientDTO {

	private String ingredient_name;
	private double calories_per_g;
	private double gram_per_ingredient;
	private Recipe_IngredientDTO recipe_ingredientDTO;
	

}
