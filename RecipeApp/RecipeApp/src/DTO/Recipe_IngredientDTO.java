package DTO;

public class Recipe_IngredientDTO {

	private int recipe_id;
	private String ingredient_name;
	private double amount;
	private String unit_name;
	private double ingredient_total_calories;
	private RecipeDTO recipeDTO;
	private UnitDTO unitDTO;
	private IngredientDTO ingredientDTO;
	
	public Recipe_IngredientDTO() {
	}
	public int getRecipe_id() {
		return recipe_id;
	}
	public void setRecipe_id(int recipe_id) {
		this.recipe_id = recipe_id;
	}
	public String getIngredient_name() {
		return ingredient_name;
	}
	public void setIngredient_name(String ingredient_name) {
		this.ingredient_name = ingredient_name;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getUnit_name() {
		return unit_name;
	}
	public void setUnit_name(String unit_name) {
		this.unit_name = unit_name;
	}
	public double getIngredient_total_calories() {
		return ingredient_total_calories;
	}
	public void setIngredient_total_calories(double ingredient_total_calories) {
		this.ingredient_total_calories = ingredient_total_calories;
	}
	public RecipeDTO getRecipeDTO() {
		return recipeDTO;
	}
	public void setRecipeDTO(RecipeDTO recipeDTO) {
		this.recipeDTO = recipeDTO;
	}
	public UnitDTO getUnitDTO() {
		return unitDTO;
	}
	public void setUnitDTO(UnitDTO unitDTO) {
		this.unitDTO = unitDTO;
	}
	public IngredientDTO getIngredientDTO() {
		return ingredientDTO;
	}
	public void setIngredientDTO(IngredientDTO ingredientDTO) {
		this.ingredientDTO = ingredientDTO;
	}
	
}
