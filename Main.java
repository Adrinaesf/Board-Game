import java.util.*; 
import becker.robots.*;
import becker.robots.RobotSE;  
import java.awt.Color; 
import becker.robots.icons.*;
import java.awt.geom.Rectangle2D;
import becker.robots.icons.CircleIcon; 

public class Main {
    public static MyRobot[] RedPieces = new BetterMyRobot[15]; // Array of redPieces
    public static MyRobot[] PinkPieces = new BetterMyRobot[15]; // Array of pinkPieces
    public static City Backgammon = new City(8, 25);
    public static BetterMyRobot[][] chips = new BetterMyRobot[2][15];  // 2D array of all chips
    public static Thing[][] background = new Thing[8][25]; // 2D array of chips of the backgrond
     public static void main(String[] args) {
      Scanner in = new Scanner(System.in); 
      //------ Making the Walls ------
      Wall[] cover = new Wall[26];
      // length-top
        for (int i = 0 ; i < 25 ; i++){ 
           cover[i] = new Wall(Backgammon, 0, i, Direction.NORTH);  
      }
      // width-left
        for(int j = 0 ; j < 8 ; j++){
            cover[j] = new Wall(Backgammon, j, 0, Direction.WEST);  
      }
      // length-buttom
        for(int o = 0 ; o < 25 ; o++){
            cover[o] = new Wall(Backgammon, 7, o, Direction.SOUTH);  
      }
      // width-right
        for(int z = 0 ; z < 8; z++){
            cover[z] = new Wall(Backgammon, z, 24, Direction.EAST);  
      }
      
      //--- Changing the background of the game ---
      Color BROWN = new Color(186, 148, 123); // getting the RGB of the brown color from internet. In robot's package there's no brown color. 
      Icon brownBoard = new ShapeIcon(new Rectangle2D.Double(0.0, 0.0, 1.0, 1.0), BROWN); 
      Icon whiteBoard = new ShapeIcon(new Rectangle2D.Double(0.0, 0.0, 1.0, 1.0), Color.LIGHT_GRAY);
      
      // shout out to Eunice for helping me figuring out how to color the background!!
      for ( int t = 0; t < 25 ; t ++){
          for ( int u = 0 ; u < 8 ; u++){
              background[u][t] = new Thing(Backgammon,u,t); // making teh things all over the city 
              if(u % 2 == 0){  // for even streets, make the even avenues brown & make the odd avenues white
                  if(t % 2 == 0){ 
                       background[u][t].setIcon(brownBoard); 
                       // if t % 2 = 0, means if avenue is even --> make it brown
                   }else {
                       background[u][t].setIcon(whiteBoard); 
                       // if t % 2 != 0, means if avenue is odd --> make it white
                   } 
              } else { // for odd street, make the even avenue white and the odd avenues brown
                  if(t % 2 != 0){ 
                       background[u][t].setIcon(brownBoard); 
                       // if avenue != even --> its odd, make ir brown
                   }else {
                       background[u][t].setIcon(whiteBoard); 
                       // if avenue = even --> make it white
                   } 
              }
          }
      }

      // ----- Creating the chips -----
      // This way for me is easier and more clear because I always need to keep track of my robots, and having them like this helps me a lot for keeping treack of them
      // But I also made it with for-loops. I will add the for-loops in the file "Solution2OfCode
      
      //Red chips                                                           labels: 
      chips[0][0]   = new BetterMyRobot(Backgammon, 7, 0, Direction.NORTH); // 1
      chips[0][1]   = new BetterMyRobot(Backgammon, 6, 0, Direction.NORTH); // 2
      chips[0][2]  = new BetterMyRobot(Backgammon, 7, 11, Direction.NORTH); // 11
      chips[0][3]  = new BetterMyRobot(Backgammon, 6, 11, Direction.NORTH); // 12
      chips[0][4]  = new BetterMyRobot(Backgammon, 5, 11, Direction.NORTH); // 13
      chips[0][5]  = new BetterMyRobot(Backgammon, 4, 11, Direction.NORTH); // 14
      chips[0][6]  = new BetterMyRobot(Backgammon, 3, 11, Direction.NORTH); // 15
      chips[0][7]  = new BetterMyRobot(Backgammon, 7, 17, Direction.NORTH); // 21
      chips[0][8]  = new BetterMyRobot(Backgammon, 6, 17, Direction.NORTH); // 22
      chips[0][9]  = new BetterMyRobot(Backgammon, 5, 17, Direction.NORTH); // 23
      chips[0][10] = new BetterMyRobot(Backgammon, 7, 19, Direction.NORTH); // 24 
      chips[0][11] = new BetterMyRobot(Backgammon, 6, 19, Direction.NORTH); // 25
      chips[0][12] = new BetterMyRobot(Backgammon, 5, 19, Direction.NORTH); // 26
      chips[0][13] = new BetterMyRobot(Backgammon, 4, 19, Direction.NORTH); // 27
      chips[0][14] = new BetterMyRobot(Backgammon, 3, 19, Direction.NORTH); // 28
      
      // Pink chips 
      chips[1][0]  = new BetterMyRobot(Backgammon, 7, 5, Direction.NORTH); // 3
      chips[1][1]  = new BetterMyRobot(Backgammon, 6, 5, Direction.NORTH); // 4
      chips[1][2]  = new BetterMyRobot(Backgammon, 5, 5, Direction.NORTH); // 5
      chips[1][3]  = new BetterMyRobot(Backgammon, 4, 5, Direction.NORTH); // 6
      chips[1][4]  = new BetterMyRobot(Backgammon, 3, 5, Direction.NORTH); // 7
      chips[1][5]  = new BetterMyRobot(Backgammon, 7, 7, Direction.NORTH); // 8
      chips[1][6]  = new BetterMyRobot(Backgammon, 6, 7, Direction.NORTH); // 9
      chips[1][7]  = new BetterMyRobot(Backgammon, 5, 7, Direction.NORTH); // 10
      chips[1][8]  = new BetterMyRobot(Backgammon, 7,13, Direction.NORTH); // 16
      chips[1][9]  = new BetterMyRobot(Backgammon, 6,13, Direction.NORTH); // 17
      chips[1][10] = new BetterMyRobot(Backgammon, 5,13, Direction.NORTH); // 18 
      chips[1][11] = new BetterMyRobot(Backgammon, 4,13, Direction.NORTH); // 19 
      chips[1][12] = new BetterMyRobot(Backgammon, 3,13, Direction.NORTH); // 20 
      chips[1][13] = new BetterMyRobot(Backgammon, 7,24, Direction.NORTH); // 29
      chips[1][14] = new BetterMyRobot(Backgammon, 6,24, Direction.NORTH); // 30
    
      // --------------------------------------------------------------
      
      for (int j = 0 ; j < 15 ; j ++){
          RedPieces[j] = chips[0][j]; // filling the array of RedPieces
          RedPieces[j].setSpeed(4.0); // setting a higher speed for the chips
          PinkPieces[j] = chips[1][j]; // filling the array of PinkPieces
          PinkPieces[j].setSpeed(4.0); // setting a higher speed for the chips
          PinkPieces[j].setColor(Color.PINK); // changing teh color of PinkPieces to pink
      }
      
      // setting the labels for all the pieces, starting from left to right
      chips[0][0].setLabel("1"); 
      chips[0][1].setLabel("2"); 
      chips[1][0].setLabel("3"); 
      chips[1][1].setLabel("4"); 
      chips[1][2].setLabel("5"); 
      chips[1][3].setLabel("6"); 
      chips[1][4].setLabel("7"); 
      chips[1][5].setLabel("8"); 
      chips[1][6].setLabel("9"); 
      chips[1][7].setLabel("10"); 
      chips[0][2].setLabel("11"); 
      chips[0][3].setLabel("12"); 
      chips[0][4].setLabel("13"); 
      chips[0][5].setLabel("14"); 
      chips[0][6].setLabel("15"); 
      chips[1][8].setLabel("16"); 
      chips[1][9].setLabel("17"); 
      chips[1][10].setLabel("18"); 
      chips[1][11].setLabel("19"); 
      chips[1][12].setLabel("20"); 
      chips[0][7].setLabel("21"); 
      chips[0][8].setLabel("22"); 
      chips[0][9].setLabel("23"); 
      chips[0][10].setLabel("24"); 
      chips[0][11].setLabel("25"); 
      chips[0][12].setLabel("26"); 
      chips[0][13].setLabel("27"); 
      chips[0][14].setLabel("28"); 
      chips[1][13].setLabel("29"); 
      chips[1][14].setLabel("30"); 
      
      RulesOftheGame waiting = new RulesOftheGame(); // calling the RulesOfTheGame for using the wait_method
      System.out.println("  _    _    _    _    _    _    _     _    _     _    _    _    _    _    _    _    _    _    _  ");
      waiting.wait(500); 
      System.out.println(" / \\  / \\  / \\  / \\  / \\  / \\  / \\   / \\  / \\   / \\  / \\  / \\  / \\  / \\  / \\  / \\  / \\  / \\  / \\ ");
      waiting.wait(500); 
      System.out.println("( W )( e )( l )( c )( o )( m )( e ) ( t )( o ) ( H )( a )( l )( f )( g )( a )( m )( m )( o )( n )");
      waiting.wait(500); 
      System.out.println(" \\_/  \\_/  \\_/  \\_/  \\_/  \\_/  \\_/   \\_/  \\_/   \\_/  \\_/  \\_/  \\_/  \\_/  \\_/  \\_/  \\_/  \\_/  \\_/ ");
      waiting.wait(500); 

      //_______________________________________________________________________________________________________________
      // ----- Intro to game -----
      PlayersGoFirst Try = new PlayersGoFirst(); 
      Try.ChoosingTheNames(); // calling teh method of choosing names
      Try.PlayersColor(); // ask the color they want 
      boolean cheakingTheNumbers; // cheak if the random numbers are equal or not, if it is generate 2 other numbers
      System.out.println("The player who has the greatest number of dice can go first."); 
      do{
        // calling the methods of PlayersGoFirst class: 
        Try.DecidingWhoGoesFirst(); 
        cheakingTheNumbers = Try.getRandomNum1_Equal_randomNum2(); 
      }while(cheakingTheNumbers == true); // do this while the two random number are equal 
      //_______________________________________________________________________________________________________________
      // ---- Printing out if it's red turn or pink turn -----
      boolean Isplayer1Turn = Try.getPlayer1Turn(); // From the class PlayersGoFirst get the player's turn.
      //True = player 1 turn ,false = player 2 turn
      boolean Isplayer2Red = Try.getIsPlayer2Red();
      // Get the color of the player, True = player 2 is red, so player one is pink, False = player 2 is not red(so it's pink), and player one is red
      int num = 1; // introducing a number for pink and red. if the number is odd, it's red turn. if the number is even, it's pink turn
      if ( Isplayer1Turn && Isplayer2Red || !Isplayer1Turn && !Isplayer2Red){
            System.out.println("Pink turn:"); 
            num = 2; 
        } else {
            System.out.println("Red turn:"); 
            num = 3; 
      }
      //_______________________________________________________________________________________________________________
      // ---- Start of the game + change in pieces color -----
      chips[0][0].changeColorBeforeStartGame(); // according to the results in "Intor to game" change the color of pieces
      TheMovesOfPieces h = new TheMovesOfPieces();   // calling the TheMovesOfPieces class
      h.DiceNum(); // dices roll 
      String diceDecison = " "; 
      diceDecison = h.getDiceDesicion(); // this should be either d1 or d2
      int dice1, dice2; // dices
      int mainDice = 0; // the final dice that will be passed to the method for movment
      int numberOfRobot = 0; // the numberOfTheRobot that the player decide to move 
      boolean x; 
      dice1 = h.getDice1(); // getting dice 1
      dice2 = h.getDice2(); // getting dice 2
      if ( diceDecison.equals("d1")){ 
              // if player say d1, then mainDice = dice1 
              mainDice = dice1; 
      } else if ( diceDecison.equals("d2")){
              // if player say d2, then mainDice = dice2 
              mainDice = dice2; 
      }
      do{
          try{
                  System.out.println("Enter the number of the robot you want to move:"); // choosing what robot they want to move
                  numberOfRobot = Integer.parseInt(in.nextLine()); // enter the number of the robot the player want to move
                  x = true; 
          } catch (Exception e) {
                  System.out.println("Please enter a number."); // give a message if an exeption happens
                  x = false; 
          }
      }while(x == false || numberOfRobot <= 0 || numberOfRobot >= 31 ); 
      chips[0][0].movingThePieces(mainDice, numberOfRobot); // call the method of movement 
      WinnerBackgrond changeTheBack = new WinnerBackgrond(); // call the WinnerBackgrond class 
      boolean redWinner; 
      boolean pinkWinner; 
      for( ; ; ){ // roll the dices and move the picese infinite time until one of the player wins the game
          chips[0][0].changeColorAfterStartGame(); // change the color of the pieces again 
          num ++; // add one to num. previously when it was red turn, the num was 3, now its 4. so it's even and it should be pink turn, because previously it was red turn
          // and same for pink. The num for pink was 2, now its 3, which is odd, so it should be red turn 
          // So if first time is red turn now it is pink and if at first it was pink turn, now is red. 
          if ( num % 2 == 0 ){
              System.out.println("Pink turn:"); 
          } else {
              System.out.println("Red turn:"); 
          }
          h.DiceNum(); // rolling the dices
          dice1 = h.getDice1(); // getting the magnetiude of dice 1
          dice2 = h.getDice2(); // getting the magnetiude of dice 2
          diceDecison = h.getDiceDesicion();
          if ( diceDecison.equals("d1")){
              mainDice = dice1; 
          } else if ( diceDecison.equals("d2")){
              mainDice = dice2; 
          }
          do{
              try{
                  System.out.println("Enter the number of the robot you want to move:"); // choosing what robot they want to move
                  numberOfRobot = Integer.parseInt(in.nextLine()); 
                  x = true; 
               } catch (Exception e) {
                  System.out.println("Please enter a number."); 
                  x = false; 
              }
          }while(x == false || numberOfRobot <= 0 || numberOfRobot >= 31); 
          chips[0][0].movingThePieces(mainDice, numberOfRobot); 
          chips[0][0].changeColorAfterStartGame(); 
          
          // --- getting the winner booleans --- 
          redWinner = chips[0][0].getWinnerRed(); 
          pinkWinner = chips[0][0].getWinnerPink(); 
          if(redWinner){
              changeTheBack.ChangeTheBackground(true); // if winner is red, pass true to changeTheBackGround for displaying the red winner background
              System.out.println("The END!"); 
              waiting.wait(1000); 
              System.out.println("Red Won this game!!!"); 
              break; // break this infinite for loop
          } else if(pinkWinner){
              changeTheBack.ChangeTheBackground(false); // if winner is pink, pass false to changeTheBackGround for displaying the pink winner background
              System.out.println("The END!"); 
              waiting.wait(1000); 
              System.out.println("Pink Won this game!!!"); 
              break; // break this infinite for loop
          } else {
              continue; // other than these two conditions, continue the for loop 
          }
      }
    }
    
    public static MyRobot[] getRedPieces(){
        return RedPieces; // method of returning the redPieces
    }
    
    public static MyRobot[] getPinkPieces(){
        return PinkPieces; // method of returning the pinkPieces
    }
    
    public static Thing[][] getThings(){
        return background; // method of returning the things for changing the color of background
    }
    
    public static City getMyCity(){
        return Backgammon; // method of returning my city
    }
    
    public static MyRobot[][] getChips(){
        return chips; // method of returning the chips
    }
}