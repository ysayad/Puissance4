import java.util.*;

/**
 *Jeu is the class that contains methods for the game
 * @author Kamil Mardaci
 * @author Yannis Bouarroudj
 * @author Etann De Sousa Alves
 * @author Youcef Sayad
 * @version 1.0
 */
public class Jeu {
    private final int[][] grille;
    private List<Integer> playerList = new LinkedList<>(Arrays.asList(1,2,3));
    private List<Integer> nextPlayerList = new LinkedList<>(Arrays.asList(2,3,1));
    private int player = 3;
    private int nextPlayer = 1;
    private int playerRemaining = playerList.size();
    private final Circle gridCircle;
    private final CurrentPlayer currentPlayer = new CurrentPlayer(this);
    private int mode;
    private final int initialMode;
    private final int colNum = 7;
    private final int rowNum = 6;
    private boolean finished = false;
    private ArrayList<Object> scoreboard = new ArrayList<>();
    private final HoverBar hoverBar = new HoverBar(this);


    /**
     * Constructor of the game
     * @param mode the game mode
     */
    public Jeu(int mode) {
        this.grille = new int[rowNum][colNum];
        this.mode = mode;
        this.initialMode = mode;

        if (this.mode == 4) {
            this.playerList = new LinkedList<>(Arrays.asList(1,2));
            this.nextPlayerList = new LinkedList<>(Arrays.asList(2,1));
            this.playerRemaining = playerList.size();
        }

        for (int i = 0 ; i < rowNum ; i++ ) {
            for (int j = 0 ; j < colNum ; j++){
                this.grille[i][j]=0;
            }

        }

        this.gridCircle = new Circle(50, this);

    }

    /**
     *
     * @return hoverBar
     */
    public HoverBar getHoverBar() {
        return this.hoverBar;
    }

    /**
     *
     * @param val takes a value and add it to the scoreboard
     */
    public void addToScoreboard(int val){
        this.scoreboard.add(Integer.toString(val));

    }

    /**
     *
     * @return scoreboard
     */
    public ArrayList<Object> getScoreboard(){
        return this.scoreboard;
        
    }


    /**
     *
     * @param num_colonne add a token to the position of num_colonne if possible
     */
    public void ajout(int num_colonne) {
        if (this.grille[0][num_colonne] == 0) {
            this.switchPlayer();
        }
        for (int i = rowNum - 1; i >= 0 ; i--) {
            if (this.grille[i][num_colonne] == 0) {
                this.grille[i][num_colonne] = this.player;
                break;

            }

        }

    }

