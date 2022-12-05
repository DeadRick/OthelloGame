package org.example;


public class Bot extends AbstractBot {
    protected static int[][] botPoints;
    protected static boolean intelligentExecute = false;
    public Bot(String id) {
        setPieceIdentifier(id);
        setClassName("Bot");
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

        System.out.print("Enter your move, " + getPieceIdentifier() + "player: ");

        setPointPossibilities(board);
        determineBestMove(board);

    }
    private void setPointPossibilities(ReversiBoard board) {

        botPoints = new int[board.getCurrBoard().length][board.getCurrBoard()[0].length];

        for(int r = 0; r<board.getCurrBoard().length; r++) {
            for(int c = 0; c<board.getCurrBoard()[r].length; c++) {
                intelligentExecute=true;
                board.updateBoard(r, c, this);
            }
        }
        board.clearUnderscores();
        intelligentExecute=false;

    }
    private void determineBestMove(ReversiBoard board) {

        int intellectualPrevious=0;
        int intellectualRow=0;
        int intellectualCol=0;

        for(int i = 0; i<board.getCurrBoard().length; i++) {
            for(int j = 0; j<board.getCurrBoard()[i].length; j++) {

                if(botPoints[i][j]>=intellectualPrevious) {
                    intellectualPrevious= botPoints[i][j];
                    intellectualRow=i;
                    intellectualCol=j;
                }

            }
        }
        java.util.Random numGen = new java.util.Random();
        int countMin = 20;
        int countMax = numGen.nextInt(30) + countMin;
        int highestPointMoveCount = 0;
        while(highestPointMoveCount <= countMax) {
            for(int i = 0; i<board.getCurrBoard().length; i++) {
                for(int j = 0; j<board.getCurrBoard()[i].length; j++) {
                    if(botPoints[i][j]== botPoints[intellectualRow][intellectualCol]) {
                        highestPointMoveCount++;
                        if(highestPointMoveCount == countMax) {
                            System.out.print((i+1) + " " + (j+1));
                            System.out.println("\n");
                            board.updateBoard(i, j, this);
                        }
                    }
                }
            }
        }
    }
}

