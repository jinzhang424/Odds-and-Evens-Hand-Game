package nz.ac.auckland.se281;

public class RandomStrategy implements BotStrategies {

  public RandomStrategy() {}

  public String pickNumber() {
    return String.valueOf(Utils.getRandomNumberRange(0, 5));
  }

  public void setPlayerHighestParity(int parity) {}
}
