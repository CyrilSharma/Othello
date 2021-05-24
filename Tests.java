public class Tests {

    public static void main(String[] args) {
      //  Test_Move();
      Test_Traverse(1);
    }

    public static void Test_Move()
    {
        Othello board = new Othello();
        int[] move = {2,3};
        board.display();
        board.move(move);
        board.display();

        int[] move1 = {2,4};
        board.move(move1);
        board.display();
    }


   public static void Test_Traverse(int step)
{
        Othello board = new Othello();
        
        int[] move1 = {2,4};
        board.move(move1);
        board.display();
        
        board.traverse(step);
        board.display();
   
}

}