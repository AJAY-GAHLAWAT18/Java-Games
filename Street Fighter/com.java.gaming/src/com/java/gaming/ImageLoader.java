package com.java.gaming;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public interface ImageLoader {
	public static BufferedImage loadImage(String image)   	// can be used to load any image , name of the image is passed as a string
	{
		try {
			BufferedImage buf =ImageIO.read(ImageLoader.class.getResource(image));
			return buf;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(GameFrame.frame,"Assests not fount Contact Admin");      //frame here is object of gameframe which
																//		helps in displaying dialog box over GameFrame
			e.printStackTrace();
			
			System.exit(0);
		}
		return null;
	}

}
