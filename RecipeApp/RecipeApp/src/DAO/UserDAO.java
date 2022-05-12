package DAO;

import DTO.Recipe_bookmarkDTO;
import DTO.Recipe_likeDTO;
import DTO.Recipe_reportDTO;
import DTO.Recipe_reviewDTO;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

import DTO.UserDTO;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAO extends DAO implements Authentication {

	public UserDAO(String username, String password) {
		super(username, password);
	}
	
	//strong entities
	public void createUser(String user_id, String password, String email, String language)
			throws InputMismatchException {
		byte[] salt = generateSalt();
		byte[] hash = generateHash(password, salt);
		checkId(user_id);
		checkEmail(email);

		updateTable("INSERT INTO users(user_id, user_pwd, email, salt, language) VALUES(?,?,?,?,?)", user_id, hash, email, salt, language);
	}

	private void checkId(String user_id) throws InputMismatchException {
		if (isExists("SELECT * FROM users WHERE user_id = ?", user_id))
			throw new InputMismatchException("ID taken!");
	}

	private void checkEmail(String email) {
		if (isExists("SELECT * FROM users WHERE email = ?", email))
			throw new InputMismatchException("Email taken!");
	}

	public boolean checkUser(String user_id, String password) {
		List<UserDTO> users = getDTOs(UserDTO.class, "SELECT * FROM users");
		for (UserDTO user : users) {
			if (user.getUser_id().equals(user_id)) {
				byte[] salt = user.getSalt();
				byte[] hash = generateHash(password, salt);
				if (Arrays.equals(hash, user.getUser_pwd())) {
					return true;
				}
			}
		}
		return false;
	}

	public void deleteUser(String user_id) {
		updateTable("SELECT * FROM users WHERE user_id = ?", user_id);
	}
	
	//weak entities
	// weak entities setters
	public void setLike(int recipe_id, String user_id) {
		updateTable("INSERT INTO recipe_likes VALUES(?,?)", recipe_id, user_id);
	}
	public void setReview(int recipe_id, String user_id, String review) {
		updateTable("INSERT INTO recipe_reviews VALUES(?,?,?)", recipe_id, user_id, review);
	}
	public void setReport(int recipe_id, String user_id, String reasonForReport) {
		updateTable("INSERT INTO recipe_reports VALUES(?,?,?)", recipe_id, user_id, reasonForReport);
	}
	public void setBookmark(int recipe_id, String user_id) {
		updateTable("INSERT INTO recipe_bookmarks VALUES(?,?)", recipe_id, user_id);
	}
	
	//weak entities getters
	public Recipe_likeDTO getLike(int recipe_id, String user_id) {
		return getDTOs(Recipe_likeDTO.class, "SELECT * FROM recipe_likes WHERE recipe_id = ? AND user_id = ?",
				recipe_id, user_id).stream().findFirst().orElse(null);
	}
	public Recipe_reviewDTO getReview(int recipe_id, String user_id) {
		return getDTOs(Recipe_reviewDTO.class, "SELECT * FROM recipe_reviews WHERE recipe_id = ? AND user_id = ?",
				recipe_id, user_id).stream().findFirst().orElse(null);
	}
	public Recipe_reportDTO getReport(int recipe_id, String user_id) {
		return getDTOs(Recipe_reportDTO.class,
				"SELECT * FROM recipe_reports WHERE recipe_id = ? AND reporting_user_id = ?", recipe_id, user_id)
				.stream().findFirst().orElse(null);
	}
	public Recipe_bookmarkDTO getBookmark(int recipe_id, String user_id) {
		return getDTOs(Recipe_bookmarkDTO.class, "SELECT * FROM recipe_bookmarks WHERE recipe_id = ? AND user_id = ?",
				recipe_id, user_id).stream().findFirst().orElse(null);
	}
	public List<Recipe_bookmarkDTO> getBookmarks(String user_id) {
		return getDTOs(Recipe_bookmarkDTO.class, "SELECT * FROM recipe_bookmarks WHERE user_id = ?", user_id);
	}
	
	//weak entities update
	public void updateReview(int recipe_id, String user_id, String review) {
		updateTable("UPDATE recipe_reviews SET review = ? WHERE recipe_id = ? AND user_id = ?", review, recipe_id, user_id);
	}
	public void updateReport(int recipe_id, String user_id, String reason) {
		updateTable("UPDATE recipe_reports SET reason_for_report = ? WHERE recipe_id = ? AND user_id = ?", reason, recipe_id, user_id);
	}
	
	//weak entities delete
	public void deleteLike(int recipe_id, String user_id) {
		updateTable("DELETE FROM recipe_likes WHERE recipe_id = ? AND user_id = ?", recipe_id, user_id);
	}
	public void deleteReview(int recipe_id, String user_id) {
		updateTable("DELETE FROM recipe_reviews WHERE recipe_id = ? AND user_id = ?", recipe_id, user_id);
	}
	public void deleteBookmark(int recipe_id, String user_id) {
		updateTable("DELETE FROM recipe_bookmarks WHERE recipe_id = ? AND user_id = ?", recipe_id, user_id);
	}
	public void deleteReport(int recipe_id, String user_id) {
		updateTable("DELETE FROM recipe_reports WHERE recipe_id = ? AND user_id = ?", recipe_id, user_id);
	}

}
