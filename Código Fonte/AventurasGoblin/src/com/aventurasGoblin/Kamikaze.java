package com.aventurasGoblin;

import java.util.ArrayList;

public class Kamikaze extends Inimigo {

	private Nave n;

	public Kamikaze(String icone, ArrayList<Tiro> tiros, int x, int y,
			int energia, Nave n) {
		super(icone, tiros, x, y, energia);
		this.n = n;
	}

	@Override
	public void controlar() {
		if ((x + larg) / 2 > (n.getX() + n.getLarg()) / 2)
			dx = -1;
		else {
			if ((x + larg) / 2 < (n.getX() + n.getLarg()) / 2)

				dx = 1;
			else {
				if (y > n.getY())
					dy = -10;
				if (y < n.getY())
					dy = 10;
			}
		}

		if (n.getEnergia() <= 0) {
			dx = 0;
			dy = 0;
		}

	}

	@Override
	public void tratarColisao() {
		y += 1;
	}
}
