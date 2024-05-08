package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  private int roundCounter = 1;
  private String playerName = null;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    roundCounter = 1;
    playerName = options[0];
  }

  public void play() {
    MessageCli.START_ROUND.printMessage(String.valueOf(roundCounter));

    MessageCli.ASK_INPUT.printMessage();
    String input = Utils.scanner.nextLine();

    // While the input is not valid, print a error message and ask for the player for another input
    while (Integer.valueOf(input) < 0 || Integer.valueOf(input) > 5) {
      MessageCli.INVALID_INPUT.printMessage();
      MessageCli.ASK_INPUT.printMessage();
      input = Utils.scanner.nextLine();
    }

    MessageCli.PRINT_INFO_HAND.printMessage(playerName, input);
    roundCounter++;
  }

  public void endGame() {}

  public void showStats() {}
}
