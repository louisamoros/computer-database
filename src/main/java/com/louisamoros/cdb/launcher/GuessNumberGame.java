package com.louisamoros.cdb.launcher;

import java.util.Random;

/**
 * A simple text-entry game.
 * 
 * @author McDowell
 */
public class GuessNumberGame {
  private final TextDevice io;
  private final NumberSource numbers;

  public GuessNumberGame(NumberSource numbers, TextDevice io) {
    this.numbers = numbers;
    this.io = io;
  }

  public void play() {
    int max = 10;
    int n = numbers.random(10) + 1;
    io.printf("Guess a number between 1 and %d%n", max);
    for (int i = 0;; i++) {
      int guess = readNumber();
      if (guess > n) {
        io.printf("Lower!%n");
      } else if (guess < n) {
        io.printf("Higher!%n");
      } else {
        io.printf("Won in %d moves%n", i);
        break;
      }
    }
  }

  private int readNumber() {
    while (true) {
      try {
        return Integer.parseInt(io.readLine());
      } catch (NumberFormatException e) {}
    }
  }

  public static void main(String[] args) {
    final Random ran = new Random();
    NumberSource numbers = new NumberSource() {
      @Override
      public int random(int max) {
        return ran.nextInt(max);
      }
    };
    new GuessNumberGame(numbers, TextDevices.defaultTextDevice()).play();
  }

  public static interface NumberSource {
    public int random(int max);
  }
}