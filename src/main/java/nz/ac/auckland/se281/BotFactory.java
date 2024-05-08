package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class BotFactory {

  public BotDifficulty BotFactory(Difficulty difficulty) {

    switch (difficulty) {
      case EASY:
        return new EasyBot();
    }

    return null;
  }
}
