import java.util.*;


public class Mots {
	String [] words = {"Dictionnaire","Image","Piano","Enveloppe","Etiquette","Différence","Discussion",
			"Ecole","Journal","Famille","Maison","Tempete","Cheval","Chat","Tortue","Souvenir","Cadeau","Professeur","Roue","Chapeau"};
	String [] alphabets ={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t",
			"u","v","w","x","y","z"};
	int i=0;
	String motADeviner;
	String[] chacarters;
	
	public void rand_word(){
		 Random word = new Random();
		 int select = word.nextInt(words.length);
		 this.motADeviner=words[select];
	}
	
	public void split_chars(){
		this.chacarters=(this.motADeviner).split("");
		System.out.println(java.util.Arrays.toString(this.chacarters));
	}
	
	public void some_chars (){
		System.out.println(this.chacarters[0]);
	}
	
	
	
	
	public void display_word(){
		 System.out.println("Le mot est: "+this.motADeviner);
	}
	



	public static void main(String[] args) {
		Mots jeu= new Mots();
		jeu.rand_word();
		jeu.display_word();
		jeu.split_chars();
		jeu.some_chars();
		
	}

}
