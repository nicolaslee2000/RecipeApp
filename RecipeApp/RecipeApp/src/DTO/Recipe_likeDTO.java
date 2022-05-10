package DTO;

public class Recipe_likeDTO {
	private int recipe_id;
	private String user_id;
	private UserDTO userDTO;
	private RecipeDTO recipeDTO;
	
	public Recipe_likeDTO() {
	}
	public int getRecipe_id() {
		return recipe_id;
	}
	public void setRecipe_id(int recipe_id) {
		this.recipe_id = recipe_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
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
	@Override
	public String toString() {
		return "Recipe_likeDTO [recipe_id=" + recipe_id + ", user_id=" + user_id + ", isLiked="  + ", userDTO="
				+ userDTO + ", recipeDTO=" + recipeDTO + "]";
	}
	
}
