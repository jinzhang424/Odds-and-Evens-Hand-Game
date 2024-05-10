package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public interface BotStrategies {
  public String pickNumber();

  public void setPlayerHighestParity(int parity);

  public void setStrategyWinCon(Choice winCon);
}