    /**
     * Method that verify if n token are connected for the player
     * @param player do the win verification for this player
     * @param mode do the verification according to the mode
     * @return true if won, false if lost
     */
    public boolean verif (int player, int mode){
        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                if (col <= colNum - mode) {
                    switch (mode) {
                        case 3:
                            if (this.grille[row][col] == player && this.grille[row][col + 1] == player && this.grille[row][col + 2] == player) {
                                return true;
                            }
                            break;

                        case 4:
                            if (this.grille[row][col] == player && this.grille[row][col + 1] == player && this.grille[row][col + 2] == player && this.grille[row][col + 3] == player) {
                                return true;
                            }
                            break;

                    }     

                }

                if (row <= rowNum - mode) {
                    switch (mode) {
                        case 3:
                            if (this.grille[row][col] == player && this.grille[row + 1][col] == player && this.grille[row + 2][col] == player) {
                                return true;
                            }
                            break;

                        case 4:
                            if (this.grille[row][col] == player && this.grille[row + 1][col] == player && this.grille[row + 2][col] == player && this.grille[row + 3][col] == player) {
                                return true;
                            }
                            break;

                    }

                }
                
                if (row <= rowNum - mode && col <= colNum - mode) {
                    switch (mode) {
                        case 3:
                            if (this.grille[row][col] == player && this.grille[row + 1][col + 1] == player && this.grille[row + 2][col + 2] == player) {
                                return true;
                            }
                            break;

                        case 4:
                            if (this.grille[row][col] == player && this.grille[row + 1][col + 1] == player && this.grille[row + 2][col + 2] == player && this.grille[row + 3][col + 3] == player) {
                                return true;
                            }
                            break;

                    }

                }

                if (row <= rowNum - mode && col >= mode - 1) {
                    switch (mode) {
                        case 3:
                            if (this.grille[row][col] == player && this.grille[row + 1][col - 1] == player && this.grille[row + 2][col - 2] == player) {
                                return true;
                            }
                            break;

                        case 4:
                            if (this.grille[row][col] == player && this.grille[row + 1][col - 1] == player && this.grille[row + 2][col - 2] == player && this.grille[row + 3][col - 3] == player) {
                                return true;
                            }
                            break;

                    }

                }

            }

        }

        return false;
        
    }


    /**
     * Method that switch the player to the next
     */
    public void switchPlayer () {
        if (this.playerList.equals(this.nextPlayerList)) {
            int temp = this.nextPlayerList.get(0);
            this.nextPlayerList.set(0, this.nextPlayerList.get(1));
            this.nextPlayerList.set(1, temp);
        }

        int index = this.playerList.indexOf(this.player);
        if (index == this.playerList.size() - 1) {
            this.player = this.playerList.get(0);
            this.nextPlayer = this.nextPlayerList.get(0);
            
        } else {
            this.player = this.playerList.get(index + 1);
            this.nextPlayer = this.nextPlayerList.get(index + 1);

        }
        this.currentPlayer.repaint();

    }

    /**
     * Method that remove a player from the list
     */
    public void removePlayer () {
        this.playerList.remove(this.player-1);
        this.playerRemaining--;
        this.nextPlayerList.remove(this.nextPlayerList.indexOf(this.player));
        System.out.println(nextPlayerList);

    }

    /**
     *
     * @return the player
     */
    public int getPlayer() {
        return this.player;
    
    }

    /**
     *
     * @return the next player
     */
    public int getNextPlayer() {
        return this.nextPlayer;
    
    }

    /**
     *
     * @return the player list
     */
    public List<Integer> getPlayerList () {
        return this.playerList;
    
    }


    /**
     *
     * @return the number of remaining player
     */
    public int getPlayerRemaining() {
        return this.playerRemaining;
    
    }

    /**
     *
     * @return if the game is finished
     */
    public boolean finished() {
        return this.finished;
    
    }

    /**
     * Set if the game is finished
     */
    public void setFinished() {
        this.finished = !this.finished;
    
    }

    /**
     *
     * @return the game mode
     */
    public int getMode() {
        return this.mode;
    
    }

    /**
     *
     * @param n set the mode to this value
     */
    public void setMode (int n) {
        this.mode = n;
    
    }

    /**
     *
     * @return the board
     */
    public Circle getGridCircle() {
        return this.gridCircle;
    
    }

    /**
     *
     * @return the grid
     */
    public int[][] getGrille () {
        return this.grille;

    }

    /**
     *
     * @return the current player
     */
    public CurrentPlayer getCurrentPlayer() {
        return this.currentPlayer;
    
    }

    /**
     *
     * @param player remove the player token from the grid
     */
    public void removePlayerToken (int player) {
        int emptySpace = 0;

        for (int i = 0 ; i < rowNum ; i++ ) {
            for (int j = 0 ; j < colNum ; j++){
                if (this.grille[i][j] == player) {
                    this.grille[i][j] = 0;
                    emptySpace++;

                }

            }

        }

        for (int e = 0 ; e < emptySpace ; e++) {
            for (int i = rowNum - 1 ; i > 0 ; i--) {
                for (int j = 0 ; j < colNum ; j++) {
                    if (this.grille[i][j] == 0) {
                        this.grille[i][j] = this.grille[i-1][j];
                        this.grille[i-1][j] = 0;
                    }
                    
                }

            }

        }

    }

    /**
     * Reset the game to the initials value
     */
    public void reset() {
        for (int i = 0 ; i < rowNum ; i++ ) {
            for (int j = 0 ; j < colNum ; j++){
                this.grille[i][j] = 0;
            }

        }
        this.mode = this.initialMode;
        if (this.mode == 4) {
            this.playerList = new LinkedList<>(Arrays.asList(1,2));
            this.nextPlayerList = new LinkedList<>(Arrays.asList(2,1));
            this.player = this.playerList.get(1);
            this.nextPlayer = this.nextPlayerList.get(1);
            
        } else {
            this.playerList = new LinkedList<>(Arrays.asList(1,2,3));
            this.nextPlayerList = new LinkedList<>(Arrays.asList(2,3,1));
            this.player = this.playerList.get(2);
            this.nextPlayer = this.nextPlayerList.get(2);
            
        }
        this.gridCircle.repaint();
        this.playerRemaining = this.playerList.size();
        this.finished = false;
        this.scoreboard = new ArrayList<>();

    }

}