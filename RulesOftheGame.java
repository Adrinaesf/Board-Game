import java.util.*; 
import becker.robots.*;
import becker.robots.RobotSE; 
import java.awt.Color;

public class RulesOftheGame{
    public static void wait(int ms){
        // making the wait method 
        // I found this from internet, but now I know how to use it later. 
        try{
            Thread.sleep(ms);
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
    
    public boolean NextPlayerMove(MyRobot robot, boolean RedGoNext){ // RedGoNext is a boolean that say who's player turn is right now. 
        // overrided veresion of isRobotAtIntersection
        // RedGoNext = true => red turn & RedGoNext = false => pink turn
        int robotAV = robot.getAvenue(); // robot avenue
        int robotST = robot.getStreet(); // robot street
        Main getInfo = new Main();
        int avenues[] = new int[15]; // creating an array of integer for avenues 
        int streets[] = new int[15]; // creating an array of integer for streets
        MyRobot[] RedPieces = getInfo.getRedPieces(); // getting the red pieces
        MyRobot[] PinkPieces = getInfo.getPinkPieces(); // getting the pink pieces
        MyRobot[] correctPieces = new MyRobot[15]; // an array of robot which is equal to redpieces or pinkPieces. and each time changes according to RedGoNext 
                             
        if (RedGoNext == true) {
            // right now is red turn, so correctPieces is RedPieces
            for (int i = 0; i < 15; i++) {
                correctPieces[i] = RedPieces[i];
                streets[i] = correctPieces[i].getStreet(); // getting the street and avenues of the correctPieces
                avenues[i] = correctPieces[i].getAvenue();
            }
        } else if (RedGoNext == false) {
            // right now is pink turn, so correctPieces is PinkPieces
            for (int i = 0; i < 15; i++) {
                correctPieces[i] = PinkPieces[i];
                streets[i] = correctPieces[i].getStreet(); // getting the street and avenues of the correctPieces
                avenues[i] = correctPieces[i].getAvenue();
            }
        }
        // We want to cheack if there is a robot above the current robot. If there is, then it's not moveable. 
        // If there is no robot, it is moveable and it can change it's color. 
        // for finding teh above robot we should say the robot with the same avenue and with a street - 1. 
        // For example a robot at (street, avenue) = (7, 0), the above robot of this is (6, 0)
        // Therfore to get the above robot we have to nimus one from its street. 
        
        for ( int t = 0 ; t < 15 ; t ++){
           if (robotST-1 == streets[t] && robotAV == avenues[t]){
                return true; 
           } 
        } 
        return false;
        // Explanation of this part of code: 
        // I said if tehre is a rbot at the same avenue of my robot avenue and with a street - 1 of my robot, then it means there is a robot above my robot
        // Therefore the current robot can not be moveable, because there is a robot on tip of it. 
        /* Example: 
        At j = 0 we have street = 7 and avenues = 0  => given robot
        robotAV = 0, and robotST = 7. robotST - 1 = 6
        At j = 1 we have street = 6 and avenues = 0, therefore it returns true, meaning that it's not moveable because there is a robot at street 7-1 and avenue 0
        */
    }    
}
