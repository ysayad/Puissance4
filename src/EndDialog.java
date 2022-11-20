import javax.swing.*;
import java.awt.*;



public class EndDialog extends JDialog {
    Jeu jeu;
    JFrame window;
    public EndDialog(JFrame window,Jeu jeu){
        //super(window, "Fin de partie");
        this.jeu = jeu;
        this.window = window;
        this.setSize(new Dimension(300, 300));
        this.setLocation(this.window.getX()/2, this.window.getY()/2);
        System.out.println("test"+this.jeu.getScoreboard());
        JLabel label = new JLabel("Fin de la partie"+this.jeu.getScoreboard());
        this.add(label);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    public void refresh(){
        //super(window, "Fin de partie");
        this.setSize(new Dimension(300, 300));
        this.setLocation(this.window.getX()/2, this.window.getY()/2);
        System.out.println("test"+this.jeu.getScoreboard());
        JLabel label = new JLabel("Fin de la partie"+this.jeu.getScoreboard());
        this.add(label);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.repaint();
        this.revalidate();
        
    }

}
