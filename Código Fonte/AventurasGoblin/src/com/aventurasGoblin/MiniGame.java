package com.aventurasGoblin;

import javax.swing.JFrame;

public abstract class MiniGame {

	protected Controle c;
	protected boolean inicializado=false;
	protected JFrame jf;
	protected boolean terminou = false, vitoria = false, bonus = false;

	public MiniGame(Controle c, JFrame jf) {
		this.c = c;
		this.jf = jf;
	}

	public abstract void inicializar();
	
	public boolean isInicializado(){
		return inicializado;
	}
	
	public abstract void rodar();
	
	public boolean temBonus(){
		return bonus;
	}
	
	public boolean terminou(){
		return terminou;
	}
	
	public boolean vitoria(){
		return vitoria;
	}

}
