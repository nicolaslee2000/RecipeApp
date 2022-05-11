package InitExamples;

import java.io.File;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

import com.sun.jdi.connect.spi.Connection;

import DAO.AdminDAO;

public class InitDB {
	AdminDAO admindao;
	InitDB() {
		File file = new File("src\\SQLscripts\\InitDB.sql");
		String dbaid = JOptionPane.showInputDialog("SYSTEM DATABASE ID");
		String dbapwd = JOptionPane.showInputDialog("password");
		AdminDAO admindao = new AdminDAO(dbaid+ " as sysdba", dbapwd);
		admindao.runScript(file);
		
		admindao = new AdminDAO("recipe_admin", "a1234");
		file = new File("src\\SQLscripts\\recipeAppInit.ddl");
		admindao.runScript(file);
		file = new File("src\\SQLscripts\\test.ddl");
		admindao.runScript(file);
		JOptionPane.showMessageDialog(null, "Initialization complete!");
	}
	
}
