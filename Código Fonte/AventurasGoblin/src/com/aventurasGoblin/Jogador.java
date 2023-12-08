package com.aventurasGoblin;

public class Jogador {

	private int fase, cena, minigame, nivelNave;
	private boolean fimJogo = false;
	private int vidas;

	public Jogador(int vidas, int fase, int cena, int minigame) {
		this.vidas = vidas;
		this.fase = fase;
		this.cena = cena;
		this.minigame = minigame;
	}

	public void avancarCena() {
		cena++;
	}

	public void avancarFase() {
		fase++;
	}

	public void avancarMinigame() {
		minigame++;
	}

	public void perderVida() {
		vidas--;
		if (vidas == 0) {
			fimJogo = true;
		}
	}

	public void reiniciar() {
		reiniciarFases();
		reiniciarCenas();
		minigame = 0;
		vidas = 3;
		fimJogo = false;
	}
	
	public void reiniciarFases(){
		fase = 0;
	}
	
	public void reiniciarCenas(){
		cena = 0;
	}
	public void subirNivel() {
		nivelNave += 25;
	}

	public int getCena() {
		return cena;
	}

	public int getFase() {
		return fase;
	}

	public int getMinigame() {
		return minigame;
	}

	public int getNivelNave() {
		return nivelNave;
	}

	public int getVidas() {
		return vidas;
	}

	public boolean isFimJogo() {
		return fimJogo;

	}
}
