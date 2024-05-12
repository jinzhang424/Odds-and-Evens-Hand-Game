package nz.ac.auckland.se281;

/** Interface for the difference difficulties of bots. */
public interface BotDifficulty {

  public BotStrategies getStrategy();

  public String getBotName();

  public void setLostPreviousRound(boolean botLost);

  public BotStrategies getTopStrategy();
}
