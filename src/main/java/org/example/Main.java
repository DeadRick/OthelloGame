package org.example;

public class Main {
    public static void main(String[] args) {
        GameLogic game = null;
        System.out.println("1. Play with other player");
        System.out.println("1. Play with bot");

        int command = 0;
        boolean isCorrect = false;
        while (!isCorrect) {
            java.util.Scanner keyboard = new java.util.Scanner(System.in);
            if (keyboard.hasNext()) {
                command = keyboard.nextInt();
            }
            if (command != 1 && command != 2) {
                System.out.println("Please, enter 1 or 2!");
            } else {
                isCorrect = true;
            }
        }
        switch (command) {
            case 1 -> game = new GameLogic(new HumanPlayer("X"), new HumanPlayer("O"));
            case 2 -> game = new GameLogic(new HumanPlayer("X"), new Bot("O"));
        }

        game.run(command);
    }
}