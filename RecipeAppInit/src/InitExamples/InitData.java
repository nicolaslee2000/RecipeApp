package InitExamples;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Date;

import javax.imageio.ImageIO;

import DAO.AdminDAO;
import DAO.RecipeDAO;
import DAO.UserDAO;

public class InitData {
	RecipeDAO recipedao = new RecipeDAO("recipe_admin", "a1234");
	UserDAO userdao = new UserDAO("recipe_admin", "a1234");
	AdminDAO admindao = new AdminDAO("recipe_admin", "a1234");
	InitData() {
		setUnits();
		setIngredients();
		setUsers();
		setCategories();
		setRecipe();
		setRecipeCategories();
		
		setRecipeLikes();
		setRecipeReport();
		setRecipeReviews();
		setRecipeBookmarks();
		setRecipeIngredients();
		setAdmin();
	}
	
	private void setAdmin() {
		admindao.addAdmin("recipe_admin", "a1234");
	}
	
	private void setUnits() {
		recipedao.setUnit("whole", 1);
		recipedao.setUnit("cup", 250);
		recipedao.setUnit("teaspoon", 5);
		recipedao.setUnit("pinch", 0.3);
		recipedao.setUnit("drizzle", 0.3);
		recipedao.setUnit("tablespoon", 14);
		recipedao.setUnit("sprig", 3);
		recipedao.setUnit("stalk", 64);
	}
	
	private void setIngredients() {
		recipedao.setIngredient("egg", 1.55, 60);
		recipedao.setIngredient("sugar", 4);
		recipedao.setIngredient("mayonnaise", 6.8);
		recipedao.setIngredient("yellow mustard", 0.66);
		recipedao.setIngredient("green onion", 0.32);
		recipedao.setIngredient("paprika", 2.82);
		recipedao.setIngredient("chicken", 2.3 ,172);
		recipedao.setIngredient("olive oil", 8.8);
		recipedao.setIngredient("herb", 0.2);
		recipedao.setIngredient("pepper", 0.2);
		recipedao.setIngredient("butter", 7);
		recipedao.setIngredient("rosemary", 0.5);
		recipedao.setIngredient("chicken stock", 0.3);
		recipedao.setIngredient("almond", 5.7);
		recipedao.setIngredient("lemon juice", 0.24);
		recipedao.setIngredient("chicken meat", 2.3);
		recipedao.setIngredient("celery", 0.14);
	}
	
	private void setUsers() {
		//create 10 random users
		for(int i = 0; i < 10; i ++) {
			userdao.createUser("randomuser"+i, "password"+i, "randomemail"+i+"@gmail.com", i%2 == 0 ? "KR" : "EN");
		}
		userdao.createUser("nick", "a", "jackychan@gmail.com", "EN");
	}
	private void setCategories() {
		recipedao.setCategory("Korean");
		recipedao.setCategory("Italian");
		recipedao.setCategory("Western");
		recipedao.setCategory("Lunch");
		recipedao.setCategory("dinner");
		recipedao.setCategory("fusion");
		recipedao.setCategory("salad");
	}
	
