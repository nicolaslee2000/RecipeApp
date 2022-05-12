package DAO;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import DTO.CategoryDTO;
import DTO.IngredientDTO;
import DTO.RecipeDTO;
import DTO.Recipe_IngredientDTO;
import DTO.Recipe_bookmarkDTO;
import DTO.Recipe_likeDTO;
import DTO.Recipe_reviewDTO;
import DTO.UnitDTO;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RecipeDAO extends DAO {

	public RecipeDAO(String username, String password) {
		super(username, password);
	}

	// Strong entities
	public void setIngredient(String name, double calPg) {
		updateTable("INSERT INTO ingredients(ingredient_name, calories_per_g) " + "VALUES(?,?)", name, calPg);
	}
	public void setIngredient(String name, double calPg, int gPingredient) {
		updateTable("INSERT INTO ingredients(ingredient_name, calories_per_g, gram_per_ingredient) VALUES(?,?,?)",
				name, calPg, gPingredient);
	}
	public void setUnit(String unitname, double gPunit) {
		updateTable("INSERT INTO units VALUES(?,?)", unitname, gPunit);
	}
	public void setCategory(String name) {
		updateTable("INSERT INTO categories VALUES(?)", name);
	}
	public void setRecipe(String name, String user_id, String recipe_content, Date published_date, int difficulty,
			int cost, int servings, String cooktime) {
		updateTable(
				"INSERT INTO recipes(recipe_name, user_id, recipe_content, published_date, difficulty, cost, servings, cook_time)"
						+ " VALUES(?,?,?,?,?,?,?,?)", name, user_id, recipe_content, published_date, difficulty, cost, servings, cooktime);
	}
	public void setRecipeImage(byte[] image, int recipe_id) {
		updateTable("UPDATE recipes SET image = ? WHERE recipe_id = ?", image, recipe_id);
	}

	//strong entities getters
	public List<RecipeDTO> getAllRecipes() {
		return getDTOs(RecipeDTO.class, "SELECT * FROM recipes");
	}
	public RecipeDTO getRecipe(int recipe_id) {
		return getDTOs(RecipeDTO.class, "SELECT * FROM recipes WHERE recipe_id = ?", recipe_id).stream().findFirst().orElse(null);
	}
	public List<RecipeDTO> getRecipesFilterName(String name) {
		return getDTOs(RecipeDTO.class, "SELECT * FROM recipes WHERE recipe_name LIKE  ?", name);
	}
	public List<RecipeDTO> getRecipesFilterIngredient(String ingredient) {
		return getDTOs(RecipeDTO.class, 
				"SELECT * FROM recipes r INNER JOIN recipe_ingredients ri ON r.recipe_id = ri.recipe_id WHERE ri.ingredient_name = ?",
				ingredient);
	}
	public List<RecipeDTO> getRecipesFilterAuthor(String author) {
		return getDTOs(RecipeDTO.class, "SELECT * FROM recipes WHERE user_id =  ?", author);
	}
	
	public List<IngredientDTO> getAllIngredients() {
		return getDTOs(IngredientDTO.class , "SELECT * FROM ingredients");
	}
	public List<CategoryDTO> getAllCategories() {
		return getDTOs(CategoryDTO.class, "SELECT * FROM categories");
	}
	public List<UnitDTO> getAllUnits() {
		return getDTOs(UnitDTO.class, "SELECT * FROM units");
	}
	
	//strong entities update
	public void updateRecipe(int recipe_id, String name, String user_id, String recipe_content, Date published_date, int difficulty,
			int cost, int servings, String cooktime) {
		updateTable(
				"UPDATE recipes SET recipe_name = ?, user_id = ?, recipe_content = ?, published_date = ?, difficulty = ?,"
				+ " cost = ?, servings = ?, cook_time = ? WHERE recipe_id = ?", 
				name, user_id, recipe_content, published_date, difficulty, cost, servings, cooktime, recipe_id);
	}
	public void updateRecipeImage(int recipe_id, byte[] image) {
		updateTable("UPDATE recipes SET image = ? WHERE recipe_id = ?", image, recipe_id);
	}
	
	//delte strong entities
	public void deleteRecipe(int recipe_id) {
		updateTable("DELETE FROM recipes WHERE recipe_id = ?", recipe_id);
	}
	
	
	//weak entities
	//weak entities setters
	public void setRecipeIngredient(int recipe_id, String ingredient_name, double amount, String unit_name) {
		updateTable("INSERT INTO recipe_ingredients VALUES(?,?,?,?)", recipe_id, ingredient_name, amount, unit_name);
	}
	public void setRecipeCategory(int recipe_id, String category_name) {
		updateTable("INSERT INTO recipe_categories VALUES(?,?)", recipe_id, category_name);
	}
	
	//weak entities getters
	public Recipe_IngredientDTO getRecipeIngredient(int recipe_id, String ingredient_name) {
		return getDTOs(Recipe_IngredientDTO.class, "SELECT * FROM recipe_ingredients WHERE recipe_id = ? AND ingredient_name = ?", 
				recipe_id, ingredient_name).stream().findFirst().orElse(null);
	}
	public List<Recipe_IngredientDTO> getIngredients(int recipe_id) {
		return getDTOs(Recipe_IngredientDTO.class, "SELECT * FROM recipe_ingredients ri INNER JOIN ingredients i"
				+ " ON ri.ingredient_name = i.ingredient_name"
				+ " INNER JOIN units u ON ri.unit_name = u.unit_name"
				+ " WHERE ri.recipe_id = ?", recipe_id);
	}
	
	
	public List<Recipe_reviewDTO> getRecipeReviews(int recipe_id) {
		return  getDTOs(Recipe_reviewDTO.class, "SELECT * FROM recipe_reviews WHERE recipe_id = ?", recipe_id);
	}
	

	//TODO utilities
	public int getRecipeId(String name, String user_id) {
		int recipe_id = getDTOs(RecipeDTO.class, "SELECT recipe_id FROM recipes WHERE recipe_name = ? AND user_id = ?"
				, name, user_id).get(0).getRecipe_id();
		return recipe_id;
	}
	public int getLikeCnt(int recipe_id) {
		int cnt = getDTOs(Recipe_likeDTO.class, "SELECT * FROM recipe_likes WHERE recipe_id = ?", recipe_id).size();
		return cnt;
	}

           
}