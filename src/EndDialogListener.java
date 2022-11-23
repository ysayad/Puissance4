import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

/**
 *EndDialogListener is the class that handles the actions on the end dialog box
 * @author Kamil Mardaci
 * @author Yannis Bouarroudj
 * @author Etann De Sousa Alves
 * @author Youcef Sayad
 * @version 1.0
 */
public class EndDialogListener implements ActionListener {
    private final Jeu jeu;
    private final JFrame window;
    private final EndDialog dial;

    /**
     * Constructor of the EndDialogListener
     * @param jeu the game
     * @param window the frame
     * @param dial the end dialog box
     */
    public EndDialogListener(Jeu jeu,JFrame window,EndDialog dial) {
        this.jeu = jeu;
        this.window = window;
        this.dial = dial;

    }


    public void actionPerformed(ActionEvent evt) {
        if (Objects.equals(evt.getActionCommand(), "Rejouer")) {
            this.jeu.reset();
            this.dial.dispose();
                
        }
        
        if (Objects.equals(evt.getActionCommand(), "Retour au menu")) {
            this.jeu.reset();
            this.dial.dispose();
            CardLayout cardLayout = (CardLayout) window.getContentPane().getLayout();
            cardLayout.show(window.getContentPane(),"menuPanel");

        }

        if (Objects.equals(evt.getActionCommand(), "Quitter")) {
            System.exit(0);
        }

    }

}


