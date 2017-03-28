package com.classe;

import java.util.*;

import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * 
 * Nom du fichier: Mots.java Date: 27 mars 2017 Membres du Projet: Laurent
 * Panek, Abdessamad Douhi Abdessalam Benharira, Branis Lamrani Chef de Projet:
 * Branis Lamrani
 */
public class Mots extends Mode {
	String[] words = { "avion", "image", "piano", "enveloppe", "etiquette", "difference", "discussion", "ecole",
			"journal", "famille", "maison", "tempete", "bouton", "chat", "tortue", "souvenir", "cadeau", "professeur",
			"roue", "chapeau" };
	String[] alphabets = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
			"s", "t", "u", "v", "w", "x", "y", "z" };
	int i = 0;
	int length;
	String letter_rand;
	String motADeviner;
	String[] characters;
	String word_chosen;
	JLabel labelIndice;
	boolean verif = true;

	public Mots(JTextField answer, JLabel labelReponse, JLabel labelInfo, JLabel labelIndice) {
		super(answer, labelReponse, labelInfo);
		this.labelIndice = labelIndice;
		// TODO Auto-generated constructor stub
	}

	/**
	 * Cette m√©thode permet de choisir un mot √† partir d'une liste
	 */
	public String rand_word() {
		Random word = new Random();
		int select = word.nextInt(words.length);
		return words[select];
	}

	public void setMot(String value) {
		this.motADeviner = value;
		this.length = motADeviner.length();

	}

	/**
	 * Cette m√©thode permet de diviser le mot en plusieurs lettres
	 */
	private void split_chars() {
		Random letter = new Random();
		int select = letter.nextInt(alphabets.length);
		this.letter_rand = alphabets[select];
		this.characters = (this.motADeviner + this.letter_rand).split("");
	}

	/**
	 * Cette m√©thode permet de mettre en d√©sordre les lettes du mot
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
	 * Cette m√©thode permet de cr√©√©r un arraylist et d'y stocker les lettres
	 * du mot en d√©sordre en ajoutant des lettres intruses de l'alphabet
	 */
	private void add_array() {
		this.unorder_split();
		ArrayList<String> new_words = new ArrayList<String>();

		for (int i = 0; i < 1; i++) {
			for (int z = 0; z < this.length + 1; z += 1) {
				new_words.add(this.characters[z]);
			}
		}
		String list = Arrays.toString(new_words.toArray()).replace("[", "").replace("]", "");
		this.labelIndice.setText("Indices : " + list);

	}

	/**
	 * Cette m√©thode permet de commencer le jeu
	 */
	public void start() {
		if ((this.coup_total >= this.coup_init || this.coupIllimite == true) && verif == true) {
			this.cp_essai--;
			this.coup_init++;
			if (coupIllimite) {
				labelInfo.setText("Essai n∞ " + this.coup_init + "\n Il vous reste \u221E essai(s)");
			} else {
				labelInfo.setText("Essai n∞ " + this.coup_init + "\n Il vous reste " + (this.cp_essai) + " essai(s)");
			}
			if (word_chosen.equals(this.motADeviner)) {
				labelReponse.setText("Bravo !!! Vous avez gagnÈ");
			} else if (!word_chosen.equals(this.motADeviner)) {
				if (this.cp_essai == 0) {
					labelReponse.setText("Vous avez perdu ! \n Le mot magique Ètait " + this.motADeviner);
				} else {
					labelReponse.setText("Ce n'est pas le bon mot. RÈessayer !");
				}
			}
		}
	}

	public void sendValue() {
		if ((answer.getText()).matches("^[A-Za-z, ]++$")) {
			word_chosen = answer.getText();
		} else {
			labelInfo.setText("/!\\ Erreur /!\\ Votre rÈponse est incorrecte !");
			verif = false;
		}
	}

	public void getInfo() {
		if (coupIllimite) {
			labelInfo.setText("Essai n∞ " + this.coup_init + "\n Il vous reste \u221E essai(s)");
		} else {
			labelInfo.setText("Essai n∞ " + this.coup_init + "\n Il vous reste " + (this.cp_essai) + " essai(s)");
		}
		this.add_array();
	}

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
