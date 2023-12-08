package com.aventurasGoblin;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Planeta {
	
	private Image img;
	private int x;
	private int y;
	
	public Planeta(String icone){
		try {
			img = ImageIO.read(new File("res/" + icone + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		y = 0 - img.getHeight(null);
		x = 350;
	}
	
	public void descer(){
		y+=1;
	}
	
	public Image getImg(){
		return img;
	}

	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
}
