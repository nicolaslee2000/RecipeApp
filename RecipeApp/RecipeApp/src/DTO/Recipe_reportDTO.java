package DTO;

public class Recipe_reportDTO {
	private int recipe_id;
	private String reporting_user_id;
	private String reason_for_report;
	private UserDTO userDTO;
	private RecipeDTO recipeDTO;
	
	public Recipe_reportDTO() {
	}
	public int getRecipe_id() {
		return recipe_id;
	}
	public void setRecipe_id(int recipe_id) {
		this.recipe_id = recipe_id;
	}
	public String getReporting_user_id() {
		return reporting_user_id;
	}
	public void setReporting_user_id(String reporting_user_id) {
		this.reporting_user_id = reporting_user_id;
	}
	public String getReason_for_report() {
		return reason_for_report;
	}
	public void setReason_for_report(String reason_for_report) {
		this.reason_for_report = reason_for_report;
	}
	public UserDTO getUserDTO() {
		return userDTO;
	}
	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}
	public RecipeDTO getRecipeDTO() {
		return recipeDTO;
	}
	public void setRecipeDTO(RecipeDTO recipeDTO) {
		this.recipeDTO = recipeDTO;
	}
	
}
