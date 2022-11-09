
import java.awt.event.*;
public class CircleListener implements MouseListener{

    Jeu jeu;

    public CircleListener(Jeu jeu) {

        this.jeu = jeu;
    }


    public void mouseClicked(MouseEvent e) {
        int x=e.getX();
        if (!this.jeu.verif(this.jeu.getPlayer(), this.jeu.getMode())){
            this.jeu.switchPlayer();
            for (int j = 0 ; j<7 ;j+=1 ){
                if (x>(j * 75) + 50 && x<((j+1) * 75) + 50){
                    this.jeu.ajout(j);
                }

            }
            
        
        } else {
            System.out.println("Le joueur "+this.jeu.getPlayer()+" a gagné");
            if (this.jeu.getPlayerRemaining() > 2) {
                this.jeu.removePlayer();
                
            }

            if (this.jeu.getPlayerRemaining() == 2) {
                this.jeu.setMode(4);

            }
            
            
            

        }

        this.jeu.gridCircle.repaint();

    }

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}
    
}