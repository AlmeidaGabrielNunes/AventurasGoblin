package com.aventurasGoblin;

import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JFrame;

public class DiceJack extends MiniGame {

	private boolean advTerminou = false, jogTerminou = false,
			advEstourou = false, jogEstourou = false;
	private int[] dados;
	private int[] dadosAdv;
	private int i = 0, ia = 0;
	private PainelDados pan;
	private Random rand;
	private int soma;
	private int somaAdv;

	public DiceJack(Controle c, JFrame jf) {
		super(c, jf);
		bonus = true;

	}

	@Override
	public void inicializar() {
		dados = new int[15];
		dadosAdv = new int[15];
		rand = new Random();
		for (int i = 0; i < 15; i++) {
			dados[i] = 0;
			dadosAdv[i] = 0;
		}
		i = 0;
		ia = 0;
		pan = new PainelDados();

		jf.setContentPane(pan);
		jf.revalidate();
		inicializado = true;
		terminou = false;
		advTerminou = false;
		jogTerminou = false;
		jogEstourou = false;
		advEstourou = false;
		soma = 0;
		somaAdv = 0;

	}

	@Override
	public void rodar() {

		if (jogTerminou && advTerminou) {
			if (21 - soma < 0)
				jogEstourou = true;
			if (21 - somaAdv < 0)
				advEstourou = true;
			if (jogEstourou) {
				if (advEstourou) {
					inicializar();
				} else {
					terminou = true;
				}
			}
			if (advEstourou && !jogEstourou) {
				terminou = true;
				vitoria = true;
			}
			if (!advEstourou && !jogEstourou) {
				if (soma > somaAdv) {
					terminou = true;
					vitoria = true;
				}
				if (somaAdv > soma) {
					terminou = true;
				}
				if (soma == somaAdv) {
					inicializar();
				}
			}

		}

		if (c.isTeclaAcaoB() && i > 0 || i == 15) {
			jogTerminou = true;
		}
		if (!jogTerminou) {
			if (c.getCode() == KeyEvent.VK_ENTER) {
				dados[i] = 1 + rand.nextInt(6);
				soma += dados[i];
				i++;
			}
		}
		if (ia > 14 || somaAdv > 21)
			advTerminou = true;
		if (!advTerminou) {
			if (somaAdv < 15) {
				dadosAdv[ia] = 1 + rand.nextInt(6);
				somaAdv += dadosAdv[ia];
				ia++;
			} else {
				if (rand.nextBoolean()) {
					dadosAdv[ia] = 1 + rand.nextInt(6);
					somaAdv += dadosAdv[ia];
					ia++;
				} else {
					advTerminou = true;
				}

			}
		}

		pan.inserirDados(dados, dadosAdv, soma, somaAdv);
		pan.notificar(jogTerminou, advTerminou, vitoria);
		if (!(c.getCode() == KeyEvent.VK_ENTER) && terminou == true)
			terminou = false;

	}

}
