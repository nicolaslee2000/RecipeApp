package InitExamples;

import java.sql.Date;

import DAO.RecipeDAO;
import DAO.UserDAO;

public class InitData {
	RecipeDAO recipedao = new RecipeDAO("recipe_admin_test", "a1234");
	UserDAO userdao = new UserDAO("recipe_admin_test", "a1234");
	
	InitData() {
		setUnits();
		setIngredients();
		setCategories();
		setUsers();
		setRecipe();
		setRecipeCategories();
		setRecipeIngredients();
		setRecipeLikes();
		setRecipeReport();
		setRecipeReviews();
		setRecipeBookmarks();
	}
	
	private void setUnits() {
		recipedao.setUnit("teaspoon", 5);
		recipedao.setUnit("tablespoon", 15);
		
	}
	
	private void setIngredients() {
		recipedao.setIngredient("apple", 0.5, 200);
		recipedao.setIngredient("sugar", 4);
	}
	
	private void setUsers() {
		userdao.createUser("nicolaslee2000", "jackychandd20", "jackychan2000@gmail.com", "en");
		userdao.createUser("locomotive", "password1234", "jackychan000@gmail.com", "kr");
	}
	
	private void setRecipe() {
		String direction = "Step 1\r\n"
				+ "In a medium bowl, mix together cream cheese, dressing mix and mayonnaise.\r\n"
				+ "\r\n"
				+ "Step 2\r\n"
				+ "Spread a thin layer of the cream cheese mixture on a slice of bread, and top with a"
				+ " slice of cucumber. Sprinkle with dill. Repeat with remaining ingredients.";
		recipedao.setRecipe("fried kentucky rice", "nicolaslee2000", direction, new Date(System.currentTimeMillis()), 3, 20000, 5, "120");
		direction = "Step 1\r\n"
				+ "Mash avocados in a bowl until creamy.\r\n"
				+ "\r\n"
				+ "Step 2\r\n"
				+ "Mix tomatoes, onion, cilantro, lemon juice, and jalapeno pepper into"
				+ " mashed avocado until well combined; season with salt and black pepper.";
		recipedao.setRecipe("traditional mexican guacamole", "locomotive", direction, new Date(System.currentTimeMillis()), 5, 40000, 10, "220");
		
	}
	
	private void setCategories() {
		recipedao.setCategory("Korean");
		recipedao.setCategory("Italian");
	}
	
	private void setRecipeCategories() {
		recipedao.setRecipe_category(1, "Korean");
		recipedao.setRecipe_category(2, "Italian");
	}
	
	private void setRecipeIngredients() {
		recipedao.setRecipeIngredient(1, "apple", 2, "teaspoon");
		recipedao.setRecipeIngredient(2, "apple", 3, "tablespoon");
		recipedao.setRecipeIngredient(2, "sugar", 200, "teaspoon");
	}
	
	
	private void setRecipeReviews() {
		userdao.setRecipe_review(1, "nicolaslee2000", "omg i loved it so much");
		userdao.setRecipe_review(1, "locomotive", "fantastic job baby");
	}
	private void setRecipeLikes() {
		userdao.setRecipe_like(2, "nicolaslee2000");
		userdao.setRecipe_like(2, "locomotive");
	}
	private void setRecipeReport() {
		userdao.setRecipe_report(2, "locomotive", "this guy sucks");
	}
	private void setRecipeBookmarks() {
		userdao.setRecipe_bookmark(1, "nicolaslee2000");
		userdao.setRecipe_bookmark(2, "locomotive");
	}
}