	private void setRecipe() {
		//Egg salad for sandwiches 
		String direction = "Step 1\r\n"
				+ "Place egg in a saucepan and cover with cold water."
				+ " Bring water to a boil and immediately remove from heat. "
				+ "Cover and let eggs stand in hot water for 10 to 12 minutes. Remove"
				+ " from hot water, cool, peel and chop.\r\n"
				+ "\r\n"
				+ "Step 2\r\n"
				+ "Place the chopped eggs in a bowl, and stir in the mayonnaise, mustard and green onion."
				+ " Season with salt, pepper and paprika. Stir and serve on your favorite bread or crackers.";
		recipedao.setRecipe("Egg salad for Sandwiches", "randomuser1", direction, new Date(System.currentTimeMillis()), 3, 5, 5, "10");
		setRecipeImage(new File("src\\images\\Eggsalad.jfif"), 1);
		
		//Airline Chicken Breast
		direction = "Step 1\r\n"
				+ "Slice off 1/2 of each chicken wing by cutting through the joint where the wing meets the drumette. Slice through the skin between the thighs and breasts. Make a shallow cut along the breast bone and 2 deep cuts on either side, separating the breasts.\r\n"
				+ "\r\n"
				+ "Step 2\r\n"
				+ "Slice each breast off the carcass using the tip of the knife, keeping the blade pressed against the bone. Cut through the cartilage to remove breast with the wing attached.\r\n"
				+ "\r\n"
				+ "Step 3\r\n"
				+ "Remove the tenders and trim as needed. Season with a drizzle of olive oil, salt, pepper, herbes de Provence, and cayenne pepper.\r\n"
				+ "\r\n"
				+ "Step 4\r\n"
				+ "Push your finger gently under the skin of each breast, right next to the wing bone, to separate it from the meat. Slide 1 tender under the skin, center it, and smooth over the skin. Sprinkle salt over breasts.\r\n"
				+ "\r\n"
				+ "Step 5\r\n"
				+ "Heat 1 tablespoon olive oil in a skillet over medium-high heat. Add chicken breasts, skin-side down. Cook until bottom is browned, 6 to 7 minutes. Flip, reduce heat to medium, and cook until no longer pink on the inside, 7 to 10 minutes more. Add 1 tablespoon butter, rosemary, and thyme. Baste chicken with the butter. Remove chicken from the skillet.\r\n"
				+ "\r\n"
				+ "Step 6\r\n"
				+ "Pour stock into the pan; increase heat to high. Boil until reduced to desired thickness, about 2 minutes. Turn off heat and whisk in remaining butter. Slice each chicken breast into thirds and spoon the pan sauce on top.";
		recipedao.setRecipe("Airline Chicken", "randomuser1", direction, new Date(System.currentTimeMillis()), 2, 10, 2, "50");
		setRecipeImage(new File("src\\images\\airlineChicken.jfif"), 2);
		
		//Basic Chicken Salad
		direction = "Step 1\r\n"
				+ "Place almonds in a frying pan. Toast over medium-high heat, shaking frequently. Watch carefully, as they burn easily.\r\n"
				+ "\r\n"
				+ "Step 2\r\n"
				+ "Mix together mayonnaise, lemon juice, and pepper in a medium bowl. Toss with chicken, toasted almonds, and celery.";
		recipedao.setRecipe("Basic Chicken Salad", "randomuser2", direction, new Date(System.currentTimeMillis()), 1, 15, 2, "5");
		setRecipeImage(new File("src\\images\\basicChickenSalad.jfif"), 3);
	}
	private void setRecipeImage(File file, int recipe_id) {
		final int WIDTH = 80;
		final int HEIGHT = 80;
		Image image;
		try {
			image = ImageIO.read(file).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
			BufferedImage outputImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
			outputImage.getGraphics().drawImage(image, 0, 0, null);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ImageIO.write(outputImage, "jpg", bos);
			recipedao.setRecipeImage(bos.toByteArray(), recipe_id);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void setRecipeCategories() {
		recipedao.setRecipeCategory(1, "Western");
		recipedao.setRecipeCategory(1, "Lunch");
		recipedao.setRecipeCategory(2, "dinner");
		recipedao.setRecipeCategory(2, "fusion");
		recipedao.setRecipeCategory(3, "salad");
		recipedao.setRecipeCategory(3, "Lunch");
	}
	
	private void setRecipeIngredients() {
		recipedao.setRecipeIngredient(1, "egg", 8, "whole");
		recipedao.setRecipeIngredient(1, "mayonnaise", 0.5, "cup");
		recipedao.setRecipeIngredient(1, "yellow mustard", 1, "teaspoon");
		recipedao.setRecipeIngredient(1, "green onion", 0.25, "whole");
		recipedao.setRecipeIngredient(1, "sugar", 0.5, "teaspoon");
		recipedao.setRecipeIngredient(1, "paprika", 0.25, "teaspoon");
		
		
		
		
		recipedao.setRecipeIngredient(2, "pepper", 0.25, "teaspoon");
		recipedao.setRecipeIngredient(2, "olive oil", 1, "tablespoon");
		recipedao.setRecipeIngredient(2, "butter", 3, "tablespoon");
		recipedao.setRecipeIngredient(2, "rosemary", 2, "sprig");
		recipedao.setRecipeIngredient(2, "chicken stock", 0.5, "cup");
		recipedao.setRecipeIngredient(2, "chicken", 1, "whole");
		recipedao.setRecipeIngredient(2, "herb", 2, "pinch");

		
		recipedao.setRecipeIngredient(3, "almond", 0.5, "cup");
		recipedao.setRecipeIngredient(3, "mayonnaise", 0.5, "cup");
		recipedao.setRecipeIngredient(3, "lemon juice", 1, "tablespoon");
		recipedao.setRecipeIngredient(3, "pepper", 0.25, "teaspoon");
		recipedao.setRecipeIngredient(3, "chicken meat", 2, "cup");
		recipedao.setRecipeIngredient(3, "celery", 1, "stalk");

	}
	
	
	private void setRecipeReviews() {
		userdao.setReview(1, "randomuser4", "omg i loved it so much");
		userdao.setReview(1, "randomuser2", "fantastic job baby");
		userdao.setReview(1, "randomuser8", "soooooooooooooooo cooooooooooooooool");
		
		userdao.setReview(2, "randomuser1", "not bad");
		userdao.setReview(2, "randomuser6", "could be better");
		
		userdao.setReview(3, "randomuser1", "wow");
		userdao.setReview(3, "randomuser6", "Amazing!");
	}
	private void setRecipeLikes() {
		for(int i = 0; i < 8; i ++) {
			userdao.setLike(1, "randomuser"+i);
		}
		for(int i = 0; i < 4; i ++) {
			userdao.setLike(2, "randomuser"+i);
		}
		userdao.setLike(3, "randomuser3");
	}
	private void setRecipeReport() {
		userdao.setReport(3, "randomuser1", "this guy sucks");
	}
	private void setRecipeBookmarks() {
		userdao.setBookmark(2, "randomuser1");
	}
}
