package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class RandomStrategy implements BotStrategies {

  public RandomStrategy() {}

  public String pickNumber() {
    return String.valueOf(Utils.getRandomNumberRange(0, 5));
  }

  public void setPlayerHighestParity(int parity) {}

  public void setStrategyWinCon(Choice winCon) {}
}
