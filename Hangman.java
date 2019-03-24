/*This is a game project I followed from the teamtreehouse.com course Java Objects. Credit goes to teamtreehouse. */

/**
 * Developed by Kevin Hudson
 * 03/24/2019
 * Java Objects learning
 */

public class Hangman {
// main method
  public static void main(String[] args) {

    /**
     * if running hangman without a string input to set the game answer
     * game will not start and wil exit with instructions why
     *
     */
    if (args.length  == 0) {
      System.out.println("Usage:  java Hangman <answer>" );
      System.err.println("answer is required");
      System.exit(0);
    }
    // create new game object with args string
    Game game = new Game(args[0]);
    // creating new prompter object
    Prompter prompter = new Prompter(game);
    
    // while game has more than zero tries left and game is not in a win
    // state then display game progress and prompt user for a guessed

    while(game.getRemainingTries() > 0 && !game.isWon()) {
      prompter.displayProgress();
      prompter.promptForGuess();
    }
    prompter.displayOutcome();
  }
}
