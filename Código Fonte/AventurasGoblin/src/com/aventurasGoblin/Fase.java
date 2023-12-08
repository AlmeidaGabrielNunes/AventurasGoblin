package com.aventurasGoblin;

import java.util.ArrayList;
import java.util.Random;

public class Fase {

	private int alt;
	private ArrayList<Estrela> estrelas;
	private Planeta p;
	private boolean terminada = false;
	private ArrayList<Tiro> tiros;
	private ArrayList<Veiculo> veiculos;

	public Fase(Jogador j, Controle c, String icone, int nivel, int numT,
			int numK, int numR) {
		p = new Planeta(icone);

		Random rand = new Random();
		tiros = new ArrayList<Tiro>();
		veiculos = new ArrayList<Veiculo>();
		estrelas = new ArrayList<Estrela>();
		alt = numT + numK + numR * 250;

		veiculos.add(new Nave("nave", tiros, 0, 0, j, c));

		for (int i = 0; i < numT; i++)
			veiculos.add(new Tremilique("tremilique", tiros,
					rand.nextInt(1024), -1 * rand.nextInt(alt), 25 * nivel));

		for (int i = 0; i < numR; i++)
			veiculos.add(new Regular("regular", tiros, rand.nextInt(1024), -1
					* rand.nextInt(alt), 25 * nivel));

		for (int i = 0; i < numK; i++)
			veiculos.add(new Kamikaze("kamikaze", tiros, rand.nextInt(1024), -1
					* rand.nextInt(alt), 25 * nivel, (Nave) veiculos.get(0)));

		while (estrelas.size() < 60) {
			estrelas.add(new Estrela(rand.nextInt(1024), rand.nextInt(768)));
		}
	}

	public void terminar() {
		terminada = true;
	}

	public int getAlt() {
		return alt;
	}

	public ArrayList<Estrela> getEstrelas() {
		return estrelas;
	}

	public Planeta getP() {
		return p;
	}

	public ArrayList<Tiro> getTiros() {
		return tiros;
	}

	public ArrayList<Veiculo> getVeiculos() {
		return veiculos;
	}

	public boolean isTerminada() {
		return terminada;
	}

}
