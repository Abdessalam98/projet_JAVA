package com.classe;

class Mode {
	protected int coup_total = 0;
	protected int coup_init = 1;
	protected int nbCoup;
	protected int cp_essai;
	protected boolean coupIllimite = false;

	protected void setCoup(int nbCoup) {
		this.coup_total = nbCoup;
		this.cp_essai = nbCoup;
		this.nbCoup = nbCoup;
	}
	
	protected void setIllimite() {
		this.coupIllimite = true;
	}
}
