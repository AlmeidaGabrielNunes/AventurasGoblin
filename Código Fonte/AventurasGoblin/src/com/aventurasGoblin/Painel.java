package com.aventurasGoblin;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Painel extends JPanel {

	private static final long serialVersionUID = 1L;

	private int aux;
	private ArrayList<Fase> fases;
	private Jogador j;
	private int tamBarra = 60;
	private int xBarra;
	private int yBarra;

	Painel(Jogador j, ArrayList<Fase> fases) {
		setDoubleBuffered(true);
		this.j = j;
		this.fases = fases;

	}

	@Override
	public void paint(Graphics g) {

		if (j.getFase() == 3) {
		} else {

			

				g.setColor(Color.PINK);
				for (int i = 0; i < j.getVidas(); i++) {
					g.drawString("♥", 20 * i, 10);
				}
				g.setColor(Color.WHITE);

				for (int x = 0; x < fases.get(j.getFase()).getEstrelas().size(); x++) {
					g.drawString("*",
							fases.get(j.getFase()).getEstrelas().get(x).getX(),
							fases.get(j.getFase()).getEstrelas().get(x).getY());
				}
				if (fases.get(j.getFase()).isTerminada())
					g.drawImage(fases.get(j.getFase()).getP().getImg(), fases
							.get(j.getFase()).getP().getX(),
							fases.get(j.getFase()).getP().getY(), this);
				g.setColor(Color.GREEN);
				for (int i = 0; i < fases.get(j.getFase()).getTiros().size(); i++) {
					g.setPaintMode();
					g.fillRect(
							fases.get(j.getFase()).getTiros().get(i).getX() - 1,
							fases.get(j.getFase()).getTiros().get(i).getY(), 3,
							8);
				}
				for (int i = 0; i < fases.get(j.getFase()).getVeiculos().size(); i++) {
					if (fases.get(j.getFase()).getVeiculos().get(i) instanceof Nave) {
						if (fases.get(j.getFase()).getVeiculos().get(i)
								.isDesaparecendo() == false
								|| aux % 10 == 0)
							g.drawImage(fases.get(j.getFase()).getVeiculos()
									.get(i).getImg(), fases.get(j.getFase())
									.getVeiculos().get(i).getX(),
									fases.get(j.getFase()).getVeiculos().get(i)
											.getY(), this);
					} else
						g.drawImage(fases.get(j.getFase()).getVeiculos().get(i)
								.getImg(), fases.get(j.getFase()).getVeiculos()
								.get(i).getX(), fases.get(j.getFase())
								.getVeiculos().get(i).getY(), this);
					if (fases.get(j.getFase()).getVeiculos().get(i) instanceof Nave) {
						g.setColor(Color.WHITE);
						xBarra = fases.get(j.getFase()).getVeiculos().get(i)
								.getX()
								+ fases.get(j.getFase()).getVeiculos().get(i)
										.getLarg() / 2 - tamBarra / 2;
						yBarra = fases.get(j.getFase()).getVeiculos().get(i)
								.getY()
								+ fases.get(j.getFase()).getVeiculos().get(i)
										.getLarg() + 2;
						g.drawRect(xBarra, yBarra, tamBarra, 4);
						g.setColor(Color.GREEN);
						g.fillRect(
								xBarra + 1,
								yBarra + 1,
								(int) (fases.get(j.getFase()).getVeiculos()
										.get(i).getEnergia() / ((float) 100 / tamBarra)),
								3);
					}
				}

				aux++;
			}
		}

	}


