import javax.swing.*;
import java.awt.*;
import javax.swing.JLabel.*;



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
                   gagnant2.setHorizontalAlignment(JLabel.CENTER);

        }

        JButton replay = new JButton("Rejouer");
        JButton quit = new JButton("Quitter");
        replay.setFocusPainted(false);
        quit.setFocusPainted(false);
        replay.setForeground(Color.WHITE);
        quit.setForeground(Color.WHITE);
        replay.setBackground(new Color(5, 40, 127));
        quit.setBackground(new Color(5, 40, 127));

        EndDialogListener evt = new EndDialogListener(this.jeu,this.window,this);
        replay.addActionListener(evt); 
        quit.addActionListener(evt); 
        this.add(replay);
        this.add(quit);

        this.setLayout(new GridLayout(5,0));
        label.setHorizontalAlignment(JLabel.CENTER);
        score.setHorizontalAlignment(JLabel.CENTER);
        gagnant1.setHorizontalAlignment(JLabel.CENTER);


        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.repaint();
        this.revalidate();
        
    }

}
