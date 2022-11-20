import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class CircleListener implements MouseListener{
    private Jeu jeu;
    private EndDialog endDialog;

    public CircleListener(Jeu jeu, JFrame window) {
        this.jeu = jeu;
        this.endDialog = new EndDialog(window,jeu);
    

    }


    public void mouseClicked(MouseEvent e) {
        int x=e.getX();
        if (!this.jeu.finished()) {
            if (!this.jeu.verif(this.jeu.getPlayer(), this.jeu.getMode())){
        
                for (int j = 0 ; j<7 ;j+=1 ){
                    if (x>(j * 75) + 50 && x<((j+1) * 75 + 25)){
                        this.jeu.ajout(j);

                    }

                }

                if (this.jeu.verif(this.jeu.getPlayer(), this.jeu.getMode())) {
                    System.out.println("Le joueur "+this.jeu.getPlayer()+" a gagné");
                    this.jeu.addToScoreboard(this.jeu.getPlayer());
                    if (this.jeu.getPlayerRemaining() > 2) {
                        this.jeu.removePlayer();
                        this.jeu.removePlayerToken(this.jeu.getPlayer());
                        List<Integer> playerList = this.jeu.getPlayerList();
                        if (this.jeu.verif(playerList.get(0), this.jeu.getMode()) && this.jeu.verif(playerList.get(1), this.jeu.getMode())) {
                            System.out.println("Match nul");
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

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}
    
}