package com.drxgb.miniengine;

import java.awt.Graphics;

/**
 * Contrato que determina que aquele objeto deve ser desenhado na tela do jogo.
 * @author Dr.XGB
 * @version 1.0
 */
public interface Drawable {
	
	/**
	 * Renderiza as informações do gráfico do objeto na tela do jogo.
	 * @param g
	 */
	
	void draw(Graphics g);
	
}
