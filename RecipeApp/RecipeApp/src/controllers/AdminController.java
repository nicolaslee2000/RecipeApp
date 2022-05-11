package controllers;

import DAO.AdminDAO;

public class AdminController extends UserController{
	AdminDAO admindao;
	public AdminController() {
		admindao = new AdminDAO("recipe_admin", "a1234");
	}
	public boolean authenticate(String id, String password) {
		return admindao.checkAdmin(id, password);
	}
}
