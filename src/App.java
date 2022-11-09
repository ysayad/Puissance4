import javax.swing.JFrame;

public class App {
    public static void main(String[] args) {
        JFrame window = new JFrame("Puissance 4");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1920, 1080);
        window.setLocation(0, 0);

        Jeu jeu = new Jeu();
        window.add(jeu.gridCircle);

        CircleListener listener = new CircleListener(jeu);
        window.addMouseListener(listener);

        window.setVisible(true);
    }
}
