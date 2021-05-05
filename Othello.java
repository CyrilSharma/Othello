// DIVISION OF LABOR
// -- This will be mostly written by Cyril and Sophiathe
public class Othello {
    /**
     * This class handles all the game mechanics in Othello.
     * 
     * PRIVATE VARIABLES
     * 
     * board: an array which keeps track of the 2d board state by storing 1 for player 1, -1 for player 2, and 0 for no player at each point on the board
     * game_history: an array which stores all the moves taken in the game, each specified by two coordinates (ex. (1, 0))
     * player: a token to keep track of who's turn it is
    **/

    // Board is 8 by 8
    private int[][] board = new int[8][8];
    private int[][] game_history = new int[8][8];
    private int player = 1;

    public Othello() {
        int color = 1;
        for (int i = 3; i < 5; i++){
            for (int j = 3; j < 5; j++) {
                board[i][j] = color;
                color *= -1;
            }
        }
    }

    boolean is_win(int action) { // Raka Adakroy
        // determines from the last action whether the game has been won or not
        int count = 0;
        for (int i = 0; i<8; i++) {
            for (int j=0; j<8; j++) {
                if (boolean[i][j]==0) {
                    count++;
                }
            }
        }
        if (count != 0) {
            return false;
        }
        return false;
    }

    boolean is_draw() { // Raka Adakroy
        // determines whether the game is drawn
        return false;
    }

    void move(int action) { // Cyril Sharma
        // 
        // advances the game state by the appropiate action, assuming the action is legal
        return;
    }

    void unmove() { //Sophia Lu
        // regresses the game state by the appropiate action, assuming the action was legal
        return;
    }


    boolean[][] legal() { // Cyril Sharma
        // crafts an array of arrays, where true corresponds to an action being legal, and false corresponds to an illegal action

        // dummy variable to make code compile
        boolean[][] dummy = new boolean[1][1];
        return dummy;
    }
}