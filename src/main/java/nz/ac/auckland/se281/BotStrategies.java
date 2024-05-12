package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

/** Interface for the different strategies of bots. */
public interface BotStrategies {
  public String pickNumber();

  public void setPlayerHighestParity(int parity);

  public void setStrategyWinCon(Choice winCon);
}
