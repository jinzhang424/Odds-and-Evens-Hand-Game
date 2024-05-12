package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

public class BotFactory {

  /**
   * Creates bots based on the difficulty the player has chosen.
   *
   * @param difficulty player input on how difficult the bot is (EASY, MEDIUM, HARD)
   * @param winCon the win condition of the bot (ODD, EVEN)
   * @return returns the newly created bot
   */
  public static BotDifficulty createBot(Difficulty difficulty, Choice winCon) {

    switch (difficulty) {
      case EASY:
        return new EasyBot();
      case MEDIUM:
        return new MediumBot(winCon);
      case HARD:
        return new HardBot(winCon);
    }

    return null;
  }
}
