import javax.swing.*;
import java.awt.*;

import javax.swing.*;
import java.awt.*;

public class App {

    public static void Jeu() {



        JPanel background = new JPanel();

        GridBagLayout gbl = new GridBagLayout();
        background.setLayout(gbl);
        background.setBackground(Color.lightGray);


        JPanel puissance4 = new JPanel();
        GridLayout test = new GridLayout(6,7);
        puissance4.setBackground(Color.red);
        puissance4.setLayout(test);

        for(int i = 0 ;i<42;i+=1){
            puissance4.add(new JLabel("z"));
        }

        GridBagConstraints gbc = new GridBagConstraints();





        JFrame fenetre = new JFrame();
        fenetre.setTitle("Puissance 4");
        fenetre.setLocation(0,0);
        fenetre.setSize(300, 300);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        background.add(puissance4);
        fenetre.add(background);

        fenetre.setVisible(true);
    }

    public static void main(String[] args) {
        Jeu(); // On lance le jeu
    }
}

