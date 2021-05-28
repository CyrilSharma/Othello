
import java.util.ArrayList;
import java.lang.Integer;

public class Tournament {   
    /** 
    * This class handles the tournament system in Othello.
    */
	int[][] tourney; 
    
    private int rounds;
    private int[] p_scores = {0,0};
    
     public Tournament(int round_num) {  //Sophia Lu
        this.rounds = round_num;
        
        tourney = new int[round_num][2];
    }
         

    void setScore(int index, int[] score) {
    
    	tourney[index] = score;
    }
     
    int[] getScore(int index)  {  //Sophia Lu
       
        return tourney[index];
    }

    int getWinner()  { //Sophia Lu
        // check if the tournament is over, and if so return who won
        // 0 means nobody won
    	int player1 = 0, player2 = 0;
    	
    	for (int i =0; i < rounds; i++) 
    	{
    		p_scores = getScore(i);
    		
    		if (p_scores[0] > p_scores[1])
    			player1 += 1;
    		if (p_scores[0] < p_scores[1])
    			player2 += 1;    		
    	}
    	
    	if (player1 > player2)
    		return 1;
    	
    	if (player2 > player1)
    		return 2;
    	else
            return 0;
       
    }

}