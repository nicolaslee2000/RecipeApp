package DTO;

public class UserDTO {
	private String user_id;
	private byte[] user_pwd;
	private String email;
	private byte[] salt;
	private String language;
	private RecipeDTO recipeDTO;
	private Recipe_reviewDTO recipe_reviewDTO;
	private Recipe_likeDTO recipe_likeDTO;
	private Recipe_reportDTO recipe_reportDTO;
	private Recipe_bookmarkDTO recipe_bookmarkDTO;
	
	public UserDTO() {
	}
	

	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public byte[] getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(byte[] user_pwd) {
		this.user_pwd = user_pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public byte[] getSalt() {
		return salt;
	}
	public void setSalt(byte[] salt) {
		this.salt = salt;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public RecipeDTO getRecipeDTO() {
		return recipeDTO;
	}
	public void setRecipeDTO(RecipeDTO recipeDTO) {
		this.recipeDTO = recipeDTO;
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
	public Recipe_reportDTO getRecipe_reportDTO() {
		return recipe_reportDTO;
	}
	public void setRecipe_reportDTO(Recipe_reportDTO recipe_reportDTO) {
		this.recipe_reportDTO = recipe_reportDTO;
	}
	public Recipe_bookmarkDTO getRecipe_bookmarkDTO() {
		return recipe_bookmarkDTO;
	}
	public void setRecipe_bookmarkDTO(Recipe_bookmarkDTO recipe_bookmarkDTO) {
		this.recipe_bookmarkDTO = recipe_bookmarkDTO;
	}
	
	

}
