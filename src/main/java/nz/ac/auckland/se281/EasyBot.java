package nz.ac.auckland.se281;

public class EasyBot implements BotDifficulty {

  private String botName = "HAL-9000";
  private BotStrategies strategy = new RandomStrategy();

  public String getBotName() {
    return botName;
  }

  public BotStrategies getStrategy() {
    return strategy;
  }

  public void setLostPreviousRound(boolean botLost) {}

  public BotStrategies getTopStrategy() {
    return strategy;
  }
}
