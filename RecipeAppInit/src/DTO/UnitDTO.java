package DTO;

import lombok.Data;

@Data
public class UnitDTO {
	private String unit_name;
	private double g_per_unit;
	private Recipe_IngredientDTO recipe_ingredientDTO;
	

}
