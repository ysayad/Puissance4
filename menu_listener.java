import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class menu_listener implements ActionListener {
    JFrame fenetre;

    public menu_listener(JFrame fen) {
        this.fenetre = fen;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "Jouer") {
            //link to conect 4
        }
        if (e.getActionCommand() == "Jouer à trois") {
            //link to connect 3
        }
        if (e.getActionCommand() == "Règles") {
            JDialog rules = new JDialog(fenetre, "Les règles");
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
        if (e.getActionCommand() == "Quitter") {
            this.fenetre.dispose();
        }
    }
}