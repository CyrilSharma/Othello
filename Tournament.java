import java.util.ArrayList;
import java.lang.Integer;

public class Tournament {   
    /** 
    * This class handles the tournament system in Othello.
    */
    ArrayList<Othello> tourney = new ArrayList<Othello>(); 
    
    private int rounds;
    
    private int[] p_scores = {0,0};
    
     public Tournament(int round_num) {  //Sophia Lu
        this.rounds = round_num;
        ArrayList<Othello> tourney = new ArrayList<Othello>();
    }

    int getScore(int player)  {  //Sophia Lu
        // returns the amount of wins of a player
        int[] Score = (tourney.get(player)).score();
        return p_scores[player];
    }

    int winner()  { //Sophia Lu
        // check if the tournament is over, and if so return who won
        // 0 means nobody won
        
        if (getScore(1) > rounds/2) {
            // player 1 has won
            return 1;
        }
        if (getScore(2) > rounds/2) {
            // player 2 has won
            return 2; 
        }
        else   {
            return 0;
       }
    }

}