package com.drxgb.miniengine;

import java.awt.Container;

import javax.swing.JFrame;

import com.drxgb.miniengine.input.Keyboard;

/**
 * Classe principal da engine. Respons�vel por operar o jogo e controlar
 * seus atributos para que a aplica��o continue est�vel. 
 * @author Dr.XGB
 * @version 1.0
 */
public class Game implements LifeCycle {
	
	/*
	 * ===========================================================
	 * 					*** CONSTANTES ***
	 * ===========================================================
	 */
	
	private static final int WIDTH = 640;
	private static final int HEIGHT = 480;
	
	/*
	 * ===========================================================
	 * 					*** ATRIBUTOS ***
	 * ===========================================================
	 */

	private static Game self = new Game();
	public static int fps;

	private String title;
	private volatile boolean running = false;
	
	/*
	 * ===========================================================
	 * 					*** ASSOCIA��ES ***
	 * ===========================================================
	 */
	
	private JFrame window = new JFrame();
	protected Scene scene;
	protected Stage stage;
	protected Thread mainLoop;
	
	/*
	 * ===========================================================
	 * 					*** CONSTRUTORES ***
	 * ===========================================================
	 */		

	/**
	 * Instancia um novo jogo. Esta inst�ncia deve ser �nica.
	 */
	private Game() {
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(WIDTH, HEIGHT);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		
		scene = new Scene(window.getWidth(), window.getHeight());
		
		Container panel = window.getContentPane();
		panel.add(scene.getCanvas());
		panel.setFocusable(true);
		panel.requestFocus();
		panel.addKeyListener((Keyboard) Keyboard.getInstance());
	}
	
	/*
	 * ===========================================================
	 * 					*** M�TODOS P�BLICOS ***
	 * ===========================================================
	 */

	/**
	 * Recupera a inst�ncia �nica do jogo.
	 * @return a inst�ncia do jogo.
	 */
	public static Game getInstance() {
		return self;
	}
	
	/*
	 * ===========================================================
	 * 					*** M�TODOS PRIVADOS ***
	 * ===========================================================
	 */

	/**
	 * Intervalo entre um frame ao outro.
	 */
	private void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gera um {@code Stage} gen�rico caso nenhum for definido antes.
	 */
	private void buildStage() {
		if (stage == null) {
			stage = new Stage(window.getWidth(), window.getHeight()) {
				@Override
				public void start() {}
	
				@Override
				public void end() {}				
			};
		}
	}
	
	/*
	 * ===========================================================
	 * 					*** M�TODOS IMPLEMENTADOS ***
	 * ===========================================================
	 */

	@Override
	public void start() {
		buildStage();
		window.setVisible(true);
		running = true;
	
		mainLoop = new Thread("Game Loop") {
			@Override
			public void run() {
				scene.getCanvas().createBufferStrategy(2);
				while (running) {
					update();
				}
			}
		};
		mainLoop.start();
	}

	@Override
	public void update() {		
		stage.update();
		scene.update();
		Keyboard.getInstance().clear();		
		sleep(5L);
	}

	@Override
	public void end() {
		running = false;
		System.exit(0);
	}
	
	/*
	 * ===========================================================
	 * 					*** GETTERS E SETTERS ***
	 * ===========================================================
	 */

	public JFrame getWindow() {
		return window;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public Scene getScene() {
		return scene;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
