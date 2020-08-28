package com.drxgb.miniengine.input;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Classe respons�vel por tratar os dispositivos de entrada do usu�rio.
 * @author Dr.XGB
 * @version 1.0
 */
public abstract class Input {
	
	/*
	 * ===========================================================
	 * 			*** ASSOCIA��ES ***
	 * ===========================================================
	 */
	
	protected List<InputAction> actions = new ArrayList<>();
	
	/*
	 * ===========================================================
	 * 			*** M�TODOS P�BLICOS ***
	 * ===========================================================
	 */
	
	/**
	 * Verifica o estado da tecla
	 * @param key O c�digo ASCII da tecla.
	 * @param state O estado da tecla a ser verificado.
	 * @return {@code true} se a tecla est� no estado dado pelo argumento
	 * ou {@code false} se n�o estiver no estado dado.
	 */
	public boolean check(int key, InputState state) {
		try {
			return getAction(key).getState() == state;
		} catch (NullPointerException e) {
			return false;
		}
	}
	
	/**
	 * Limpa o estado da tecla.
	 */
	public void clear() {
		actions.removeIf(a ->
				a.getState() == InputState.RELEASE ||
				a.getState() == InputState.TAP
			);
	}
	
	/*
	 * ===========================================================
	 * 			*** M�TODOS PRIVADOS ***
	 * ===========================================================
	 */

	/**
	 * Busca se h� alguma a��o de tecla.
	 * @param code O c�digo ASCII da tecla.
	 * @return A a��o encontrada. Se n�o encontrar a a��o de tecla, retorne {@code null}.
	 */
	private InputAction getAction(int code) {
		InputAction key = null;
		try {
			key = actions.stream().filter(i -> i.getKey() == code).findFirst().get();
		} catch (NoSuchElementException e) {
			key = new InputAction(code);
			actions.add(key);
		}		
		return key;
	}
	
	/*
	 * ===========================================================
	 * 			*** M�TODOS PROTEGIDOS ***
	 * ===========================================================
	 */

	/**
	 * Tecla de a��o pressionada.
	 * @param ev Evento da tecla detectada.
	 */
	protected void press(KeyEvent ev) {
		getAction(ev.getKeyCode()).press();
	}
	
	/**
	 * Tecla de a��o solta.
	 * @param ev Event da tecla detectada.
	 */
	protected void release(KeyEvent ev) {
		getAction(ev.getKeyCode()).release();
	}
	
}
