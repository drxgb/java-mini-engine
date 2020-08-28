package com.drxgb.miniengine;

/**
 * Contrato que define ações de uma classe que terá um ciclo de vida,
 * isto é um início, durante e fim.
 * @author Dr.XGB
 * @version 1.0
 */
public interface LifeCycle extends Updatable {

	/**
	 * Realiza ações no momento em que o objeto é inicializado.
	 */
	
	void start();
	
	/**
	 * Realiza ações no momento em que o objeto se encerra.
	 */
	
	void end();
	
}
