package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class HardBot implements BotDifficulty {

  private String botName = "HAL-9000";
  private BotStrategies strategy;
  private BotStrategies strategyRandom;
  private BotStrategies strategyTop;
  private int roundCounter = 0;
  private boolean lostPreviousRound = false;

  public HardBot(Choice winCon) {

    strategyRandom = new RandomStrategy();
    strategy = strategyRandom;
    strategyTop = new TopStrategy();

    strategyTop.setStrategyWinCon(winCon);
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

    // When after round 3, toggles the strategy of the bot if it lost
    if (roundCounter > 3 && lostPreviousRound) {

      if (strategy == strategyRandom) {
        strategy = strategyTop;
      } else {
        strategy = strategyRandom;
      }
    }
  }

  public void setLostPreviousRound(boolean botLost) {
    lostPreviousRound = botLost;
  }

  public BotStrategies getTopStrategy() {
    return strategyTop;
  }
}
