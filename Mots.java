package com.classe;

import java.util.*;

import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * 
 * Nom du fichier: Mots.java 
 * Date: 29 mars 2017
 * Membres du Projet:
 * Laurent Panek, Abdessamad Douhi
 * Abdessalam Benharira, Branis Lamrani
 * Chef de Projet: Branis Lamrani
 */
public class Mots extends Mode {
	String[] words = { "avion", "image", "piano", "enveloppe", "etiquette",
			"difference", "discussion", "ecole", "journal", "famille",
			"maison", "tempete", "bouton", "chat", "tortue", "souvenir",
			"cadeau", "professeur", "roue", "chapeau" };
	String[] alphabets = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
			"k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w",
			"x", "y", "z" };
	int i = 0;
	int length;
	String letter_rand;
	String motADeviner;
	String[] characters;
	String word_chosen;
	JLabel labelIndice;
	boolean verif = true;

	/**
	 * Constructeur Mots
	 * 
	 * @param answer
	 * @param labelReponse
	 * @param labelInfo
	 * @param labelIndice
	 */
	public Mots(JTextField answer, JLabel labelReponse, JLabel labelInfo,
			JLabel labelIndice) {
		super(answer, labelReponse, labelInfo);
		this.labelIndice = labelIndice;
		// TODO Auto-generated constructor stub
	}

	/**
	 * Cette méthode permet de choisir un mot à partir d'une liste
	 */
	public String rand_word() {
		Random word = new Random();
		int select = word.nextInt(words.length);
		return words[select];
	}

	/**
	 * Cette méthode permet récupérer le contenu du champ et l'affecter à
	 * motADeviner
	 * 
	 * @param value
	 */
	public void setMot(String value) {
		this.motADeviner = value;
		this.length = motADeviner.length();

	}

	/**
	 * Cette méthode permet de diviser le mot en plusieurs lettres
	 */
	private void split_chars() {
		Random letter = new Random();
		int select = letter.nextInt(alphabets.length);
		this.letter_rand = alphabets[select];
		this.characters = (this.motADeviner + this.letter_rand).split("");
	}

	/**
	 * Cette méthode permet de mettre en désordre les lettes du mot
	 */
	private void unorder_split() {
		this.split_chars();
		String temp;
		for (int i = this.length; i > 0; i--) {
			int j = (int) (Math.random() * (i + 1));
			temp = this.characters[i];
			this.characters[i] = this.characters[j];
			this.characters[j] = temp;
		}

	}

	/**
	 * Cette méthode permet de créer un arraylist et d'y stocker les lettres du
	 * mot en désordre en ajoutant des lettres intruses de l'alphabet
	 */
	private void add_array() {
		this.unorder_split();
		ArrayList<String> new_words = new ArrayList<String>();

		for (int i = 0; i < 1; i++) {
			for (int z = 0; z < this.length + 1; z += 1) {
				new_words.add(this.characters[z]);
			}
		}
		String list = Arrays.toString(new_words.toArray()).replace("[", "")
				.replace("]", "");
		this.labelIndice.setText("Indices : " + list);

	}

	/**
	 * Cette méthode permet de commencer le jeu
	 */
	public void start() {
		if ((this.coup_total >= this.coup_init || this.coupIllimite == true)
				&& verif == true) {
			this.cp_essai--;
			this.coup_init++;
			if (coupIllimite) {
				labelInfo.setText("Essai n° " + this.coup_init
						+ "\n Il vous reste \u221E essai(s)");
			} else {
				labelInfo.setText("Essai n° " + this.coup_init
						+ "\n Il vous reste " + (this.cp_essai) + " essai(s)");
			}
			if (word_chosen.equals(this.motADeviner)) {
				labelReponse.setText("<html><font color='green'>\u2713</font> Bravo !!! Vous avez gagné</html>");
			} else if (!word_chosen.equals(this.motADeviner)) {
				if (this.cp_essai == 0) {
					labelReponse
							.setText("<html><font color='red'>\u274C</font> Vous avez perdu !!! Le mot magique était "+this.motADeviner+"</html>"
									);
				} else {
					labelReponse
							.setText("<html>Ce n'est pas le bon mot. <font color='orange'>\u27F3</font> Réessayez</html>");
				}
			}
		}
	}

	/**
	 * Cette méthode permet d'éviter le disfonctionnement du programme lorsque
	 * l'utilisateur insère un type de valeur différent de celui qui est demandé
	 */
	public void sendValue() {
		if ((answer.getText()).matches("^[A-Za-z, ]++$")) {
			word_chosen = answer.getText();
		} else {
			labelInfo
					.setText("<html><font color='red'>\u26A0</font> Erreur <font color='red'>\u26A0</font> Votre réponse est incorrecte !</html>");
			verif = false;
		}
	}

	/**
	 * Cette méthode permet d'afficher le nombre d'essais
	 */

	public void getInfo() {
		if (coupIllimite) {
			labelInfo.setText("Essai n° " + this.coup_init
					+ "\n Il vous reste \u221E essai(s)");
		} else {
			labelInfo.setText("Essai n° " + this.coup_init
					+ "\n Il vous reste " + (this.cp_essai) + " essai(s)");
		}
		this.add_array();
	}

	/**
	 * Cette méthode permet de recommencer le jeu
	 */
	public void restart() {
		this.coup_init = 1;
		this.cp_essai = nbCoup;
		this.coup_total = nbCoup;
		this.coupIllimite = false;
		this.rand_word();
		this.getInfo();
		verif = true;
		labelReponse.setText("");
	}

}