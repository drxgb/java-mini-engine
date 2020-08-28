package com.drxgb.miniengine.input;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Classe responsável por tratar os dispositivos de entrada do usuário.
 * @author Dr.XGB
 * @version 1.0
 */
public abstract class Input {
	
	/*
	 * ===========================================================
	 * 			*** ASSOCIAÇÕES ***
	 * ===========================================================
	 */
	
	protected List<InputAction> actions = new ArrayList<>();
	
	/*
	 * ===========================================================
	 * 			*** MÉTODOS PÚBLICOS ***
	 * ===========================================================
	 */
	
	/**
	 * Verifica o estado da tecla
	 * @param key O código ASCII da tecla.
	 * @param state O estado da tecla a ser verificado.
	 * @return {@code true} se a tecla está no estado dado pelo argumento
	 * ou {@code false} se não estiver no estado dado.
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
	 * 			*** MÉTODOS PRIVADOS ***
	 * ===========================================================
	 */

	/**
	 * Busca se há alguma ação de tecla.
	 * @param code O código ASCII da tecla.
	 * @return A ação encontrada. Se não encontrar a ação de tecla, retorne {@code null}.
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
	 * 			*** MÉTODOS PROTEGIDOS ***
	 * ===========================================================
	 */

	/**
	 * Tecla de ação pressionada.
	 * @param ev Evento da tecla detectada.
	 */
	protected void press(KeyEvent ev) {
		getAction(ev.getKeyCode()).press();
	}
	
	/**
	 * Tecla de ação solta.
	 * @param ev Event da tecla detectada.
	 */
	protected void release(KeyEvent ev) {
		getAction(ev.getKeyCode()).release();
	}
	
}
