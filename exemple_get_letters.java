import java.util.ArrayList;
import java.util.Arrays;


public class Table {
	
	
	public static void main(String[] args) {
		
		
		//Avoir les lettres de l'alphabet à partir du code ASCII
		for (int i=97;i<=122;i++){
			System.out.printf("%c"+" ",i);
			
		}
		System.out.println("\n");
		
		
		  for(int i =97; i<=122; i++)
	        {
	            System.out.println((char)i);
	        }
		
		
		for (char ch='a';ch<='z';ch++){
			System.out.println(ch);
		}
		
		
		
		
		ArrayList<Character> new_words =new ArrayList<Character>();
		for (char ch='a';ch<='z';ch++){
			new_words.add(ch);
		}
		String list=Arrays.toString(new_words.toArray()).replace("[", "").replace("]", "");
		System.out.println(list);
		
			 
		
	}
}
