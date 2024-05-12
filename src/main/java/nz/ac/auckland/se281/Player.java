package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

/** Class for the player which contains all necessary elements for the player. */
public class Player {

  private String playerName;
  private Choice winChoice;

  /**
   * Constructor for class Player. This sets the player's name and win condition based on the
   * player's input
   *
   * @param name input string of the name of the player
   * @param winChoice input win condition of the player (EVEN or ODD)
   */
  public Player(String name, Choice winChoice) {
    playerName = name;
    this.winChoice = winChoice;
  }

  public String getPlayerName() {
    return playerName;
  }

  public Choice getWinChoice() {
    return winChoice;
  }

  /**
   * Gets input from plater by using a scanner. If the input from the player is invalid, it will
   * print a message telling the player that the input is invalid and continue asking the player for
   * input until the player enters a valid input
   *
   * @return The player's input numerical input (0 to 5 inclusive)
   */
  public String pickNumber() {

    String input = Utils.scanner.nextLine();

    // While the input is not valid, print a error message and ask for the player for another input
    while (!Utils.isInteger(input) || (Integer.valueOf(input) < 0 || Integer.valueOf(input) > 5)) {

      MessageCli.INVALID_INPUT.printMessage();
      MessageCli.ASK_INPUT.printMessage();

      input = Utils.scanner.nextLine();
    }

    return input;
  }
}
