import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import star.StarRating;

public class MenuListener implements ActionListener {
    private JFrame window;
    private JDialog rules;

    public MenuListener(JFrame window) {
        this.window = window;
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "Jouer") {
            CardLayout cardLayout = (CardLayout) window.getContentPane().getLayout();
            cardLayout.show(window.getContentPane(), "gamePanel4");
        }
        if (e.getActionCommand() == "Jouer à trois") {
            CardLayout cardLayout = (CardLayout) window.getContentPane().getLayout();
            cardLayout.show(window.getContentPane(), "gamePanel3");
        }
        if (e.getActionCommand() == "Règles") {
            rules = new JDialog(window, "Les règles");
            JPanel panneau = new JPanel();
            JLabel etiquette = new JLabel("Les règles :");
            JTextArea text = new JTextArea("Mode de jeu à 2 :\n\nLe but du jeu est d'aligner une suite de 4 pions de même couleur sur une grille comptant 6 rangées et 7 colonnes. Chaque joueur dispose de pions d'une couleur. Tour à tour, les deux joueurs placent un pion dans la colonne de leur choix, le pion coulisse alors jusqu'à la position la plus basse possible dans la dite colonne à la suite de quoi c'est à l'adversaire de jouer. Le vainqueur est le joueur qui réalise le premier un alignement (horizontal, vertical ou diagonal) consécutif d'au moins quatre pions de sa couleur. Si, alors que toutes les cases de la grille de jeu sont remplies, aucun des deux joueurs n'a réalisé un tel alignement, la partie est déclarée nulle. \n\nMode de jeu à 3 :\n\nLe but du jeu est d'aligner une suite de 3 pions de même couleur sur une grille comptant 6 rangées et 7 colonnes. Chaque joueur dispose de pions d'une couleur. Tour à tour, les trois joueurs placent un pion dans la colonne de leur choix, le pion coulisse alors jusqu'à la position la plus basse possible dans la dite colonne à la suite de quoi, c'est à l'adversaire de jouer. Le vainqueur est le joueur qui réalise le premier un alignement (horizontal, vertical ou diagonal) consécutif d'au moins trois pions de sa couleur. Une fois que l'un des trois joueurs gagne, ses pions sont retirés de la partie et les pions adverses coulissent alors à la position la plus basse. La partie continue sous les mêmes règles du mode de jeu à 2. ",10,70);
            text.setLineWrap(true);
            text.setWrapStyleWord(true);

            text.setEditable(false);

            rules.setSize(780, 400);
            rules.setLocationRelativeTo(null);
            FlowLayout gestionnaire = new FlowLayout(FlowLayout.CENTER,1,2);

            panneau.setLayout(gestionnaire);
            panneau.add(etiquette);
            panneau.add(text);
            rules.add(panneau);
            rules.setVisible(true);
            rules.setResizable(false);
        }
        if (e.getActionCommand() == "Donnez votre avis !") {
            rules = new JDialog(window, "Donnez votre avis");
            JPanel panneau = new JPanel();
            JLabel etiquette = new JLabel("Qu'avez-vous penser du jeu ? Que pouvons-nous améliorer ?");
            JTextArea text = new JTextArea(10,40);
            StarRating star = new StarRating();
            star.setStar(3);
            star.setForeground(Color.RED);
            star.setBackground(Color.WHITE);
            star.setPreferredSize(new Dimension(100,40));
            JButton valider = new JButton("Envoyer");
            valider.addActionListener(this);
            valider.setFocusPainted(false);
            valider.setForeground(Color.WHITE);
            valider.setBackground(new Color(5, 40, 127));
            valider.setPreferredSize(new Dimension(350,40));

            text.setEditable(true);
            text.setLineWrap(true);

            rules.setSize(500, 325);
            rules.setLocationRelativeTo(null);
            FlowLayout gestionnaire = new FlowLayout(FlowLayout.CENTER,1,2);

            panneau.setLayout(gestionnaire);
            panneau.add(etiquette);
            panneau.add(text);
            panneau.add(star);
            panneau.add(Box.createRigidArea(new Dimension(700, 10)));  
            panneau.add(valider);
            rules.add(panneau);
            rules.setVisible(true);
            rules.setResizable(false);
        }
        if (e.getActionCommand() == "Quitter") {
            this.window.dispose();
        }
        if (e.getActionCommand() == "Envoyer") {
            rules.dispose();
        }

    }
}