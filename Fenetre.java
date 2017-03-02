package com.classe;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Fenetre extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	CardLayout cl = new CardLayout();
	JPanel content = new JPanel();
	// Liste des noms de nos conteneurs pour la pile de cartes
	JPanel mode = new JPanel();
	String[] listContent = { "CARD_1", "CARD_2", "CARD_3", "CARD_4", "CARD_5" };
	private JButton goNB = new JButton("Nombre");
	private JButton goMot = new JButton("Mot");
	private JRadioButton infinite_chance = new JRadioButton("Coup Infini");
	private JRadioButton fixed_chance = new JRadioButton("Coup maximum");
	private JButton play = new JButton("Jouer");
	private JTextField nb_coup = new JTextField(5);
	private JPanel plateau = new JPanel();
	private JButton ans = new JButton("Soumettre");
	private String isMode;
	private JLabel label1 = new JLabel("Devinez le nombre magique");
	private JLabel label2 = new JLabel("Devinez le mot magique");

	public Fenetre() {

		this.setTitle("CardLayout");
		this.setSize(600, 500);
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

		boutonPane.add(toMenu);
		// On définit le layout
		content.setLayout(cl);
		// On ajoute les cartes à la pile avec un nom pour les retrouver
		content.add(menu, listContent[0]);
		content.add(this.mode, listContent[1]);
		content.add(this.plateau, listContent[4]);

		this.getContentPane().add(boutonPane, BorderLayout.SOUTH);
		this.getContentPane().add(content, BorderLayout.CENTER);
		this.setVisible(true);
	}

	public JPanel defMenu() {
		JPanel menu = new JPanel();
		menu.setBackground(Color.gray);

		JLabel titre = new JLabel("LE NOM DU JEU");

		// Définition de l'action du bouton
		this.goNB.addActionListener(this);

		// Définition de l'action du bouton2
		this.goMot.addActionListener(this);

		menu.add(titre);
		menu.add(this.goNB);
		menu.add(this.goMot);

		return menu;

	}

	public void defMode() {
		this.mode.setBackground(Color.red);

		this.play.addActionListener(this);

		ButtonGroup group = new ButtonGroup();

		group.add(this.infinite_chance);
		group.add(this.fixed_chance);

		this.infinite_chance.setSelected(true);
		this.infinite_chance.addActionListener(this);
		this.fixed_chance.addActionListener(this);

		this.nb_coup.setVisible(false);

		this.mode.add(this.infinite_chance);
		this.mode.add(this.fixed_chance);
		this.mode.add(this.nb_coup);
		this.mode.add(this.play);

	}

	public void defPlateau() {
		plateau.setBackground(Color.lightGray);
		JTextField answer = new JTextField(20);

		ans.addActionListener(this);
		answer.addActionListener(this);

		plateau.add(answer);
		plateau.add(ans);

	}

	public static void main(String[] args) {

		Fenetre fen = new Fenetre();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == goMot) {
			cl.show(content, listContent[1]);
			isMode = "mot";
			plateau.remove(label1);
			plateau.add(label2);
			plateau.validate();
		} else if (source == goNB) {
			cl.show(content, listContent[1]);
			isMode = "nb";
			plateau.remove(label2);
			plateau.add(label1);
			plateau.validate();
		} else if (source == play) {
			cl.show(content, listContent[4]);
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
		}
	}
}
