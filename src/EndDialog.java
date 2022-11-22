import javax.swing.*;
import java.awt.*;

public class EndDialog extends JDialog {
    private Jeu jeu;
    private JFrame window;
    private JLabel label = new JLabel("Fin de la partie");
    private JLabel score = new JLabel("Scoreboard : ");
    private JLabel gagnant1 = new JLabel("Joueur 1 : ");
    private JLabel gagnant2 = new JLabel("Joueur 2 : ");
    private JButton replay = new JButton("Rejouer");
    private JButton quit = new JButton("Quitter");
    
    public EndDialog(JFrame window,Jeu jeu){
        //super(window, "Fin de partie");
        this.jeu = jeu;
        this.window = window;
        EndDialogListener dialListener = new EndDialogListener(this.jeu,this.window,this);
        this.setSize(new Dimension(300, 300));
        this.setLocation(this.window.getX()/2, this.window.getY()/2);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setAlwaysOnTop(this.isAlwaysOnTop());
        this.setLayout(new GridLayout(8,0));
        this.add(label);
        this.add(score);

        this.add(gagnant1);
        this.add(gagnant2);
        
        this.add(replay);
        this.add(quit);

        this.replay.addActionListener(dialListener);
        this.quit.addActionListener(dialListener);
        this.replay.setFocusPainted(false);
        this.quit.setFocusPainted(false);
        this.replay.setForeground(Color.WHITE);
        this.quit.setForeground(Color.WHITE);
        this.replay.setBackground(new Color(5, 40, 127));
        this.quit.setBackground(new Color(5, 40, 127));
        
        this.label.setHorizontalAlignment(JLabel.CENTER);
        this.score.setHorizontalAlignment(JLabel.CENTER);
                
    }

    public void refresh(){
        
        this.gagnant1 = new JLabel("Gagnant 1 : Joueur "+ this.jeu.getScoreboard().get(0));
        this.gagnant1.setHorizontalAlignment(JLabel.CENTER);
        this.add(gagnant1);
        // if(this.jeu.getMode()==3){
        try {
            this.gagnant2 = new JLabel("Gagnant 2 : Joueur "+ this.jeu.getScoreboard().get(1));
            this.gagnant2.setHorizontalAlignment(JLabel.CENTER);
            this.add(gagnant2);
        } catch (IndexOutOfBoundsException e){
            System.out.println(e);
        }   
            
        this.add(replay);
        this.add(quit);

        this.repaint();
        this.revalidate();
        
    }

    public void reset() {
        this.remove(gagnant1);
        this.remove(gagnant2);
        this.remove(replay);
        this.remove(quit);
        this.repaint();
    }

}
