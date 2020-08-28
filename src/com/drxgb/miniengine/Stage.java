package com.drxgb.miniengine;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Respons�vel por armazenar os objetos do jogo.</p>
 * <p>Este � o cen�rio onde � mostrado o mapa e todos os eus objetos dentro dele</p>
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
	 * 			*** ASSOCIA��ES ***
	 * ===========================================================
	 */
	
	protected List<GameObject> objects = new ArrayList<>();
	
	/*
	 * ===========================================================
	 * 			*** CONSTRUTORES ***
	 * ===========================================================
	 */
	
	/**
	 * Cria uma nova �rea do jogo.
	 * @param width Comprimento da �rea
	 * @param height Altura da �rea
	 */
	public Stage(Integer width, Integer height) {
		this.width = width;
		this.height = height;
		start();
	}
	
	/*
	 * ===========================================================
	 * 			*** M�TODOS IMPLEMENTADOS ***
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
