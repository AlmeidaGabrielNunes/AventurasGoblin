package com.aventurasGoblin;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PainelCaixa extends JPanel {

	private static final long serialVersionUID = 1L;

	private Caixa cax;

	PainelCaixa(Caixa cax) {
		this.cax = cax;

	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawString("APERTE ESPAÇO VÁRIAS VEZES PARA EMPURRAR A CAIXA", 15, 15);
		g.drawString("TEMPO RESTANTE (em kalikassegundos): " + cax.getTempo(), 30, 30);
		g.drawLine(650, 0, 650, 768);
		g.drawImage(cax.getImg(), cax.getX(), cax.getY(), this);
	}

}
