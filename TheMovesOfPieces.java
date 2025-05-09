import java.util.*; 
import becker.robots.*;
import becker.robots.RobotSE; 
import java.awt.Color;

public class TheMovesOfPieces{
    // private fields
    private int dice1, dice2; 
    private String diceDecision; 
    public void DiceNum(){
        Scanner in = new Scanner(System.in);  
        Random numGenerator = new Random(); 
        boolean correctValueForDiceDecision = true; 
        //---- Maiking the dices ----
        dice1 = numGenerator.nextInt(7)+1; // random numbers between 1 and 7
        dice2 = numGenerator.nextInt(7)+1; // random numbers between 1 and 7
        System.out.println("Dice 1: " + dice1 );
        System.out.println("Dice 2: " + dice2 );
        //---- getting the dice desicion ----- 
        do{
            // Ask for the dice decision until the player input the correct answer. 
            System.out.println("What dice is your first choice to go? Enter d1 or d2");
            diceDecision = in.nextLine(); 
            if ( diceDecision.equals("d1") || diceDecision.equals("d2") ){ 
                correctValueForDiceDecision = true; 
            } else {
                correctValueForDiceDecision = false; 
                System.out.println("Please enter 'd1' or 'd2'");
            }
        }while(correctValueForDiceDecision == false); 
    }
    
    public String getDiceDesicion(){
        return diceDecision; // returning d1 or d2 
    }
    
    public int getDice1(){
        return dice1; // returning dice 1
    }
    
    public int getDice2(){
        return dice2; // returning dice 2
    }
}
