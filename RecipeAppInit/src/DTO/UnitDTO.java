package DTO;

public class UnitDTO {
	private String unit_name;
	private double g_per_unit;
	private Recipe_IngredientDTO recipe_ingredientDTO;
	
	public UnitDTO() {
	}
	public String getUnit_name() {
		return unit_name;
	}
	public void setUnit_name(String unit_name) {
		this.unit_name = unit_name;
	}
	public double getG_per_unit() {
		return g_per_unit;
	}
	public void setG_per_unit(double g_per_unit) {
		this.g_per_unit = g_per_unit;
	}
	public Recipe_IngredientDTO getRecipe_ingredientDTO() {
		return recipe_ingredientDTO;
	}
	public void setRecipe_ingredientDTO(Recipe_IngredientDTO recipe_ingredientDTO) {
		this.recipe_ingredientDTO = recipe_ingredientDTO;
	}
	
}
