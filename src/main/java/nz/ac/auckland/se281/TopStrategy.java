package nz.ac.auckland.se281;

public class TopStrategy implements BotStrategies {

  private int playerEvenPicks = 0;
  private int playerOddPicks = 0;

  public TopStrategy() {}

  public String pickNumber() {

    return "";
  }

  public int getHighestParity() {

    if (playerEvenPicks > playerOddPicks) { // 0 indicates player has picked even numbers the most
      return 0;
    } else if (playerOddPicks
        > playerEvenPicks) { // 1 indicates player has picked odd numbers the most
      return 1;
    } else { // 2 indicates the player has picked an equal number of odd and even numbers
      return 2;
    }
  }

  public void incrementParity(int playerInput) {

    // Checks if the player input is even or odd and increments playerEvenPicks or playerOddPicks
    // accordingly
    if (Utils.isEven(playerInput)) {
      playerEvenPicks++;
    } else {
      playerOddPicks++;
    }
  }
}
