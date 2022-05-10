package DAO;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import controllers.UserController;

public class test02 {
	public static byte[] image;
	public static void main(String[] args) throws IOException {
		new UserController().setRecipeImage(new File("src\\icons\\sandwich.jpg"), 2);

		
	}
	

}
