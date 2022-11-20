import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuListener implements ActionListener {
    private JFrame window;

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
            JDialog rules = new JDialog(window, "Les règles");
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
            this.window.dispose();
        }
    }
}