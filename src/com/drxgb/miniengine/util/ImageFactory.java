package com.drxgb.miniengine.util;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import com.drxgb.miniengine.Game;

/**
 * Classe auxiliar para carregar uma imagem a um objeto.
 * @author Dr.XGB
 * @version 1.0
 */
public abstract class ImageFactory {
	
	/*
	 * ===========================================================
	 * 			*** MÉTODOS PÚBLICOS ***
	 * ===========================================================
	 */

	/**
	 * Carrega uma imagem dado por argumento.
	 * @param path Caminho onde se encontra esse arquivo.
	 * @return Uma nova imagem gerada recuperada do argumento.
	 * Se a imagem não for encontrada, retorne {@code null}.
	 */
	public static BufferedImage loadImage(String path) {
		URL url = Game.class.getResource("/res/" + path + ".png");
		try {
			return ImageIO.read(url);
		} catch (IOException e) {
			return null;
		}
	}
	
}
