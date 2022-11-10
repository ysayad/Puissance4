import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) {
        JFrame window = new JFrame("Puissance 4");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1920, 1080);
        window.setLocationRelativeTo(null);

        Jeu jeu = new Jeu();

        JPanel panneau = new JPanel();
        panneau.setLayout(new GridBagLayout());
        panneau.add(jeu.gridCircle);
        panneau.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        window.add(panneau);


        CircleListener listener = new CircleListener(jeu, 0, 0);
        jeu.gridCircle.addMouseListener(listener);



        window.setVisible(true);
    }
}
