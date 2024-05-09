package nz.ac.auckland.se281;

public class TopStrategy implements BotStrategies {

  private int playerHighestParity = 0;

  public TopStrategy() {}

  public String pickNumber() {

    return "";
  }

  public void setPlayerHighestParity(int parity) {
    playerHighestParity = parity;
  }
}
