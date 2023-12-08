package com.aventurasGoblin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Nave extends Veiculo {

	private boolean aptoAtirar = true;
	private Controle cont;
	private Jogador j;
	private int restricao;
	private int velTiro = 7;

	public Nave(String icone, ArrayList<Tiro> tiros, int x, int y, Jogador j,
			Controle cont) {
		super(icone, tiros, x, y);
		this.j = j;
		this.cont = cont;
		energia = 100;

		try {
			img = ImageIO.read(new File("res/nave.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		defAltLarg();

	}

	public void atirar() {

		Tiro disparo = new Tiro(x + larg / 2, y, -velTiro);
		tiros.add(disparo);
	}

	@Override
	public void controlar() {
		if (restricao > 50 - j.getNivelNave())
			aptoAtirar = true;
		if (cont.isTeclaDir())
			dx = 5;
		else {
			if (cont.isTeclaEsq())
				dx = -5;
			else
				dx = 0;
		}
		if (cont.isTeclaBai())
			dy = 5;
		else {
			if (cont.isTeclaCim())
				dy = -5;
			else
				dy = 0;
		}
		if (cont.isTeclaAcaoA()) {
			if (aptoAtirar) {
				atirar();
				restricao = 0;
				aptoAtirar = false;
			}

		}
		restricao++;
	}

	public void destruir() {

		j.perderVida();
		if (j.getVidas() > 0) {
			energia = 100;
		}
	}

	@Override
	public void tomarDano(int dano) {
		super.tomarDano(dano);
		if (energia <= 0) {
			desaparecendo = true;
			aux++;
			if (aux > 100) {
				destruir();
				aux = 0;
				desaparecendo = false;
			}
		}
	}
}
