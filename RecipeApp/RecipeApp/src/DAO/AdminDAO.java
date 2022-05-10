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
		List<AdminDTO> admins = readContent("SELECT * FROM admins", AdminDTO.class);
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
		updateTable("INSERT INTO admins VALUES(?,?,?)", e -> {
			try {
				e.setString(1, username);
				e.setBytes(2, hash);
				e.setBytes(3, salt);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});
	}
	
}
