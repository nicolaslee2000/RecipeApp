package DAO;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import DTO.AdminDTO;

public class AdminDAO extends DAO implements Authentication{

	public AdminDAO(String username, String password) {
		super(username, password);
	}
	
	public boolean checkAdmin(String username, String password) {
		List<AdminDTO> admins = getDTOs(AdminDTO.class, "SELECT * FROM admins");
		for(AdminDTO admin : admins) {
			if(admin.getAdmin_id().equals(username)) {
				byte[] salt = admin.getSalt();
				byte[] hash = generateHash(password, salt);
				if(Arrays.equals(hash, admin.getAdmin_pwd())) {
					return true;
				} 
			}
		}
		return false;
	}
	
	public void addAdmin(String username, String password) {
		byte[] salt = generateSalt();
		byte[] hash = generateHash(password, salt);
		updateTable("INSERT INTO admins VALUES(?,?,?)", username, hash, salt);
	}
	
}
