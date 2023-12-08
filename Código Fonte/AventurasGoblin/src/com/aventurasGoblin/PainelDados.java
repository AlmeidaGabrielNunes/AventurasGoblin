package com.aventurasGoblin;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PainelDados extends JPanel {

	private static final long serialVersionUID = 1L;

	String a = "0";
	private int[] dado;
	private int[] dadoAdversario;
	private ArrayList<Image> faces;
	private Font fonte;
	private int soma, somaAdv;
	private boolean terminou, v;

	PainelDados() {
		fonte = new Font("Calibri", Font.PLAIN, 32);
		faces = new ArrayList<Image>();
		dado = new int[15];
		dadoAdversario = new int[15];
		
		try {
			faces.add(ImageIO.read(new File("res/dado0.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			faces.add(ImageIO.read(new File("res/dado1.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			faces.add(ImageIO.read(new File("res/dado2.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			faces.add(ImageIO.read(new File("res/dado3.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			faces.add(ImageIO.read(new File("res/dado4.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			faces.add(ImageIO.read(new File("res/dado5.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			faces.add(ImageIO.read(new File("res/dado6.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void inserirDados(int[] dado, int[] dadoAdv, int soma, int somaAdv){
		for(int i =0; i<15; i++){
			this.dado[i] = dado[i];
			this.dadoAdversario[i] = dadoAdv[i];
		}
		this.soma = soma;
		this.somaAdv = somaAdv;
		
	}
	
	public void notificar(boolean a, boolean b, boolean v){
		if (a && b){
			terminou = true;
			this.v = v;}
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.setFont(fonte);
		g.drawString("APERTE ENTER PARA JOGAR MAIS UM DADO / SHIFT PARA PARAR", 15, 25);
		g.drawString("Seus Dados:", 15, 55);
		g.drawString("= " + soma, 900, 105);
		for(int i =0; i<15; i++){
			g.drawImage(faces.get(dado[i]), 60*i, 70, this);
			if(terminou){
				g.drawString("Dados do Adversário:", 15, 160);
			g.drawImage(faces.get(dadoAdversario[i]), 60*i, 175, this);
			g.drawString("= " + somaAdv, 900, 210);
			if(v)
				g.drawString("VOCÊ VENCEU!", 15, 450);
			else
				g.drawString("VOCÊ PERDEU!", 15, 450);
			g.drawString("Aperte Enter para continuar", 15, 480);
}
		}

	}

}
