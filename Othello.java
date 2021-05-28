
import java.util.ArrayList;

// DIVISION OF LABOR
// -- This will be mostly written by Cyril and Sophiathe
public class Othello {
    /**
     * This class handles all the game mechanics in Othello.
     * 
     * PRIVATE VARIABLES
     * 
     * board: an array which keeps track of the 2d board state by storing 1 for player 1, -1 for player 2, and 0 for no player at each point on the board
     * game_history: an array which stores all the game states that have occurred throughout the game, each specified by an array of arrays
     * player: a token to keep track of who's turn it is
    **/

    // Board is 8 by 8
    private ArrayList<int[][]> game_history = new ArrayList<int[][]>();
    private int player = 1;
    private int time = 0;

    public Othello() {
        int[][] board = new int[8][8];
        for (int i = 3; i < 5; i++){
            for (int j = 3; j < 5; j++) {
                // generate a checkerboard pattern (1 being white, -1 being blue)
                board[i][j] = (((i + j) % 2) * 2) - 1;
            }
        }
        game_history.add(deepcopy(board));
    }

    boolean is_over() { // need to be upgraded
        // determines whether the game is over or not
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                int[] loc = {i, j};
                if (legal(loc)) {
                    return false;
                }
            }
        }

        return true;
    }

    int[] score() { // Raka Adakroy
        // determines whether the game is drawn
        int[][] board = game_history.get(game_history.size() - 1);
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
        // advances the game state by the appropiate action, assuming the action is legal
        int offset;
        int[][] board = deepcopy(game_history.get(game_history.size() - 1));
        for (int i = -1; i < 2; i++){
            for (int j = -1; j < 2; j++) {
                offset = check_direction(action[0], action[1], i, j);
                if (offset != 0)
                    flip_section(board, action[0], action[1], action[0] + i * offset, action[1] + j * offset);
            }
        }

        board[action[0]][action[1]] = player;
        player *= -1;

        // we don't want to copy a reference to the latest board state
        game_history.add(board);
        time += 1;
        return;
    }

    void unmove() {
        game_history.remove(game_history.size() - 1);
        player *= -1;
        time -= 1;
    }

    // returns othe amount in the specified direction the enclosing piece is
    int check_direction(int row, int col, int delta_row, int delta_col) {
        int[][] board = game_history.get(game_history.size() - 1);
        int current_row = row + delta_row;
        int current_col = col + delta_col;
        int counter = 1;
        
        // make sure path isn't on the edge
        if (current_col == board.length || current_col == -1)
            return 0;
        else if (current_row == board.length || current_row == -1)
            return 0;

        if (board[current_row][current_col] != player * -1)
            return 0;
        else {
            // tracks if consecutive pieces have the same color
            boolean matches = true;
            while (matches) {
                current_row += delta_row;
                current_col += delta_col;
                counter += 1;

                if (current_col == board.length || current_col == -1)
                    return 0;
                else if (current_row == board.length || current_row == -1)
                    return 0;
                else
                    // if player's tokens do not surround opponenets, match was not found.
                    matches = board[current_row][current_col] == player * -1;
            }

            // if the player encloses the opponents pieces with this move
            if (board[current_row][current_col] == player) {
                return counter;
            }
            else 
                return 0;
        }
    }

    
    void flip_section(int[][] board, int row, int col, int final_row, int final_col) {
        int r = row;
        int c = col;
        int delta_row;
        int delta_col;

        if (row == final_row)
            delta_row = 0;
        else 
            delta_row = Math.abs(final_row - row) / (final_row - row);

        if (col == final_col)
            delta_col = 0;
        else 
            delta_col = Math.abs(final_col - col) / (final_col - col);

        while (r != final_row || c != final_col) {
            r += delta_row;
            c += delta_col;
            board[r][c] = player;
        } 
    }

    void traverse(int step) { //Sophia Lu
        // advances the display through history by a certain step_size
        int length = game_history.size();
        if ((time + step) >= 0 & (time + step) < length) {
            time += step;  
            player *= -1;
        }
    }


    boolean legal(int[] action) { // Cyril Sharma
        int[][] board = game_history.get(game_history.size() - 1);
        // checks if an action is legal
        boolean valid = false;
        int offset;
        if (board[action[0]][action[1]] == 0) {
            for (int i = -1; i < 2; i++){
                for (int j = -1; j < 2; j++) {
                    offset = check_direction(action[0], action[1], i, j);
                    if (offset != 0)
                        valid = true;
                }
            }
        }
        
        return valid;
    }

    private int[][] deepcopy(int[][] array) {
        int[][] new_array = new int[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            new_array[i] = array[i].clone();
        }
        return new_array;
    }

    // accessor method for board state

    int getState(int i, int j) {
    	int[][] board = game_history.get(game_history.size() - 1);
    	return board[i][j];
        //return 1;
}

    // determines if board is at some point in the past, or at the current move.
    public boolean current() {
        return time == (game_history.size() - 1);

    }
    
    int[][] setDefaultState()   {
      int[][] board = new int[8][8];
        for (int i = 3; i < 5; i++){
            for (int j = 3; j < 5; j++) {
                // generate a checkerboard pattern (1 being white, -1 being blue)
                board[i][j] = (((i + j) % 2) * 2) - 1;
            }
        }
        return board;
    }

    void display() {
        int[][] board = game_history.get(game_history.size() - 1);
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