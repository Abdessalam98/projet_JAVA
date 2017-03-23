package com.classe;
import java.util.*;


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
	String letter_rand;
	String motADeviner;
	String[] characters;
	String word_chosen;
	
	public void rand_word(){
		 Random word = new Random();
		 int select = word.nextInt(words.length);
		 this.motADeviner=words[select];
		 this.length=(this.motADeviner).length();
	}
	
	/*public void rand_letter(){
		for(int i=0; i<10;i++){
		 Random letter = new Random();
		 int select = letter.nextInt(alphabets.length);
		 this.letter_rand=alphabets[select];
	}
	}*/
	
	public void split_chars(){
		this.characters=(this.motADeviner).split("");
	}
		
	public void unorder_split (){
		String temp;
		for(int i=(this.length)-1;i>0;i--){
	           int j = (int)(Math.random()*(i + 1));
	            temp = this.characters[i];
	            this.characters[i] =this.characters[j];
	            this.characters[j] = temp;
		}
		
	}
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
	
	
	public void display_chars(){

	}
	
	
	public void display_word(){
		
	}
	public void start(){
		Scanner value =new Scanner(System.in);
		for(this.coup_init=1;this.coups_total>=this.coup_init;this.coup_init++){
			this.cp_essai--;
		System.out.println("Essai n° "+this.coup_init+"\nIl vous reste "+(this.cp_essai)+" essai(s)");
		System.out.println("Entrez le mot");
		this.word_chosen=value.nextLine();
		if (this.coups_total<=this.coup_init){
			System.out.println("Vous avez perdu \nLe mot magique était "+this.motADeviner);
		}else{
		if (this.word_chosen.equals(this.motADeviner)){
				System.out.println("Bravo !!! Vous avez gagné");
				break;}
		}
		}
	}



	public static void main(String[] args) {
		Mots jeu= new Mots();
		jeu.rand_word();
		jeu.display_word();
		jeu.split_chars();
		jeu.unorder_split();
		jeu.add_array();
		jeu.start();
		jeu.display_chars();
	}

}
