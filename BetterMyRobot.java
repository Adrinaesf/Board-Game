import java.util.*; 
import becker.robots.*; 
import becker.robots.Robot;
import becker.robots.RobotSE; 
import java.awt.Color;
public class BetterMyRobot extends MyRobot{
    // Important Datas needed for the game
    Main getInfo = new Main(); 
    MyRobot[] RedPieces = getInfo.getRedPieces(); // red pieces from the main class
    MyRobot[] PinkPieces = getInfo.getPinkPieces(); //  pink pieces
    int[] streets = new int[15]; // streets of the player's robots. If its red's turn, it's the street of all red pieces
    int[] avenues = new int[15]; // avenues of the player's robot. ...
    int[] streetsForOtherColor = new int[15]; // avenues of the other color. If it's red turn, this array has the streets of the pink robots
    int[] avenuesForOtherColor = new int[15]; // streets of the other color 
    boolean RedPlayerTurn = true; // This boolean is for seeing who's turn is next. If right now redPlayerTurn is true, then next turn is for pink
    // booleans for Winner: 
    boolean winnerRed = false; 
    boolean winnerPink = false; 
    
    public void move(int num) { //an extra move method (OVERLOADING)
        for ( int i = 0 ; i < num ; i ++) { 
            super.move(); 
        }
    }
    
    public BetterMyRobot(City c, int s , int a, Direction d){
        super(c, s, a, d); 
    }
    
