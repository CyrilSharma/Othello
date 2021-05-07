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
    private int[][][] game_history = new int[8][8][8];
    private int player = 1;

    public Othello() {
        int color = 1;
        for (int i = 3; i < 5; i++){
            for (int j = 3; j < 5; j++) {
                // generate a checkerboard pattern (1 being white, -1 being blue)
                board[i][j] = (((i + j) % 2) * 2) - 1;
            }
        }
    }

    boolean is_over() { // Raka Adakroy
        // determines from the last action whether the game has been won or not
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    int[] score() { // Raka Adakroy
        // determines whether the game is drawn
        int p1_score = 0;
        int p2_score = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 1)
                    p1_score += 1;
                else if (board[i][j] == -1) 
                    p2_score += 1;
            }
        }

        int[] scores = {p1_score, p2_score};
        return scores;
    }

    void move(int[] action) { // Cyril Sharma
        for (int i = -1; i < 2; i++){
            for (int j = -1; j < 2; j++) {
                flip_section(action[0], action[1], i, j);
            }
        }
        board[action[0]][action[1]] = player;
        player *= -1;
        // 
        // advances the game state by the appropiate action, assuming the action is legal
        return;
    }

    void flip_section(int row, int col, int delta_row, int delta_col) {
        int current_row = row + delta_row;
        int current_col = col + delta_col;
        
        // make sure path isn't on the edge
        if (current_col == board.length || current_col == -1)
            return;
        else if (current_row == board.length || current_row == -1)
            return;

        if (board[current_row][current_col] != player * -1)
            return;
        else {
            // tracks if consecutive pieces have the same color
            boolean matches = true;
            while (matches) {
                current_row += delta_row;
                current_col += delta_col;

                if (current_col == board.length || current_col == -1)
                    return;
                else if (current_row == board.length || current_row == -1)
                    return;
                else
                    matches = board[current_row][current_col] == player * -1;
            }
            // if the player encloses the opponents pieces with this move
            if (board[current_row][current_col] == player) {
                // flip the appropiate pieces
                while (!(row == current_row & col == current_col)) {
                    row += delta_row;
                    col += delta_col;
                    board[row][col] = player;
                }
            }
        }
    }

    void unmove() { //Sophia Lu
        // regresses the game state by the appropiate action, assuming the action was legal
        return;
    }


    boolean legal(int[] action) { // Cyril Sharma
        // crafts an array of arrays, where true corresponds to an action being legal, and false corresponds to an illegal action

        // dummy variable to make code compile
        boolean[][] dummy = new boolean[1][1];
        return dummy;
    }

    void display() {
        String RED = "\033[0;31m";     // RED
        String BLUE = "\033[0;34m";    // BLUE
        String RESET = "\033[0m";

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 1) {
                    System.out.print(RED + "H " + RESET);
                }
                else if (board[i][j] == -1) {
                    System.out.print(BLUE + "H " + RESET);
                }
                else {
                    System.out.print("H ");
                }
            }
            System.out.println("");
        }
        System.out.println("");
    }
}