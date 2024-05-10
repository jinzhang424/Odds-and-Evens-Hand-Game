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

    if (playerHighestParity == 0) { // When player has played more even numbers
      return Utils.getRandomEvenNumber();
    } else if (playerHighestParity == 1) { // When player has played more odd numbers
      return Utils.getRandomOddNumber();
    } else { // When player has played an equal amount of odd and even numbers
      return Utils.getRandomNumberRange(0, 5);
    }
  }

  public int winConIsOdd() {

    if (playerHighestParity == 0) { // When player has played more even numbers
      return Utils.getRandomOddNumber();
    } else if (playerHighestParity == 1) { // When player has played more odd numbers
      return Utils.getRandomEvenNumber();
    } else { // When player has played an equal amount of odd and even numbers
      return Utils.getRandomNumberRange(0, 5);
    }
  }
}
