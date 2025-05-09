import becker.robots.*;
import becker.robots.RobotSE;  
import java.awt.Color; 
import becker.robots.icons.*;
import java.awt.geom.Rectangle2D;

public class WinnerBackgrond{
    Main getInfo = new Main(); 
    City backgammon = getInfo.getMyCity(); // getting the city of my programm
    MyRobot[][] chips = getInfo.getChips(); // getting the all the chips from teh main class 
    Thing[][] background = getInfo.getThings(); // getting teh things for changing the color of background
    public void ChangeTheBackground(boolean winner){ // if winner = true, red is the winner, if winner = false, pink is the winner
        Color green = new Color(144, 238, 144); // The RGB of teh light green 
        Icon greenBoard = new ShapeIcon(new Rectangle2D.Double(0.0, 0.0, 1.0, 1.0), green); 
        MyRobot[] winners = new MyRobot[30]; 
        if(winner){ // if winner is red
            for ( int t = 0; t < 25 ; t ++){
                for ( int u = 0 ; u < 8 ; u++){
                      background[u][t].setIcon(greenBoard); // change the color of things(background) to light green
                }
            }
            for ( int p = 0 ; p < 2; p++){
                for ( int j = 0 ; j < 15; j++){
                    chips[p][j].setColor(new Color(144, 238, 144)); // change the color of chips to green too so it will be invisible
                    chips[p][j].setLabel(""); // set their label to "", so their numbers remove from it  
                }
            }
            // making robots and label them so it shows "Red Won the Game!" or "Pink Won the Game!"
            winners[1] = new MyRobot(backgammon, 2, 9, Direction.NORTH); 
            winners[2] = new MyRobot(backgammon, 2, 10, Direction.NORTH); 
            winners[3] = new MyRobot(backgammon, 2, 11, Direction.NORTH); 
            winners[4] = new MyRobot(backgammon, 2, 13, Direction.NORTH); 
            winners[5] = new MyRobot(backgammon, 2, 14, Direction.NORTH);
            winners[6] = new MyRobot(backgammon, 2, 15, Direction.NORTH); 
            winners[7] = new MyRobot(backgammon, 3, 11, Direction.NORTH); 
            winners[8] = new MyRobot(backgammon, 3, 12, Direction.NORTH); 
            winners[9] = new MyRobot(backgammon, 3, 13, Direction.NORTH); 
            winners[10] = new MyRobot(backgammon, 4, 10, Direction.NORTH);
            winners[11] = new MyRobot(backgammon, 4, 11, Direction.NORTH); 
            winners[12] = new MyRobot(backgammon, 4, 12, Direction.NORTH); 
            winners[13] = new MyRobot(backgammon, 4, 13, Direction.NORTH); 
            winners[14] = new MyRobot(backgammon, 4, 14, Direction.NORTH);
            for(int u = 1 ; u < 15 ; u ++){
                winners[u].setColor(new Color(144, 238, 144)); // set the color of the robot to green
            }
            // ---- labeling the robots ---- 
            winners[1].setLabel("R");
            winners[2].setLabel("e");
            winners[3].setLabel("d");
            winners[4].setLabel("W");
            winners[5].setLabel("o");
            winners[6].setLabel("n");
            winners[7].setLabel("t");
            winners[8].setLabel("h");
            winners[9].setLabel("e");
            winners[10].setLabel("G");
            winners[11].setLabel("a");
            winners[12].setLabel("m");
            winners[13].setLabel("e");
            winners[14].setLabel("!");
        } else if (!winner){ // if winner is pink
            for ( int t = 0; t < 25 ; t ++){
                for ( int u = 0 ; u < 8 ; u++){
                      background[u][t].setIcon(greenBoard); // change the color of things(background) to light green
                }
            }
            for ( int p = 0 ; p < 2; p++){
                for ( int j = 0 ; j < 15; j++){
                    chips[p][j].setColor(new Color(144, 238, 144)); // change the color of chips to green too so it will be invisible
                    chips[p][j].setLabel("");  // set their label to "", so their numbers remove from it  
                }
            }
            // ---- Making the robots ----
            winners[0] = new MyRobot(backgammon, 2, 8, Direction.NORTH); 
            winners[1] = new MyRobot(backgammon, 2, 9, Direction.NORTH);
            winners[2] = new MyRobot(backgammon, 2, 10, Direction.NORTH);
            winners[3] = new MyRobot(backgammon, 2, 11, Direction.NORTH); 
            winners[4] = new MyRobot(backgammon, 2, 13, Direction.NORTH); 
            winners[5] = new MyRobot(backgammon, 2, 14, Direction.NORTH);
            winners[6] = new MyRobot(backgammon, 2, 15, Direction.NORTH); 
            winners[7] = new MyRobot(backgammon, 3, 11, Direction.NORTH); 
            winners[8] = new MyRobot(backgammon, 3, 12, Direction.NORTH); 
            winners[9] = new MyRobot(backgammon, 3, 13, Direction.NORTH); 
            winners[10] = new MyRobot(backgammon, 4, 10, Direction.NORTH); 
            winners[11] = new MyRobot(backgammon, 4, 11, Direction.NORTH); 
            winners[12] = new MyRobot(backgammon, 4, 12, Direction.NORTH); 
            winners[13] = new MyRobot(backgammon, 4, 13, Direction.NORTH); 
            winners[14] = new MyRobot(backgammon, 4, 14, Direction.NORTH); 
             for(int u = 0 ; u < 15 ; u ++){
                winners[u].setColor(new Color(144, 238, 144)); // set the color of the robots to green
            }
            // ---- Labeling the robots ---- 
            winners[0].setLabel("P");
            winners[1].setLabel("i");
            winners[2].setLabel("n");
            winners[3].setLabel("k");
            winners[4].setLabel("W");
            winners[5].setLabel("o");
            winners[6].setLabel("n");
            winners[7].setLabel("t");
            winners[8].setLabel("h");
            winners[9].setLabel("e");
            winners[10].setLabel("G");
            winners[11].setLabel("a");
            winners[12].setLabel("m");
            winners[13].setLabel("e");
            winners[14].setLabel("!");
        }
    }
}