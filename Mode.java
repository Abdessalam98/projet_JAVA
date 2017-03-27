package com.classe;

import javax.swing.JLabel;
import javax.swing.JTextField;

class Mode {
	protected int coup_total = 0;
	protected int coup_init = 1;
	protected int nbCoup;
	protected int cp_essai;
	protected boolean coupIllimite = false;
	protected JTextField answer;
	protected JLabel labelReponse;
	protected JLabel labelInfo;

	public Mode(JTextField answer, JLabel labelReponse, JLabel labelInfo) {
		// TODO Auto-generated constructor stub
		this.answer = answer;
		this.labelInfo = labelInfo;
		this.labelReponse = labelReponse;
	}
	
	protected void setCoup(int nbCoup) {
		this.coup_total = nbCoup;
		this.cp_essai = nbCoup;
		this.nbCoup = nbCoup;
	}
	
	protected void setIllimite() {
		this.coupIllimite = true;
	}
	
	protected void getInfo() {
		if (coupIllimite) {
			labelInfo.setText("Essai n° " + this.coup_init + "\n Il vous reste \u221E essai(s)");				
		} else {
			labelInfo.setText("Essai n° " + this.coup_init + "\n Il vous reste " + (this.cp_essai) + " essai(s)");
		}
	}
}
