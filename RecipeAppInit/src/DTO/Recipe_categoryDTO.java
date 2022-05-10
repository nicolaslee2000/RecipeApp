package DTO;

public class Recipe_categoryDTO {
	private int recipe_id;
	private String category_name;
	private RecipeDTO recipeDTO;
	private CategoryDTO categoryDTO;
	
	public Recipe_categoryDTO() {
	}
	public int getRecipe_id() {
		return recipe_id;
	}
	public void setRecipe_id(int recipe_id) {
		this.recipe_id = recipe_id;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public CategoryDTO getCategoryDTO() {
		return categoryDTO;
	}
	public void setCategoryDTO(CategoryDTO categoryDTO) {
		this.categoryDTO = categoryDTO;
	}
	public RecipeDTO getRecipeDTO() {
		return recipeDTO;
	}
	public void setRecipeDTO(RecipeDTO recipeDTO) {
		this.recipeDTO = recipeDTO;
	}
	
	
}
