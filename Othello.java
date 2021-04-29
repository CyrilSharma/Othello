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

    private int[][] board = new int[8][8];
    private int[][] game_history = new int[8][8];
    private int player = 1;

    Othello() {

    }

    boolean is_win(int action) {
        // determines from the last action whether the game has been won or not
        return false;
    }

    boolean is_draw() {
        // determines whether the game is drawn
        return false;
    }

    void move(int action) {
        // advances the game state by the appropiate action, assuming the action is legal
        return;
    }

    void unmove() {
        // regresses the game state by the appropiate action, assuming the action was legal
        return;
    }


    boolean[][] legal() {
        // crafts an array of arrays, where true corresponds to an action being legal, and false corresponds to an illegal action

        // dummy variable to make code compile
        boolean[][] dummy = new boolean[1][1];
        return dummy;
    }
}