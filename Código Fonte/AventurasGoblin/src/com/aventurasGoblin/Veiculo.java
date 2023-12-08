package com.aventurasGoblin;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public abstract class Veiculo {

	protected int alt;
	protected int aux;
	protected boolean desaparecendo = false;
	protected int dx;
	protected int dy;
	protected int energia;
	protected Image img;
	protected int larg;
	protected int nivelTiro;
	protected ArrayList<Tiro> tiros;
	protected int x;
	protected int y;

	public Veiculo(String icone, ArrayList<Tiro> tiros, int x, int y) {
		this.tiros = tiros;
		this.x = x;
		this.y = y;

		try {
			img = ImageIO.read(new File("res/" + icone + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		defAltLarg();
	}

	public abstract void controlar();

	public void defAltLarg() {
		alt = img.getHeight(null);
		larg = img.getWidth(null);
	}

	public void mover(int largTela, int altTela) {
		tomarDano(0);
		if (desaparecendo == false) {
			controlar();

			x += dx;

			y += dy;
		}
		if (x > largTela - larg)
			x = largTela - larg;
		else {
			if (x < 0)
				x = 0;
		}
		if (this instanceof Nave && y > altTela - alt) {
			y = altTela - alt;
		} else {
			if (y < 0 && this instanceof Nave)
				y = 0;
		}

	}

	public void posicionar(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void tomarDano(int dano) {
		energia -= dano;
		if (energia <= 0) {
			energia = 0;

		}
	}

	public void tratarColisao() {
		x -= dx;
		y -= dy;

	}

	public int getAlt() {
		return alt;
	}

	public int getEnergia() {
		return energia;
	}

	public Image getImg() {
		return img;
	}

	public int getLarg() {
		return larg;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean isDesaparecendo() {
		return desaparecendo;
	}

}
