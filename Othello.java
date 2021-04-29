public class Othello {
    /**
     * This class handles all the game mechanics in Othello.
     * PRIVATE VARIABLES
     * board is an array which keeps track of the state by storing 1 for player 1, -1 for player 2, and 0 for no player at each point on the board
     * player is a token to keep track of who's turn it is
    **/

    private int[][] board = new int[8][8];
    private int player = 1;

    Othello() {

    }

    boolean is_win(int action) {
        return false;
    }

    boolean is_draw() {
        return false;
    }

    boolean is_terminal(int action) {
        return false;
    }

    void move(int action) {
        return;
    }

    void unmove(int action) {
        return;
    }


    int[][] legal() {
        int[][] dummy = new int[1][1];
        return dummy;
    }
}