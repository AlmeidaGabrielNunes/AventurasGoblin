package com.aventurasGoblin;

import java.util.ArrayList;
import java.util.Random;

public class Tremilique extends Inimigo {

	private Random rand;

	public Tremilique(String icone, ArrayList<Tiro> tiros, int x, int y,
			int energia) {
		super(icone, tiros, x, y, energia);
		nivelTiro = 3;
		cronTiro = 40;
		defAltLarg();
		rand = new Random();
	}

	@Override
	public void controlar() {
		switch (rand.nextInt(6)) {
		case 0:
			dx = vel;
			break;
		case 1:
			dx = -vel;
			break;
		case 2:
			dy = vel;
			break;
		case 3:
			dy = -vel;
			break;
		case 4:
			dx = 0;
			break;
		case 5:
			dy = 0;
			break;
		}

		if (cronTiro - nivelTiro == 0) {
			cronTiro = 40;
			atirar();
		}
		cronTiro--;
	}

	@Override
	public void tratarColisao() {
		y += 1;
	}

}
