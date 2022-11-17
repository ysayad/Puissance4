import java.awt.event.*;

public class CircleListener implements MouseListener, MouseMotionListener{
    Jeu jeu;

    public CircleListener(Jeu jeu) {
        this.jeu = jeu;

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x=e.getX();
        if (!this.jeu.verif(this.jeu.getPlayer(), this.jeu.getMode())){
    
            for (int j = 0 ; j<7 ;j+=1 ){
                if (x>(j * 75) + 50 && x<((j+1) * 75) + 50){
                    this.jeu.ajout(j);

                }

            }

            if (this.jeu.verif(this.jeu.getPlayer(), this.jeu.getMode())) {
                System.out.println("Le joueur "+this.jeu.getPlayer()+" a gagné");
                if (this.jeu.getPlayerRemaining() > 2) {
                    this.jeu.removePlayer();
                    this.jeu.removePlayerToken(this.jeu.getPlayer());
                
                }

                if (this.jeu.getPlayerRemaining() == 2) {
                    this.jeu.setMode(4);

                }
            }
        
        }

        this.jeu.getGridCircle().repaint();

    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {
        this.jeu.getHoverBar().slide(e.getX());
    }

    @Override
    public void mouseDragged(MouseEvent e) {}
    
}