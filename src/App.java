import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;

public class App {

    public static void Jeu() {


        JFrame fenetre = new JFrame();
        JDialog quitter = new JDialog(fenetre, "Quitter ?", true);

        fenetre.setTitle("Puissance 4");
        fenetre.setLocation(0,0);
        fenetre.setSize(300, 300);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel titre = new JPanel();
        titre.add(new JLabel("Puissance 4"), BorderLayout.CENTER);


        Dessin fond = new Dessin("fond_du_jeu");
        JPanel fond_du_jeu = new JPanel();
        GridLayout fond_du_jeu_gridlayout = new GridLayout(1,1);
        fond_du_jeu.setLayout(fond_du_jeu_gridlayout);
        fond_du_jeu.add(fond);

        JPanel jeu = new JPanel();
        GridLayout jeu_gridlayout = new GridLayout(9,9);
        jeu.setLayout(jeu_gridlayout);
        jeu.add(new Dessin("jeton"));



        //temporaire
        fenetre.add(new JPanel(),BorderLayout.SOUTH);
        fenetre.add(new JPanel(),BorderLayout.WEST);
        fenetre.add(new JPanel(),BorderLayout.EAST);
        //fin


        fenetre.add(titre, BorderLayout.NORTH);
        fenetre.add(fond_du_jeu, BorderLayout.CENTER);

        fenetre.setVisible(true);
    }

    public static void main(String[] args) {
        Jeu(); // On lance le jeu
    }
}