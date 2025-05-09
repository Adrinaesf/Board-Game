import java.util.*; 
import becker.robots.*;
import becker.robots.RobotSE; 
import java.awt.Color; 

public class PlayersGoFirst{
    // The nesseccary datas that will be used in several methods or it will be passed to other clsses 
    String player1Name = ""; 
    String player2Name = "";
    String playerColor1 = "";
    String playerColor2 = "";
    public static boolean randomNum1_Equal_randomNum2 = false; // boolean to see if the random numbers are equal or not 
    public static boolean IsPlayer2Red; // True = player 2 is red, so player one is pink, False = player 2 is not red(so it's pink), and player one 
    public static boolean player1Turn; //True = player 1 turn ,false = player 2 tur
    
    public void ChoosingTheNames() { 
        Scanner in = new Scanner(System.in); 
        RulesOftheGame waiting = new RulesOftheGame(); 
        System.out.println("Welcome to Halfgammon, and I hope you enjoy it. Please read the instructions befor starting the game. Have fun!"); 
        waiting.wait(800); 
        System.out.println("Enter your name: "); 
        player1Name = in.nextLine(); // player 1 name
        System.out.println("Enter the name of second player: ");
        player2Name = in.nextLine(); // player 2 name 
        System.out.println("-----------------------------------------"); // for organizing 
    }
    
    public void PlayersColor(){
        Scanner in = new Scanner(System.in); 
        String choosingThePlayerColor; // Player color. Whether if it's pink or red
        System.out.println(player1Name + ": What color you want to be? Enter 'red' or 'pink'"); 
        choosingThePlayerColor = in.nextLine(); 
        if (choosingThePlayerColor.equals("red")){
            System.out.println( player1Name + ": you are the red pieces"); // player one says red
            System.out.println( player2Name + ": you are the pink pieces"); // player one says red, so player 2 is pink
            IsPlayer2Red = false; 
            playerColor1 = "red"; 
            playerColor2 = "pink"; 
            System.out.println("-----------------------------------------"); // for organizing 
        } else if (choosingThePlayerColor.equals("pink")){
            System.out.println( player1Name + ": you are the pink pieces"); // player one says pink
            System.out.println( player2Name + ": you are the red pieces"); // player one says pink, so player 2 is red
            IsPlayer2Red = true; 
            playerColor1 = "pink"; 
            playerColor2 = "red"; 
            System.out.println("-----------------------------------------"); // for organizing 
        }
    }
    
    public void DecidingWhoGoesFirst() {
        Random numGenerator = new Random(); 
        RulesOftheGame waiting = new RulesOftheGame(); 
        int randomNumberForPlayer1 = numGenerator.nextInt(6)+1; // random number for player one to see who has the greatest nummber
        int randomNumberForPlayer2 = numGenerator.nextInt(6)+1; // random number for player two
        System.out.println( player1Name + ": your number is = " + randomNumberForPlayer1); 
        System.out.println( player2Name + ": your number is = " + randomNumberForPlayer2); 
        if (randomNumberForPlayer1 > randomNumberForPlayer2){ // randomNumPlayer1 > randomNumPlayer2 => player one goes first(player one's turn
            System.out.println(playerColor1 + " has a bigger number " + player1Name + " go first."); 
            randomNum1_Equal_randomNum2 = false; 
            player1Turn = true; // player 1 go first & player 2 go second
        } else if ( randomNumberForPlayer1 < randomNumberForPlayer2 ){
            System.out.println(playerColor2 + " has a bigger number " + player2Name + " goes first."); 
            randomNum1_Equal_randomNum2 = false;  
            player1Turn = false; // player 2 go first & player 1 go second
        } else {
            randomNum1_Equal_randomNum2 = true; // random numbers are equal
        } 
            
        if (randomNum1_Equal_randomNum2 == true){
            System.out.println("The numbers should not be equal. Dices will roll again."); // if ranodm numbers are equal the method will run agind in the main class
        }
    }
    
    public boolean getRandomNum1_Equal_randomNum2(){
        return randomNum1_Equal_randomNum2; // returning the boolean to see if the random numbers are equal or no
    }

    public boolean getIsPlayer2Red(){
        return IsPlayer2Red; 
    }
    
    public boolean getPlayer1Turn(){
       return player1Turn; 
    }
}
