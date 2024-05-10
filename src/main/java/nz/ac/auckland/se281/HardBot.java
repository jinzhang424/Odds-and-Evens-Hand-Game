package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

public class HardBot implements BotDifficulty {

  private String botName = "HAL-9000";
  private Difficulty difficulty = Difficulty.HARD;
  private BotStrategies strategy = null;
  private BotStrategies strategyRandom = new RandomStrategy();
  private BotStrategies strategyTop = new TopStrategy();
  private int roundCounter = 0;
  private boolean lostPreviousRound = false;

  public HardBot(Choice winCon) {

    strategy = new RandomStrategy();
    strategyRandom = new RandomStrategy();
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
    System.out.println("IT IS CURRENTLY ROUND " + roundCounter);
    // When after round 3, toggles the strategy of the bot if it lost
    if (roundCounter > 3 && lostPreviousRound) {
      if (strategy.equals(strategyRandom)) {
        System.out.println("SETTING STRATEGY TO TOP");
        strategy = strategyTop;
      } else {
        strategy = strategyRandom;
        System.out.println("SETTING STRATEGY TO RANDOM");
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
