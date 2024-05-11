package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  private int playerEvenPicks = 0;
  private int playerOddPicks = 0;

  private int roundCounter = 1;
  private Player player = null;
  private BotDifficulty bot = null;

  private int playerWinCount = 0;
  private int botWinCount = 0;

  /**
   * Creates a new game by intializing the starting variables. It also creates an instance for of
   * player and assigns the player instance with a name and their win condition. It then determines
   * the bot's win condition by whichever win condition the player didn't pick and passes that into
   * the bot's constructor.
   *
   * @param difficulty the difficulty of the bot the player will be up against
   * @param choice the players win condition (Even or Odd)
   * @param options contains the player input for their name
   */
  public void newGame(Difficulty difficulty, Choice choice, String[] options) {

    MessageCli.WELCOME_PLAYER.printMessage(options[0]);

    playerEvenPicks = 0;
    playerOddPicks = 0;
    roundCounter = 1;
    playerWinCount = 0;
    botWinCount = 0;

    player = new Player(options[0], choice);

    if (choice.equals(Choice.EVEN)) {
      bot = BotFactory.createBot(difficulty, Choice.ODD);
    } else {
      bot = BotFactory.createBot(difficulty, Choice.EVEN);
    }
  }

  /**
   * This method asks for the player's input and gets the bot input and takes their sum and passes
   * that into method roundResult and to determine the winner of the round. Then updates the number
   * of times a player has picked an odd or even number by calling the method updateParity
   */
  public void play() {

    int sum;
    String input;
    String botNumber;

    if (player == null) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    // Opening messsage and asking player for input
    MessageCli.START_ROUND.printMessage(String.valueOf(roundCounter));
    MessageCli.ASK_INPUT.printMessage();

    // Get the player's and bot's number
    input = player.pickNumber();
    botNumber = bot.getStrategy().pickNumber();

    MessageCli.PRINT_INFO_HAND.printMessage(player.getPlayerName(), input);
    MessageCli.PRINT_INFO_HAND.printMessage(bot.getBotName(), botNumber);

    // Getting the sum and determining the round result
    sum = Integer.valueOf(input) + Integer.valueOf(botNumber);
    roundResult(sum);

    updateParity(Integer.valueOf(input));
    roundCounter++;
  }

  /**
   * Uses sum to determine the winner of the round by first determining if the sum is even or odd.
   * It then uses that to determine whether the player or bot won by checking the win condition of
   * the player. If it matches that of the player, it must mean that the player has won otherwise
   * the bot wins. It also updates the number of times the bot won or lost and updates whether the
   * bot won or lost the round.
   *
   * @param sum the sum of the player's and bot's input
   */
  public void roundResult(int sum) {

    Choice sumOutcome;

    // Checking whether the sum was odd or even
    if (Utils.isEven(sum)) {
      sumOutcome = Choice.EVEN;
    } else {
      sumOutcome = Choice.ODD;
    }

    // Printing the round outcome
    if (sumOutcome.equals(Choice.EVEN)) { // The sum was even
      if (player
          .getWinChoice()
          .equals(
              Choice.EVEN)) { // Sum is even so player wins if they picked even otherwise bot wins

        MessageCli.PRINT_OUTCOME_ROUND.printMessage(
            String.valueOf(sum), "EVEN", player.getPlayerName());

        // Recording the necessary events of the round (whether bot lost and win count)
        bot.setLostPreviousRound(true);
        playerWinCount++;
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "EVEN", bot.getBotName());

        bot.setLostPreviousRound(false);
        botWinCount++;
      }
    } else { // The sum was odd
      if (player
          .getWinChoice()
          .equals(Choice.ODD)) { // Sum is odd so player wins if they picked odd otherwise bot wins

        MessageCli.PRINT_OUTCOME_ROUND.printMessage(
            String.valueOf(sum), "ODD", player.getPlayerName());

        bot.setLostPreviousRound(true);
        playerWinCount++;
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "ODD", bot.getBotName());

        bot.setLostPreviousRound(false);
        botWinCount++;
      }
    }
  }

  /**
   * First checks if a game has been created or not. If so shows the stats of the game and
   * determines the whether the player or bot won or if its a tie and prints the message
   * accordingly. It then resets all the fields.
   */
  public void endGame() {

    // Checks if a game has been created by checking whether player is null
    if (player == null) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    showStats();

    // Printing out the final game message of who won or whether it was a tie
    if (playerWinCount > botWinCount) {
      MessageCli.PRINT_END_GAME.printMessage(player.getPlayerName());
    } else if (playerWinCount < botWinCount) {
      MessageCli.PRINT_END_GAME.printMessage(bot.getBotName());
    } else {
      MessageCli.PRINT_END_GAME_TIE.printMessage();
    }

    // Resetting the game
    playerEvenPicks = 0;
    playerOddPicks = 0;

    roundCounter = 1;
    player = null;
    bot = null;

    playerWinCount = 0;
    botWinCount = 0;
  }

  /** Prints a message showing how many wins/losses the player and bot has. */
  public void showStats() {

    // Checks if a game has been created by checking whether player is null
    if (player == null) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    // Prints the current number of wins/losses the player and bot has
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        player.getPlayerName(), String.valueOf(playerWinCount), String.valueOf(botWinCount));

    MessageCli.PRINT_PLAYER_WINS.printMessage(
        bot.getBotName(), String.valueOf(botWinCount), String.valueOf(playerWinCount));
  }

  /**
   * Determines whether the player has picked more even or odd numbers, or if they've picked an
   * equal amount of even or odd numbers
   *
   * @return An indicator of whether the player has picked more even numbers, odd numbers or an
   *     equal amount of both denoted by 0, 1 and 2 respectively
   */
  public int getHighestParity() {

    if (playerEvenPicks > playerOddPicks) { // 0 indicates player has picked even numbers the most
      return 0;
    } else if (playerOddPicks
        > playerEvenPicks) { // 1 indicates player has picked odd numbers the most
      return 1;
    } else { // 2 indicates the player has picked an equal number of odd and even numbers
      return 2;
    }
  }

  /**
   * Keeps track of the number of odd and even numbers the player has picked throughout the game by
   * incrementing the fields, playerEvenPicks and playerOddPicks.
   *
   * @param playerInput the input from the player (0 to 5)
   */
  public void incrementParity(int playerInput) {

    // Checks if the player input is even or odd and increments playerEvenPicks or playerOddPicks
    // accordingly
    if (Utils.isEven(playerInput)) {
      playerEvenPicks++;
    } else {
      playerOddPicks++;
    }
  }

  /**
   * Updates the number of odd and even picks of the player by calling incrementParity and updates
   * the bot on whether the player picks more odd numbers, even numbers or an equal of both by using
   * a setter.
   *
   * @param playerInput the player's input value (0 to 5)
   */
  public void updateParity(int playerInput) {
    incrementParity(playerInput);
    bot.getTopStrategy().setPlayerHighestParity(getHighestParity());
  }
}
