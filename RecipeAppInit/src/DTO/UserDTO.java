package DTO;

import lombok.Data;

@Data
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


}
