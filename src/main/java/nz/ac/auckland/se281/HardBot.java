package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class HardBot implements BotDifficulty {

  private String botName = "HAL-9000";
  private Difficulty difficulty = Difficulty.HARD;
  private BotStrategies strategy = new RandomStrategy();
  private BotStrategies strategyRandom = new RandomStrategy();
  private BotStrategies strategyTop = new TopStrategy();
  private int roundCounter = 0;
  private boolean lostPreviousRound = false;

  public HardBot() {}

  public String getBotName() {
    return botName;
  }

  public BotStrategies getStrategy() {
    this.setStrategy();
    return strategy;
  }

  public void setStrategy() {
    roundCounter++;

    // When after round 3, toggles the strategy of the bot if it lost
    if (roundCounter > 3 && lostPreviousRound) {
      if (strategy.equals(strategyRandom)) {
        strategy = strategyTop;
      } else {
        strategy = strategyRandom;
      }
    }
  }
}
