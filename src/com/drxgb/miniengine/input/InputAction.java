package com.drxgb.miniengine.input;

/**
 * Classe responsável por tratar alguma ação de tecla.
 * @author Dr.XGB
 * @version 1.0
 */
public class InputAction {
	
	/*
	 * ===========================================================
	 * 			*** ATRIBUTOS ***
	 * ===========================================================
	 */

	private Integer key;
	private InputState state;
	private Long amount;
	
	/*
	 * ===========================================================
	 * 			*** CONSTRUTORES ***
	 * ===========================================================
	 */
	
	/**
	 * Registra uma nova ação de tecla.
	 * @param key Código ASCII da tecla.
	 */
	public InputAction(Integer key) {
		this.key = key;
		this.state = InputState.IDLE;
		this.amount = 0L;
	}
	
	/*
	 * ===========================================================
	 * 			*** MÉTODOS PÚBLICOS ***
	 * ===========================================================
	 */
	
	/**
	 * Mudar ação de acordo com a tecla pressionada.
	 */
	public void press() {
		amount++;
		
		if (state == InputState.IDLE) {
			state = InputState.PRESS;
		}
	}
	
	/**
	 * Mudar ação de acordo com a tecla solta.
	 */
	public void release() {
		amount = 0L;
		
		if (state == InputState.PRESS) {
			state = InputState.RELEASE;
		}
	}
	
	/*
	 * ===========================================================
	 * 			*** GETTERS E SETTERS ***
	 * ===========================================================
	 */

	public InputState getState() {
		return state;
	}

	public void setState(InputState state) {
		this.state = state;
	}

	public Integer getKey() {
		return key;
	}

	public Long getAmount() {
		return amount;
	}
	
}
