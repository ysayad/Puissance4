import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import star.Star;
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
            JTextArea text = new JTextArea("Placez chacun cotre tour un pion, celui qui en aligne 4 ou 3 selon le mode choisi gagne.");
            text.setEditable(false);

            rules.setSize(500, 300);
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