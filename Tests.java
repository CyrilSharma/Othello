public class Tests {

    public static void main(String[] args) {
        Test_Move();
    }

    public static void Test_Move()
    {
        Othello board = new Othello();
        int[] move = {0,0};
        board.move(move);
        board.display();
    }
}
