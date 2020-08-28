package com.drxgb.miniengine.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Classe responsável pelo controle de entrada do teclado.
 * @author Dr.XGB
 * @version 1.0
 * @see KeyListener
 */
public class Keyboard extends Input implements KeyListener {
	
	/*
	 * ===========================================================
	 * 					*** ATRIBUTOS ***
	 * ===========================================================
	 */
	
	private static Keyboard self = new Keyboard();
	
	/*
	 * ===========================================================
	 * 					*** MÉTODOS IMPLEMENTADOS ***
	 * ===========================================================
	 */

	@Override
	public void keyPressed(KeyEvent e) {
		press(e);
		e.consume();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		release(e);
		e.consume();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		e.consume();
	}
	
	/*
	 * ===========================================================
	 * 					*** GETTERS ***
	 * ===========================================================
	 */
	
	public static Keyboard getInstance() {
		return self;
	}
	
}
