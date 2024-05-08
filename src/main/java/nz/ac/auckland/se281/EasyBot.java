package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class EasyBot implements BotDifficulty {

  private String botName = "HAL-9000";
  private Difficulty difficulty = Difficulty.EASY;
  private BotStrategies strategy = new RandomStrategy();

  public EasyBot() {}
}
