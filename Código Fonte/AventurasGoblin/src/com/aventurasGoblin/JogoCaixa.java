package com.aventurasGoblin;

import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class JogoCaixa extends MiniGame {

	private Caixa cax;
	private int i = 0;
	private PainelCaixa pan;

	public JogoCaixa(Controle c, JFrame jf) {
		super(c, jf);

	}

	@Override
	public void inicializar() {
		cax = new Caixa();
		pan = new PainelCaixa(cax);
		
		jf.setContentPane(pan);
		jf.revalidate();
		inicializado = true;
		terminou = false;
		vitoria = false;
		bonus = false;
		i = 0;

	}

	@Override
	public void rodar() {

		if (i % 30 == 0)
			cax.dimTempo();
		if (c.getCode() == KeyEvent.VK_SPACE) {
			cax.andar();
		}

		if (cax.getTempo() == 0) {
			terminou = true;
			if (cax.getX() > 650)
				vitoria = true;
		}
		i++;

	}

}
