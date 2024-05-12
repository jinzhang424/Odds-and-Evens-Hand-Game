package nz.ac.auckland.se281;

/** Easy level difficulty bot that simply chooses numbers at random. */
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
