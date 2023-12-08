package com.aventurasGoblin;

public class Tiro {

	private int dy;
	private int x;
	private int y;

	public Tiro(int x, int y, int dy) {
		this.x = x;
		this.y = y;
		this.dy = dy;
	}

	public void mover() {
		y += dy;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public int getDy(){
		return dy;
	}

}
