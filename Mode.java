package com.classe;

class Mode {
	protected int coup_total;
	protected int coup_init = 1;
	protected int nbCoup;
	protected int cp_essai;
	private Integer integer;

	protected void coupIllimite() {
		integer = (Integer) null;
		this.coup_total = integer;
	}

	protected void setCoup(int nbCoup) {
		this.coup_total = nbCoup;
		this.cp_essai = nbCoup;
		this.nbCoup = nbCoup;
	}
}
