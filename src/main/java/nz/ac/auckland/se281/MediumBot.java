package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

/**
 * The medium level bot that uses the Random strategy and switches to the Top strategy after the 3rd
 * round
 */
public class MediumBot implements BotDifficulty {

  private String botName = "HAL-9000";
  private BotStrategies strategy;
  private BotStrategies strategyRandom;
  private BotStrategies strategyTop;
  private int roundCounter;

  /**
   * Constructor for the medium for class. This is used to intialize strategyRandom and strategyTop
   * and setting the starting strategy of the bot to strategyRandom.
   *
   * @param winCon the condition for the bot
   */
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
