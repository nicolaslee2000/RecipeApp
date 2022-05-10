package InitExamples;

import DAO.UserDAO;

public class Main {
	public static void main(String[] args) {
	    new UserDAO("recipe_admin_test", "a1234").createUser("nick", "a", "aaa", "kr");
	}
}
