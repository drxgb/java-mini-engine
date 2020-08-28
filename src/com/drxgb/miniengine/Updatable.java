package com.drxgb.miniengine;

/**
 * Contrato para que os objetos implementados por ele sejam
 * atualizados constantemente a cada frame.
 * @author Dr.XGB
 * @version 1.0
 */
public interface Updatable {

	/**
	 * Atualiza as informações do objeto.
	 */
	
	void update();
	
}
