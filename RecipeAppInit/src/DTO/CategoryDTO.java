package DTO;

public class CategoryDTO {
	private String category_name;
	private Recipe_categoryDTO recipe_categoryDTO;
	
	public CategoryDTO() {
		super();
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public Recipe_categoryDTO getRecipe_categoryDTO() {
		return recipe_categoryDTO;
	}
	public void setRecipe_categoryDTO(Recipe_categoryDTO recipe_categoryDTO) {
		this.recipe_categoryDTO = recipe_categoryDTO;
	}
	
}
