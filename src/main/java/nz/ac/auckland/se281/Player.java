package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class Player {

  private String playerName = null;
  private Choice winChoice = null;

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
}
