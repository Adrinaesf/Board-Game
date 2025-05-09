
public class Solution2OfCodes {
    // second way to code this program  
/*public class BetterMyRobot extends MyRobot{
    // Important Datas needed for the game
    Main getInfo = new Main(); 
    MyRobot[] RedPieces = getInfo.getRedPieces(); // getting red pieces from the main class
    MyRobot[] PinkPieces = getInfo.getPinkPieces(); // ...   pink pieces
    int[] streets = new int[15]; // streets of the player's robot. If its red turn, it's the street of all red pieces, and same for pink
    int[] avenues = new int[15]; // avenues of the player's robot. ...
    int[] streetsForOtherColor = new int[15]; // avenues of the other color. If it's red turn, this array has the streets of the pink robots
    int[] avenuesForOtherColor = new int[15]; // streets of the other color 
    boolean RedPlayerTurn = true; // This boolean is for seeing who's turn is next. If right now redPlayerTurn is true, then next turn is for pink
    // booleans for Winner: 
    boolean winnerRed = false; 
    boolean winnerPink = false; 

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
    
    
    public void movingThePieces(int dice, Color color, int numOfPlayer){
      //Needed data for this class: 
      int MainDice = dice; 
      Scanner in = new Scanner(System.in); 
      MyRobot[][] chips = getInfo.getChips(); // getting the array of the chips from the main class
      TheMovesOfPieces h = new TheMovesOfPieces();   // calling the TheMovesOfPieces class
      int numberOfRobot = numOfPlayer; 
      Color playerColor = color; // get the color of the robot player choose
      
      String diceDecision = h.getDiceDesicion(); // The dice the player decide to go with, d1 or d2
      int dice1 = h.getDice1(); // getting the magnetiude of dice 1
      int dice2 = h.getDice2(); // getting the magnetiude of dice 2
      
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
      //-----------------------------------------------------------------------------------------------------------------
      // Conditions for movment: 
      /* There are basically 4 main condition that the pieces can be in: 
       * 1. If the final avenue(robot avenue + dice) is not the same as other pieces
       * 2.  If the final avenue is the same as other pieces: (This have 3 main possibility):
       *      a) When your choosen robot street is lower than the street of the your pieces's street. It means it has to move up to decrase the street num
       *            - Like a robot in (5, 17) with a dice = 2, and the final point of it is (3, 19)
       *      b) When your choosen robot street is higher than the street of the your pieces's street
       *            - Like a robot in (3, 17) with a dice = 2, and the final point is (5, 19). It means it has to move down to increase the street num
       *      c) When your choosen robot street is equal to the street of the your pieces's street
       *            - Like a robot in (3, 17), witha a dice = 2, the final point will be (3, 19), the street will not change
       */
      // For better understanding map can help a lot. 
      // if the robot is red, it moves to the right, meaning that we have to add the number of dice to its avenue
      // if the robot is pink, it moves to the left, meaning that we have to minus the number of dice from its avenue
      // Each avenue has its own number according to different dices and colors. So the final avenues are: 
      
