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
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    public void refresh(){
        //super(window, "Fin de partie");
        this.setSize(new Dimension(300, 300));
        this.setLocation(this.window.getX()/2, this.window.getY()/2);
        System.out.println("test"+this.jeu.getScoreboard());
        JLabel label = new JLabel("Fin de la partie");
        JLabel score = new JLabel("Scoreboard : ");
        
        JLabel gagnant1 = new JLabel("Gagnant 1 : Joueur "+ this.jeu.getScoreboard().get(0));
                this.add(label);
        this.add(score);
        this.add(gagnant1);
        if(this.jeu.getMode()!=4){
           JLabel gagnant2 = new JLabel("Gagnant 2 : Joueur "+ this.jeu.getScoreboard().get(1));
                   this.add(gagnant2);

        }
        this.setLayout(new GridLayout(4,0));


        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.repaint();
        this.revalidate();
        
    }

}
