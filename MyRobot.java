import java.util.*; 
import becker.robots.*;
import becker.robots.RobotSE; 
import java.awt.Color; 

public class MyRobot extends RobotSE{
    public MyRobot(City i, int s , int a, Direction d){
        super(i, s, a, d); 
    }
    
    public void move(){
        // This method notify you if there is a wall
        if ( super.frontIsClear() ) { 
            super.move(); 
        }else { 
            System.out.println("Sorry, I can't move!"); 
        }
    }
    
    public boolean isRobotAtIntersection(MyRobot robot){
        // This method explanation is at the class TheRulesOfTheGame, in NextPlayerMove method
        PlayersGoFirst Try = new PlayersGoFirst(); 
        boolean IsPlayer1Turn = Try.getPlayer1Turn(); // true = player 1 turn , // false = player 2 turn
        boolean Isplayer2Red = Try.getIsPlayer2Red();
        int avenues[] = new int[15];
        int streets[] = new int[15]; 
        Main getInfo = new Main();
        MyRobot[] RedPieces = getInfo.getRedPieces(); 
        MyRobot[] PinkPieces = getInfo.getPinkPieces();
        MyRobot[] correctPieces = new MyRobot[15]; 
        
        if (Isplayer2Red &&  IsPlayer1Turn || !Isplayer2Red && !IsPlayer1Turn) {
            // if player2red = true (player2 = red & player1 = pink) and IsPLayer1Turn = true --> correctPieces = pink
            // if player2red = false (player2 = pink, player1 = red) --> and IsPLayer1Turn = false --> correctPieces = pink
            for (int i = 0; i < 15; i++) {
                correctPieces[i] = PinkPieces[i];
                streets[i] = correctPieces[i].getStreet();
                avenues[i] = correctPieces[i].getAvenue();
            }
        } else {
            // if player2red = true (player2 = red & player1 = pink) and IsPLayer1Turn = false --> correctPieces = red
            // if player2red = false (player2 = pink, player1 = red) --> and IsPLayer1Turn = true --> correctPieces = red
            for (int i = 0; i < 15; i++) {
                correctPieces[i] = RedPieces[i];
                streets[i] = correctPieces[i].getStreet();
                avenues[i] = correctPieces[i].getAvenue();
            }
        }
        
        int downAV = robot.getAvenue(); 
        int downST = robot.getStreet(); 
        // Explanation of this part of teh code is at class RulesOfTheGame
        for ( int t = 0 ; t < 15 ; t ++){
           if (downST-1 == streets[t] && downAV == avenues[t]){
                return true; 
           } 
        } 
        return false;
    }
}