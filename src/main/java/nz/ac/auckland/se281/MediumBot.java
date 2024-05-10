package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class MediumBot implements BotDifficulty {

  private String botName = "HAL-9000";
  private Difficulty difficulty = Difficulty.EASY;
  private BotStrategies strategy = new RandomStrategy();

  public MediumBot() {}

  public String getBotName() {
    return botName;
  }

  public BotStrategies getStrategy() {
    return strategy;
  }
}
