package com.drxgb.miniengine;

/**
 * Contrato que define a��es de uma classe que ter� um ciclo de vida,
 * isto � um in�cio, durante e fim.
 * @author Dr.XGB
 * @version 1.0
 */
public interface LifeCycle extends Updatable {

	/**
	 * Realiza a��es no momento em que o objeto � inicializado.
	 */
	
	void start();
	
	/**
	 * Realiza a��es no momento em que o objeto se encerra.
	 */
	
	void end();
	
}
