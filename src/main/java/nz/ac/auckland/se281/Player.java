package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class Player {

  private String playerName = null;
  private Choice winChoice = null;
  private int evenNumPicks = 0;
  private int oddNumPicks = 0;

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

  public int getHighestParity() {

    if (evenNumPicks > oddNumPicks) { // 0 indicates player has picked even numbers the most
      return 0;
    } else if (oddNumPicks > evenNumPicks) { // 1 indicates player has picked odd numbers the most
      return 1;
    } else { // 2 indicates the player has picked an equal number of odd and even numbers
      return 2;
    }
  }

  public void incrementParity(int playerInput) {

    // Checks if the player input is even or odd and increments evenNumPicks or oddNumPicks
    // accordingly
    if (Utils.isEven(playerInput)) {
      evenNumPicks++;
    } else {
      oddNumPicks++;
    }
  }
}
