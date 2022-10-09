import javax.swing.*;
import java.io.DataInputStream;
import java.io.FileInputStream;

public class Grille {
    JLabel cpt;
    int compteur;
    int[][] jeu;
    Case[][] bouton;
    int lignes;
    int colonnes;
    int bombes;
    JFrame fenetre;

    public Grille(JFrame fenetre, JLabel cpt){
        /*
        * ce constructeur de la class Grille recupere les information dans le meme
        * ordre que l'ont les as sauvegardé du fichier sauvegarde (test.dat)
        * et les inserts dans les variable que l'ont aura besoin pour le jeu
        * */
        this.cpt = cpt;
        this.fenetre=fenetre;

        try {

            FileInputStream fichier = new FileInputStream("test.dat");
            DataInputStream flux = new DataInputStream(fichier);




            this.lignes = flux.readInt();
            System.out.println(this.lignes);
            this.colonnes = flux.readInt();
            System.out.println(this.colonnes);
            this.bombes = flux.readInt();
            System.out.println(this.bombes);

            this.jeu = new int[this.lignes][this.colonnes];

            this.bouton = new Case[this.lignes][this.colonnes];

            for (int i = 0 ; this.lignes > i ; i++ ) {
                for (int j = 0 ; this.colonnes > j ; j++ ) {
                    this.bouton[i][j] = new Case(0, this.fenetre, i, j, this);
                    int val = flux.readInt();
                    if (val != 0){
                        for (int x =0 ; x < val+2 ; x++) {
                            this.bouton[i][j].setClick(1);
                        }
                    } else {
                        this.bouton[i][j].setClick(0);
                    }
                    System.out.println(val);
                    System.out.println(this.bouton[i][j].val);
                }
            }

            for (int i = 0; this.lignes > i; i++) {
                for (int j = 0; this.colonnes > j; j++) {
                    this.jeu[i][j] = flux.readInt();
                }
            }



        }catch (Exception zeze){
            //
        }



        this.compteur = 0;
        for (int i = 0; i < this.lignes; i++) {
            for (int j = 0; j < this.colonnes; j++) {
                if (this.bouton[i][j].val == 3) {
                    this.compteur += 1;
                }
            }
        }

        this.cpt.setText(Integer.toString( this.bombes-this.compteur));





}

    public Grille(int lignes, int colonnes, int bombes, JFrame fenetre,JLabel cpt) {

        /*
         * ce constructeur de la class Grille genere les informations utile au deroulement du jeu
         * et on les inserts dans les variable que l'ont aura besoin
         * */



        this.fenetre = fenetre;
        this.cpt = cpt;
        this.lignes = lignes;
        this.colonnes = colonnes;
        this.bombes = bombes;
        this.jeu = new int[this.lignes][this.colonnes];
        this.bouton = new Case[this.lignes][this.colonnes];

        for (int i = 0; this.lignes > i; i++) {
            for (int j = 0; this.colonnes > j; j++) {
                this.bouton[i][j] = new Case(1, this.fenetre, i, j, this);
            }
        }

        for (int i = 0; this.lignes > i; i++) {
            for (int j = 0; this.colonnes > j; j++) {
                this.jeu[i][j] = 0;
            }
        }


        int minl = 1;
        int maxl = this.lignes;
        int l = (int) (Math.random() * (maxl - minl + 1) + minl) - 1;
        int minc = 1;
        int maxc = this.colonnes;
        int c = (int) (Math.random() * (maxc - minc + 1) + minc) - 1;

        for (int e = 0; this.bombes > e; e++) {
            if (this.jeu[l][c] == -1) {
                e -= 1;
            }
            this.jeu[l][c] = -1;
            l = (int) (Math.random() * (maxl - minl + 1) + minl) - 1;
            c = (int) (Math.random() * (maxc - minc + 1) + minc) - 1;
        }




        //ceci permet de recuperer le nombre de bombe qu'il y as autour de a case
        for (int i = 0; this.lignes > i; i++) {
            for (int j = 0; this.colonnes > j; j++) {
                if (this.jeu[i][j] == -1) {
                    for (int k = -1; k <= 1; k++) {
                        for (int x = -1; x <= 1; x++) {
                            //
                            try {
                                if (this.jeu[i + k][j + x] != -1) {
                                    this.jeu[i + k][j + x] += 1;
                                }
                            } catch (Exception e) {
                                //
                            }
                        }
                    }
                }
            }
        }


        int compteur = 0;
        for (int i = 0; i < this.lignes; i++) {
            for (int j = 0; j < this.colonnes; j++) {
                if (this.bouton[i][j].val == 3) {
                    this.compteur += 1;
                }
            }
        }

        this.cpt.setText(Integer.toString( this.bombes-this.compteur));

    }



}