      //Basically I made the below integers and booleans after I faced an error. 
      // The error: When the final avenue of your robot is equal to one of the indexes of avenues. 
      /*  
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
        So how can we find the coorectnumber for cheaking the avenues? 
        I'll explain this in following. 
       */
      /*int correctnumForMove = 0 ; 
      boolean canMoveYellowD1 = true; 
      boolean canMoveWhiteD1 = true;
      boolean canMoveYellowD2 = true; 
      boolean canMoveWhiteD2 = true; 
      // Explanation of "correctnumForMove" : 
      /* For Red:   
       * Example: your piece is (5, 17) , dice is 2, final point is (5, 19) 
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
        
      // It's a little hard to explain this without showing on the city, so looking at the city can help a lot
      /*for ( int b = 0 ; b < 15 ; b++){
            // Details at the top explain this part 
            if (finalAvenue1yello == avenues[b]){
               correctnumForMove = b; // now we cheack the values of b after 10. Right now finalAvenue = avenue[10] = 19 
                // Therefore the movement of the piece is now different from when there's no piece in that avenue. because right now we confirm that 
                // there are/is avenue[k] that equal to the finallavenue. 
               break; // we need the very first one and we dont need other values of b, we need to find the start point. 
            }
      }
      for ( int g = correctnumForMove ; g < 15 ; g ++){
            if (finalAvenue1yello == avenues[g]){
                canMoveYellowD1 = true; // so now the condition is related to the second condition
                break; 
            }else {
                canMoveYellowD1 = false; 
            }
      }
      // So know basically we have to do all these same thing but just for other color. They all have to have their own for loop because the for loop has to break after 
      // They all have to have their own for-loop because the for loop has to break after it finds canMoveYellowD1 = true and we can't use it anymore
      for ( int b = 0 ; b < 15 ; b++){
            if (finalAvenue1white == avenues[b]){
               correctnumForMove = b; 
               break; 
            }
      }
      for ( int g = correctnumForMove ; g < 15 ; g ++){
            if (finalAvenue1white == avenues[g]){
                canMoveWhiteD1 = true; 
                break; 
            }else {
                canMoveWhiteD1 = false;  
            }
      }
    
      // --- Dice 2 --- , Yellow Chips(red)
      for ( int b = 0 ; b < 15 ; b++){
            if (finalAvenue2yello == avenues[b]){
               correctnumForMove = b; 
               break; 
            }
      }
      for ( int g = correctnumForMove ; g < 15 ; g ++){
            if (finalAvenue2yello == avenues[g]){
                canMoveYellowD2 = true; 
                break; 
            }else {
                canMoveYellowD2 = false; 
            }
      }
      // White chips (pink) 
      for ( int b = 0 ; b < 15 ; b++){
            if (finalAvenue2white == avenues[b]){
               correctnumForMove = b;
               break; 
            }
      }
      for ( int g = correctnumForMove ; g < 15 ; g ++){
            if (finalAvenue2white == avenues[g]){
                canMoveWhiteD2 = true; 
                break; 
            }else {
                canMoveWhiteD2 = false; 
            }
      }
      
      // ---------------------------------------------------------------------------------------------------------
      //----The movment of the robots, based on their condition------
      // This values gives you the smallest street in an avenue that has several robots.
      // For example, on avenue 13, I have 5 robot, this value is equal to 3 at this situation, because the smallest street, or in another word the topest robot is at street 3, avenue 13
      int lowestD1 = 0; 
      int lowestD2 = 0; 
      boolean choosingTheWrongPlayer = false; // If the player choose a robot that its final avenue is equal to the other's player avenue,, then choosingTheWrongPlayer = true.
      if ( diceDecision.equals("d1")){
              if (playerColor.equals(Color.YELLOW)){
                  finalAvenue1yello = suiteableRobot[numberOfRobot].getAvenue() + dice1;
                  for ( int u = 0 ; u < 15 ; u ++) {
                      if ( finalAvenue1yello == avenuesForOtherColor[u]){
                          suiteableRobot[numberOfRobot].setColor(Color.RED); 
                          System.out.println("Oh you choose the wrong player :( ");
                          choosingTheWrongPlayer = true; 
                          break; 
                      }
                   }
                  for ( int z = 0 ; z < 15 ; z ++){
                      if (finalAvenue1yello == avenues[z]){
                            lowestD1 = streets[z]; 
                            if (avenues[z] == finalAvenue1yello && streets[z] < lowestD1){
                                lowestD1 = streets[z]; 
                            }
                            System.out.println("Lowest = " + lowestD1); 
                      } 
                    }
                  if(canMoveYellowD1 == false && choosingTheWrongPlayer == false){
                      suiteableRobot[numberOfRobot].turnRight(); 
                      int m = 7 - suiteableRobot[numberOfRobot].getStreet() ; 
                      for ( int v = 0 ; v < dice1 ; v++){
                          suiteableRobot[numberOfRobot].move(); 
                      }
                      suiteableRobot[numberOfRobot].turnRight(); 
                      for ( int l = 0 ; l < m ; l++){
                          suiteableRobot[numberOfRobot].move(); 
                      }
                      suiteableRobot[numberOfRobot].turnRight(); 
                      suiteableRobot[numberOfRobot].turnRight(); 
                  }
                  for (int b = 0 ; b < 15 ; b ++){
                      if(finalAvenue1yello == avenues[b] && suiteableRobot[numberOfRobot].getStreet() - lowestD1 > 0 && choosingTheWrongPlayer == false){
                      int numMoveUpWard = suiteableRobot[numberOfRobot].getStreet() - lowestD1 + 1 ; 
                      System.out.println("numMoveUp = " + numMoveUpWard); 
                      for ( int l = 0 ; l < numMoveUpWard ; l++){
                          suiteableRobot[numberOfRobot].move(); 
                      }
                      suiteableRobot[numberOfRobot].turnRight(); 
                      for ( int v = 0 ; v < dice1 ; v++){
                           suiteableRobot[numberOfRobot].move(); 
                      }
                      suiteableRobot[numberOfRobot].turnLeft();
                      break; 
                     } else if (finalAvenue1yello == avenues[b] && suiteableRobot[numberOfRobot].getStreet() - lowestD1 < 0 && choosingTheWrongPlayer == false   ){
                        int numMoveUpWard = Math.abs(suiteableRobot[numberOfRobot].getStreet() - lowestD1) -1; 
                        suiteableRobot[numberOfRobot].turnRight(); 
                        for ( int l = 0 ; l < dice1 ; l++){
                          suiteableRobot[numberOfRobot].move(); 
                        }
                        suiteableRobot[numberOfRobot].turnRight(); 
                        for ( int v = 0 ; v < numMoveUpWard ; v++){
                          suiteableRobot[numberOfRobot].move(); 
                        }
                        suiteableRobot[numberOfRobot].turnRight(); 
                        suiteableRobot[numberOfRobot].turnRight(); 
                        break; 
                     }else if(finalAvenue1yello == avenues[b] && lowestD1 == suiteableRobot[numberOfRobot].getStreet() && choosingTheWrongPlayer == false){
                         suiteableRobot[numberOfRobot].move(); 
                         suiteableRobot[numberOfRobot].turnRight(); 
                         for (int u = 0 ; u < dice1 ; u ++){
                             suiteableRobot[numberOfRobot].move(); 
                         }
                         suiteableRobot[numberOfRobot].turnLeft(); 
                         break;
                     } 
                  }    
              } else if (playerColor.equals(Color.WHITE)){
                  finalAvenue1white = suiteableRobot[numberOfRobot].getAvenue() - dice1; 
                  for ( int u = 0 ; u < 15 ; u ++) {
                      if ( finalAvenue1white == avenuesForOtherColor[u]){
                          suiteableRobot[numberOfRobot].setColor(Color.PINK); 
                          System.out.println("Oh you choose the wrong player :( ");
                          choosingTheWrongPlayer = true; 
                          break; 
                      }
                   }
                  for ( int z = 0 ; z < 15 ; z ++){
                      if (finalAvenue1white == avenues[z]){
                        lowestD1 = streets[z]; 
                        if (avenues[z] == finalAvenue1white && streets[z] < lowestD1){
                            lowestD1 = streets[z]; 
                        }
                      } 
                  }
                  if(canMoveWhiteD1 == false && choosingTheWrongPlayer == false){
                      suiteableRobot[numberOfRobot].turnLeft(); 
                      int m = 7 - suiteableRobot[numberOfRobot].getStreet() ; 
                      for ( int v = 0 ; v < dice1 ; v++){
                          suiteableRobot[numberOfRobot].move(); 
                      }
                      suiteableRobot[numberOfRobot].turnLeft(); 
                      for ( int l = 0 ; l < m ; l++){
                          suiteableRobot[numberOfRobot].move(); 
                      }
                      suiteableRobot[numberOfRobot].turnRight(); 
                      suiteableRobot[numberOfRobot].turnRight(); 
                  }
                  for(int k = 0 ; k < 15 ; k ++){
                      if(finalAvenue1white == avenues[k] && suiteableRobot[numberOfRobot].getStreet() - lowestD1 > 0 && choosingTheWrongPlayer == false){ // if the place you want to go is higher
                      int numMoveUpWard = suiteableRobot[numberOfRobot].getStreet() - lowestD1 + 1; 
                      for ( int v = 0 ; v < numMoveUpWard ; v++){
                          suiteableRobot[numberOfRobot].move(); 
                      }
                      suiteableRobot[numberOfRobot].turnLeft(); 
                      for ( int l = 0 ; l < dice1 ; l++){
                          suiteableRobot[numberOfRobot].move(); 
                      }
                      suiteableRobot[numberOfRobot].turnRight();
                      break; 
                    } else if (finalAvenue1white == avenues[k] && suiteableRobot[numberOfRobot].getStreet() - lowestD1 < 0 && choosingTheWrongPlayer == false){
                        int numMoveUpWard = Math.abs(suiteableRobot[numberOfRobot].getStreet() - lowestD1) -1; 
                        suiteableRobot[numberOfRobot].turnLeft(); 
                        for ( int l = 0 ; l < dice1 ; l++){
                          suiteableRobot[numberOfRobot].move(); 
                        }
                        suiteableRobot[numberOfRobot].turnLeft(); 
                        for ( int v = 0 ; v < numMoveUpWard ; v++){
                          suiteableRobot[numberOfRobot].move(); 
                        }
                        suiteableRobot[numberOfRobot].turnLeft(); 
                        suiteableRobot[numberOfRobot].turnLeft(); 
                        break; 
                    } else if(finalAvenue1white == avenues[k] && lowestD1 == suiteableRobot[numberOfRobot].getStreet() && choosingTheWrongPlayer == false){
                         suiteableRobot[numberOfRobot].move(); 
                         suiteableRobot[numberOfRobot].turnLeft(); 
                         for (int u = 0 ; u < dice1 ; u ++){
                             suiteableRobot[numberOfRobot].move(); 
                         }
                         suiteableRobot[numberOfRobot].turnRight(); 
                         break;
                     }
                  }
              }
        }
      // Applying the dices to move the pieces
      if ( diceDecision.equals("d2")){
            if (playerColor.equals(Color.YELLOW)){
                   finalAvenue2yello = suiteableRobot[numberOfRobot].getAvenue() + dice2; 
                   for ( int u = 0 ; u < 15 ; u ++) {
                      if ( finalAvenue2yello == avenuesForOtherColor[u]){
                          suiteableRobot[numberOfRobot].setColor(Color.RED); 
                          System.out.println("Oh you choose the wrong player :( ");
                          choosingTheWrongPlayer = true; 
                          break; 
                      }
                   }
                   for ( int z = 0 ; z < 15 ; z ++){
                      if (finalAvenue2yello == avenues[z]){
                        lowestD2 = streets[z]; 
                        if (avenues[z] == finalAvenue2yello && streets[z] < lowestD2){
                        lowestD2 = streets[z]; 
                        }
                      } 
                   }
                   if(canMoveYellowD2 == false && choosingTheWrongPlayer == false){
                       suiteableRobot[numberOfRobot].turnRight(); 
                       int m = 7 - suiteableRobot[numberOfRobot].getStreet() ; 
                       for ( int v = 0 ; v < dice2 ; v++){
                           suiteableRobot[numberOfRobot].move(); 
                       }
                       suiteableRobot[numberOfRobot].turnRight(); 
                       for ( int l = 0 ; l < m ; l++){
                           suiteableRobot[numberOfRobot].move(); 
                       }
                       suiteableRobot[numberOfRobot].turnRight(); 
                       suiteableRobot[numberOfRobot].turnRight(); 
                   } 
                   System.out.println("Lowest is " + lowestD2); 
                   for ( int i = 0 ; i < 15 ; i ++){
                       if (finalAvenue2yello == avenues[i] && suiteableRobot[numberOfRobot].getStreet() - lowestD2 > 0 && choosingTheWrongPlayer == false){
                       int numMoveUpWard = suiteableRobot[numberOfRobot].getStreet() - lowestD2 + 1 ; 
                       for ( int l = 0 ; l < numMoveUpWard ; l++){
                           suiteableRobot[numberOfRobot].move(); 
                       }
                       suiteableRobot[numberOfRobot].turnRight(); 
                       for ( int v = 0 ; v < dice2 ; v++){
                            suiteableRobot[numberOfRobot].move(); 
                       }
                       suiteableRobot[numberOfRobot].turnLeft();
                       break; 
                     } else if(finalAvenue2yello == avenues[i] && suiteableRobot[numberOfRobot].getStreet() - lowestD2 < 0 && choosingTheWrongPlayer == false){
                        int numMoveUpWard = Math.abs(suiteableRobot[numberOfRobot].getStreet() - lowestD2) -1; 
                        suiteableRobot[numberOfRobot].turnRight(); 
                        for ( int l = 0 ; l < dice2 ; l++){
                          suiteableRobot[numberOfRobot].move(); 
                        }
                        suiteableRobot[numberOfRobot].turnRight(); 
                        for ( int v = 0 ; v < numMoveUpWard ; v++){
                          suiteableRobot[numberOfRobot].move(); 
                        }
                        suiteableRobot[numberOfRobot].turnRight(); 
                        suiteableRobot[numberOfRobot].turnRight(); 
                        break; 
                     } else if (finalAvenue2yello == avenues[i] && lowestD2 == suiteableRobot[numberOfRobot].getStreet() && choosingTheWrongPlayer == false){
                         suiteableRobot[numberOfRobot].move(); 
                         suiteableRobot[numberOfRobot].turnRight(); 
                         for (int u = 0 ; u < dice2 ; u ++){
                             suiteableRobot[numberOfRobot].move(); 
                         }
                         suiteableRobot[numberOfRobot].turnLeft(); 
                         break;
                     }
                   }
               }else if (playerColor.equals(Color.WHITE)){
                  finalAvenue2white = suiteableRobot[numberOfRobot].getAvenue() - dice2; 
                  for ( int u = 0 ; u < 15 ; u ++) {
                      if ( finalAvenue2white == avenuesForOtherColor[u]){
                          suiteableRobot[numberOfRobot].setColor(Color.PINK); 
                          System.out.println("Oh you choose the wrong player :( ");
                          choosingTheWrongPlayer = true; 
                          break; 
                      }
                   }
                  for ( int z = 0 ; z < 15 ; z ++){
                      if (finalAvenue2white == avenues[z]){ 
                        lowestD2 = streets[z]; 
                        if (avenues[z] == finalAvenue2white && streets[z] < lowestD2){
                        lowestD2 = streets[z]; 
                        }
                      } 
                  }
                  if(canMoveWhiteD2 == false && choosingTheWrongPlayer == false){
                      suiteableRobot[numberOfRobot].turnLeft(); 
                      int m = 7 - suiteableRobot[numberOfRobot].getStreet() ; 
                      for ( int v = 0 ; v < dice2 ; v++){
                          suiteableRobot[numberOfRobot].move(); 
                      }
                      suiteableRobot[numberOfRobot].turnLeft(); 
                      for ( int l = 0 ; l < m ; l++){
                          suiteableRobot[numberOfRobot].move(); 
                      }
                      suiteableRobot[numberOfRobot].turnRight(); 
                      suiteableRobot[numberOfRobot].turnRight(); 
                  }
                  for ( int z = 0; z < 15 ; z++){
                      if(finalAvenue2white == avenues[z] && suiteableRobot[numberOfRobot].getStreet() - lowestD2 > 0 && choosingTheWrongPlayer == false){
                      int numMoveUpWard = suiteableRobot[numberOfRobot].getStreet() - lowestD2 + 1; 
                      for ( int v = 0 ; v < numMoveUpWard ; v++){
                          suiteableRobot[numberOfRobot].move(); 
                      }
                      suiteableRobot[numberOfRobot].turnLeft(); 
                      for ( int l = 0 ; l < dice2 ; l++){
                          suiteableRobot[numberOfRobot].move(); 
                      }
                      suiteableRobot[numberOfRobot].turnRight(); 
                      break; 
                    }
                    if (finalAvenue2white == avenues[z] && suiteableRobot[numberOfRobot].getStreet() - lowestD2 < 0 && choosingTheWrongPlayer == false){
                        int numMoveUpWard = Math.abs(suiteableRobot[numberOfRobot].getStreet() - lowestD2) -1; 
                        suiteableRobot[numberOfRobot].turnLeft(); 
                        for ( int l = 0 ; l < dice2 ; l++){
                          suiteableRobot[numberOfRobot].move(); 
                        }
                        suiteableRobot[numberOfRobot].turnLeft(); 
                        for ( int v = 0 ; v < numMoveUpWard ; v++){
                          suiteableRobot[numberOfRobot].move(); 
                        }
                        suiteableRobot[numberOfRobot].turnLeft(); 
                        suiteableRobot[numberOfRobot].turnLeft(); 
                        break; 
                    } else if(finalAvenue2white == avenues[z] && lowestD2 == suiteableRobot[numberOfRobot].getStreet() && choosingTheWrongPlayer == false){
                         suiteableRobot[numberOfRobot].move(); 
                         suiteableRobot[numberOfRobot].turnLeft(); 
                         for (int u = 0 ; u < dice2 ; u ++){
                             suiteableRobot[numberOfRobot].move(); 
                         }
                         suiteableRobot[numberOfRobot].turnRight();
                         break;
                    }
                  }
            }
      }
      
      for ( int g = 0 ; g < 15 ; g ++){
          if (playerColor.equals(Color.YELLOW)){
            Color[] OriginalColor = new Color[15]; 
            OriginalColor[g] = RedPieces[g].getColor(); 
             if (OriginalColor[g].equals(Color.YELLOW)){
                RedPieces[g].setColor(Color.RED); 
            }
            RedPlayerTurn = false; 
        }else if(playerColor.equals(Color.WHITE)){
            Color[] OriginalColor = new Color[15]; 
            OriginalColor[g] = PinkPieces[g].getColor(); 
             if (OriginalColor[g].equals(Color.WHITE)){
                PinkPieces[g].setColor(Color.PINK); 
            }
            RedPlayerTurn = true; 
         }
      }
      
      // Making the winner and looser 
      for ( int t = 0 ; t < 15 ; t ++){
            if (avenues[t] <= 5){
                winnerRed = true; 
            } else {
                winnerRed = false; 
                break;
            }
      }
      
      for ( int t = 0 ; t < 15 ; t ++){
            if (avenues[t] >= 19){
                winnerPink = true; 
            } else {
                winnerPink = false; 
                break; 
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
    
    boolean y = true; 
    RulesOftheGame getInfo3 = new RulesOftheGame(); 
    public void changeColorAfterStartGame(){
        boolean u = true;
        if (RedPlayerTurn == true){ 
            PlayersGoFirst Try = new PlayersGoFirst(); 
            boolean Isplayer1Turn = Try.getPlayer1Turn(); // true = player 1 turn , // false = player 2 turn
            boolean Isplayer2Red = Try.getIsPlayer2Red();
            System.out.println("1"); 
            for ( int cheaking = 0 ; cheaking < 15; cheaking ++){
                y = getInfo3.NextPlayerMove(RedPieces[cheaking], RedPlayerTurn);
                if (y == false) { 
                    RedPieces[cheaking].setColor(Color.YELLOW);
                } 
            }
        } else {
            System.out.println("2");
            for ( int cheaking = 0 ; cheaking < 15; cheaking ++){
                y = getInfo3.NextPlayerMove(PinkPieces[cheaking], RedPlayerTurn);
                if (y == false) { 
                    PinkPieces[cheaking].setColor(Color.WHITE);
                } 
            }
        }
    }

}*/
    // 1. Making the array for chips with for-loop: 
    /* for ( int a = 7 ; a > 5 ; a -- ) {
          Redpices2[a] = new MyRobot(Backgammon, a, 0, Direction.NORTH);
          for ( int b = 0 ; b < 2 ; b ++ ){
             RedPieces[b] = Redpices2[a];  // (7, 0) = RedPieces[0] , (6,0) = 
          }
      }
      
      for ( int s = 7 ; s > 2 ; s -- ) {
          Blackpices5Home[s] = new MyRobot(Backgammon, s, 5, Direction.NORTH);
          Blackpices5Home[s].setColor(Color.BLACK); 
          for ( int d = 0 ; d < 5 ; d ++ ){
              BlackPieces[d] = Blackpices5Home[s];  
          }
      }
      
      for ( int g = 7 ; g > 4 ; g -- ) {
          Blackpices3[g] = new MyRobot(Backgammon, g, 7, Direction.NORTH);
          Blackpices3[g].setColor(Color.BLACK); 
          for ( int f = 5 ; f < 8 ; f ++ ){
               BlackPieces[f] = Blackpices3[g];  // 
          }
      }
      
      for ( int h = 7 ; h > 2 ; h -- ) {
          Redpices5[h] = new MyRobot(Backgammon, h, 11, Direction.NORTH);
          for ( int j = 2 ; j < 7 ; j ++ ){
              RedPieces[j] = Redpices5[h];  // 
          }
      }
      
      for ( int k = 7 ; k > 2 ; k -- ) {
          Blackpices5[k] = new MyRobot(Backgammon, k, 13, Direction.NORTH);
          Blackpices5[k].setColor(Color.BLACK); 
          for (int l = 8 ; l < 13 ; l ++){
              BlackPieces[l] = Blackpices5[k];  // 
          }
      }
    
      for ( int e = 7 ; e > 4 ; e -- ) {
          Redpices3[e] = new MyRobot(Backgammon, e, 17, Direction.NORTH);
          for ( int r = 7 ; r < 10 ; r ++ ){
              RedPieces[r] = Redpices3[e];  // 
          }
      }
      
      for ( int v = 7 ; v > 2 ; v -- ) {
          Redpices5Home[v] = new MyRobot(Backgammon, v, 19, Direction.NORTH);
          for ( int z = 10 ; z < 15 ; z ++ ){
              RedPieces[z] = Redpices5Home[v];  // 
          }
      }
      
      for ( int t = 7 ; t > 5 ; t -- ) {
          Blackpices2[t] = new MyRobot(Backgammon, t, 24, Direction.NORTH);
          Blackpices2[t].setColor(Color.BLACK); 
          for ( int y = 13 ; y < 15 ; y ++ ){
              BlackPieces[y] = Blackpices2[t];  // 
          }
      }*/
      
