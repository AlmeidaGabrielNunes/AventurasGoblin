package com.aventurasGoblin;

import java.util.ArrayList;

public class Regular extends Inimigo {
	
	private int dir;
	private int i = 0;
	
	public Regular(String icone, ArrayList<Tiro> tiros, int x, int y, int energia) {
		super(icone, tiros, x, y, energia);
		dir = 1;
	}
	
	@Override
	public void controlar() {
		if(i<30){
			dy=0;
			dx = 1*dir*2;
		}
		else { if(i<60){
			dy = 0;
			dx = -1*dir*2;
		} else{
			dx = 0;
		if(i<90 && y<380) {
			dy = 1*Math.abs(dir);
			}
		}}
		i++;
		if (i==90)
			i = 0;
		
		
		if(cronTiro - nivelTiro == 0) {
			cronTiro = 40;
			atirar();
		}
		cronTiro--;
	}

}
