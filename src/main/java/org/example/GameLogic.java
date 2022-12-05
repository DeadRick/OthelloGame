package org.example;

public class GameLogic {
    private ReversiBoard board;
    private HumanPlayer human;
    private HumanPlayer human2;
    private Bot intelligentCPU;
    private Bot intelligentCPU2;
    public GameLogic(HumanPlayer player1, HumanPlayer player2) {
        board = new ReversiBoard();
        human = player1;
        human2 = player2;

        intelligentCPU = null;
        intelligentCPU2 = null;
    }
    public GameLogic(HumanPlayer player1, Bot player2) {
        board = new ReversiBoard();
        human = player1;
        intelligentCPU = player2;
        human2 = null;
        intelligentCPU2 = null;
    }
    public GameLogic(Bot player1, Bot player2) {
        board = new ReversiBoard();
        intelligentCPU = player1;
        intelligentCPU2 = player2;

        human = null;
        human2 = null;
    }
    public GameLogic(Bot player1, HumanPlayer player2) {
        board = new ReversiBoard();
        intelligentCPU = player1;
        human = player2;

        human2 = null;
        intelligentCPU2 = null;
    }
    public void run(int command) {

        printWelcome();

        switch (command) {

            case 1:
                while (true) {
                    this.<HumanPlayer>playTurn(human);
                    checkWin(human, human2);
                    this.<HumanPlayer>playTurn(human2);
                    checkWin(human, human2);
                }
            case 2:
                while (true) {
                    this.<HumanPlayer>playTurn(human);
                    checkWin(human, intelligentCPU);
                    this.<Bot>playTurn(intelligentCPU);
                    checkWin(human, intelligentCPU);
                }
        }
    }
    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to Reversi!  Moves looks like a \"[row] [column]\".");
        System.out.println();
    }
    private void cancelTurn(Player p) {
        System.out.println();
        System.out.println(p.getPieceIdentifier() + "Has no valid moves." + " Turn canceled.");
        System.out.println();
    }
    private <T extends Player> void playTurn(T player) {

        player.setValidMovesArray(board.getValidMovesFor(player));
        if (!player.hasValidMoveLeft()) {
            player.setDidForfeitTurn(true);
            cancelTurn(player);
        } else {
            player.setDidForfeitTurn(false);
        }

        if (!player.getDidForfeitTurn()) {
            validMoves(player);
            printScore();
            board.printBoard();
            player.chooseMove(board);
            player.setValidMovesArray(null);
        }
    }

    private void validMoves(Player player) {
        System.out.println("Your moves: ");
        for (int i = 0; i < player.validMoves.length; i++) {
            for (int j = 0; j < player.validMoves[i].length; j++) {
                if (player.validMoves[i][j]) {
                    System.out.print(" [" + (i + 1) + " " + (j + 1) + "] ");
                }
            }
        }
    }

    private void checkWin(Player p1, Player p2) {
        if ((p1.getDidForfeitTurn() && p2.getDidForfeitTurn()) || board.isFull()) {
            if (board.countNumX() > board.countNumO()) {
                firstPlayerWin();
            } else if (board.countNumO() > board.countNumX()) {
                secondPlayerWin();
            } else {
                tie();
            }
        }
    }

    private void firstPlayerWin() {
        System.out.println("X player wins!");
        System.out.println("Final score is X = " + board.countNumX() + " , O = " + board.countNumO());
        board.printBoard();
        System.exit(0);
    }
    private void secondPlayerWin() {
        System.out.println("O player wins!");
        System.out.println("Final score is O = " + board.countNumO() + " , X = " + board.countNumX());
        board.printBoard();
        System.exit(0);
    }

    private void tie() {
        System.out.println("It's a draw!");
        System.out.println("Final score is X = " + board.countNumX() + " , O = " + board.countNumO());
        board.printBoard();
        System.exit(0);
    }
    private void printScore() {
        System.out.println();
        System.out.println("  SCORE: X=" + board.countNumX() + " , O=" + board.countNumO());
        System.out.println();
    }

}