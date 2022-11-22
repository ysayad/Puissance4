import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class EndDialogListener implements ActionListener {
    private Jeu jeu;
    private JFrame window;
    private EndDialog dial;

    public EndDialogListener(Jeu jeu,JFrame window,EndDialog dial) {
        this.jeu = jeu;
        this.window = window;
        this.dial = dial;
    }


    public void actionPerformed(ActionEvent evt) {


        if (evt.getActionCommand() == "Rejouer") {
                this.jeu.reset();
                this.dial.dispose();
                
        }
        
        if (evt.getActionCommand() == "Quitter") {
            this.dial.dispose();
            CardLayout cardLayout = (CardLayout) window.getContentPane().getLayout();
            cardLayout.show(window.getContentPane(),"menuPanel");
        }

            
            // String test = this.window.getContentPane().getName();       
            // if (test == "gamePanel3"){
            //     GamePanel gamePanel3 = new GamePanel(3, this.window);
            //     this.window.add(gamePanel3,"gamePanel3");
            //     CardLayout cardLayout = (CardLayout) window.getContentPane().getLayout();
            //     cardLayout.show(window.getContentPane(), "gamePanel3");

            // }else {
            //     GamePanel gamePanel4 = new GamePanel(4, this.window);
            //     this.window.add(gamePanel4,"gamePanel4");
            //     CardLayout cardLayout = (CardLayout) window.getContentPane().getLayout();
            // cardLayout.show(window.getContentPane(), "gamePanel4");
            // }
        }

    }


