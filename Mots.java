package com.classe;
import java.util.*;

import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * 
 * Nom du fichier: Mots.java 
 * Date: 27 mars 2017
 * Membres du Projet:
 * Laurent Panek, Abdessamad Douhi
 * Abdessalam Benharira, Branis Lamrani
 * Chef de Projet: Branis Lamrani
 */
public class Mots extends Mode {
	String [] words = {"avion","image","piano","enveloppe","etiquette","difference","discussion",
			"ecole","journal","famille","maison","tempete","bouton","chat","tortue","souvenir","cadeau","professeur","roue","chapeau"};
	String [] alphabets ={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t",
			"u","v","w","x","y","z"};
	int i=0;
	int length;
	int coups_total=10;
	int coup_init=1;
	int cp_essai=coups_total;
	JTextField answer;
	JLabel labelReponse;
	JLabel labelInfo;
	String value;
	String letter_rand;
	String motADeviner;
	String[] characters;
	String word_chosen;
	boolean verif = true;
	
	public Mots(JTextField answer, JLabel labelReponse, JLabel labelInfo){
		super(answer, labelReponse, labelInfo);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Cette méthode permet de choisir un mot à partir d'une liste
	 */
	public void rand_word(){
		 Random word = new Random();
		 int select = word.nextInt(words.length);
		 this.motADeviner=words[select];
		 this.length=(this.motADeviner).length();
	}
	
	
	public void setMot(String value) {
		this.motADeviner = value;
	}
	
	/*public void rand_letter(){
		for(int i=0; i<10;i++){
		 Random letter = new Random();
		 int select = letter.nextInt(alphabets.length);
		 this.letter_rand=alphabets[select];
	}
	}*/
	
	
	/**
	 * Cette méthode permet de diviser le mot en plusieurs lettres
	 */
	public void split_chars(){
		this.characters=(this.motADeviner).split("");
	}
	/**
	 * Cette méthode permet de mettre en désordre les lettes du mot
	 */
	public void unorder_split (){
		String temp;
		for(int i=(this.length)-1;i>0;i--){
	           int j = (int)(Math.random()*(i + 1));
	            temp = this.characters[i];
	            this.characters[i] =this.characters[j];
	            this.characters[j] = temp;
		}
		
	}
	/**
	 * Cette méthode permet de créér un arraylist et d'y stocker les lettres du mot
	 * en désordre en ajoutant des lettres intruses de l'alphabet
	 */
	public void add_array () {		
		ArrayList<String> new_words =new ArrayList<String>();
		
		for(int i=0; i<1;i++){
			 Random letter = new Random();
			 int select = letter.nextInt(alphabets.length);
			 this.letter_rand=alphabets[select];
			 new_words.add(this.letter_rand);
			 for (int z=0;z<this.length;z+=1){
					new_words.add(this.characters[z]);
				}
		}
		System.out.println("Indices");
		String list=Arrays.toString(new_words.toArray()).replace("[", "").replace("]", "");
		System.out.println(list);
		
	}
	
	/**
	 * Cette méthode permet de commencer le jeu
	 */
	public void start(){
		for(this.coup_init=1;this.coups_total>=this.coup_init;this.coup_init++){
			this.cp_essai--;
		System.out.println("Essai n° "+this.coup_init+"\nIl vous reste "+(this.cp_essai)+" essai(s)");
		System.out.println("Entrez le mot");
		if (this.coups_total<=this.coup_init){
			System.out.println("Vous avez perdu \nLe mot magique était "+this.motADeviner);
		}else{
		if (this.word_chosen.equals(this.motADeviner)){
				System.out.println("Bravo !!! Vous avez gagné");
				break;
				}
		}
		}
	}
	public void sendValue() {
		try {
			if((answer.getText()).matches("^[A-Za-z, ]++$")){
				value = answer.getText();
			}else{
				labelInfo.setText("/!\\ Erreur /!\\ Votre réponse est incorrecte !");
				verif = false;
			}
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
		this.rand_word();
		this.getInfo();
		verif = true;
		labelReponse.setText("");
	}

}
