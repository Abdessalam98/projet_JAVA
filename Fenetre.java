package com.classe;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Fenetre extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
  CardLayout cl = new CardLayout();
  JPanel content = new JPanel();
  //Liste des noms de nos conteneurs pour la pile de cartes
  String[] listContent = {"CARD_1", "CARD_2", "CARD_3", "CARD_4", "CARD_5"};
  
public Fenetre(){
    this.setTitle("CardLayout");
    this.setSize(300, 300);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
		
    JPanel menu = new JPanel();
    menu.setBackground(Color.black);
    JPanel mode = new JPanel();
    mode.setBackground(Color.red);		
    JPanel nombre = new JPanel();
    nombre.setBackground(Color.green);
    JPanel mot = new JPanel();
    mot.setBackground(Color.blue);
    JPanel plateau = new JPanel();
    plateau.setBackground(Color.darkGray);
    JPanel boutonPane = new JPanel();
    
    
    JLabel label1 = new JLabel("Devinez le nombre magique");
    JTextField answer = new JTextField(20);
    JTextField nb_coup = new JTextField(5);

    JButton goNB = new JButton("Nombre");
    //Définition de l'action du bouton
    goNB.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){
        cl.show(content, listContent[1]);
        /* Nombre jeu = new Nombre();
        jeu.start(); */
      }
    });
		
    JButton goMOT = new JButton("Mot");
    //Définition de l'action du bouton2
    goMOT.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){				
        cl.show(content, listContent[1]);
        /* Mot jeu = new Mot(); */
      }
    });
    
    JButton ans = new JButton("Soumettre");
    
    ans.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			/* jeu.reponse(answer.getText(); */
			
		}
	});
    
    JButton toMenu = new JButton("Menu");
    
    toMenu.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent event) {
			cl.show(content, listContent[0]);
		}
	});
    
    JButton play = new JButton("Jouer");
    
    play.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			cl.show(content, listContent[4]);
			/*jeu.setNBcoup();
			 * jeu.start();*/
		}
	});
    /*infinite = jeu.coupIllimite();
     * fixed = jeu.coupDef();*/
    JRadioButton infinite_chance = new JRadioButton("Coup Infini");
    //infinite_chance.setActionCommand(infinite);
    infinite_chance.setSelected(true);
    
    JRadioButton fixed_chance = new JRadioButton("Coup maximum");
    fixed_chance.setActionCommand(getWarningString());
    
    ButtonGroup group = new ButtonGroup();
    group.add(infinite_chance);
    group.add(fixed_chance);
    
    infinite_chance.addActionListener(this);
    fixed_chance.addActionListener(this);
    
    if (fixed_chance.getSelectedObjects() == null ) {
    	nb_coup.setVisible(false);
	}
    else {
    	nb_coup.setVisible(true);
    }
    
    mode.add(infinite_chance);
    mode.add(fixed_chance);
    mode.add(nb_coup);
    answer.addActionListener(this);
    plateau.add(label1);
    plateau.add(answer);
    plateau.add(ans);
    menu.add(goNB);
    menu.add(goMOT);
    mode.add(play);
    boutonPane.add(toMenu);
    //On définit le layout
    content.setLayout(cl);
    //On ajoute les cartes à la pile avec un nom pour les retrouver
    content.add(menu, listContent[0]);
    content.add(mode, listContent[1]);
    content.add(nombre, listContent[2]);
    content.add(mot, listContent[3]);
    content.add(plateau, listContent[4]);

    this.getContentPane().add(boutonPane, BorderLayout.SOUTH);
    this.getContentPane().add(content, BorderLayout.CENTER);
    this.setVisible(true);
  }
  
  public static void main(String[] args) {
		
		Fenetre fen = new Fenetre();

	}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}
}

