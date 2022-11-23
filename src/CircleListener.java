import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;

/**
 * CircleListener is the class that handles the mouse events ont the game board
 * @author Kamil Mardaci
 * @author Yannis Bouarroudj
 * @author Etann De Sousa Alves
 * @author Youcef Sayad
 * @version 1.0
 */
public class CircleListener implements MouseListener, MouseMotionListener{
    private final Jeu jeu;
    private final EndDialog endDialog;

    /**
     * Constructor of the CircleListener
     * @param jeu the game
     * @param window the frame
     */
    public CircleListener(Jeu jeu, JFrame window) {
        this.jeu = jeu;
        this.endDialog = new EndDialog(window,jeu);

    }

    /**
     * This method is called when the mouse is clicked
     * It calls the method slide of the HoverBar class to update the color of the hover circle
     * @param e the mouse event
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        this.jeu.getHoverBar().slide(e.getX());

    }
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}

    /**
     * This method is called when the mouse is pressed
     * It adds if possible a token to the game board
     * It uses various methods to check if the game is won by the current player, and the following players in some conditions
     * @param e the mouse event
     */
    @Override
    public void mousePressed(MouseEvent e) {
        int x=e.getX();
        if (!this.jeu.finished()) {

            if (!this.jeu.verif(this.jeu.getPlayer(), this.jeu.getMode())){
                for (int j = 0 ; j<7 ;j+=1 ){
                    if (x>(j * 75) + 50 && x<((j+1) * 75 + 25)){
                        this.jeu.ajout(j);

                    }

                }

                if (this.jeu.verif(this.jeu.getPlayer(), this.jeu.getMode())) {
                    this.endDialog.reset();
                    System.out.println("Le joueur "+this.jeu.getPlayer()+" a gagné");
                    this.jeu.addToScoreboard(this.jeu.getPlayer());

                    if (this.jeu.getPlayerRemaining() > 2) {
                        this.jeu.removePlayer();
                        this.jeu.removePlayerToken(this.jeu.getPlayer());
                        List<Integer> playerList = this.jeu.getPlayerList();

                        if (this.jeu.verif(playerList.get(0), this.jeu.getMode()) && this.jeu.verif(playerList.get(1), this.jeu.getMode())) {
                            System.out.println("Match nul");
                            this.endDialog.refresh();
                            this.endDialog.setVisible(true);
                            this.jeu.setFinished();

                        } else if (this.jeu.verif(playerList.get(0), this.jeu.getMode())) {
                            this.jeu.addToScoreboard(playerList.get(0));
                            System.out.println("Le joueur "+playerList.get(0)+" a gagné");
                            this.endDialog.refresh();
                            this.endDialog.setVisible(true);
                            this.jeu.setFinished();

                        } else if (this.jeu.verif(playerList.get(1), this.jeu.getMode())) {
                            this.jeu.addToScoreboard(playerList.get(1));
                            System.out.println("Le joueur "+playerList.get(1)+" a gagné");
                            this.endDialog.refresh();
                            this.endDialog.setVisible(true);
                            this.jeu.setFinished();

                        }
                    
                    } else if (this.jeu.getPlayerRemaining() == 2) {
                        this.endDialog.refresh();
                        this.endDialog.setVisible(true);
                    }
                    
                    if (this.jeu.getPlayerRemaining() == 2) {
                        this.jeu.setMode(4);

                    }
                }
            
            }
            this.jeu.getGridCircle().repaint();

        }

    }
    @Override
    public void mouseReleased(MouseEvent e) {}

    /**
     * This method is called when the mouse is moved
     * It calls the slide method of the HoverBar class to move the hover circle
     * @param e the mouse event
     */
    @Override
    public void mouseMoved(MouseEvent e) {
        this.jeu.getHoverBar().slide(e.getX());

    }
    @Override
    public void mouseDragged(MouseEvent e) {}

}