import java.util.*;


public class Numbers{
	 
	int nb_magic;
	int coups_total=5;
	int coup_init=1;
	int nb_chosen;
	int cp_essai=coups_total;
	boolean verif=true;

	
	
	public void rand_val (){
		Random valeur =new Random();
		this.nb_magic=1+valeur.nextInt(99);
	}
	
	public void start(){
	while(verif){
		try {
	
		Scanner input=new Scanner (System.in);
		
		for(this.coup_init=1;this.coups_total>=this.coup_init;this.coup_init++){
			this.cp_essai--;
		System.out.println("Essai n° "+this.coup_init+"\nIl vous reste "+(this.cp_essai)+" essai(s)");
		System.out.println("Entrez le nombre:");
		
		this.nb_chosen=input.nextInt();
		if (this.cp_essai==0){
			System.out.println("Vous avez perdu \nLe nombre magique était "+this.nb_magic);
		}else{
			if (this.nb_chosen>this.nb_magic){
				System.out.println("Trop grand");
			}
			if (this.nb_chosen<this.nb_magic){
				System.out.println("Trop petit");
			}
			if (this.nb_chosen==this.nb_magic){
				System.out.println("Bravo !!! Vous avez gagné");
				break;
			}
		}
		
		}
		input.close();
	} catch (Exception e) {
		System.out.println("\nSaisie incorrecte. Le jeu recommence...\n");
		this.coup_init=1;
		this.cp_essai=5;
		continue;
	}
		break;
	}
	}

		
	
	
	
	public static void main(String[] args) {
		Numbers jeu=new Numbers();
		jeu.rand_val();
		System.out.println("Le nombre magique est compris entre 1 et 100");
		jeu.start();
		
	}

	
}

 