package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class HardBot implements BotDifficulty {

  private String botName = "HAL-9000";
  private BotStrategies strategy;
  private BotStrategies strategyRandom;
  private BotStrategies strategyTop;
  private int roundCounter = 0;
  private boolean lostPreviousRound = false;

  /**
   * Constructor for the HardBot class. This is used to intialize strategyRandom, strategyTop and
   * set the starting strategy of the HardBot to strategyRandom.
   *
   * @param winCon the win condition of the bot
   */
  public HardBot(Choice winCon) {

    strategyRandom = new RandomStrategy();
    strategy = strategyRandom;
    strategyTop = new TopStrategy();

    strategyTop.setStrategyWinCon(winCon);
  }

  /**
   * A getter for the bot's name.
   *
   * @return the bot's name
   */
  public String getBotName() {
    return botName;
  }

  /**
   * Getter for the strategy the bot will be using against the player.
   *
   * @return the strategy the bot will use to pick a number
   */
  public BotStrategies getStrategy() {
    this.setStrategy();
    return strategy;
  }

  /**
   * Starts changing the bot's strategy after the first 3 rounds, by toggling if it lost the
   * previous round.
   */
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

  /**
   * Updates whether the bot won/lost the previous round.
   *
   * @param botLost the variable parameter determining whether the bot has lost
   */
  public void setLostPreviousRound(boolean botLost) {
    lostPreviousRound = botLost;
  }

  public BotStrategies getTopStrategy() {
    return strategyTop;
  }
}
