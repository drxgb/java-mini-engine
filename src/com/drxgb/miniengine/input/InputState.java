package com.drxgb.miniengine.input;

/**
 * Constantes para estado de tecla.
 * @author Dr.XGB
 * @version 1.0
 */
public enum InputState {
	
	IDLE(1),
	PRESS(2),
	HOLD(3),
	RELEASE(4),
	TAP(5);
	
	private int key;
	
	private InputState(int key) {
		this.key = key;
	}
	
	public int getKey() {
		return key;
	}

}
