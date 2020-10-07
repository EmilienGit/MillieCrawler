package com.em.millecrawler.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextField;

import com.em.millecrawler.controler.DownloadImages2;
import com.em.millecrawler.model.JButtonToolBar;

import jiconfont.icons.FontAwesome;
import jiconfont.swing.IconFontSwing;


/**
 * JFreeChart : a free chart library for the Java(tm) platform.
 * This class manage the panel where graphs are.
 *
 * @author Emilien
 *
 * <p>06 decembre 2020 : Version 1 (Emilien)</p>
 */
public class MillieCrawlerPanel extends JPanel {
	private static final int DEFAULT_WIDTH = 1100;
	private static final int DEFAULT_HEIGHT = 700;
	private static final Color DEFAULT_BACKGROUND_COLOR = new Color(43, 43, 43);

	/**
	 * Constructor
	 */
	public MillieCrawlerPanel() {
		setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
		setBackground(DEFAULT_BACKGROUND_COLOR);
		init();
	}

	/**
	 * Initialisation
	 */
	public void init() {
		JTextField pathField = new JTextField();
		pathField.setText("C:/Users/e.mamalet/Downloads/Crawler");
		pathField.setHorizontalAlignment(JTextField.CENTER);
		pathField.setColumns(50); // Largeur de l'input

		JTextField searchField = new JTextField();
		searchField.setHorizontalAlignment(JTextField.CENTER);
		searchField.setColumns(50); // Largeur de l'input

		IconFontSwing.register(FontAwesome.getIconFont()); // Charge les images
		JButtonToolBar jButton = new JButtonToolBar(FontAwesome.SEARCH); // Choisi l'image
		jButton.addActionListener(e -> {
			DownloadImages2 downloadImages2 = new DownloadImages2();
			downloadImages2.saveImages(searchField.getText());
		});

		this.add(pathField);
		this.add(searchField);
		this.add(jButton);
	}
}
