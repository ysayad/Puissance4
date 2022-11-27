import javax.swing.*;
import java.awt.*;

/**
 *EndDialog is a class that creates a dialog box when the game is over
 * @author Kamil Mardaci
 * @author Yannis Bouarroudj
 * @author Etann De Sousa Alves
 * @author Youcef Sayad
 * @version 1.0
 */
public class EndDialog extends JDialog {
    private final Jeu jeu;
    private final JFrame window;
    private final JLabel label = new JLabel("Fin de la partie");
    private final JLabel score = new JLabel("Scoreboard : ");
    private JLabel gagnant1 = new JLabel("Joueur 1 : ");
    private JLabel gagnant2 = new JLabel("Joueur 2 : ");
    private final JButton replay = new JButton("Rejouer");
    private final JButton quit = new JButton("Quitter");
    private final JButton backToMenu = new JButton("Retour au menu");

    /**
     * Constructeur de la classe EndDialog
     * @param window the frame
     * @param jeu the game
     */
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
        this.add(backToMenu);
        this.add(quit);

        this.replay.addActionListener(dialListener);
        this.backToMenu.addActionListener(dialListener);
        this.quit.addActionListener(dialListener);
        this.replay.setFocusPainted(false);
        this.backToMenu.setFocusPainted(false);
        this.quit.setFocusPainted(false);
        this.replay.setForeground(Color.WHITE);
        this.backToMenu.setForeground(Color.WHITE);
        this.quit.setForeground(Color.WHITE);
        this.replay.setBackground(CustomColor.BLUE);
        this.backToMenu.setBackground(CustomColor.BLUE);
        this.quit.setBackground(CustomColor.BLUE);
        
        this.label.setHorizontalAlignment(JLabel.CENTER);
        this.score.setHorizontalAlignment(JLabel.CENTER);
                
    }

    /**
     * This method is called to update the value of the scoreboard
     */
    public void refresh(){
        
        this.gagnant1 = new JLabel("Gagnant 1 : Joueur "+ this.jeu.getScoreboard().get(0));
        System.out.println(this.jeu.getScoreboard().get(0));
        if (this.jeu.getScoreboard().get(0) == Integer.valueOf(1) ) {
            this.gagnant1.setForeground(CustomColor.RED);
        }
        if (this.jeu.getScoreboard().get(0) == Integer.valueOf(2) ) {
            this.gagnant1.setForeground(CustomColor.YELLOW);
        }
        if (this.jeu.getScoreboard().get(0) == Integer.valueOf(3) ) {
            this.gagnant1.setForeground(CustomColor.GREEN);
        }
        this.gagnant1.setHorizontalAlignment(JLabel.CENTER);
        this.add(gagnant1);
        // if(this.jeu.getMode()==3){
        try {
            this.gagnant2 = new JLabel("Gagnant 2 : Joueur "+ this.jeu.getScoreboard().get(1));

            if (this.jeu.getScoreboard().get(1) == Integer.valueOf(1) ) {
                this.gagnant2.setForeground(CustomColor.RED);
            }
            if (this.jeu.getScoreboard().get(1) == Integer.valueOf(2) ) {
                this.gagnant2.setForeground(CustomColor.YELLOW);
            }
            if (this.jeu.getScoreboard().get(1) == Integer.valueOf(3) ) {
                this.gagnant2.setForeground(CustomColor.GREEN);
            }
            this.gagnant2.setHorizontalAlignment(JLabel.CENTER);
            this.add(gagnant2);
        } catch (IndexOutOfBoundsException e){
            System.out.println(e);
        }   
            
        this.add(replay);
        this.add(backToMenu);
        this.add(quit);

        this.repaint();
        this.revalidate();
        
    }

    /**
     * This method is called to reset the dialog box
     */
    public void reset() {
        this.remove(gagnant1);
        this.remove(gagnant2);
        this.remove(replay);
        this.remove(backToMenu);
        this.remove(quit);
        this.repaint();

    }

}
