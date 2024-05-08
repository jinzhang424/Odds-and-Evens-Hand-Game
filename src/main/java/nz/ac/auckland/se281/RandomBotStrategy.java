package nz.ac.auckland.se281;

public abstract class RandomBotStrategy implements BotStrategies {

  public int pickNumber() {
    return Utils.getRandomNumberRange(0, 5);
  }
}
