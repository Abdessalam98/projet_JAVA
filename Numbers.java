package com.classe;

import java.util.*;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class Numbers extends Mode {

	int nb_magic;
	int coup_init = 1;
	int nb_chosen;
	int value;
	boolean verif = true;

	public Numbers(JTextField answer, JLabel labelReponse, JLabel labelInfo) {
		super(answer, labelReponse, labelInfo);
		// TODO Auto-generated constructor stub
	}
	
	public int rand_val() {
		Random valeur = new Random();
		return 1 + valeur.nextInt(99);
	}
	
	public void setNB(int value) {
		this.nb_magic = value;
	}

	public void start() {
		// Scanner input=new Scanner (System.in);
		if ((this.coup_total >= this.coup_init || this.coupIllimite == true) && verif == true) {
			this.cp_essai--;
			this.coup_init++;
			if (coupIllimite) {
				labelInfo.setText("Essai n° " + this.coup_init + "\n Il vous reste \u221E essai(s)");				
			} else {
				labelInfo.setText("Essai n° " + this.coup_init + "\n Il vous reste " + (this.cp_essai) + " essai(s)");
			}
			this.nb_chosen = value;
			if (this.nb_chosen > this.nb_magic) {
				labelReponse.setText("Trop grand");
			} else if (this.nb_chosen < this.nb_magic) {
				labelReponse.setText("Trop petit");
			} else if (this.nb_chosen == this.nb_magic) {
				labelReponse.setText("Bravo !!! Vous avez gagné");
			} else if (this.cp_essai == 0) {
				labelReponse.setText("Vous avez perdu \n Le nombre magique était " + this.nb_magic);
			}
		}
	}

	public void sendValue() {
		try {
			value = Integer.parseInt(answer.getText());
		} catch (Exception e) {
			labelInfo.setText("/!\\ Erreur /!\\ Votre réponse est incorrecte !");
			verif = false;
		}

	}

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