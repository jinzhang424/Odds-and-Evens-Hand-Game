package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class TopStrategy implements BotStrategies {

  private int playerHighestParity = 0;
  private Choice winCon = null;

  public TopStrategy() {}

  public String pickNumber() {

    if (winCon.equals(Choice.EVEN)) {
      return String.valueOf(winConIsEven());
    } else {
      return String.valueOf(winConIsOdd());
    }
  }

  public void setPlayerHighestParity(int parity) {
    playerHighestParity = parity;
  }

  public void setStrategyWinCon(Choice winCon) {
    this.winCon = winCon;
  }

  public int winConIsEven() {

    if (playerHighestParity == 0) {
      return Utils.getRandomEvenNumber();
    } else {
      return Utils.getRandomOddNumber();
    }
  }

  public int winConIsOdd() {

    if (playerHighestParity == 0) {
      return Utils.getRandomOddNumber();
    } else {
      return Utils.getRandomEvenNumber();
    }
  }
}
