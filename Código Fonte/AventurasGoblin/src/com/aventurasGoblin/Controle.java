package com.aventurasGoblin;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controle implements KeyListener {

	private int cod, cdx = 1, cd;
	private boolean teclaAcaoA = false;
	private boolean teclaAcaoB = false;
	private boolean teclaBai = false;
	private boolean teclaCim = false;
	private boolean teclaDir = false;
	private boolean teclaEsq = false;

	@Override
	public void keyPressed(KeyEvent e) {

		cod = e.getKeyCode();

		switch (e.getKeyCode()) {
		case KeyEvent.VK_D:
		case KeyEvent.VK_RIGHT:
			teclaDir = true;
			break;
		case KeyEvent.VK_A:
		case KeyEvent.VK_LEFT:
			teclaEsq = true;
			break;
		case KeyEvent.VK_W:
		case KeyEvent.VK_UP:
			teclaCim = true;
			break;
		case KeyEvent.VK_S:
		case KeyEvent.VK_DOWN:
			teclaBai = true;
			break;
		case KeyEvent.VK_SPACE:
		case KeyEvent.VK_ENTER:
			teclaAcaoA = true;
			break;
		case KeyEvent.VK_SHIFT:
		case KeyEvent.VK_CONTROL:
			teclaAcaoB = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

		cdx = e.getKeyCode();

		switch (e.getKeyCode()) {
		case KeyEvent.VK_D:
		case KeyEvent.VK_RIGHT:
			teclaDir = false;
			break;
		case KeyEvent.VK_A:
		case KeyEvent.VK_LEFT:
			teclaEsq = false;
			break;
		case KeyEvent.VK_W:
		case KeyEvent.VK_UP:
			teclaCim = false;
			break;
		case KeyEvent.VK_S:
		case KeyEvent.VK_DOWN:
			teclaBai = false;
			break;
		case KeyEvent.VK_SPACE:
		case KeyEvent.VK_ENTER:
			teclaAcaoA = false;
			break;
		case KeyEvent.VK_SHIFT:
		case KeyEvent.VK_CONTROL:
			teclaAcaoB = false;
		}

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	public int getCode() {
		if (cod == cdx) {
			cd = cod;
			cod = 0;
			cdx = 1;
			return cd;
		} else
			return 0;
	}

	public boolean isTeclaAcaoA() {
		return teclaAcaoA;
	}

	public boolean isTeclaAcaoB() {
		return teclaAcaoB;
	}

	public boolean isTeclaBai() {
		return teclaBai;
	}

	public boolean isTeclaCim() {
		return teclaCim;
	}

	public boolean isTeclaDir() {
		return teclaDir;
	}

	public boolean isTeclaEsq() {
		return teclaEsq;
	}

}
