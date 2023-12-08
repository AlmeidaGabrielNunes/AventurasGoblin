package com.aventurasGoblin;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Personagem {

	private int falaAtual, ind;
	private String[] falas;
	private Image img;
	private String nome;
	
	public Personagem(String nome, String icone){
		this.nome = nome;
		try {
			img = ImageIO.read(new File("res/" + icone + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		falas = new String[30];
		ind = 0;
	}
	
	public void adicionarFala(String fala){
		falas[ind] = fala;
		ind++;
	}
	
	public void falou(){
		falaAtual++;
	}
	
	public String getFala(){
		if(falas[falaAtual] != null)
		return falas[falaAtual];
		else
			return "";
	}
	
	public int getFalaAtual(){
		return falaAtual;
	}
	
	public Image getImg(){
		return img;
	}
	
	public String getNome(){
		return nome;
	}
}
