package com.aventurasGoblin;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class PainelCena extends JPanel {

	private static final long serialVersionUID = 1L;

	private ArrayList<Cena> cenas;
	private Font fonte;
	private int i = 0;
	private int iCar;
	private Jogador j;
	private int larg;
	private int numEleLinha;
	private String p1;

	PainelCena(Jogador j, ArrayList<Cena> cenas) {
		this.j = j;
		this.cenas = cenas;
		fonte = new Font("Calibri", Font.PLAIN, 32);
		numEleLinha = 55;
		i++;
	}

	public void desenharCaixaTexto(Personagem p, char[] s, Graphics g, int x) {
		iCar = x / 2;

		g.setColor(Color.GRAY);
		for (int i = 0; i < 10; i += 2)
			g.drawRect(i / 2, 589 + i / 2, larg - 1 - i, 150 - i);
		g.setColor(Color.BLUE);
		g.fillRect(5, 594, larg - 10, 150 - 9);
		g.drawImage(p.getImg(), 135, 585, this); 
												
		g.setColor(Color.WHITE);
		g.setFont(fonte);
		g.drawString(p.getNome(), 5, 719);
		if (iCar >= s.length)
			iCar = s.length;
		if (iCar > numEleLinha * 2) {
			g.drawChars(s, numEleLinha * 2, iCar - numEleLinha * 2, 295, 679);
			iCar = numEleLinha * 2;
		}
		if (iCar > numEleLinha) {
			g.drawChars(s, numEleLinha, iCar - numEleLinha, 295, 649);
			iCar = numEleLinha;
		}
		g.drawChars(s, 0, iCar, 295, 619);

	}

	@Override
	public void paint(Graphics g) {
		larg = this.getWidth() - this.getInsets().left - this.getInsets().right;
		p1 = cenas.get(j.getCena()).getPersonagem().getFala();
		cenas.get(j.getCena()).fazerDialogo();
		if (p1 != cenas.get(j.getCena()).getPersonagem().getFala())
			i = 0;
		else
			i++;
		g.drawImage(cenas.get(j.getCena()).getImg(), 0, 0, this);
		desenharCaixaTexto(cenas.get(j.getCena()).getPersonagem(),
				cenas.get(j.getCena()).dialogo().toCharArray(), g, i);


	}

}
