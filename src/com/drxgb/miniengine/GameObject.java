package com.drxgb.miniengine;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.drxgb.miniengine.input.KeyCode;

/**
 * Classe gen�rica que representa o objeto no mapa do jogo.
 * Estes objetos s�o respons�veis por gerar toda a mec�nica e vida ao jogo.
 * @author Dr.XGB
 * @version 1.0
 */
public abstract class GameObject implements Drawable, LifeCycle, KeyCode {

	/*
	 * ===========================================================
	 * 					*** ATRIBUTOS ***
	 * ===========================================================
	 */
	
	private static GameObject self;
	
	protected Double x;
	protected Double y;
	protected BufferedImage sprite;
	
	/*
	 * ===========================================================
	 * 					*** CONSTRUTORES ***
	 * ===========================================================
	 */	
	
	/**
	 * Instancia um novo objeto de acordo com a posi��o dada por argumentos.
	 * @param sprite O gr�fico do objeto
	 * @param x A posi��o X do objeto na tela
	 * @param y A posi��o Y do objeto na tela.
	 */
	public GameObject(BufferedImage sprite, Double x, Double y) {
		this.sprite = sprite;
		this.x = x;
		this.y = y;
		self = this;
	}
	
	/*
	 * ===========================================================
	 * 					*** M�TODOS P�BLICOS ***
	 * ===========================================================
	 */
	 
	/**
	 * Recupera a inst�ncia do objeto.
	 * @return uma inst�ncia do objeto.
	 */
	public static GameObject getInstance() {
		return self;
	}

	/*
	 * ===========================================================
	 * 					*** M�TODOS IMPLEMENTADOS ***
	 * ===========================================================
	 */
	
	@Override
	public void draw(Graphics g) {
		g.drawImage(sprite, x.intValue(), y.intValue(), null);
	}
	
}
