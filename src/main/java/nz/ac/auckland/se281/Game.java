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

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {

    MessageCli.WELCOME_PLAYER.printMessage(options[0]);

    roundCounter = 1;

    player = new Player(options[0], choice);
    bot = BotFactory.createBot(difficulty);

    if (choice.equals(Choice.EVEN)) {
      bot.getStrategy().setStrategyWinCon(Choice.ODD);
    } else {
      bot.getStrategy().setStrategyWinCon(Choice.EVEN);
    }
  }

  public void play() {

    int sum = 0;

    String botNumber;

    MessageCli.START_ROUND.printMessage(String.valueOf(roundCounter));
    MessageCli.ASK_INPUT.printMessage();
    String input = Utils.scanner.nextLine();

    // While the input is not valid, print a error message and ask for the player for another input
    while (Integer.valueOf(input) < 0 || Integer.valueOf(input) > 5) {
      MessageCli.INVALID_INPUT.printMessage();
      MessageCli.ASK_INPUT.printMessage();
      input = Utils.scanner.nextLine();
    }

    updateParity(Integer.valueOf(input));
    botNumber = bot.getStrategy().pickNumber();

    MessageCli.PRINT_INFO_HAND.printMessage(player.getPlayerName(), input);
    MessageCli.PRINT_INFO_HAND.printMessage(bot.getBotName(), botNumber);

    sum = Integer.valueOf(input) + Integer.valueOf(botNumber);
    roundResult(sum);

    roundCounter++;
  }

  public void roundResult(int sum) {

    Choice sumOutcome = null;

    // Checking whether the sum was odd or even
    if (Utils.isEven(sum)) {
      sumOutcome = Choice.EVEN;
    } else {
      sumOutcome = Choice.ODD;
    }

    // Printing the round outcome
    switch (sumOutcome) {
      case EVEN:
        if (player
            .getWinChoice()
            .equals(
                Choice.EVEN)) { // Sum is even so player wins if they picked even otherwise bot wins
          MessageCli.PRINT_OUTCOME_ROUND.printMessage(
              String.valueOf(sum), "EVEN", player.getPlayerName());
        } else {
          MessageCli.PRINT_OUTCOME_ROUND.printMessage(
              String.valueOf(sum), "EVEN", bot.getBotName());
        }
      case ODD:
        if (player
            .getWinChoice()
            .equals(
                Choice.ODD)) { // Sum is odd so player wins if they picked odd otherwise bot wins
          MessageCli.PRINT_OUTCOME_ROUND.printMessage(
              String.valueOf(sum), "ODD", player.getPlayerName());
        } else {
          MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "ODD", bot.getBotName());
        }
    }
  }

  public void endGame() {}

  public void showStats() {}

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

  public void incrementParity(int playerInput) {

    // Checks if the player input is even or odd and increments playerEvenPicks or playerOddPicks
    // accordingly
    if (Utils.isEven(playerInput)) {
      playerEvenPicks++;
    } else {
      playerOddPicks++;
    }
  }

  public void updateParity(int playerInput) {
    incrementParity(playerInput);
    bot.getStrategy().setPlayerHighestParity(getHighestParity());
  }
}
