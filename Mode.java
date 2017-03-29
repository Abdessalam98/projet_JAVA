package com.classe;

import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * 
 * Nom du fichier: Mode.java 
 * Date: 29 mars 2017
 * Membres du Projet:
 * Laurent Panek, Abdessamad Douhi
 * Abdessalam Benharira, Branis Lamrani
 * Chef de Projet: Branis Lamrani
 */
class Mode {
	protected int coup_total = 0;
	protected int coup_init = 1;
	protected int nbCoup;
	protected int cp_essai;
	protected boolean coupIllimite = false;
	protected JTextField answer;
	protected JLabel labelReponse;
	protected JLabel labelInfo;

	/**
	 * Constructeur Mode
	 * 
	 * @param answer
	 * @param labelReponse
	 * @param labelInfo
	 */
	public Mode(JTextField answer, JLabel labelReponse, JLabel labelInfo) {
		// TODO Auto-generated constructor stub
		this.answer = answer;
		this.labelInfo = labelInfo;
		this.labelReponse = labelReponse;
	}

	/**
	 * Cette méthode permet définir le nombre d'essais
	 * 
	 * @param nbCoup
	 */
	protected void setCoup(int nbCoup) {
		this.coup_total = nbCoup;
		this.cp_essai = nbCoup;
		this.nbCoup = nbCoup;
	}

	/**
	 * Cette méthode permet de jouer en illimité
	 */
	protected void setIllimite() {
		this.coupIllimite = true;
	}

	/**
	 * Cette méthode permet d'afficher le nombre d'essais donnés et le nombre
	 * d'essais restants
	 */
	protected void getInfo() {
		if (coupIllimite) {
			labelInfo.setText("Essai n° " + this.coup_init
					+ "\n Il vous reste \u221E essai(s)");
		} else {
			labelInfo.setText("Essai n° " + this.coup_init
					+ "\n Il vous reste " + (this.cp_essai) + " essai(s)");
		}
	}
}