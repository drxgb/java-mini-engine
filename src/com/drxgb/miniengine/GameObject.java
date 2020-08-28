package com.drxgb.miniengine;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.drxgb.miniengine.input.KeyCode;

/**
 * Classe genérica que representa o objeto no mapa do jogo.
 * Estes objetos são responsáveis por gerar toda a mecânica e vida ao jogo.
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
	 * Instancia um novo objeto de acordo com a posição dada por argumentos.
	 * @param sprite O gráfico do objeto
	 * @param x A posição X do objeto na tela
	 * @param y A posição Y do objeto na tela.
	 */
	public GameObject(BufferedImage sprite, Double x, Double y) {
		this.sprite = sprite;
		this.x = x;
		this.y = y;
		self = this;
	}
	
	/*
	 * ===========================================================
	 * 					*** MÉTODOS PÚBLICOS ***
	 * ===========================================================
	 */
	 
	/**
	 * Recupera a instância do objeto.
	 * @return uma instância do objeto.
	 */
	public static GameObject getInstance() {
		return self;
	}

	/*
	 * ===========================================================
	 * 					*** MÉTODOS IMPLEMENTADOS ***
	 * ===========================================================
	 */
	
	@Override
	public void draw(Graphics g) {
		g.drawImage(sprite, x.intValue(), y.intValue(), null);
	}
	
}
