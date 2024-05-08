package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class BotFactory {

  public static BotDifficulty createBot(Difficulty difficulty) {

    switch (difficulty) {
      case EASY:
        return new EasyBot();
    }

    return null;
  }
}
