package com.classe;

import java.awt.BorderLayout;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.classe.Numbers;

public class Fenetre extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	CardLayout cl = new CardLayout();
	JPanel content = new JPanel();
	// Liste des noms de nos conteneurs pour la pile de cartes
	JPanel mode = new JPanel();
	String[] listContent = { "CARD_1", "CARD_2", "CARD_3", "CARD_4", "CARD_5" };
	private JButton goNB = new JButton("Nombre");
	JButton goMot = new JButton("Mot");
	JRadioButton infinite_chance = new JRadioButton("Coup Infini");
	JRadioButton fixed_chance = new JRadioButton("Coup maximum");
	JButton play = new JButton("Jouer");
	JTextField nb_coup = new JTextField(5);
	JPanel plateau = new JPanel();
	JButton ans = new JButton("Soumettre");
	JButton restart = new JButton("Restart");
	String isMode;
	JLabel label1 = new JLabel("Devinez le nombre magique");
	JLabel label2 = new JLabel("Devinez le mot magique");
	JLabel labelInfo = new JLabel();
	JLabel labelReponse = new JLabel();
	JButton solo = new JButton("Solo");
	JButton multi = new JButton("multi");
	GridBagConstraints pos = new GridBagConstraints();
	JTextField answer = new JTextField(20);
	Numbers jeuNB = new Numbers(answer, labelReponse, labelInfo);
	Mots jeuMots = new Mots();

	public Fenetre() {

		this.setTitle("Mot ou Nombre Magique");
		this.setSize(650, 550);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		JPanel boutonPane = new JPanel();

		JButton toMenu = new JButton("Menu");

		toMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				cl.show(content, listContent[0]);
			}
		});

		JPanel menu = this.defMenu();
		this.defMode();
		this.defPlateau();
		JPanel network = this.defNetwork();

		boutonPane.add(toMenu);
		// On définit le layout
		content.setLayout(cl);
		// On ajoute les cartes à la pile avec un nom pour les retrouver
		content.add(menu, listContent[0]);
		content.add(this.mode, listContent[1]);
		content.add(network, listContent[2]);
		content.add(this.plateau, listContent[4]);

		this.getContentPane().add(boutonPane, BorderLayout.SOUTH);
		this.getContentPane().add(content, BorderLayout.CENTER);
		this.setVisible(true);
	}

	public JPanel defMenu() {

		JPanel menu = new JPanel();
		menu.setBackground(Color.gray);
		menu.setLayout(new GridBagLayout());
		menu.setPreferredSize(new Dimension(650, 550));

		GridBagConstraints pos = new GridBagConstraints();
		pos.gridheight = 1;
		pos.gridwidth = 1;
		pos.gridx = 0;
		pos.gridy = 0;
		pos.weightx = 10;
		pos.weighty = 10;
		pos.gridwidth = GridBagConstraints.REMAINDER;

		JPanel pan_titre = new JPanel();
		JLabel titre = new JLabel("LE NOM DU JEU");
		pan_titre.add(titre);
		menu.add(pan_titre, pos);

		// Définition de l'action du bouton
		this.goNB.addActionListener(this);
		// Définition de l'action du bouton2
		this.goMot.addActionListener(this);

		pos.gridy = 1;
		pos.gridx = 0;
		pos.gridwidth = 1;
		pos.weightx = 3;
		pos.weighty = 10;
		pos.anchor = GridBagConstraints.FIRST_LINE_END;
		pos.insets = new Insets(0, 0, 0, 5);

		menu.add(goNB, pos);

		pos.gridx = 1;
		pos.weightx = 3;
		pos.weighty = 10;
		pos.gridwidth = GridBagConstraints.RELATIVE;
		pos.anchor = GridBagConstraints.FIRST_LINE_START;

		menu.add(goMot, pos);

		return menu;

	}

	public void defMode() {
		this.mode.setBackground(Color.red);
		mode.setLayout(new GridBagLayout());
		mode.setPreferredSize(new Dimension(650, 550));

		GridBagConstraints pos = new GridBagConstraints();

		this.play.addActionListener(this);

		ButtonGroup group = new ButtonGroup();

		group.add(this.infinite_chance);
		group.add(this.fixed_chance);

		this.infinite_chance.setSelected(true);
		this.infinite_chance.addActionListener(this);
		this.fixed_chance.addActionListener(this);

		this.nb_coup.setVisible(false);

		pos.gridheight = 1;
		pos.gridwidth = 1;
		pos.gridx = 0;
		pos.gridy = 0;
		pos.weightx = 10;
		pos.weighty = 10;
		pos.insets = new Insets(0, 0, 0, 10);
		pos.anchor = GridBagConstraints.LAST_LINE_END;
		this.mode.add(this.infinite_chance, pos);
		pos.gridheight = 1;
		pos.gridwidth = 1;
		pos.gridx = 1;
		pos.gridy = 0;
		pos.weightx = 10;
		pos.weighty = 10;
		pos.anchor = GridBagConstraints.LAST_LINE_START;
		pos.gridwidth = GridBagConstraints.REMAINDER;
		this.mode.add(this.fixed_chance, pos);
		JPanel coup_pan = new JPanel();
		coup_pan.add(nb_coup);
		pos.gridheight = 1;
		pos.gridwidth = 1;
		pos.gridx = 1;
		pos.gridy = 1;
		pos.weightx = 10;
		pos.weighty = 2;
		pos.insets = new Insets(10, 0, 0, 0);
		pos.anchor = GridBagConstraints.FIRST_LINE_START;
		pos.gridwidth = GridBagConstraints.REMAINDER;
		this.mode.add(coup_pan, pos);
		JPanel play_pan = new JPanel();
		play_pan.add(play);
		play_pan.setBackground(Color.red);
		pos.gridheight = 1;
		pos.gridwidth = 1;
		pos.gridx = 0;
		pos.gridy = 2;
		pos.weightx = 10;
		pos.weighty = 20;
		pos.anchor = GridBagConstraints.CENTER;
		pos.gridwidth = GridBagConstraints.REMAINDER;
		this.mode.add(play_pan, pos);

	}

	public void defPlateau() {
		plateau.setBackground(Color.lightGray);
		plateau.setLayout(new GridBagLayout());
		plateau.setPreferredSize(new Dimension(650, 550));

		ans.addActionListener(this);
		restart.addActionListener(this);
		answer.addActionListener(this);

		pos.gridheight = 1;
		pos.gridwidth = 1;
		pos.gridx = 0;
		pos.gridy = 0;
		pos.weightx = 10;
		pos.weighty = 10;
		pos.gridwidth = GridBagConstraints.REMAINDER;
		plateau.add(labelInfo, pos);
		pos.gridheight = 1;
		pos.gridwidth = 1;
		pos.gridx = 0;
		pos.gridy = 2;
		pos.weightx = 10;
		pos.weighty = 10;
		pos.gridwidth = GridBagConstraints.REMAINDER;
		plateau.add(answer, pos);
		pos.gridheight = 1;
		pos.gridwidth = 1;
		pos.gridx = 0;
		pos.gridy = 3;
		pos.weightx = 10;
		pos.weighty = 10;
		pos.anchor = GridBagConstraints.PAGE_START;
		plateau.add(ans, pos);
		pos.gridheight = 1;
		pos.gridwidth = 1;
		pos.gridx = 1;
		pos.gridy = 3;
		pos.weightx = 10;
		pos.weighty = 10;
		pos.gridwidth = GridBagConstraints.REMAINDER;
		plateau.add(restart, pos);
		pos.gridheight = 1;
		pos.gridwidth = 1;
		pos.gridx = 0;
		pos.gridy = 4;
		pos.weightx = 10;
		pos.weighty = 10;
		pos.gridwidth = GridBagConstraints.REMAINDER;
		plateau.add(labelReponse, pos);

	}

	public JPanel defNetwork() {
		JPanel network = new JPanel();
		network.setBackground(Color.lightGray);
		network.setLayout(new GridBagLayout());
		network.setPreferredSize(new Dimension(650, 550));

		GridBagConstraints pos = new GridBagConstraints();
		pos.gridheight = 1;
		pos.gridwidth = 1;
		pos.gridx = 0;
		pos.gridy = 0;
		pos.weightx = 10;
		pos.weighty = 10;
		pos.gridwidth = GridBagConstraints.REMAINDER;

		JPanel text_pan = new JPanel();
		JLabel text = new JLabel("Mode de jeu :");
		text_pan.add(text);
		network.add(text_pan, pos);

		solo.addActionListener(this);
		multi.addActionListener(this);

		pos.gridx = 0;
		pos.gridy = 1;
		pos.weightx = 5;
		pos.gridwidth = 1;
		pos.weighty = 10;
		pos.anchor = GridBagConstraints.FIRST_LINE_END;
		pos.insets = new Insets(0, 0, 0, 5);
		network.add(solo, pos);

		pos.gridx = 1;
		pos.gridy = 1;
		pos.weightx = 5;
		pos.weighty = 10;
		pos.anchor = GridBagConstraints.FIRST_LINE_START;
		pos.gridwidth = GridBagConstraints.RELATIVE;
		network.add(multi, pos);

		return network;
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == goMot) {
			cl.show(content, listContent[2]);
			isMode = "mot";
			plateau.remove(label1);
			pos.gridheight = 1;
			pos.gridwidth = 1;
			pos.gridx = 0;
			pos.gridy = 0;
			pos.weightx = 10;
			pos.weighty = 10;
			pos.anchor = GridBagConstraints.PAGE_END;
			pos.gridwidth = GridBagConstraints.REMAINDER;
			plateau.add(label2, pos);
			plateau.validate();
		} else if (source == goNB) {
			cl.show(content, listContent[2]);
			jeuNB.rand_val();
			isMode = "nb";
			plateau.remove(label2);
			pos.gridheight = 1;
			pos.gridwidth = 1;
			pos.gridx = 0;
			pos.gridy = 1;
			pos.weightx = 10;
			pos.weighty = 10;
			pos.anchor = GridBagConstraints.PAGE_END;
			pos.gridwidth = GridBagConstraints.REMAINDER;
			plateau.add(label1, pos);
			plateau.validate();
		} else if (source == play) {
			cl.show(content, listContent[4]);
			if (nb_coup.isVisible()) {
				jeuNB.setCoup(Integer.parseInt(nb_coup.getText()));
			} else {
				jeuNB.setCoup(1000);
			}
			this.jeuNB.getInfo();
			plateau.validate();

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
		} else if (source == multi) {
			cl.show(content, listContent[1]);
		} else if (source == ans) {
			jeuNB.sendValue();
			plateau.validate();
			jeuNB.start();
			plateau.validate();
		} else if (source == restart) {
			jeuNB.restart();
			plateau.validate();
		}
	}
}
