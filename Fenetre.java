package com.classe;

import java.awt.BorderLayout;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.classe.Numbers;

public class Fenetre extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	CardLayout cl = new CardLayout();
	JPanel content = new JPanel();
	// Liste des noms de nos conteneurs pour la pile de cartes
	JPanel menu = new JPanel();
	JPanel mode = new JPanel();
	JPanel onlinePanel = new JPanel();
	String[] listContent = { "CARD_1", "CARD_2", "CARD_3", "CARD_4", "CARD_5" };
	private JButton goNB = new JButton("Nombre");
	JButton goMot = new JButton("Mot");
	JRadioButton infinite_chance = new JRadioButton("Coup Infini");
	JRadioButton fixed_chance = new JRadioButton("Coup maximum");
	JButton play = new JButton("Jouer");
	JTextField nb_coup = new JTextField(5);
	JPasswordField nb_magique = new JPasswordField(10);
	JPanel plateau = new JPanel();
	JButton ans = new JButton("Soumettre");
	JButton restart = new JButton("Restart");
	String isMode;
	JLabel label1 = new JLabel("");
	JLabel labelInfo = new JLabel();
	JLabel labelReponse = new JLabel();
	JLabel labelIndice = new JLabel();

	JButton solo = new JButton("Solo");
	JLabel info_val = new JLabel("");
	JButton multi = new JButton("Multi");
	JButton online = new JButton("Online");

	JTextField answer = new JTextField(20);
	Numbers jeuNB = new Numbers(answer, labelReponse, labelInfo);
	Mots jeuMots = new Mots(answer, labelReponse, labelInfo, labelIndice);
	JButton toMenu = new JButton("Menu");
	JButton close = new JButton("Fermer");
	JLabel error = new JLabel("Vous devez entrer un nombre");

	public void defFenetre() {

		this.setTitle("Mot ou Nombre Magique");
		this.setSize(650, 550);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		JPanel boutonPane = new JPanel();

		toMenu.addActionListener(this);
		close.addActionListener(this);

		this.defMenu();
		this.defMode();
		this.defPlateau();
		this.defOnline();
		JPanel network = this.defNetwork();

		boutonPane.add(toMenu);
		boutonPane.add(close);
		// On définit le layout
		content.setLayout(cl);
		// On ajoute les cartes à la pile avec un nom pour les retrouver
		content.add(this.menu, listContent[0]);
		content.add(this.mode, listContent[1]);
		content.add(network, listContent[2]);
		content.add(this.onlinePanel, listContent[3]);
		content.add(this.plateau, listContent[4]);

		add(content, BorderLayout.CENTER);
		add(boutonPane, BorderLayout.SOUTH);
		this.setVisible(true);
	}

	private void defMenu() {

		menu.setLayout(new GridBagLayout());
		menu.setPreferredSize(new Dimension(650, 550));

		JLabel titre = new JLabel("LE NOM DU JEU");
		menu.add(titre, posElement(0, 0, 1, 1, 10, 10, "REMAINDER", true, "CENTER"));

		// Définition de l'action du bouton
		this.goNB.addActionListener(this);
		// Définition de l'action du bouton2
		this.goMot.addActionListener(this);

		menu.add(goNB, posElement(0, 1, 1, 1, 3, 10, "", true, "FIRST_LINE_END", true, 0, 0, 0, 10));

		menu.add(goMot, posElement(1, 1, 1, 1, 3, 10, "REMAINDER", true, "FIRST_LINE_START"));

	}

	private void defMode() {
		this.mode.setBackground(Color.red);
		mode.setLayout(new GridBagLayout());
		mode.setPreferredSize(new Dimension(650, 550));

		this.play.addActionListener(this);

		ButtonGroup group = new ButtonGroup();

		group.add(this.infinite_chance);
		group.add(this.fixed_chance);

		this.infinite_chance.setSelected(true);
		this.infinite_chance.addActionListener(this);
		this.fixed_chance.addActionListener(this);

		this.nb_coup.setVisible(false);
		this.nb_magique.setVisible(false);
		info_val.setVisible(false);
		info_val.setForeground(Color.black);
		this.mode.add(nb_magique, posElement(1, 2, 1, 1, 10, 10, "REMAINDER", true, "FIRST_LINE_START"));
		this.mode.add(info_val, posElement(0, 2, 1, 1, 10, 10, "", true, "FIRST_LINE_END", true, 0, 0, 0, 10));

		this.mode.add(this.infinite_chance, posElement(0, 0, 1, 1, 10, 10, "", false, "", true, 0, 0, 0, 10));
		this.mode.add(this.fixed_chance, posElement(1, 0, 1, 1, 10, 10, "REMAINDER", false, ""));
		this.mode.add(nb_coup, posElement(1, 1, 1, 1, 10, 10, "REMAINDER", true, "PAGE_START", true, 10, 0, 0, 0));
		this.mode.add(play, posElement(0, 3, 1, 1, 10, 10, "REMAINDER", true, "CENTER"));

	}

	private void defPlateau() {
		plateau.setBackground(Color.lightGray);
		plateau.setLayout(new GridBagLayout());
		plateau.setPreferredSize(new Dimension(650, 550));

		ans.addActionListener(this);
		restart.addActionListener(this);
		answer.addActionListener(this);

		plateau.add(labelInfo, posElement(0, 0, 1, 1, 10, 10, "REMAINDER", true, "PAGE_END"));
		plateau.add(answer, posElement(0, 3, 1, 1, 10, 10, "REMAINDER"));
		plateau.add(ans, posElement(0, 5, 1, 1, 10, 20, "", true, "FIRST_LINE_END", true, 0, 0, 0, 10));
		plateau.add(restart, posElement(1, 5, 1, 1, 10, 20, "REMAINDER", true, "FIRST_LINE_START"));
		plateau.add(labelReponse, posElement(0, 4, 1, 1, 10, 10, "REMAINDER", true, "PAGE_START"));
		plateau.add(labelIndice, posElement(0, 2, 1, 1, 10, 10, "REMAINDER"));

	}

	private JPanel defNetwork() {
		JPanel network = new JPanel();
		network.setBackground(Color.lightGray);
		network.setLayout(new GridBagLayout());
		network.setPreferredSize(new Dimension(650, 550));

		JLabel text = new JLabel("Mode de jeu :");
		network.add(text, posElement(0, 0, 1, 1, 10, 10, "REMAINDER", true, "CENTER"));

		solo.addActionListener(this);
		multi.addActionListener(this);
		online.addActionListener(this);

		network.add(solo, posElement(0, 1, 1, 1, 55, 10, "", true, "FIRST_LINE_END"));
		network.add(multi, posElement(1, 1, 1, 1, 5, 10, "", true, "PAGE_START"));
		network.add(online, posElement(2, 1, 1, 1, 55, 10, "REMAINDER", true, "FIRST_LINE_START"));

		return network;
	}

	private void defOnline() {

	}

	private GridBagConstraints posElement(int posX, int posY, int gridHeight, int gridWidth, int WeightX, int WeightY,
			String EndLine, boolean Anchor, String posAnchor, boolean Inset, int InsetTop, int InsetLeft,
			int InsetBottom, int InsetRight) {

		GridBagConstraints pos = new GridBagConstraints();
		pos.gridx = posX;
		pos.gridy = posY;
		pos.gridheight = gridHeight;
		pos.gridwidth = gridWidth;
		pos.weightx = WeightX;
		pos.weighty = WeightY;
		switch (EndLine) {
		case "REMAINDER":
			pos.gridwidth = GridBagConstraints.REMAINDER;
			break;

		case "RELATIVE":
			pos.gridwidth = GridBagConstraints.RELATIVE;
			break;

		default:
			break;
		}
		if (Anchor) {
			switch (posAnchor) {
			case "PAGE_START":
				pos.anchor = GridBagConstraints.PAGE_START;
				break;

			case "PAGE_END":
				pos.anchor = GridBagConstraints.PAGE_END;
				break;

			case "FIRST_LINE_START":
				pos.anchor = GridBagConstraints.FIRST_LINE_START;
				break;

			case "FIRST_LINE_END":
				pos.anchor = GridBagConstraints.FIRST_LINE_END;
				break;

			case "LINE_START":
				pos.anchor = GridBagConstraints.LINE_START;
				break;

			case "LINE_END":
				pos.anchor = GridBagConstraints.LINE_END;
				break;

			case "LAST_LINE_START":
				pos.anchor = GridBagConstraints.LAST_LINE_START;
				break;

			case "LAST_LINE_END":
				pos.anchor = GridBagConstraints.LAST_LINE_END;
				break;

			case "CENTER":
				pos.anchor = GridBagConstraints.CENTER;
				break;

			default:
				break;
			}
			if (Inset) {
				pos.insets = new Insets(InsetTop, InsetLeft, InsetBottom, InsetRight);
			}

		}
		return pos;
	}

	private GridBagConstraints posElement(int posX, int posY, int gridHeight, int gridWidth, int WeightX, int WeightY,
			String EndLine, boolean Anchor, String posAnchor) {
		return posElement(posX, posY, gridHeight, gridWidth, WeightX, WeightY, EndLine, Anchor, posAnchor, false, 0, 0,
				0, 0);
	}

	private GridBagConstraints posElement(int posX, int posY, int gridHeight, int gridWidth, int WeightX, int WeightY,
			String EndLine) {
		return posElement(posX, posY, gridHeight, gridWidth, WeightX, WeightY, EndLine, false, "");
	}

	private GridBagConstraints posElement(int posX, int posY, int gridHeight, int gridWidth, int WeightX, int WeightY) {
		return posElement(posX, posY, gridHeight, gridWidth, WeightX, WeightY, "");
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == goMot) {
			cl.show(content, listContent[2]);
			isMode = "mot";
			label1.setText("Devinez le mot magique");
			plateau.validate();
		} else if (source == goNB) {
			cl.show(content, listContent[2]);
			isMode = "nb";
			label1.setText("Devinez le nombre magique");
			plateau.validate();
		} else if (source == play) {
			boolean play = true;
			try {
				if (nb_coup.isVisible()) {
					switch (isMode) {
					case "nb":
						jeuNB.setCoup(Integer.parseInt(nb_coup.getText()));
						break;
					case "mot":
						jeuMots.setCoup(Integer.parseInt(nb_coup.getText()));
						break;
					default:
						break;
					}
				} else {
					switch (isMode) {
					case "nb":
						jeuNB.setIllimite();
						break;
					case "mot":
						jeuMots.setIllimite();
						break;
					default:
						break;
					}
				}
				if (nb_magique.isVisible()) {
					switch (isMode) {
					case "nb":
						jeuNB.setNB(Integer.parseInt(new String(nb_magique.getPassword())));
						break;
					case "mot":
						if ((answer.getText()).matches("^[A-Za-z, ]++$")) {
							jeuMots.setMot(new String(nb_magique.getPassword()));
							mode.remove(error);
							mode.validate();
							play = true;
						} else {
							error.setText("Mot Magique vide");
							mode.add(error, posElement(1, 1, 1, 1, 10, 10));
							mode.validate();
							play = false;
						}
						break;
					default:
						break;
					}
				} else {
					switch (isMode) {
					case "nb":
						jeuNB.setNB(jeuNB.rand_val());
						break;
					case "mot":
						jeuMots.setMot(jeuMots.rand_word());
						break;
					default:
						break;
					}
				}
				switch (isMode) {
				case "nb":
					jeuNB.getInfo();
					break;
				case "mot":
					jeuMots.getInfo();
					break;
				default:
					break;
				}
				nb_coup.setText("");
				nb_magique.setText("");
				plateau.validate();
				if (play) {
					cl.show(content, listContent[4]);
				}
			} catch (Exception e2) {
				mode.add(error, posElement(1, 1, 1, 1, 10, 10));
				mode.validate();
			}

		} else if (source == fixed_chance) {
			if (this.fixed_chance.isSelected()) {
				this.nb_coup.setVisible(true);
				this.mode.validate();
			}
		} else if (source == infinite_chance) {
			if (this.infinite_chance.isSelected()) {
				this.nb_coup.setVisible(false);
				this.mode.validate();
			}
		} else if (source == solo) {
			cl.show(content, listContent[1]);
			this.nb_magique.setVisible(false);
			this.info_val.setVisible(false);
			this.mode.validate();
		} else if (source == multi) {
			cl.show(content, listContent[1]);
			this.nb_magique.setVisible(true);
			this.info_val.setVisible(true);
			switch (isMode) {
			case "nb":
				info_val.setText("Nombre Magique");
				break;
			case "mot":
				info_val.setText("Mot Magique");
				break;
			default:
				break;
			}
			this.mode.validate();
		} else if (source == ans) {
			switch (isMode) {
			case "nb":
				jeuNB.sendValue();
				jeuNB.start();
				break;
			case "mot":
				jeuMots.sendValue();
				jeuMots.start();
				break;
			default:
				break;
			}
			answer.setText("");
			plateau.validate();
		} else if (source == restart) {
			switch (isMode) {
			case "nb":
				jeuNB.restart();
				break;
			case "mot":
				jeuMots.restart();
				break;
			default:
				break;
			}
			plateau.validate();
			error.setVisible(false);
			mode.validate();
			cl.show(content, listContent[1]);
		} else if (source == toMenu) {
			error.setVisible(false);
			mode.validate();
			cl.show(content, listContent[0]);
		} else if (source == close) {
			this.dispose();
		} else if (source == online) {
			cl.show(content, listContent[3]);
		}
	}
}
