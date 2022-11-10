
import java.awt.event.*;
public class CircleListener implements MouseListener{

    Jeu jeu;
    int posx;
    int posy;

    public CircleListener(Jeu jeu, int posx, int posy) {

        this.jeu = jeu;
        this.posx = posx;
        this.posy = posy;
    }


    public void mouseClicked(MouseEvent e) {
        int x=e.getX();
        if (!this.jeu.verif(this.jeu.getPlayer(), this.jeu.getMode())){
            

            for (int j = 0 ; j<7 ;j+=1 ){
                if (x>(j * 75) + 50 && x<((j+1) * 75) + 50 ){
                    this.jeu.switchPlayer();
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

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {}

    public void mousePressed(MouseEvent e) {
        System.out.println(e.getX());
    }

    public void mouseReleased(MouseEvent e) {}
    
}