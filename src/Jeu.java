import java.lang.*;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;

public class Jeu {
    int[][] grille;
    int joueur;
    int dernier_joueur;
    int ldernier_coups;
    int cdernier_coups;
    Circle test;
    JFrame fenetre;

    public Jeu(JFrame fenetre) {
        this.fenetre = fenetre;
        this.joueur = 1;
        this.grille = new int[6][7];
        for (int i = 0 ; i < 6 ; i += 1 ) {
            for (int j = 0 ; j < 7 ; j += 1 ){
                this.grille[i][j]=0;
            }
        }
        this.test = new Circle(50, this);
    }

    public void repaint(){
        this.test.repaint();
    }
    public void jouer(int zebi){
        this.ajout(zebi);
        this.verif_gagner();
        this.repaint();
    }

    public void ajout(int num_colonne) {
        this.cdernier_coups = num_colonne;
        this.dernier_joueur = this.joueur;
        if (this.grille[0][num_colonne]!=0) {
            jouer(num_colonne);
        } else {

            for (int i = 0; i < 6; i += 1) {
                if (this.grille[i][num_colonne] != 0 || (this.grille[i][num_colonne] == 0 && i >= 5)) {
                    if (this.joueur==1) {
                        this.grille[i - 1][num_colonne] = 1;
                        this.joueur=2;
                        this.ldernier_coups=i-1;
                        break;
                    }
                    this.grille[i - 1][num_colonne] = 2;
                    this.joueur=1;
                    this.ldernier_coups=i-1;
                    break;
                } else if (this.grille[5][num_colonne] == 0) {

                    if (this.joueur==1) {
                        this.grille[5][num_colonne] = 1;
                        this.joueur=2;
                        this.ldernier_coups=5;
                        break;
                    }
                    this.grille[5][num_colonne] = 2;
                    this.ldernier_coups=5;
                    this.joueur=1;
                    break;



                }
            }
        }
    }


    public void affiche_matrice(){
        for (int i = 0 ; i < 6 ; i += 1 ) {
            for (int j = 0 ; j < 7 ; j += 1 ){
                System.out.print(this.grille[i][j]);
            }
            System.out.println("");

        }
    }




    public int verif_gagner(){
        int cpt = 1;
        for(int j = 1; j<=3 ; j+=1){
            if (this.cdernier_coups+j < 6){
                if(this.grille[this.ldernier_coups][this.cdernier_coups+j]==this.dernier_joueur){
                    cpt+=1;
                    if (cpt == 4){
                        System.out.println("Le joueur "+this.dernier_joueur+" a Gagné !");
                        return this.dernier_joueur;
                    }
                }
            }
        }
        System.out.println("droite : "+ cpt);


        for(int j = 1; j<=3 ; j+=1){
            if (this.cdernier_coups-j >= 0){
                if(this.grille[this.ldernier_coups][this.cdernier_coups-j]==this.dernier_joueur){
                    cpt+=1;
                    if (cpt == 4){
                        System.out.println("Le joueur "+this.dernier_joueur+" a Gagné !");
                        return this.dernier_joueur;
                    }

                }
            }
        }
        System.out.println("gauche : "+ cpt);







        cpt = 1;
        for(int i = 1; i<=3 ; i+=1){
            if (this.ldernier_coups+i < 6){
                if(this.grille[this.ldernier_coups+i][this.cdernier_coups]==this.dernier_joueur){
                    cpt+=1;
                    if (cpt == 4){
                        System.out.println("Le joueur "+this.dernier_joueur+" a Gagné !");
                        return this.dernier_joueur;
                    }
                }
            }
        }
        System.out.println("bas : "+ cpt);


        cpt = 1;
        for(int i = 1; i<=3 ; i+=1){
            if (this.ldernier_coups-i >= 0 && this.cdernier_coups-i >= 0){
                if(this.grille[this.ldernier_coups-i][this.cdernier_coups-i]==this.dernier_joueur){
                    cpt+=1;
                    if (cpt == 4){
                        System.out.println("Le joueur "+this.dernier_joueur+" a Gagné !");
                        return this.dernier_joueur;
                    }
                }
            }
        }
        System.out.println("bas gauche : "+ cpt);


        cpt = 1;
        for(int i = 1; i<=3 ; i+=1){
            if (this.ldernier_coups+i < 6 && this.cdernier_coups+i < 7){
                if(this.grille[this.ldernier_coups+i][this.cdernier_coups+i]==this.dernier_joueur){
                    cpt+=1;
                    if (cpt == 4){
                        System.out.println("Le joueur "+this.dernier_joueur+" a Gagné !");
                        return this.dernier_joueur;
                    }
                }
            }
        }
        System.out.println("diagonale haut droite : "+ cpt);



        cpt = 1;
        for(int i = 1; i<=3 ; i+=1){
            if (this.ldernier_coups+i < 6 && this.cdernier_coups-i >= 0){
                if(this.grille[this.ldernier_coups+i][this.cdernier_coups-i]==this.dernier_joueur){
                    cpt+=1;
                    if (cpt == 4){
                        System.out.println("Le joueur "+this.dernier_joueur+" a Gagné !");
                        return this.dernier_joueur;
                    }
                }
            }
        }
        System.out.println("diagonale haut gauche : "+ cpt);


        cpt = 1;
        for(int i = 1; i<=3 ; i+=1){
            if (this.ldernier_coups-i >= 0 && this.cdernier_coups+i < 7){
                if(this.grille[this.ldernier_coups-i][this.cdernier_coups+i]==this.dernier_joueur){
                    cpt+=1;
                    if (cpt == 4){
                        System.out.println("Le joueur "+this.dernier_joueur+" a Gagné !");
                        return this.dernier_joueur;
                    }
                }
            }
        }
        System.out.println("diagonale bas droite : "+ cpt);


        System.out.println("winval : "+cpt);
        return -1;
    }


    public void ecranfin(){
        this.fenetre.add(new JLabel("le joueur "+this.dernier_joueur+" à gagné !"), BorderLayout.NORTH);
        this.fenetre.invalidate();
        this.fenetre.validate();
        this.fenetre.repaint();
    }


    public static void main(String[] args) {

        JFrame fenetre = new JFrame();
        fenetre.setTitle("Puissance 4");
        fenetre.setLocation(0,0);
        fenetre.setSize(1920, 900);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Jeu jeu = new Jeu(fenetre);
        fenetre.add(jeu.test, BorderLayout.CENTER);
        jeu.test.setBackground(Color.GRAY);
        fenetre.setVisible(true);
        CircleListener listener = new CircleListener(jeu);
        fenetre.addMouseListener(listener);


    }
}