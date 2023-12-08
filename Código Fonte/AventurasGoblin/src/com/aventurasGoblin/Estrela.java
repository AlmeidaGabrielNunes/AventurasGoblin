package com.aventurasGoblin;

public class Estrela {
	
	int x;
	int y;
	
	public Estrela(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void descer(){
		y += 1;
	}
	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}

}
