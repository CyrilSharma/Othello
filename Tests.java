public class Tests {

    public static void main(String[] args) {
        Test_Move();
    }

    public static void Test_Move()
    {
        Othello board = new Othello();
        int[] move = {2,3};
        board.textdisplay();
        board.move(move);
        board.textdisplay();

        int[] move1 = {2,4};
        board.move(move1);
        board.textdisplay();
    }
}
