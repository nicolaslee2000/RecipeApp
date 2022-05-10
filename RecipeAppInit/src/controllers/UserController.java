package controllers;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import DAO.RecipeDAO;
import DAO.UserDAO;
import DTO.RecipeDTO;
import DTO.Recipe_IngredientDTO;
import java.sql.SQLException;

public class UserController extends Controller {
	private UserDAO userdao;
	private RecipeDAO recipedao;

	public UserController() {
		userdao = new UserDAO("recipe_admin_test", "a1234");
		recipedao = new RecipeDAO("recipe_admin_test", "a1234");
	}

	public boolean authenticate(String id, String password) {
		return userdao.checkUser(id, password);
	}

	public void createUser(String id, String password, String email, String language) throws InputMismatchException {
		userdao.createUser(id, password, email, language);
	}

	public List<RecipeDTO> getRecipes() {
		return recipedao.getRecipes();
	}

	public RecipeDTO getRecipe(int recipe_id) {
		return recipedao.getRecipe(recipe_id);
	}

	public List<RecipeDTO> getRecipesFilter(String filterType, String filter) {
		switch (filterType) {
		case "recipe name":
			return recipedao.getRecipesFilterName(filter);
		case "author":
			return recipedao.getRecipesFilterAuthor(filter);
		case "ingredient":
			return recipedao.getRecipesFilterIngredient(filter);
		default:
			return null;
		}
	}

	public int getLikeCnt(int recipe_id) {
		return recipedao.getLikeCnt(recipe_id);
	}

	public int getRecipeId(String name, String id) {
		return recipedao.getRecipeId(name, id);
	}

	public void setRecipeImage(File file, int recipe_id) {
		final int WIDTH = 80;
		final int HEIGHT = 80;
		String ext = file.getName().substring(file.getName().lastIndexOf(".") + 1);
		Image image;
		try {
			image = ImageIO.read(file).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
			BufferedImage outputImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
			outputImage.getGraphics().drawImage(image, 0, 0, null);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ImageIO.write(outputImage, ext, bos);
			recipedao.setRecipeImage(bos.toByteArray(), recipe_id);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// TODO image resizing should be on the side of gui
	}
	
	public void setRecipeLike(int recipe_id, String user_id) {
		userdao.setRecipe_like(recipe_id, user_id);
	}
	


	public ImageIcon getImageIcon(byte[] arr) {
		return new ImageIcon(arr);
	}

	public List<Recipe_IngredientDTO> getRecipeIngredients(int recipe_id) {
		return recipedao.getIngredients(recipe_id);
	}

}
