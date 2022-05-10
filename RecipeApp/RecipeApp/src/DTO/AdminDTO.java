package DTO;

import lombok.Data;

@Data
public class AdminDTO {

	String admin_id;
	byte[] admin_pwd;
	byte[] salt;
	
}
