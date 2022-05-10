package DAO;

import java.util.List;

import DTO.Recipe_likeDTO;
public class test {
	public static void main(String[] args) {
		RecipeDAO dao = new RecipeDAO("recipe_admin_test", "a1234");
		List<Recipe_likeDTO> list = dao.readContent("select r.recipe_id, l.user_id from recipes r INNER JOIN recipe_likes l ON r.recipe_id = l.recipe_id WHERE r.recipe_id = 2",
				Recipe_likeDTO.class);
		System.out.println(list.size());
		list.forEach(e -> System.out.printf("recipe_id = %d liked user id = %s",
				e.getRecipe_id(), e.getUser_id()));
		
	}
}