    // _________________________________________________________________________________________________
      
    /*
       public boolean isRobotAtIntersection(MyRobot m){
            int a = m.getAvenue(); 
            int b = m.getStreet(); 
            if (m.getAvenue() == a+1 && m.getStreet() == b ){
                return true; 
            } 
            return false;
        }
      
       if (I == true && W == true ){
            for ( int cheaking = 0 ; cheaking < 15; cheaking ++){
                //c = RedPieces[cheaking];
                // x = RedPieces[cheaking].isRobotAtIntersection(RedPieces[cheaking], 2);
                if (x == false) { 
                        RedPieces[cheaking].setColor(Color.YELLOW);
                }
            }
        } else if ( I == false && W == true){
            for ( int cheaking = 0 ; cheaking < 15; cheaking ++){
                //c = BlackPieces[cheaking];
                //x = BlackPieces[cheaking].isRobotAtIntersection(BlackPieces[cheaking], 2);
                if (x == false) {
                        BlackPieces[cheaking].setColor(Color.YELLOW);
                }
            } 
        } else if ( I == true && W == false){
            for ( int cheaking = 0 ; cheaking < 15; cheaking ++){
                //c = BlackPieces[cheaking];
                //x = RedPieces[cheaking].isRobotAtIntersection(RedPieces[cheaking], 2);
                if (x == false) {
                       RedPieces[cheaking].setColor(Color.YELLOW);
                    } 
                }
        }else if ( I == false && W == false){
            for ( int cheaking = 0 ; cheaking < 15; cheaking ++){
                //c = RedPieces[cheaking];
                //x = BlackPieces[cheaking].isRobotAtIntersection(BlackPieces[cheaking],2);
                if (x == false) {
                    BlackPieces[cheaking].setColor(Color.YELLOW);
                    }
                }
        }
        
        chips[7][0]   = new BetterMyRobot(Backgammon, 7, 0, Direction.NORTH); 
      chips[6][0]   = new BetterMyRobot(Backgammon, 6, 0, Direction.NORTH); 
      chips[7][11]  = new BetterMyRobot(Backgammon, 7, 11, Direction.NORTH); 
      chips[6][11]  = new BetterMyRobot(Backgammon, 6, 11, Direction.NORTH); 
      chips[5][11]  = new BetterMyRobot(Backgammon, 5, 11, Direction.NORTH); 
      chips[4][11]  = new BetterMyRobot(Backgammon, 4, 11, Direction.NORTH); 
      chips[3][11]  = new BetterMyRobot(Backgammon, 3, 11, Direction.NORTH); 
      chips[7][17]  = new BetterMyRobot(Backgammon, 7, 17, Direction.NORTH); 
      chips[6][17]  = new BetterMyRobot(Backgammon, 6, 17, Direction.NORTH); 
      chips[5][17]  = new BetterMyRobot(Backgammon, 5, 17, Direction.NORTH); 
      chips[7][19] = new BetterMyRobot(Backgammon, 7, 19, Direction.NORTH); 
      chips[6][19] = new BetterMyRobot(Backgammon, 6, 19, Direction.NORTH); 
      chips[5][19] = new BetterMyRobot(Backgammon, 5, 19, Direction.NORTH); 
      chips[4][19] = new BetterMyRobot(Backgammon, 4, 19, Direction.NORTH); 
      chips[3][19] = new BetterMyRobot(Backgammon, 3, 19, Direction.NORTH); 
      
      chips[7][0].setLabel("1"); 
      // Black chips 
      chips[7][5]  = new BetterMyRobot(Backgammon, 7, 5, Direction.NORTH); 
      chips[6][5]  = new BetterMyRobot(Backgammon, 6, 5, Direction.NORTH); 
      chips[5][5]  = new BetterMyRobot(Backgammon, 5, 5, Direction.NORTH); 
      chips[4][5]  = new BetterMyRobot(Backgammon, 4, 5, Direction.NORTH); 
      chips[3][5]  = new BetterMyRobot(Backgammon, 3, 5, Direction.NORTH); 
      chips[7][7]  = new BetterMyRobot(Backgammon, 7, 7, Direction.NORTH); 
      chips[6][7]  = new BetterMyRobot(Backgammon, 6, 7, Direction.NORTH); 
      chips[5][7]  = new BetterMyRobot(Backgammon, 5, 7, Direction.NORTH); 
      chips[7][13]  = new BetterMyRobot(Backgammon, 7,13, Direction.NORTH); 
      chips[6][13]  = new BetterMyRobot(Backgammon, 6,13, Direction.NORTH); 
      chips[5][13] = new BetterMyRobot(Backgammon, 5,13, Direction.NORTH); 
      chips[4][13] = new BetterMyRobot(Backgammon, 4,13, Direction.NORTH); 
      chips[3][13] = new BetterMyRobot(Backgammon, 3,13, Direction.NORTH); 
      chips[7][24] = new BetterMyRobot(Backgammon, 7,24, Direction.NORTH); 
      chips[6][24] = new BetterMyRobot(Backgammon, 6,24, Direction.NORTH); 
      
      // --------------------------------------------------------------
      chips[7][5].setColor(Color.BLACK);
      chips[6][5].setColor(Color.BLACK);
      chips[5][5].setColor(Color.BLACK);
      chips[4][5].setColor(Color.BLACK); 
      chips[3][5].setColor(Color.BLACK);
      chips[7][7].setColor(Color.BLACK);
      chips[6][7].setColor(Color.BLACK);
      chips[5][7].setColor(Color.BLACK);
      chips[7][13].setColor(Color.BLACK);
      chips[6][13].setColor(Color.BLACK); 
      chips[5][13].setColor(Color.BLACK);
      chips[4][13].setColor(Color.BLACK);
      chips[3][13].setColor(Color.BLACK);
      chips[7][24].setColor(Color.BLACK);
      chips[6][24].setColor(Color.BLACK);*/
      
