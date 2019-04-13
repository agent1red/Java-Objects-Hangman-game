/*This is a game project I followed from the teamtreehouse.com course Java Objects. Credit goes to teamtreehouse. */

/**
 * Developed by Kevin Hudson.
 * 03/24/2019
 * Java Objects learning
 */


public class Game{
  public static final int MAX_MISSES = 7;
  private String answer;
  private String hits;
  private String misses;


  public Game(String answer){
    this.answer = answer.toLowerCase();
    hits = "";
    misses = "";
  }

  public String getAnswer(){
    return answer;
  }

  /**
   * normalizeGuess checks for no entry, not a letter, and if letter
   *                has already been guessed
   * @param  letter a single Character entered in by user. Only accepts
   *                the first char of the string array if you enter in
   *                more than one character
   * @return letter returns letter value if all true
   */

  private char normalizeGuess(char letter){
    if (! Character.isLetter(letter)){
      throw new IllegalArgumentException("Guess is NOT a letter");
    }
    letter = Character.toLowerCase(letter);
     if (misses.indexOf(letter) != -1 || hits.indexOf(letter) != -1){
      throw new IllegalArgumentException(letter + " has already been guessed");
    }
    return letter;
  }

/**
 * applyGuess overloading method of applyGuess() accepting a paramater
 *            that checks if the guess is empty string or not
 * @param  letters users guess input
 * @return applyGuess() returns the method with the letter
 */
  public boolean applyGuess(String letters){
    if (letters.length() == 0){
      throw new IllegalArgumentException("No letter found");
    }
    return applyGuess(letters.charAt(0));
  }


/**
 * applyGuess method to return a true,false
 * @param  letter a single Character entered in by user. Only accepts
 *                the first char of the string array if you enter in
 *                more than one character
 * @return isHit  if true add to variable hits if false add to misses
 */

  public boolean applyGuess(char letter) {
    letter = normalizeGuess(letter);
    boolean isHit = answer.indexOf(letter) != -1;
    if (isHit) {
      hits += letter;
    } else {
      misses += letter;
    }
    return isHit;
  }

  /**
   * getRemainingTries method that is used to calulate total tries
   *                   left
   * @return max tries fro the game (7) minus how many misses counted
   */

  public int getRemainingTries(){
    return MAX_MISSES - misses.length();
  }

  /**
   * getCurrentProgress method displays dashes or letters through itteration
   *
   * @return progress
   */

  public String getCurrentProgress() {
    String progress = "";
    for (char letter : answer.toCharArray()) {
      char display = '-';
      if(hits.indexOf(letter) != -1) {
        display = letter;
      }
      progress += display;
    }
    return progress;
  }

/**
 * isWon method returns a true,false if all dashes are filled or not
 * @return getCurrentProgress method looking for the dashes and is equal to
 *         false. So no dashes means a win
 */

  public boolean isWon(){
    return getCurrentProgress().indexOf('-') == -1;
  }

}
