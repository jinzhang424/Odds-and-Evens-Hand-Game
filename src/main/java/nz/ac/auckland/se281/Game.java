package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  private int roundCounter = 1;
  private Player player = null;
  private BotDifficulty bot = null;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    roundCounter = 1;
    player = new Player(options[0]);
    bot = BotFactory.createBot(difficulty);
  }

  public void play() {

    String botNumber = bot.getStrategy().pickNumber();

    MessageCli.START_ROUND.printMessage(String.valueOf(roundCounter));
    MessageCli.ASK_INPUT.printMessage();
    String input = Utils.scanner.nextLine();

    // While the input is not valid, print a error message and ask for the player for another input
    while (Integer.valueOf(input) < 0 || Integer.valueOf(input) > 5) {
      MessageCli.INVALID_INPUT.printMessage();
      MessageCli.ASK_INPUT.printMessage();
      input = Utils.scanner.nextLine();
    }

    MessageCli.PRINT_INFO_HAND.printMessage(player.getPlayerName(), input);
    MessageCli.PRINT_INFO_HAND.printMessage(bot.getBotName(), botNumber);
    roundCounter++;
  }

  public void endGame() {}

  public void showStats() {}
}