      //---------------------------------------------------------------
      /*public void CanRobotMove(MyRobot m, int delta, boolean turn){
        int av = m.getAvenue(); //0 
        int st = m.getStreet(); //7 
        int resultAvenue = av + delta; 
        Color color = m.getColor(); 
        int avenueOFAllchips;  
        
        Main getInfo = new Main(); 
        MyRobot[][] chips = getInfo.getChips(); 
        PlayersGoFirst getInfo2 = new PlayersGoFirst(); 
        String playerColor2 = " ";
        String playerColor1 = getInfo2.getPlayer1Color(); 
        playerColor2 = getInfo2.getPlayer2Color(); 
        Color cr = m.getColor(); 
        boolean x = true; 
        // -------------------------------------------------------
        int h = 0; 
        while( h < 25 ){ 
            for (int a = 0 ; a <= 7 ; a ++ ) {
                for (int b = 0 ; b <= 24 ; b ++){
                    
                    for (int i = 0 ; i < 2; i ++) {
                        
                        for (int j = 0 ; j < 15 ; j ++){
                            if (chips[i][j].getAvenue() + delta == b && chips[i][j].getStreet() + delta == a) {
                                numberOfFreeIntersection[i] = true; // Robot found at the intersection
                            }
                        }
                        
                    }
                    
                }
            }
            numberOfFreeIntersection[h] = false;
            h++; 
        }
        
        if (numberOfFreeIntersection[h] = false){
            x = true; 
        } else if (numberOfFreeIntersection[h] = true){
            x = false; // x is for seeing if the player can be on an intersection
        }
        
        for ( int u = 0 ; u < 2; u ++){
            for ( int r = 0 ; r < 15 ; r ++){
                
            if(turn == true){ // player 1 turn 
                if(playerColor1.equals("red")){
                    if (resultAvenue == chips[u][r].getAvenue() + delta && color.equals(Color.BLACK) || x == true){
                        m.setColor(Color.YELLOW); 
                    }
                } else if ( playerColor2.equals("black")){
                    if (resultAvenue == chips[u][r].getAvenue() + delta && color.equals(Color.BLACK) || x == true){
                        m.setColor(Color.YELLOW); 
                    }
                }                
            } else if (turn == false ){ // player 2 turn 
                if(playerColor2.equals("black")){
                        if (resultAvenue == chips[u][r].getAvenue() && color.equals(Color.BLACK) || x == true){
                            m.setColor(Color.YELLOW); 
                        } else if (playerColor2.equals("black")){
                        if (resultAvenue == chips[u][r].getAvenue() && color.equals(Color.RED) || x == true){
                            m.setColor(Color.YELLOW); 
                        }
                    }
                }
            }
            
          }
        }
    }
    
    //-----------------------------------------------------------------------------
    // Method to check if there is a robot at a given intersection
    public static boolean isRobotAtIntersection2(MyRobot robot, int street, int avenue) {
        // Check if the robot's current street and avenue match the given street and avenue
        if (robot.getStreet() == street && robot.getAvenue() == avenue) {
            return true; // Robot is at the specified intersection
        } else {
            return false; // Robot is not at the specified intersection
        }
    }
    
    
    for ( int j = 0 ; j < 15 ; j ++){
          if (suiteableRobot[numberOfRobot].getAvenue() + dice1 != avenues[j]){
              if ( playerColor.equals(Color.RED)){
                  suiteableRobot[numberOfRobot].turnRight(); 
                  int m = 7 - suiteableRobot[numberOfRobot].getStreet() ; 
                  for ( int v = 0 ; v < dice1 ; v++){
                      suiteableRobot[numberOfRobot].move(); 
                  }
                  suiteableRobot[numberOfRobot].turnRight(); 
                  for ( int l = 0 ; l < m ; l++){
                      suiteableRobot[numberOfRobot].move(); 
                  }
                  suiteableRobot[numberOfRobot].turnRight(); 
                  suiteableRobot[numberOfRobot].turnRight(); 
              }
          } else if (suiteableRobot[numberOfRobot].getAvenue() + dice2 != avenues[j]){
              if ( playerColor.equals(Color.RED)){
                  suiteableRobot[numberOfRobot].turnRight(); 
                  int m = 7 - suiteableRobot[numberOfRobot].getStreet() ; 
                  for ( int v = 0 ; v < dice2 ; v++){
                      suiteableRobot[numberOfRobot].move(); 
                  }
                  suiteableRobot[numberOfRobot].turnRight(); 
                  for ( int l = 0 ; l < m ; l++){
                      suiteableRobot[numberOfRobot].move(); 
                  }
                  suiteableRobot[numberOfRobot].turnRight(); 
                  suiteableRobot[numberOfRobot].turnRight(); 
              }
          }
      }
      
      //------------------------------------------------------------------
      for ( int j = 0 ; j < 15 ; j ++){
          if ( diceDecision.equals("d1")){
              if (suiteableRobot[numberOfRobot].getAvenue() + dice1 != avenues[j]){
              if (playerColor.equals(Color.YELLOW)){
                  suiteableRobot[numberOfRobot].turnRight(); 
                  int m = 7 - suiteableRobot[numberOfRobot].getStreet() ; 
                  for ( int v = 0 ; v < dice1 ; v++){
                      suiteableRobot[numberOfRobot].move(); 
                  }
                  suiteableRobot[numberOfRobot].turnRight(); 
                  for ( int l = 0 ; l < m ; l++){
                      suiteableRobot[numberOfRobot].move(); 
                  }
                  suiteableRobot[numberOfRobot].turnRight(); 
                  suiteableRobot[numberOfRobot].turnRight(); 
              }else if (playerColor.equals(Color.WHITE)){
                  suiteableRobot[numberOfRobot].turnLeft(); 
                  int m = 7 - suiteableRobot[numberOfRobot].getStreet() ; 
                  for ( int v = 0 ; v < dice1 ; v++){
                      suiteableRobot[numberOfRobot].move(); 
                  }
                  suiteableRobot[numberOfRobot].turnLeft(); 
                  for ( int l = 0 ; l < m ; l++){
                      suiteableRobot[numberOfRobot].move(); 
                  }
                  suiteableRobot[numberOfRobot].turnRight(); 
                  suiteableRobot[numberOfRobot].turnRight(); 
              }
              break;
              }
        }
        
        if ( diceDecision.equals("d2")){
            if (suiteableRobot[numberOfRobot].getAvenue() + dice2 != avenues[j]){
               if (playerColor.equals(Color.YELLOW)){
                  suiteableRobot[numberOfRobot].turnRight(); 
                  int m = 7 - suiteableRobot[numberOfRobot].getStreet() ; 
                  for ( int v = 0 ; v < dice2 ; v++){
                      suiteableRobot[numberOfRobot].move(); 
                  }
                  suiteableRobot[numberOfRobot].turnRight(); 
                  for ( int l = 0 ; l < m ; l++){
                      suiteableRobot[numberOfRobot].move(); 
                  }
                  suiteableRobot[numberOfRobot].turnRight(); 
                  suiteableRobot[numberOfRobot].turnRight(); 
               }else if (playerColor.equals(Color.WHITE)){
                  suiteableRobot[numberOfRobot].turnLeft(); 
                  int m = 7 - suiteableRobot[numberOfRobot].getStreet() ; 
                  for ( int v = 0 ; v < dice2 ; v++){
                      suiteableRobot[numberOfRobot].move(); 
                  }
                  suiteableRobot[numberOfRobot].turnLeft(); 
                  for ( int l = 0 ; l < m ; l++){
                      suiteableRobot[numberOfRobot].move(); 
                  }
                  suiteableRobot[numberOfRobot].turnRight(); 
                  suiteableRobot[numberOfRobot].turnRight(); 
               }
               break; 
            }  
        }
      }
      
      // ---- second condition of moving ----
      int finalAvenue1 = suiteableRobot[numberOfRobot].getAvenue() + dice1; 
      int finalAvenue2 = suiteableRobot[numberOfRobot].getAvenue() + dice2; 
      for ( int p = 0 ; p < 15 ; p ++){
          int greatest = streets[p];
        if (finalAvenue1 == avenues[p]){
          greatest = streets[p]; 
          if (avenues[p] == finalAvenue1 && streets[p] > greatest){
                greatest = streets[p]; 
          }
        }
        
        if ( diceDecision.equals("d1")){
          if (finalAvenue1 == avenues[p]){
              if (playerColor.equals(Color.YELLOW)){
                  int numMoveUpWard = suiteableRobot[numberOfRobot].getStreet() - greatest + 1 ; 
                  for ( int l = 0 ; l < numMoveUpWard ; l++){
                      suiteableRobot[numberOfRobot].move(); 
                  }
                  suiteableRobot[numberOfRobot].turnRight(); 
                  for ( int v = 0 ; v < dice1 ; v++){
                      suiteableRobot[numberOfRobot].move(); 
                  }
                  suiteableRobot[numberOfRobot].turnLeft(); 
              }else if (playerColor.equals(Color.WHITE)){
                  int numMoveUpWard = suiteableRobot[numberOfRobot].getStreet() - greatest + 1; 
                  for ( int v = 0 ; v < dice1 ; v++){
                      suiteableRobot[numberOfRobot].move(); 
                  }
                  suiteableRobot[numberOfRobot].turnLeft(); 
                  for ( int l = 0 ; l < numMoveUpWard ; l++){
                      suiteableRobot[numberOfRobot].move(); 
                  }
                  suiteableRobot[numberOfRobot].turnRight(); 
              }
              break;
              }
        }
        
        if ( diceDecision.equals("d2")){
            if (finalAvenue2 == avenues[p]){
               if (playerColor.equals(Color.YELLOW)){
                  int numMoveUpWard = suiteableRobot[numberOfRobot].getStreet() - greatest + 1 ; 
                  for ( int v = 0 ; v < dice2 ; v++){
                      suiteableRobot[numberOfRobot].move(); 
                  }
                  suiteableRobot[numberOfRobot].turnRight(); 
                  for ( int l = 0 ; l < numMoveUpWard ; l++){
                      suiteableRobot[numberOfRobot].move(); 
                  }
                  suiteableRobot[numberOfRobot].turnLeft();
               }else if (playerColor.equals(Color.WHITE)){
                  int numMoveUpWard = suiteableRobot[numberOfRobot].getStreet() - greatest + 1 ; 
                  for ( int v = 0 ; v < dice2 ; v++){
                      suiteableRobot[numberOfRobot].move(); 
                  }
                  suiteableRobot[numberOfRobot].turnLeft(); 
                  for ( int l = 0 ; l < numMoveUpWard ; l++){
                      suiteableRobot[numberOfRobot].move(); 
                  }
                  suiteableRobot[numberOfRobot].turnRight(); 
               }
               break; 
            }  
        }
      }
      
      for (int j = 0 ; j < 15 ; j ++){
          if (playerColor.equals(Color.YELLOW)){
            Color[] OriginalColor = new Color[15]; 
            OriginalColor[j] = RedPieces[j].getColor(); 
             if (OriginalColor[j].equals(Color.YELLOW)){
                RedPieces[j].setColor(Color.RED); 
            }
        }else if(playerColor.equals(Color.WHITE)){
            Color[] OriginalColor = new Color[15]; 
            OriginalColor[j] = PinkPieces[j].getColor(); 
             if (OriginalColor[j].equals(Color.WHITE)){
                PinkPieces[j].setColor(Color.PINK); 
            }
        }
      }
      
      //-----------------------------------------------------------
      h.DiceNum(); 
      String diceDesicion = h.getDiceDecision(); 
      String secondPlay = ""; 
      if (diceDesicion.equals("d1")){
          secondPlay = "d2"; 
      } else if (diceDesicion.equals("d2")){
          secondPlay = "d1"; 
      }
      chips[0][0].movingThePieces(diceDesicion); 
      chips[0][0].changeColorAfterStartGame(); 
      chips[0][0].movingThePieces(secondPlay); 
      
      
    */
}