    // Method for coloring the moveable robots
    public void changeColorBeforeStartGame(){
      PlayersGoFirst Try = new PlayersGoFirst(); 
      boolean Isplayer1Turn = Try.getPlayer1Turn(); // true = player 1 turn , // false = player 2 turn
      boolean Isplayer2Red = Try.getIsPlayer2Red(); // getting the needed information to see who's turn is right now
      boolean x = true; // the result of "isRobotAtIntersection" method
      if (Isplayer2Red == true && Isplayer1Turn == true ){ 
            // player 2 color = red --> player 1 color = pink  &&  player 1 turn = true, --> The player right now is pink
            for ( int cheaking = 0 ; cheaking < 15; cheaking ++){
                // cheack all the pink pieces and see if they are  moveable or not. if it's moveable change the color to white for pink
                x = PinkPieces[cheaking].isRobotAtIntersection(PinkPieces[cheaking]); 
                if (x == false) { 
                    PinkPieces[cheaking].setColor(Color.WHITE);
                } 
            }
        } else if ( Isplayer2Red == false && Isplayer1Turn == true){ 
            // player 2 is red = false, so its pink --> player 1 color = red  &&  player 1 turn = true, --> The player right now is red
            for ( int cheaking = 0 ; cheaking < 15; cheaking ++){
                // change the color of the moveable pieces to yellow for red 
                x = RedPieces[cheaking].isRobotAtIntersection(RedPieces[cheaking]);
                if (x == false) {
                    RedPieces[cheaking].setColor(Color.YELLOW);
                }
            } 
        } else if ( Isplayer2Red == true && Isplayer1Turn == false){
            // player 2 color = red --> player 1 color = pink  &&  player 1 turn = false, --> The player right now is red
            for ( int cheaking = 0 ; cheaking < 15; cheaking ++){
                // change the color of the moveable pieces to yellow for red 
                x = RedPieces[cheaking].isRobotAtIntersection(RedPieces[cheaking]);
                if (x == false) {
                    RedPieces[cheaking].setColor(Color.YELLOW);
                } 
            }
        }else if ( Isplayer2Red == false && Isplayer1Turn == false){ 
            // player 2 color = pink --> player 1 color = red  &&  player 1 turn = false, --> The player right now is pink
            for ( int cheaking = 0 ; cheaking < 15; cheaking ++){
                x = PinkPieces[cheaking].isRobotAtIntersection(PinkPieces[cheaking]);
                if (x == false) { 
                   PinkPieces[cheaking].setColor(Color.WHITE);
                } 
            }
        }
    }
    
    
    public void movingThePieces(int dice, int numOfPlayer){
      //Needed data for this class: 
      int MainDice = dice; 
      Scanner in = new Scanner(System.in); 
      MyRobot[][] chips = getInfo.getChips(); // getting the array of the chips from the main class
      TheMovesOfPieces h = new TheMovesOfPieces();   // calling the TheMovesOfPieces class
      int numberOfRobot = numOfPlayer; 
      // get the color of the robot player choose
      
      MyRobot[] suiteableRobot = new MyRobot[31]; // creating an array of robots with equal number of index and label, so when the user input the number of robot, its easy to access
      switch(numberOfRobot){
          // using the switch case for switching the number of the robot user choose to the actual robot in the array of chips
          case 1:  suiteableRobot[1]  = chips[0][0]; break; 
          case 2:  suiteableRobot[2]  = chips[0][1]; break; 
          case 3:  suiteableRobot[3]  = chips[1][0]; break; 
          case 4:  suiteableRobot[4]  = chips[1][1]; break; 
          case 5:  suiteableRobot[5]  = chips[1][2]; break; 
          case 6:  suiteableRobot[6]  = chips[1][3]; break; 
          case 7:  suiteableRobot[7]  = chips[1][4]; break; 
          case 8:  suiteableRobot[8]  = chips[1][5]; break; 
          case 9:  suiteableRobot[9]  = chips[1][6]; break; 
          case 10: suiteableRobot[10] = chips[1][7]; break; 
          case 11: suiteableRobot[11] = chips[0][2]; break; 
          case 12: suiteableRobot[12] = chips[0][3]; break; 
          case 13: suiteableRobot[13] = chips[0][4]; break; 
          case 14: suiteableRobot[14] = chips[0][5]; break; 
          case 15: suiteableRobot[15] = chips[0][6]; break; 
          case 16: suiteableRobot[16] = chips[1][8]; break; 
          case 17: suiteableRobot[17] = chips[1][9]; break; 
          case 18: suiteableRobot[18] =chips[1][10]; break; 
          case 19: suiteableRobot[19] =chips[1][11]; break; 
          case 20: suiteableRobot[20] =chips[1][12]; break; 
          case 21: suiteableRobot[21] = chips[0][7]; break; 
          case 22: suiteableRobot[22] = chips[0][8]; break; 
          case 23: suiteableRobot[23] = chips[0][9]; break; 
          case 24: suiteableRobot[24] =chips[0][10]; break; 
          case 25: suiteableRobot[25] =chips[0][11]; break; 
          case 26: suiteableRobot[26] =chips[0][12]; break; 
          case 27: suiteableRobot[27] =chips[0][13]; break; 
          case 28: suiteableRobot[28] =chips[0][14]; break; 
          case 29: suiteableRobot[29] =chips[1][13]; break; 
          case 30: suiteableRobot[30] =chips[1][14]; break;      
      }
      Color playerColor = suiteableRobot[numberOfRobot].getColor();
      for ( int k = 0 ; k < 15 ; k ++){
          if (playerColor.equals(Color.YELLOW)){
              // Eairlier I changed the red moveable pieces to yellow, so if user choose the yellow robot, it means it's red turn
              streets[k] = RedPieces[k].getStreet(); 
              avenues[k] = RedPieces[k].getAvenue(); 
              avenuesForOtherColor[k] = PinkPieces[k].getAvenue(); // avenue for other color/player
          }else if(playerColor.equals(Color.WHITE)){
              // Eairlier I changed thepink moveable pieces to white, so if user choose the white robot, it means it's pink turn
              streets[k] = PinkPieces[k].getStreet(); 
              avenues[k] = PinkPieces[k].getAvenue(); 
              avenuesForOtherColor[k] = RedPieces[k].getAvenue(); 
          }
        }
       
      int finalAvenue = 0; 
      int numMoveUpWard = 0; 
      int movingDown = 0; 
      int correctnumForMove = 0; // explanation in below
      boolean CanMove = true; 
      int topest = 0; 
      boolean choosingTheWrongPlayer = false; // If the player choose a robot that its final avenue is equal to the other's player avenue,, then choo
      //Explanation Of correctNumForMove
      /* I wrote this code when I face an error. 
       * For example: on avenue 17 I have 3 red pieces 
       * If my dice is 2, then I move 2 step forward 
       * So the final avenue is 17 + 2 = 19 
       * so MyRobotFinalAvenue = 19 = avenues[k],
       * The problem was in here: 
       * In a for loop, I'm constantly cheaking if the final avenue is in avenues[k] or not, if its not, it means none of the red pieces is in that avenue. 
       * For this type of condition movment is different. But when the final avenue is = avenue[k], then it has it's own movment. (I'm going to talk about it more in following)
       * The problem comes from here:
       * for ( int j = 0; j < 15 ; j ++){
           if ( FinalAvenue != avenues[j]){
               robot.move(); // for example
           } else if ( FinalAvenue == avenue[j]){
               robot.turnRight();
           }
        }
        in here the final avenue is not equal to avenue[0], so it will move.
        But it shouldn't, becasue later on final avenue will be equal to the avenues in the array. like 17 + 2 which is 19.  
        At first when the for loop is cheaking the condition it sees that 19 != avenues[0], so it will do the incorrect movement. 
        
        // --------- Example of this with the result of for loop ------------
        Example: your piece is (5, 17) , dice is 2, final point is (5, 19) 
        At b = 0 ----> street = 7 and avenues = 0
        At b = 1 ----> street = 6 and avenues = 0
        At b = 2 ----> street = 7 and avenues = 11
        At b = 3 ----> street = 6 and avenues = 11
        At b = 4 ----> street = 5 and avenues = 11
        At b = 5 ----> street = 4 and avenues = 11
        At b = 6 ----> street = 3 and avenues = 11
        At b = 7 ----> street = 7 and avenues = 17
        At b = 8 ----> street = 6 and avenues = 17
        At b = 9 ----> street = 5 and avenues = 17
        At b = 10 ---> street = 7 and avenues = 19   // if at any point finalAvenue == avenues[b], we have to check the indexses after b = 9
        At b = 11 ---> street = 6 and avenues = 19      because before that there is a different situation and after is something else. 
        At b = 12 ---> street = 5 and avenues = 19      So basically the value of b = correctnumForMove. 
        At b = 13 ---> street = 4 and avenues = 19
        At b = 14 ---> street = 3 and avenues = 19  */
    
      if (playerColor.equals(Color.YELLOW)){
          finalAvenue = suiteableRobot[numberOfRobot].getAvenue() + MainDice;
          for ( int b = 0 ; b < 15 ; b++){
            if (finalAvenue == avenues[b]){
               correctnumForMove = b; // now we cheack the values of b after 10. Right now finalAvenue = avenue[10] = 19 
               break; // we need the very first one and we dont need other values of b, we need to find the start point. 
            }
          }
          for ( int g = correctnumForMove ; g < 15 ; g ++){
            if (finalAvenue == avenues[g]){
                CanMove = true; // so now the condition is related to the second condition
                break; 
            }else {
                CanMove = false; // meaning that there is no robot at the finalAvenue
            }
          }
          // --- if FinalAvenue = othe player's robot avenues: 
          for ( int u = 0 ; u < 15 ; u ++) {
            if ( finalAvenue == avenuesForOtherColor[u]){
                suiteableRobot[numberOfRobot].setColor(Color.RED); // make it red again, meaning that it can't move
                System.out.println("Oh you choose the wrong player :( ");
                choosingTheWrongPlayer = true; 
                break;  
            }
          }
          topest = streets[0]; // This value gives the topest robot that are in a row with the same avenue, which should be the smallest number of street
          for ( int z = correctnumForMove ; z < 15 ; z ++){
            if (finalAvenue == avenues[z]){
                 if (avenues[z] == finalAvenue && streets[z] < topest){
                    topest = streets[z]; // Looking at the map, we can see that the robots on the top has the smallest street. 
               }
            } 
          }
          // ---- Condition 1: If there's no robot at finial avenue: 
          if(CanMove == false && choosingTheWrongPlayer == false){ 
               suiteableRobot[numberOfRobot].turnRight(); // moving to the right
               suiteableRobot[numberOfRobot].move(MainDice); // move according to the number of dice
               suiteableRobot[numberOfRobot].turnRight(); 
               movingDown = 7 - suiteableRobot[numberOfRobot].getStreet() ; // The number of moving downward, so that it reach strett 7. 
               // Because when there is no robot at final avenue, it means the final street should be at 7.
               suiteableRobot[numberOfRobot].move(movingDown); 
               suiteableRobot[numberOfRobot].turnRight(); 
               suiteableRobot[numberOfRobot].turnRight(); 
          }
          // ----- Condition 2: a) If there's robot at the finalAvenue: 
          for (int b = 0 ; b < 15 ; b ++){
                if(finalAvenue == avenues[b] && suiteableRobot[numberOfRobot].getStreet() - topest + 1 > 0 && choosingTheWrongPlayer == false){
                        numMoveUpWard = suiteableRobot[numberOfRobot].getStreet() - topest + 1 ; 
                        // When the choosen robot's street is lower than the final street. 
                        // For example a robot at (street, avenue) = (5, 17), with dice 2, the topest robot at avenue 19 is on street 3, and final point at, (2, 19). 
                        // If we look at the map for this situation we can see that the choosen robot is lower than the final point of it. 
                        // For this situation, it has to sit on the topest robot at final avenue so it moves suiteableRobot[numberOfRobot].getStreet() - topest and 1 to go higher than the highest robot
                        // for example choosen robot = (5, 17) --> get street = 5, topest robot's street at avenue 19 = 3 so it moves 5-3 up and 1 more to go on top of the robot. 
                        suiteableRobot[numberOfRobot].move(numMoveUpWard); 
                        suiteableRobot[numberOfRobot].turnRight(); 
                        suiteableRobot[numberOfRobot].move(MainDice ); 
                        suiteableRobot[numberOfRobot].turnLeft();
                        break; 
                } else if (finalAvenue == avenues[b] && suiteableRobot[numberOfRobot].getStreet() - topest - 1 < 0 && choosingTheWrongPlayer == false   ){
                        //------ Condition 2: b)  If there's robot at the finalAvenue:
                        // When the choosen robot's street is higher than the final street. 
                        // For example a robot at (street, avenue) = (3, 17), with dice 2, the topest robot at avenue 19 is on street 5, so the final point is at (4, 19). 
                        // If we look at the map for this situation we can see that the choosen robot is higher than the final point of it. 
                        // For this situation, it has to sit on the topest robot at final avenue so it moves suiteableRobot[numberOfRobot].getStreet() - topest and 1 to less than the highest robot
                        // for example choosen robot = (5, 17) --> get street = 5, topest robot's street at avenue 19 = 5 so it moves math.abs(3-5) and 1 down to sit on the topest robot
                        numMoveUpWard = Math.abs(suiteableRobot[numberOfRobot].getStreet() - topest) -1; 
                        suiteableRobot[numberOfRobot].turnRight(); 
                        suiteableRobot[numberOfRobot].move(MainDice); 
                        suiteableRobot[numberOfRobot].turnRight(); 
                        suiteableRobot[numberOfRobot].move(numMoveUpWard);
                        suiteableRobot[numberOfRobot].turnRight(); 
                        suiteableRobot[numberOfRobot].turnRight(); 
                        break; 
                }else if(finalAvenue == avenues[b] && topest == suiteableRobot[numberOfRobot].getStreet() && choosingTheWrongPlayer == false){
                         // ---- Condition 2: c) When the choosen robot's street = the robot at the final avenuet
                         // For example a robot at (5, 17), the topest robot at avenue 19 is also at street 5 ehich is (5, 19). 
                         // for this situation it just have to move one to the up and then turn right and move according to the number of the dice. 
                         suiteableRobot[numberOfRobot].move(); 
                         suiteableRobot[numberOfRobot].turnRight(); 
                         suiteableRobot[numberOfRobot].move(MainDice); 
                         suiteableRobot[numberOfRobot].turnLeft(); 
                         break;
                } 
          }    
      } else if (playerColor.equals(Color.WHITE)){
          // Basically most of the thing in this color is also the same as teh other color. The differences are: 
          // 1. The direction of its movment. Red move to the right and white move to the left. 
          // 2. The finalAvenue: because it moves to the left you have to minus the dice from suiteable robot. 
          // other than these two all other part is the same. 
          finalAvenue = suiteableRobot[numberOfRobot].getAvenue() - MainDice;
          for ( int b = 0 ; b < 15 ; b++){
            if (finalAvenue == avenues[b]){
               correctnumForMove = b; 
               break; 
            }
          }
          for ( int g = correctnumForMove ; g < 15 ; g ++){
            if (finalAvenue == avenues[g]){
                CanMove = true; 
                break; 
            }else {
                CanMove = false; // meaning that there is no robot at the finalAvenue 
            }
          }
          for ( int u = 0 ; u < 15 ; u ++) {
             if ( finalAvenue == avenuesForOtherColor[u]){
                suiteableRobot[numberOfRobot].setColor(Color.PINK); // make it pink again, meaning that it can't move
                System.out.println("Oh you choose the wrong player :( ");
                choosingTheWrongPlayer = true; 
                break; 
             }
          }
          topest = streets[0]; 
          for ( int z = 0 ; z < 15 ; z ++){
              if (finalAvenue == avenues[z]){
                 if (avenues[z] == finalAvenue && streets[z] < topest){
                    topest = streets[z]; 
                 }
             } 
          }
          if(CanMove == false && choosingTheWrongPlayer == false){
              suiteableRobot[numberOfRobot].turnLeft(); // its direction is differnt
              movingDown = 7 - suiteableRobot[numberOfRobot].getStreet() ; 
              suiteableRobot[numberOfRobot].move(MainDice); 
              suiteableRobot[numberOfRobot].turnLeft(); 
              suiteableRobot[numberOfRobot].move(movingDown); 
              suiteableRobot[numberOfRobot].turnRight(); 
              suiteableRobot[numberOfRobot].turnRight(); 
          }
          // All the comments from the previous part will also apply in ghere too. 
          for(int k = 0 ; k < 15 ; k ++){
               if(finalAvenue == avenues[k] && suiteableRobot[numberOfRobot].getStreet() - topest + 1 > 0 && choosingTheWrongPlayer == false){ // if the place you want to go is higher
                        // We have to reapeat everything again but with jsut a differnet direction of movment. 
                        numMoveUpWard = suiteableRobot[numberOfRobot].getStreet() - topest + 1;
                        suiteableRobot[numberOfRobot].move(numMoveUpWard); 
                        suiteableRobot[numberOfRobot].turnLeft(); 
                        suiteableRobot[numberOfRobot].move(MainDice); 
                        suiteableRobot[numberOfRobot].turnRight();
                        break; 
               } else if (finalAvenue == avenues[k] && suiteableRobot[numberOfRobot].getStreet() - topest - 1< 0 && choosingTheWrongPlayer == false){
                        numMoveUpWard = Math.abs(suiteableRobot[numberOfRobot].getStreet() - topest) -1; 
                        suiteableRobot[numberOfRobot].turnLeft(); 
                        suiteableRobot[numberOfRobot].move(MainDice); 
                        suiteableRobot[numberOfRobot].turnLeft(); 
                        suiteableRobot[numberOfRobot].move(numMoveUpWard);
                        suiteableRobot[numberOfRobot].turnLeft(); 
                        suiteableRobot[numberOfRobot].turnLeft(); 
                        break; 
               } else if(finalAvenue == avenues[k] && topest == suiteableRobot[numberOfRobot].getStreet() && choosingTheWrongPlayer == false){
                         suiteableRobot[numberOfRobot].move(); 
                         suiteableRobot[numberOfRobot].turnLeft(); 
                         suiteableRobot[numberOfRobot].move(MainDice); 
                         suiteableRobot[numberOfRobot].turnRight(); 
                         break; // After all this movments we need the break code so that it just do the movements for once. 
               }
          }
      }
      
      // Coloring the robots again back to their normal. So if it is yellow make all of them red again, ansd if it's white, make all them white again 
      for ( int g = 0 ; g < 15 ; g ++){
          if (playerColor.equals(Color.YELLOW)){
            RedPieces[g].setColor(Color.RED); // Make all the pieces red agian
            RedPlayerTurn = false; // because the player is red now,the next turn is for pink --> RedPlayerTurn = false
             for ( int t = 0 ; t < 15 ; t ++){
                // check all the avenues the red pieces if they pass teh avenue 19 or it's equal, then winnerRed is true. 
                // if just one avenue is not greater or equal ithan 19 then break and make the winnerRed = false
                if (avenues[t] >= 19){
                    winnerRed = true; 
                } else {
                    winnerRed = false; 
                    break;
                 }
            }
        }else if(playerColor.equals(Color.WHITE)){
            PinkPieces[g].setColor(Color.PINK); // Make all the pieces pink agian
            RedPlayerTurn = true; // because the player is pink now, the next turn is for red --> RedPlayerTurn = true
            for ( int t = 0 ; t < 15 ; t ++){
                // check all the avenues the pink pieces if they their avenue is smaller or equal 5, then winnerPink is true. 
                // if just one avenue is not smaller or equal than 5, then break and make the winnerPink = false
                if (avenues[t] <= 5){
                    winnerPink = true; 
                } else {
                    winnerPink = false; 
                    break; 
                }
            }
         }
      }
    }
     
    
    boolean y = true;
    RulesOftheGame getInfo3 = new RulesOftheGame(); 
    public void changeColorAfterStartGame(){
        if (RedPlayerTurn == true){ 
            // if RedPlayerTurn = true, it means next turn is red so cheack the red pieces and see which one is moveable
            for ( int cheaking = 0 ; cheaking < 15; cheaking ++){
                y = getInfo3.NextPlayerMove(RedPieces[cheaking], RedPlayerTurn);
                if (y == false) { 
                    RedPieces[cheaking].setColor(Color.YELLOW); // make the moveable piece to yellow
                } 
            }
        } else {
            // if RedPlayerTurn = false, it means next turn is pink so cheack the pink pieces and see which one is moveable
            for ( int cheaking = 0 ; cheaking < 15; cheaking ++){
                y = getInfo3.NextPlayerMove(PinkPieces[cheaking], RedPlayerTurn);
                if (y == false) { 
                    PinkPieces[cheaking].setColor(Color.WHITE); // make the moveable piece to white
                } 
            }
        }
    }
    
    public boolean getWinnerPink(){
        return winnerPink; 
    }
    
    public boolean getWinnerRed(){
        return winnerRed; 
    }
    
    public boolean getRedPlayerTurn(){
        return RedPlayerTurn; 
    }
    
    
   

}