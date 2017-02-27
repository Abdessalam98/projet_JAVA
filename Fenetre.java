package com.classe;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame{

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
  CardLayout cl = new CardLayout();
  JPanel content = new JPanel();
  //Liste des noms de nos conteneurs pour la pile de cartes
  String[] listContent = {"CARD_1", "CARD_2", "CARD_3", "CARD_4"};
  int indice = 0;

  /**
 * 
 */
public Fenetre(){
    this.setTitle("CardLayout");
    this.setSize(300, 300);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
		
    //On crée trois conteneurs de couleur différente
    JPanel menu = new JPanel();
    menu.setBackground(Color.black);		
    JPanel mode = new JPanel();
    mode.setBackground(Color.red);		
    JPanel nombre = new JPanel();
    nombre.setBackground(Color.green);
    JPanel mot = new JPanel();
    mot.setBackground(Color.blue);

    JPanel boutonPane = new JPanel();
    JButton goNB = new JButton("Nombre");
    //Définition de l'action du bouton
    goNB.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){
        cl.show(content, listContent[2]);
        Nombre jeu = new Nombre();
        jeu.start();
      }
    });
		
    JButton goMOT = new JButton("Mot");
    //Définition de l'action du bouton2
    goMOT.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){				
        cl.show(content, listContent[3]);
        Mot jeu = new Mot();
        jeu.start();
      }
    });
    
    JButton toMenu = new JButton("Menu");
    
    toMenu.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent event) {
			cl.show(content, listContent[0]);
		}
	});
    
    JButton toMode = new JButton("Mode");
    
    toMode.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent event) {
			cl.show(content, listContent[1]);
			Mode mode = new Mode();
		}
	});
		
    menu.add(goNB);
    menu.add(goMOT);
    mot.add(toMode);
    boutonPane.add(toMenu);
    //On définit le layout
    content.setLayout(cl);
    //On ajoute les cartes à la pile avec un nom pour les retrouver
    content.add(menu, listContent[0]);
    content.add(mode, listContent[1]);
    content.add(nombre, listContent[2]);
    content.add(mot, listContent[3]);

    this.getContentPane().add(boutonPane, BorderLayout.SOUTH);
    this.getContentPane().add(content, BorderLayout.CENTER);
    this.setVisible(true);
  }
  
  public static void main(String[] args) {
		
		Fenetre fen = new Fenetre();

	}
}

