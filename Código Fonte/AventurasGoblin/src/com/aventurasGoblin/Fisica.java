package com.aventurasGoblin;

import java.util.ArrayList;

public class Fisica {

	private int largComp, altComp;
	private ArrayList<Tiro> tiros;
	private ArrayList<Veiculo> veiculos;

	public Fisica() {
	}

	public void calcularColisoes(Fase f) {
		this.veiculos = f.getVeiculos();
		this.tiros = f.getTiros();
		colisoesVeiculosTiros();
		colisoesVeiculos();

	}

	public void colisoesVeiculos() {
		for (int i = 1; i < veiculos.size(); i++) {
			for (int j = 0; j < i; j++) {

				if (veiculos.get(i).getLarg() < veiculos.get(j).getLarg())
					largComp = veiculos.get(i).getLarg();
				else
					largComp = veiculos.get(j).getLarg();
				if (veiculos.get(i).getAlt() < veiculos.get(j).getAlt())
					altComp = veiculos.get(i).getAlt();
				else
					altComp = veiculos.get(j).getAlt();

				if (Math.abs((veiculos.get(i).getX() + veiculos.get(i)
						.getLarg() / 2)
						- (veiculos.get(j).getX() + veiculos.get(j).getLarg() / 2)) <= largComp
						&& Math.abs((veiculos.get(i).getY() + veiculos.get(i)
								.getAlt() / 2)
								- (veiculos.get(j).getY() + veiculos.get(j)
										.getAlt() / 2)) <= altComp) {

					if (veiculos.get(i) instanceof Nave
							|| veiculos.get(j) instanceof Nave) {
						veiculos.get(i).tomarDano(100);
						;
						veiculos.get(j).tomarDano(100);
						;

					} else {
						veiculos.get(i).tratarColisao();
						veiculos.get(j).tratarColisao();
					}
					break;
				}
			}
		}
	}

	public void colisoesVeiculosTiros() {
		for (Veiculo v : veiculos) {

			for (int i = v.getX() + v.getLarg() / 4; i < v.getX() + v.getLarg()
					- v.getLarg() / 4; i++) {

				{
					for (int j = v.getY() + v.getAlt() / 3; j < v.getY()
							+ v.getAlt() - v.getAlt() / 3; j++) {
						for (int k = 0; k < tiros.size(); k++) {

							if (tiros.get(k).getX() == i
									&& tiros.get(k).getY() == j) {
								if(!(tiros.get(k).getDy()>0 && v instanceof Inimigo)){
								v.tomarDano(25);
								tiros.remove(k);
								}}

							}

						}
					}

				}

			}

		}
	

	public void setFase(Fase f) {
		this.veiculos = f.getVeiculos();
		this.tiros = f.getTiros();
	}

}
