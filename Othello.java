public class Othello {

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