package nz.ac.auckland.se281;

public interface BotDifficulty {
  public BotStrategies getStrategy();

  public String getBotName();

  public void setLostPreviousRound(boolean botLost);
}
