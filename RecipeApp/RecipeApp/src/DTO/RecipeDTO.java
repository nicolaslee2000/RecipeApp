package DTO;

import java.sql.Date;

import lombok.Data;
@Data
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

}
