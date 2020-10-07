package com.em.millecrawler.model;

import java.awt.*;

import javax.swing.*;

import jiconfont.IconCode;
import jiconfont.swing.IconFontSwing;

/**
 * @author Emilien
 */
public class JButtonToolBar extends JButton {

	/**
	 * Constructeur
	 *
	 * @param icon button's icon
	 */
	public JButtonToolBar(IconCode icon) {
		super();
		setIcon(IconFontSwing.buildIcon(icon, 20, new Color(200, 200, 200)));
		setBorderPainted(false);
		setBackground(new Color(53, 53, 53));
		setFocusPainted(false);
	}
}