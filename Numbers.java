package com.classe;

import java.util.*;

import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * 
 * Nom du fichier: Numbers.java 
 * Date: 29 mars 2017
 * Membres du Projet:
 * Laurent Panek, Abdessamad Douhi
 * Abdessalam Benharira, Branis Lamrani
 * Chef de Projet: Branis Lamrani
 */
public class Numbers extends Mode {

	int nb_magic;
	int nb_chosen;
	int value;
	boolean verif = true;

	/**
	 * Constructeur Numbers
	 * 
	 * @param answer
	 * @param labelReponse
	 * @param labelInfo
	 */
	public Numbers(JTextField answer, JLabel labelReponse, JLabel labelInfo) {
		super(answer, labelReponse, labelInfo);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Cette méthode permet au système de générer aléatoirement un nombre
	 * compris entre deux valeurs
	 * 
	 * @return rand_value
	 */
	public int rand_val() {
		Random valeur = new Random();
		return 1 + valeur.nextInt(99);
	}

	/**
	 * Cette méthode permet de récupérer le contenu du champ et l'affecter à
	 * nb_magic
	 * 
	 * @param value
	 */

	public void setNB(int value) {
		this.nb_magic = value;
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
			this.nb_chosen = value;
			if (this.nb_chosen > this.nb_magic) {
				labelReponse.setText("Trop grand");
			} else if (this.nb_chosen < this.nb_magic) {
				labelReponse.setText("Trop petit");
			} else if (this.nb_chosen == this.nb_magic) {
				labelReponse.setText("<html><font color='green'>\u2713</font> Bravo !!! Vous avez gagné</html>");
			} else if (this.cp_essai == 0) {
				labelReponse
						.setText("<html><font color='red'>\u274C</font> Vous avez perdu !!! Le nombre magique était</html> "
								+ this.nb_magic);
			}
		}
	}

	/**
	 * Cette méthode permet d'éviter le disfonctionnement du programme lorsque
	 * l'utilisateur insère un type de valeur différent de celui qui est demandé
	 */
	public void sendValue() {
		try {
			value = Integer.parseInt(answer.getText());
		} catch (Exception e) {
			labelInfo
					.setText("\u26A0 Erreur \u26A0 Votre réponse est incorrecte !");
			verif = false;
		}

	}
/**
 * Cette méthode permet de recommencer le jeu
 */
	public void restart() {
		this.coup_init = 1;
		this.cp_essai = nbCoup;
		this.coup_total = nbCoup;
		this.coupIllimite = false;
		this.rand_val();
		this.getInfo();
		verif = true;
		labelReponse.setText("");
	}
}