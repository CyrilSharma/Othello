public class Tournament {   
    /** 
    * This class handles the tournament system in Othello.
    */

    private int rounds;

    private float[] p_scores = {0,0};

    public Tournament(int round_num) {  //Sophia Lu
        this.rounds = round_num;
    }

    float getScore(int player)  {  //Sophia Lu
        // returns the amount of wins of a player
        return p_scores[player];
    }

    int winner()  { //Sophia Lu
        // check if the tournament is over, and if so return who won
        // 0 means nobody won
        return 0;
    }
}