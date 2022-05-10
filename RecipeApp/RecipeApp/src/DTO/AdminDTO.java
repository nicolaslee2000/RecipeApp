package DTO;

public class AdminDTO {
	public AdminDTO() {
		
	}
	String admin_id;
	byte[] admin_pwd;
	byte[] salt;
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public byte[] getAdmin_pwd() {
		return admin_pwd;
	}
	public void setAdmin_pwd(byte[] admin_pwd) {
		this.admin_pwd = admin_pwd;
	}
	public byte[] getSalt() {
		return salt;
	}
	public void setSalt(byte[] salt) {
		this.salt = salt;
	}
	
}
