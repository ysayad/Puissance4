import java.lang.*;
import java.util.Scanner;
public class Jeu {
    int[][] grille;
    int joueur;
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
    }

    public void ajout(int num_colonne) {
        if (this.grille[0][num_colonne]!=0) {
            jouer();
        } else {

            for (int i = 0; i < 6; i += 1) {
                if (this.grille[i][num_colonne] != 0 || (this.grille[i][num_colonne] == 0 && i >= 5)) {
                    if (this.joueur==1) {
                        this.grille[i - 1][num_colonne] = 1;
                        this.joueur=2;
                        break;
                    }
                    this.grille[i - 1][num_colonne] = 2;
                    this.joueur=1;
                    break;
                } else if (this.grille[5][num_colonne] == 0) {

                    if (this.joueur==1) {
                        this.grille[5][num_colonne] = 1;
                        this.joueur=2;
                        break;
                    }
                    this.grille[5][num_colonne] = 2;
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

    }





    public static void main(String[] args) {
        Jeu jeu = new Jeu();
        while(true) {
            jeu.jouer();
            jeu.affiche_matrice();
        }
    }
}