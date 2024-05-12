package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class MediumBot implements BotDifficulty {

  private String botName = "HAL-9000";
  private BotStrategies strategy;
  private BotStrategies strategyRandom;
  private BotStrategies strategyTop;
  private int roundCounter;

  public MediumBot(Choice winCon) {

    strategyRandom = new RandomStrategy();
    strategyTop = new TopStrategy();
    strategyTop.setStrategyWinCon(winCon);

    strategy = strategyRandom;
    roundCounter = 0;
  }

  /**
   * Getter for the bot's name.
   *
   * @return bot's name
   */
  public String getBotName() {
    return botName;
  }

  /**
   * Updates the bot's strategy by calling setStrategy and then returns the bot's strategy.
   *
   * @return the bot's strategy
   */
  public BotStrategies getStrategy() {
    this.setStrategy();
    return strategy;
  }

  /** After the first 3 rounds, change the bot's strategy to a TopStrategy. */
  public void setStrategy() {
    roundCounter++;

    if (roundCounter > 3) {
      strategy = strategyTop;
    }
  }

  public void setLostPreviousRound(boolean botLost) {}

  /** Getter for the TopStrategy of the bot. */
  public BotStrategies getTopStrategy() {
    return strategyTop;
  }
}
