package org.example;

public class HumanPlayer extends Player {
    public HumanPlayer(String id) {
        setPieceIdentifier(id);
        setClassName("HumanPlayer");
    }
    public boolean hasValidMoveLeft() {
        boolean hasValidMove = false;
        for(int i = 0; i < validMoves.length; i++) {
            for(int j = 0; j < validMoves[i].length; j++) {
                if(validMoves[i][j]) {
                    hasValidMove = true;
                }
            }
        }
        return hasValidMove;
    }
    public void chooseMove(ReversiBoard board) {
        java.util.Scanner keyboard = new java.util.Scanner(System.in);
        boolean isValidInput = false;
        String input;
        do {
            System.out.print("Enter your move, " + getPieceIdentifier() + "player: ");
            input = keyboard.nextLine().trim();
            System.out.println();
            if(input.length() == 3 && input.charAt(1) == ' ') {
                java.util.Scanner keyboardTwo = new java.util.Scanner(input);
                if(keyboardTwo.hasNextInt()) {
                    int row = keyboardTwo.nextInt() - 1; // takes into account that reversi does start indices at 0
                    if(keyboardTwo.hasNextInt()) {
                        int col = keyboardTwo.nextInt() - 1; // takes into account that reversi does start indices at 0
                        if(row < board.getCurrBoard().length && col < board.getCurrBoard()[0].length && row >= 0 && col >= 0) {
                            if(validMoves[row][col]) {
                                board.updateBoard(row, col, this);
                                board.clearUnderscores();
                                isValidInput = true;
                            }
                        }
                    }
                }
            }
            if(!isValidInput) {
                System.out.println();
                System.out.println("Please enter a valid move.");
                System.out.println();
                board.printBoard();
            }
        } while(!isValidInput);
    }
}
