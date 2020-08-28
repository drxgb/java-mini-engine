package com.drxgb.miniengine;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Responsável por armazenar os objetos do jogo.</p>
 * <p>Este é o cenário onde é mostrado o mapa e todos os eus objetos dentro dele</p>
 * @author Dr.XGB
 * @version 1.0
 */
public abstract class Stage implements Drawable, LifeCycle {
	
	/*
	 * ===========================================================
	 * 			*** ATRIBUTOS ***
	 * ===========================================================
	 */
	
	protected Integer width;
	protected Integer height;
	
	/*
	 * ===========================================================
	 * 			*** ASSOCIAÇÕES ***
	 * ===========================================================
	 */
	
	protected List<GameObject> objects = new ArrayList<>();
	
	/*
	 * ===========================================================
	 * 			*** CONSTRUTORES ***
	 * ===========================================================
	 */
	
	/**
	 * Cria uma nova área do jogo.
	 * @param width Comprimento da área
	 * @param height Altura da área
	 */
	public Stage(Integer width, Integer height) {
		this.width = width;
		this.height = height;
		start();
	}
	
	/*
	 * ===========================================================
	 * 			*** MÉTODOS IMPLEMENTADOS ***
	 * ===========================================================
	 */
	
	@Override
	public void draw(Graphics g) {
		for (GameObject obj : objects) {
			obj.draw(g);
		}
	}

	@Override
	public void update() {
		for (GameObject obj : objects) {
			obj.update();
		}
	}
	
	/*
	 * ===========================================================
	 * 			*** GETTERS E SETTERS ***
	 * ===========================================================
	 */

	public List<GameObject> getObjects() {
		return objects;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}
	
}
