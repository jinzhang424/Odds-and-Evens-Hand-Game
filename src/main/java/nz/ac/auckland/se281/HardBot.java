package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class HardBot implements BotDifficulty {

  private String botName = "HAL-9000";
  private Difficulty difficulty = Difficulty.HARD;
  private BotStrategies strategy = new RandomStrategy();
  private BotStrategies strategyRandom = new RandomStrategy();
  private BotStrategies strategyTop = new TopStrategy();

  public HardBot() {}

  public String getBotName() {
    return botName;
  }

  public BotStrategies getStrategy() {
    return strategy;
  }
}
