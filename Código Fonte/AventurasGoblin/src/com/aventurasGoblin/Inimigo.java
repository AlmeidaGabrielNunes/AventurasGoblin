package com.aventurasGoblin;

import java.util.ArrayList;
import java.util.Random;

public abstract class Inimigo extends Veiculo {

	protected int cronTiro;
	protected Random rand;
	protected int vel;

	public Inimigo(String icone, ArrayList<Tiro> tiros, int x, int y,
			int energia) {
		super(icone, tiros, x, y);
		this.energia = energia;
		vel = 5;
		defAltLarg();
	}

	public void atirar() {

		Tiro disparo = new Tiro(x + larg / 2, y + alt, 5);
		tiros.add(disparo);
	}

	public void descer() {
		y++;
	}
}
