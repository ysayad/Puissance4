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

    public Jeu() {
        this.joueur = 1;
        this.grille = new int[6][7];
        for (int i = 0 ; i < 6 ; i += 1 ) {
            for (int j = 0 ; j < 7 ; j += 1 ){
                this.grille[i][j]=0;
            }
        }
    }

    public void jouer(){
        Scanner input = new Scanner(System.in);
        this.ajout(input.nextInt());
        this.verif_gagner();
    }

    public void ajout(int num_colonne) {
        this.cdernier_coups = num_colonne;
        this.dernier_joueur = this.joueur;
        if (this.grille[0][num_colonne]!=0) {
            jouer();
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




    public void verif_gagner(){
        int cpt = 1;
        for(int j = 1; j<=3 ; j+=1){
            if (this.cdernier_coups+j < 6){
                if(this.grille[this.ldernier_coups][this.cdernier_coups+j]==this.dernier_joueur){
                    cpt+=1;
                    if (cpt == 4){
                        System.out.println("Le joueur "+this.dernier_joueur+" a Gagné !");
                        break;
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
                        break;
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
                        break;
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
                        break;
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
                        break;
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
                        break;
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
                        break;
                    }
                }
            }
        }
        System.out.println("diagonale bas droite : "+ cpt);


        System.out.println("winval : "+cpt);
    }





    public static void main(String[] args) {
        Jeu jeu = new Jeu();

        JFrame fenetre = new JFrame();
        fenetre.setTitle("Puissance 4");
        fenetre.setLocation(0,0);
        fenetre.setSize(1920, 900);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Circle test = new Circle(50, jeu.grille);
        fenetre.add(test);
        fenetre.setVisible(true);

        while(true) {
            jeu.jouer();
            jeu.affiche_matrice();
            test.repaint();
        }
    }
}