package com.drxgb.miniengine;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

/**
 * Responsável por controlar a tela do jogo.
 * @author Dr.XGB
 * @version 1.0
 */
public final class Scene implements Drawable, Updatable {

	/*
	 * ===========================================================
	 * 			*** ASSOCIAÇÕES ***
	 * ===========================================================
	 */
	private Canvas canvas = new Canvas();
	
	/*
	 * ===========================================================
	 * 			*** CONSTRUTORES ***
	 * ===========================================================
	 */	
	
	/**
	 * Gera uma nova tela.
	 * @param width Comprimento da tela
	 * @param height Altura da tela
	 */
	public Scene(int width, int height) {
		canvas.setSize(width, height);
		canvas.setBackground(Color.BLACK);
	}
	
	/*
	 * ===========================================================
	 * 			*** MÉTODOS PRIVADOS ***
	 * ===========================================================
	 */

	/**
	 * Limpa a tela do jogo.
	 * @param g Instância de {@code Graphics}
	 */
	private void clear(Graphics g) {
		g.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
	}

	/**
	 * Renderiza as informações à tela.
	 */
	private void render() {
		BufferStrategy bs = canvas.getBufferStrategy();
		do {
			do {
				draw(bs.getDrawGraphics());
			} while (bs.contentsRestored());	
			bs.show();
		} while (bs.contentsLost());
		Toolkit.getDefaultToolkit().sync();
	}
	
	/**
	 * Atualiza a barra de título da janela do jogo.
	 */
	private void refreshTitle() {
		Game game = Game.getInstance();
		
		StringBuilder title = new StringBuilder();
		title.append(game.getTitle());
		
		game.getWindow().setTitle(title.toString());
	}
	
	/*
	 * ===========================================================
	 * 			*** MÉTODOS IMPLEMENTADOS ***
	 * ===========================================================
	 */

	@Override
	public void draw(Graphics g) {
		Game game = Game.getInstance();
		clear(g);
		game.getStage().draw(g);
		g.dispose();
	}

	@Override
	public void update() {
		refreshTitle();
		render();		
	}
	
	/*
	 * ===========================================================
	 * 			*** GETTERS ***
	 * ===========================================================
	 */

	public Canvas getCanvas() {
		return canvas;
	}
	
}
