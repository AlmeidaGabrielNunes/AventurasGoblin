package com.aventurasGoblin;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Caixa {
	
	private Image img;
	private int tempo;
	private int x,y;
	
	Caixa(){
		x = 0;
		y = 350;
		tempo = 20;
		try {
			img = ImageIO.read(new File("res/caixa.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void andar(){
		x += 10;
	}
	
	public void dimTempo(){
		tempo--;
	}

	public Image getImg() {
		return img;
	}

	public int getTempo(){
		return tempo;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY() {
		return y;
	}
	
}
