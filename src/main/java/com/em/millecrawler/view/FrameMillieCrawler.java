package com.em.millecrawler.view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Emilien
 */
public class FrameMillieCrawler extends javax.swing.JFrame {
	private static final String DEFAULT_TITLE = "com.em.millecrawler.MillieCrawler";
	private static FrameMillieCrawler instance = new FrameMillieCrawler();
	private MillieCrawlerPanel panelGraph = new MillieCrawlerPanel();
	private JPanel panel = new JPanel();

	/**
	 * Settings of the frame
	 */
	private FrameMillieCrawler() {
		this.setTitle(DEFAULT_TITLE);
		this.setSize(new Dimension(800, 200));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		this.panel.add(this.panelGraph);


		this.getContentPane().add(panel);
		this.setVisible(true);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/Images/Logo_transparent.png"));

	}

	/**
	 * Getter
	 *
	 * @return l'instance Frame
	 */
	public static FrameMillieCrawler getInstance() {
		return instance;
	}

}