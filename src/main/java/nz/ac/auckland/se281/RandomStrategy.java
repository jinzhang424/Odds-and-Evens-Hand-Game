package nz.ac.auckland.se281;

public abstract class RandomStrategy implements BotStrategies {

  public RandomStrategy() {}

  public int pickNumber() {
    return Utils.getRandomNumberRange(0, 5);
  }
}
