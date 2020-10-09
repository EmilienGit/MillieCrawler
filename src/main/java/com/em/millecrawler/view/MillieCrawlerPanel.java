package com.em.millecrawler.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextField;

import com.em.millecrawler.controler.AliExpress;
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
		JTextField pathChromeDriverField = new JTextField();
		pathChromeDriverField.setText("C:/Shared/Tools/ChromeDriver/chromedriver.exe");
		pathChromeDriverField.setHorizontalAlignment(JTextField.CENTER);
		pathChromeDriverField.setColumns(50); // Largeur de l'input

		JTextField pathSaveField = new JTextField();
		pathSaveField.setText("C:/Users/e.mamalet/Downloads/Crawler/");
		pathSaveField.setHorizontalAlignment(JTextField.CENTER);
		pathSaveField.setColumns(50); // Largeur de l'input

		JTextField searchField = new JTextField();
		searchField.setText("https://fr.aliexpress.com/item/4000113765773.html?spm=a2g0o.productlist.0.0.6581404bxnirc6&algo_pvid=392676e5-ed9a-4f6b-ae97-b17695a887e9&algo_expid=392676e5-ed9a-4f6b-ae97-b17695a887e9-22&btsid=0b0a0ae215981721400153150eaee2&ws_ab_test=searchweb0_0,searchweb201602_,searchweb201603_");
		searchField.setHorizontalAlignment(JTextField.CENTER);
		searchField.setColumns(50); // Largeur de l'input

		IconFontSwing.register(FontAwesome.getIconFont()); // Charge les images
		JButtonToolBar jButton = new JButtonToolBar(FontAwesome.SEARCH); // Choisi l'image
		jButton.addActionListener(e -> {
			AliExpress saveImageFromAliExpress = new AliExpress(pathChromeDriverField.getText(), pathSaveField.getText());
			saveImageFromAliExpress.saveImages(searchField.getText());
		});

		this.add(pathChromeDriverField);
		this.add(pathSaveField);
		this.add(searchField);
		this.add(jButton);
	}
}
