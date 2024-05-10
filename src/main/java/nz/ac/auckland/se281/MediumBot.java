package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

public class MediumBot implements BotDifficulty {

  private String botName = "HAL-9000";
  private Difficulty difficulty = Difficulty.EASY;
  private BotStrategies strategy = null;
  private BotStrategies strategyRandom = null;
  private BotStrategies strategyTop = null;
  private int roundCounter = 0;

  public MediumBot(Choice winCon) {

    strategyRandom = new RandomStrategy();
    strategyTop = new TopStrategy();
    strategyTop.setStrategyWinCon(winCon);

    strategy = strategyRandom;
  }

  public String getBotName() {
    return botName;
  }

  public BotStrategies getStrategy() {
    this.setStrategy();
    return strategy;
  }

  public void setStrategy() {
    roundCounter++;

    if (roundCounter > 3) {
      strategy = strategyTop;
    }
  }
}
