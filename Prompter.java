
/*This is a game project I followed from the teamtreehouse.com course Java Objects. Credit goes to teamtreehouse. */

/**
 * Developed by Kevin Hudson
 * 03/24/2019
 * Java Objects learning
 */

/*
 * Class is used to define our I/O for the game
 * Prompter class will use the Game class info
 */
import java.util.Scanner;

// Pubic class Prompter
public class Prompter{

  // create an instance of the game here
  private Game game;

  // contructor to require a new game
  public Prompter(Game game) {
    this.game = game;
  }

  //method to prompt user for a guess and return if its correct or not using a new class scanner over again
  public boolean promptForGuess() {
    Scanner scanner = new Scanner(System.in);
    boolean isHit = false;
    boolean isAcceptable = false;
// do while loop that will repeat until user inputs correct type of Character
// do enter a letter stored in guessInput
    do {
      System.out.print("Enter a letter:  ");
      String guessInput = scanner.nextLine();
      try {
        isHit = game.applyGuess(guessInput);
        isAcceptable = true;
      } catch(IllegalArgumentException iae){
        System.out.printf("%s.  Please try again. %n",
                           iae.getMessage());
      }
    } while(! isAcceptable);

    return isHit;
  }

  // method to display progress got from the game class

  public void displayProgress() {
    System.out.printf("You have %d tries left to solve: %s%n",
                     game.getRemainingTries(),
                     game.getCurrentProgress());
  }

// method used to dislay outcome of game if game is won or lost
  public void displayOutcome() {
    if(game.isWon()){
     System.out.printf("You correctly guess the word within %d tries. You win!! %n",
                      game.getRemainingTries());
    } else {
     System.out.printf("You ran out of tries. The word was: %s.%n You lost this game better luck next time!! %n",
                      game.getAnswer());
    }
  }

}
