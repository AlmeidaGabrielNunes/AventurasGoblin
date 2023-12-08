package com.aventurasGoblin;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class TelaEstatica extends JPanel {

	private static final long serialVersionUID = 1L;

	private Image background;

	TelaEstatica(String icone) {

		try {
			background = ImageIO.read(new File("res/" + icone + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, this);
		g.setColor(Color.WHITE);
		g.drawString("CRÉDITOS:", 5, 500);
		g.drawString("Gabriel Almeida", 5, 520);
		g.drawString("Hamilton Santos", 5, 540);
		g.drawString("Kledilson Oliveira", 5, 560);
		g.drawString("Lucas Favaro", 5, 580);
	}

}
