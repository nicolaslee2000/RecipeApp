package DTO;

import lombok.Data;

@Data
public class Recipe_IngredientDTO {

	private int recipe_id;
	private String ingredient_name;
	private double amount;
	private String unit_name;
	private double ingredient_total_calories;
	private UnitDTO unitDTO;
	private IngredientDTO ingredientDTO;
	
	
}
