package com.classe;

class Mode {
	protected int coup_total;
	protected int coup_init = 1;
	private Integer integer;

	protected void coupIllimite() {
		integer = (Integer) null;
		this.coup_total = integer;	
	}
	
	protected void coupDef(int nbCoup) {
		this.coup_total = nbCoup;
	}
}
