package com.aventurasGoblin;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Cena {

	private Controle c;
	private int cont=0, i, qtdFalas;
	private boolean encerrada = false;
	private int estado;
	private String falaAtual;
	private boolean falaElfo = true;
	private Image img;
	private boolean monologo;
	private ArrayList<Personagem> personagens;

	public Cena(int rot, ArrayList<Personagem> personagens, Controle c, int i, int qtdFalas, boolean monologo, int estado) {
		this.personagens = personagens;
		this.monologo = monologo;
		this.c = c;
		this.i = i;
		this.qtdFalas = qtdFalas;
		this.estado = estado;
		try {
			img = ImageIO.read(new File("res/cena" + String.valueOf(rot) + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String dialogo(){
		return falaAtual;
	}

	public void fazerDialogo() {
		if (cont >= qtdFalas) {
			cont--;
			encerrada = true;
		}
		if(!encerrada){
		if (falaElfo) {
			if (c.getCode() == KeyEvent.VK_ENTER) {
				if(!monologo)
					falaElfo = false;
				personagens.get(0).falou();
				cont++;
			}
			
			falaAtual = personagens.get(0).getFala();
		} else {
			if (c.getCode() == KeyEvent.VK_ENTER){
				falaElfo = true;
				personagens.get(i).falou();
				cont++;}
			
			falaAtual = personagens.get(i).getFala();
		}}
	}

	public int getEstado(){
		return estado;
	}
	
	public Image getImg(){
		return img;
	}
	
	public Personagem getPersonagem() {
		if (falaElfo)
			return personagens.get(0);
		else
			return personagens.get(i);
	}
	
	public boolean isEncerrada() {
		return encerrada;
	}

}
