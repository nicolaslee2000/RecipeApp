package DAO;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

import DTO.UserDTO;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAO extends DAO implements Authentication{
	
	public UserDAO(String username, String password) {
		super(username, password);
	}

	public void createUser(String user_id, String password, String email, String language) throws InputMismatchException{
		byte[] salt = generateSalt();
		byte[] hash = generateHash(password, salt);
		checkId(user_id);
		checkEmail(email);
		
		updateTable("INSERT INTO users(user_id, user_pwd, email, salt, language) VALUES(?,?,?,?,?)", e -> {
			try {
				e.setString(1, user_id);
				e.setBytes(2, hash);
				e.setString(3, email);
				e.setBytes(4, salt);
				e.setString(5, language);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});
	}
	
	private void checkId(String user_id) {
		for(Object o : readContent("SELECT * FROM users WHERE user_id = '" + user_id + "'", UserDTO.class)) {
			throw new InputMismatchException("ID taken!");
		}
	}
	
	private void checkEmail(String email) {
		for(Object o : readContent("SELECT * FROM users WHERE email = '" + email + "'", UserDTO.class)) {
			throw new InputMismatchException("Email taken!");
		}
	}
	
	
	public boolean checkUser(String user_id, String password) {
		List<UserDTO> users = readContent("SELECT * FROM users", UserDTO.class);
		for(UserDTO user : users) {
			if(user.getUser_id().equals(user_id)) {
				byte[] salt = user.getSalt();
				byte[] hash = generateHash(password, salt);
				if(Arrays.equals(hash, user.getUser_pwd())) {
					return true;
				} 
			}
		}
		return false;
	}
	
	//weak entities
	public void setRecipe_review(int recipe_id, String user_id, String review) {
		updateTable("INSERT INTO recipe_reviews VALUES(?,?,?)", e -> {
			try {
				e.setInt(1, recipe_id);
				e.setString(2, user_id);
				e.setString(3, review);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});
	}
	
	public void setRecipe_like(int recipe_id, String user_id) {
		updateTable("INSERT INTO recipe_likes VALUES(?,?)", e -> {
			try {
				e.setInt(1, recipe_id);
				e.setString(2, user_id);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});
	}
	
                public void deleteRecipe_like(int recipe_id, String user_id) {
                        updateTable("DELETE FROM recipe_likes WHERE recipe_id = ? AND user_id = ?", e -> {
                            try {
                                e.setInt(1, recipe_id);
                                e.setString(2, user_id);
                            } catch (SQLException ex) {
                                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        });
                }
	
	public void setRecipe_report(int recipe_id, String user_id, String reasonForReport) {
		updateTable("INSERT INTO recipe_reports VALUES(?,?,?)", e -> {
			try {
				e.setInt(1, recipe_id);
				e.setString(2, user_id);
				e.setString(3, reasonForReport);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});
	}
	
	public void setRecipe_bookmark(int recipe_id, String user_id) {
		updateTable("INSERT INTO recipe_bookmarks VALUES(?,?)", e -> {
			try {
				e.setInt(1, recipe_id);
				e.setString(2, user_id);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});
	}
}
