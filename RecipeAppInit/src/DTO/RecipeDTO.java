package DTO;

import java.sql.Date;

public class RecipeDTO {

	private int recipe_id;
	private String recipe_name;
	private String user_id;
	private String recipe_content;
	private Date published_date;
	private int difficulty;
	private double cost;
	private int servings;
	private String cook_time;
	private double recipe_total_calories;
	private byte[] image;
	private Recipe_reviewDTO recipe_reviewDTO;
	private Recipe_likeDTO recipe_likeDTO;
	private Recipe_bookmarkDTO recipe_bookmarkDTO;
	private Recipe_reportDTO recipe_reportDTO;
	private Recipe_IngredientDTO recipe_ingredientDTO;
	private Recipe_categoryDTO recipe_categoryDTO;
	private UserDTO userDTO;
	
	public RecipeDTO() {
	}
	public int getRecipe_id() {
		return recipe_id;
	}
	public void setRecipe_id(int recipe_id) {
		this.recipe_id = recipe_id;
	}
	public String getRecipe_name() {
		return recipe_name;
	}
	public void setRecipe_name(String recipe_name) {
		this.recipe_name = recipe_name;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getRecipe_content() {
		return recipe_content;
	}
	public void setRecipe_content(String recipe_content) {
		this.recipe_content = recipe_content;
	}
	public Date getPublished_date() {
		return published_date;
	}
	public void setPublished_date(Date published_date) {
		this.published_date = published_date;
	}
	public int getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public int getServings() {
		return servings;
	}
	public void setServings(int servings) {
		this.servings = servings;
	}
	public String getCook_time() {
		return cook_time;
	}
	public void setCook_time(String cook_time) {
		this.cook_time = cook_time;
	}
	public double getRecipe_total_calories() {
		return recipe_total_calories;
	}
	public void setRecipe_total_calories(double recipe_total_calories) {
		this.recipe_total_calories = recipe_total_calories;
	}
	public Recipe_reviewDTO getRecipe_reviewDTO() {
		return recipe_reviewDTO;
	}
	public void setRecipe_reviewDTO(Recipe_reviewDTO recipe_reviewDTO) {
		this.recipe_reviewDTO = recipe_reviewDTO;
	}
	public Recipe_likeDTO getRecipe_likeDTO() {
		return recipe_likeDTO;
	}
	public void setRecipe_likeDTO(Recipe_likeDTO recipe_likeDTO) {
		this.recipe_likeDTO = recipe_likeDTO;
	}
	public Recipe_bookmarkDTO getRecipe_bookmarkDTO() {
		return recipe_bookmarkDTO;
	}
	public void setRecipe_bookmarkDTO(Recipe_bookmarkDTO recipe_bookmarkDTO) {
		this.recipe_bookmarkDTO = recipe_bookmarkDTO;
	}
	public Recipe_reportDTO getRecipe_reportDTO() {
		return recipe_reportDTO;
	}
	public void setRecipe_reportDTO(Recipe_reportDTO recipe_reportDTO) {
		this.recipe_reportDTO = recipe_reportDTO;
	}
	public Recipe_IngredientDTO getRecipe_ingredientDTO() {
		return recipe_ingredientDTO;
	}
	public void setRecipe_ingredientDTO(Recipe_IngredientDTO recipe_ingredientDTO) {
		this.recipe_ingredientDTO = recipe_ingredientDTO;
	}
	public Recipe_categoryDTO getRecipe_categoryDTO() {
		return recipe_categoryDTO;
	}
	public void setRecipe_categoryDTO(Recipe_categoryDTO recipe_categoryDTO) {
		this.recipe_categoryDTO = recipe_categoryDTO;
	}
	
	public UserDTO getUserDTO() {
		return userDTO;
	}
	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}
	
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "RecipeDTO [recipe_id=" + recipe_id + ", recipe_name=" + recipe_name + ", user_id=" + user_id
				+ ", recipe_content=" + recipe_content + ", published_date=" + published_date + ", difficulty="
				+ difficulty + ", cost=" + cost + ", servings=" + servings + ", cook_time=" + cook_time
				+ ", recipe_total_calories=" + recipe_total_calories + ", recipe_reviewDTO="
				+ recipe_reviewDTO + ", recipe_likeDTO=" + recipe_likeDTO + ", recipe_bookmarkDTO=" + recipe_bookmarkDTO
				+ ", recipe_reportDTO=" + recipe_reportDTO + ", recipe_ingredientDTO=" + recipe_ingredientDTO
				+ ", recipe_categoryDTO=" + recipe_categoryDTO + "]";
	}
	

}
