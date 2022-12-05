package org.example;


public class ReversiBoard implements Board {

    private final int row = 8;
    private final int col = 8;
    private String[][] currBoard = new String[row][col];

    public ReversiBoard() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                currBoard[i][j] = ".";
            }
        }

        currBoard[3][3] = "X";
        currBoard[3][4] = "O";
        currBoard[4][3] = "O";
        currBoard[4][4] = "X";
    }
    public void printBoard() {
        for (int i = 0; i < row; i++) {
            if (i == 0) {
                for (int k = 0; k < row; k++) {
                    if (k == 0) {
                        System.out.print("    " + (k + 1));
                    } else {
                        System.out.print(" " + (k + 1));
                    }
                }
                System.out.println();
            }
            System.out.print("  " + (i + 1) + " ");
            for (int j = 0; j < col; j++) {
                System.out.print(currBoard[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public void updateBoard(int r, int c, Player p) {

        String oppositePiece = "", playerPiece = "";
        if (p.getPieceIdentifier().equals("X")) {
            oppositePiece = "O";
            playerPiece = "X";
        } else if (p.getPieceIdentifier().equals("O")) {
            oppositePiece = "X";
            playerPiece = "O";
        }


        int intelligentPieces = 0;
        int locatePiece = 0;
        if (currBoard[r][c].equals("_") || p.getValidMovesArray()[r][c]) {
            if (!Bot.intelligentExecute) {
                currBoard[r][c] = playerPiece;
            }
            locatePiece = 1;
        }


        if (locatePiece == 1) {

            int checkPiece = 0, checkStop = 1, otherPiece = 0, flipPieces = 0, endFlip = 0, checkSkip = 0;
            for (int i = c + 1; i < col; i++) {
                if (!currBoard[r][i].equals(oppositePiece)) {
                    checkSkip = 1;
                }
                if (currBoard[r][i].equals(oppositePiece) && checkSkip == 0) {
                    if (checkStop == 1) {
                        for (int j = i; j < col; j++) {
                            if (currBoard[r][j].equals(oppositePiece)) {
                                checkPiece = 1;
                                endFlip++;
                                continue;
                            }
                            if (currBoard[r][j].equals(".") || currBoard[r][j].equals("_") || (j == col - 1 && currBoard[r][j].equals(oppositePiece))) {
                                otherPiece = 1;
                                endFlip = 0;
                            }
                            if (currBoard[r][j].equals(playerPiece) && checkPiece == 1 && otherPiece != 1) {
                                flipPieces = 1;
                                checkStop = 0;
                                break;
                            }
                        }
                    }
                    if (flipPieces == 1 && currBoard[r][i].equals(oppositePiece) && endFlip > 0) {
                        if (!Bot.intelligentExecute) {
                            currBoard[r][i] = (playerPiece);
                        }
                        endFlip--;
                        intelligentPieces++;
                    }
                    else if (currBoard[r][i].equals(playerPiece)) {
                        break;
                    }
                }
            }
            int checkPieceTwo = 0, checkStopTwo = 1, otherPieceTwo = 0, flipPiecesTwo = 0, endFlipTwo = 0, checkSkipTwo = 0;
            for (int i = c - 1; i >= 0; i--) {
                if (!currBoard[r][i].equals(oppositePiece)) {
                    checkSkipTwo = 1;
                }
                if (currBoard[r][i].equals(oppositePiece) && checkSkipTwo == 0) {
                    if (checkStopTwo == 1) {
                        for (int j = i; j >= 0; j--) {
                            if (currBoard[r][j].equals(oppositePiece)) {
                                checkPieceTwo = 1;
                                endFlipTwo++;
                                continue;
                            }
                            if (currBoard[r][j].equals(".") || currBoard[r][j].equals("_") || (j == 0 && currBoard[r][j].equals(oppositePiece))) {
                                otherPieceTwo = 1;
                                endFlipTwo = 0;
                                break;
                            }
                            if (currBoard[r][j].equals(playerPiece) && checkPieceTwo == 1 && otherPieceTwo != 1) {
                                flipPiecesTwo = 1;
                                checkStopTwo = 0;
                                break;
                            }
                        }
                    }
                    if (flipPiecesTwo == 1 && currBoard[r][i].equals(oppositePiece) && endFlipTwo > 0) {
                        if (!Bot.intelligentExecute) {
                            currBoard[r][i] = (playerPiece);
                        }
                        endFlipTwo--;
                        intelligentPieces++;
                    }
                    else if (currBoard[r][i].equals(playerPiece)) {
                        break;
                    }
                }
            }

            int checkPieceThree = 0, checkStopThree = 1, otherPieceThree = 0, flipPiecesThree = 0, endFlipThree = 0, checkSkipThree = 0;
            for (int i = r + 1; i < row; i++) {
                if (!currBoard[i][c].equals(oppositePiece)) {
                    checkSkipThree = 1;
                }
                if (currBoard[i][c].equals(oppositePiece) && checkSkipThree == 0) {
                    if (checkStopThree == 1) {
                        for (int j = i; j < row; j++) {
                            if (currBoard[j][c].equals(oppositePiece)) {
                                checkPieceThree = 1;
                                endFlipThree++;
                                continue;
                            }
                            if (currBoard[j][c].equals(".") || currBoard[j][c].equals("_") || (j == row - 1 && currBoard[j][c].equals(oppositePiece))) {
                                otherPieceThree = 1;
                                endFlip = 0;
                                break;
                            }
                            if (currBoard[j][c].equals(playerPiece) && checkPieceThree == 1 && otherPieceThree != 1) {
                                flipPiecesThree = 1;
                                checkStopThree = 0;
                                break;
                            }
                        }
                    }
                    if (flipPiecesThree == 1 && currBoard[i][c].equals(oppositePiece) && endFlipThree > 0) {
                        if (!Bot.intelligentExecute) {
                            currBoard[i][c] = (playerPiece);
                        }
                        endFlipThree--;
                        intelligentPieces++;
                        continue;
                    }
                    else if (currBoard[i][c].equals(playerPiece)) {
                        break;
                    }
                }
            }

            int checkPieceFour = 0, checkStopFour = 1, otherPieceFour = 0, flipPiecesFour = 0, endFlipFour = 0, checkSkipFour = 0;
            for (int i = r - 1; i >= 0; i--) {
                if (!currBoard[i][c].equals(oppositePiece)) {
                    checkSkipFour = 1;
                }
                if (currBoard[i][c].equals(oppositePiece) && checkSkipFour == 0) {
                    if (checkStopFour == 1) {
                        for (int j = i; j >= 0; j--) {
                            if (currBoard[j][c].equals(oppositePiece) && otherPieceFour == 0) {
                                checkPieceFour = 1;
                                endFlipFour++;
                                continue;
                            }
                            if ((currBoard[j][c].equals(".") || currBoard[j][c].equals("_")) || (j == 0 && currBoard[j][c].equals(oppositePiece))) {
                                otherPieceFour = 1;
                                endFlipFour = 0;
                                break;
                            }
                            if (currBoard[j][c].equals(playerPiece) && checkPieceFour == 1 && otherPieceFour != 1) {
                                flipPiecesFour = 1;
                                checkStopFour = 0;
                                break;
                            }
                        }
                    }
                    if (flipPiecesFour == 1 && currBoard[i][c].equals(oppositePiece) && endFlipFour > 0) {
                        if (!Bot.intelligentExecute) {
                            currBoard[i][c] = (playerPiece);
                        }
                        endFlipFour--;
                        intelligentPieces++;
                    }
                    else if (currBoard[i][c].equals(playerPiece)) {
                        break;
                    }
                }
            }

            int checkPieceFive = 0, checkStopFive = 1, otherPieceFive = 0, flipPiecesFive = 0, endFlipFive = 0, checkSkipFive = 0;
            for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
                if (!currBoard[i][j].equals(oppositePiece)) {
                    checkSkipFive = 1;
                }
                if (currBoard[i][j].equals(oppositePiece) && checkSkipFive == 0) {
                    if (checkStopFive == 1) {
                        for (int k = i, l = j; k >= 0 && l >= 0; k--, l--) {
                            if (currBoard[k][l].equals(oppositePiece)) {
                                checkPieceFive = 1;
                                endFlipFive++;
                                continue;
                            }
                            if (currBoard[k][l].equals(".") || currBoard[k][l].equals("_") || ((k == 0 && j == 0) && currBoard[k][l].equals(oppositePiece))) {
                                otherPieceFive = 1;
                                endFlipFive = 0;
                                break;
                            }
                            if (currBoard[k][l].equals(playerPiece) && checkPieceFive == 1 && otherPieceFive != 1) {
                                flipPiecesFive = 1;
                                checkStopFive = 0;
                                break;
                            }
                        }
                    }
                    if (flipPiecesFive == 1 && currBoard[i][j].equals(oppositePiece) && endFlipFive > 0) {
                        if (!Bot.intelligentExecute) {
                            currBoard[i][j] = (playerPiece);
                        }
                        endFlipFive--;
                        intelligentPieces++;
                    }
                    else if (currBoard[i][j].equals(playerPiece)) {
                        break;
                    }
                }
            }

            int checkPieceSix = 0, checkStopSix = 1, otherPieceSix = 0, flipPiecesSix = 0, endFlipSix = 0, checkSkipSix = 0;
            for (int i = r - 1, j = c + 1; i >= 0 && j < col; i--, j++) {
                if (!currBoard[i][j].equals(oppositePiece)) {
                    checkSkipSix = 1;
                }
                if (currBoard[i][j].equals(oppositePiece) && checkSkipSix == 0) {
                    if (checkStopSix == 1) {
                        for (int k = i, l = j; k >= 0 && l < col; k--, l++) {
                            if (currBoard[k][l].equals(oppositePiece)) {
                                checkPieceSix = 1;
                                endFlipSix++;
                                continue;
                            }
                            if (currBoard[k][l].equals(".") || currBoard[k][l].equals("_") || ((k == 0 && j == col - 1) && currBoard[k][l].equals(oppositePiece))) {
                                otherPieceSix = 1;
                                endFlipSix++;
                                break;
                            }
                            if (currBoard[k][l].equals(playerPiece) && checkPieceSix == 1 && otherPieceSix != 1) {
                                flipPiecesSix = 1;
                                checkStopSix = 0;
                                break;
                            }
                        }
                    }
                    if (flipPiecesSix == 1 && currBoard[i][j].equals(oppositePiece) && endFlipSix > 0) {
                        if (!Bot.intelligentExecute) {
                            currBoard[i][j] = (playerPiece);
                        }
                        endFlipSix--;
                        intelligentPieces++;
                        continue;
                    }
                    else if (currBoard[i][j].equals(playerPiece)) {
                        break;
                    }
                }
            }

            int checkPieceSeven = 0, checkStopSeven = 1, otherPieceSeven = 0, flipPiecesSeven = 0, endFlipSeven = 0, checkSkipSeven = 0;
            for (int i = r + 1, j = c + 1; i < row && j < col; i++, j++) {
                if (!currBoard[i][j].equals(oppositePiece)) {
                    checkSkipSeven = 1;
                }
                if (currBoard[i][j].equals(oppositePiece) && checkSkipSeven == 0) {
                    if (checkStopSeven == 1) {
                        for (int k = i, l = j; k < row && l < col; k++, l++) {
                            if (currBoard[k][l].equals(oppositePiece)) {
                                checkPieceSeven = 1;
                                endFlipSeven++;
                                continue;
                            }
                            if (currBoard[k][l].equals(".") || currBoard[k][l].equals("_") || ((k == row - 1 && j == col - 1) && currBoard[k][l].equals(oppositePiece))) {
                                otherPieceSeven = 1;
                                endFlipSeven = 0;
                                break;
                            }
                            if (currBoard[k][l].equals(playerPiece) && checkPieceSeven == 1 && otherPieceSeven != 1) {
                                flipPiecesSeven = 1;
                                checkStopSeven = 0;
                                break;
                            }
                        }
                    }
                    if (flipPiecesSeven == 1 && currBoard[i][j].equals(oppositePiece) && endFlipSeven > 0) {
                        if (!Bot.intelligentExecute) {
                            currBoard[i][j] = (playerPiece);
                        }
                        endFlipSeven--;
                        intelligentPieces++;
                    }
                    else if (currBoard[i][j].equals(playerPiece)) {
                        break;
                    }
                }
            }

            int checkPieceEight = 0, checkStopEight = 1, otherPieceEight = 0, flipPiecesEight = 0, endFlipEight = 0, checkSkipEight = 0;
            for (int i = r + 1, j = c - 1; i < row && j >= 0; i++, j--) {
                if (!currBoard[i][j].equals(oppositePiece)) {
                    checkSkipEight = 1;
                }
                if (currBoard[i][j].equals(oppositePiece) && checkSkipEight == 0) {
                    if (checkStopEight == 1) {
                        for (int k = i, l = j; k < row && l >= 0; k++, l--) {
                            if (currBoard[k][l].equals(oppositePiece)) {
                                checkPieceEight = 1;
                                endFlipEight++;
                                continue;
                            }
                            if (currBoard[k][l].equals(".") || currBoard[k][l].equals("_") || ((k == row - 1 && j == 0) && currBoard[k][l].equals(oppositePiece))) {
                                otherPieceEight = 1;
                                endFlipEight = 0;
                                break;
                            }
                            if (currBoard[k][l].equals(playerPiece) && checkPieceEight == 1 && otherPieceEight != 1) {
                                flipPiecesEight = 1;
                                checkStopEight = 0;
                                break;
                            }
                        }
                    }
                    if (flipPiecesEight == 1 && currBoard[i][j].equals(oppositePiece) && endFlipEight > 0) {
                        if (!Bot.intelligentExecute) {
                            currBoard[i][j] = (playerPiece);
                        }
                        endFlipEight--;
                        intelligentPieces++;
                    }
                    else if (currBoard[i][j].equals(playerPiece)) {
                        break;
                    }
                }
            }

            if (p.getClassName() == "Bot") {
                Bot.botPoints[r][c] = intelligentPieces;
            }

        }

    }

    public boolean[][] getValidMovesFor(Player p) {

        boolean[][] validMoves = new boolean[row][col];

        String oppositePiece, playerPiece;
        if (p.getPieceIdentifier().equals("X")) {
            oppositePiece = "O";
            playerPiece = "X";
        } else {
            oppositePiece = "X";
            playerPiece = "O";
        }

        for (int r = 0; r < row; r++) {

            for (int c = 0; c < col; c++) {

                int locatePiece = 0;
                if (currBoard[r][c].equals(playerPiece)) {
                    locatePiece = 1;
                }

                if (locatePiece == 1) {
                    int didContinue = 1, didFindOppositePiece = 0;
                    for (int i = c + 1; i < col; i++) {
                        if (currBoard[r][i].equals(".") && didFindOppositePiece == 0) {
                            didContinue = 0;
                            break;
                        }
                        if (currBoard[r][i].equals(oppositePiece) && didContinue == 1) {
                            didFindOppositePiece = 1;
                        }
                        else if (!currBoard[r][i].equals(oppositePiece) && !currBoard[r][i].equals(".") && didContinue == 1) {
                            break;
                        }
                        else if (currBoard[r][i].equals(".") && didFindOppositePiece == 1 && didContinue == 1) {
                            currBoard[r][i] = "_";
                            validMoves[r][i] = true;
                            break;
                        }
                    }

                    int didContinueTwo = 1, didFindOppositePieceTwo = 0;
                    for (int i = c - 1; i >= 0; i--) {
                        if (currBoard[r][i].equals(".") && didFindOppositePieceTwo == 0) {
                            didContinueTwo = 0;
                            break;
                        }
                        if (currBoard[r][i].equals(oppositePiece) && didContinueTwo == 1) {
                            didFindOppositePieceTwo = 1;
                        }
                        else if (!currBoard[r][i].equals(oppositePiece) && !currBoard[r][i].equals(".") && didContinueTwo == 1) {
                            break;
                        }
                        else if (currBoard[r][i].equals(".") && didFindOppositePieceTwo == 1 && didContinueTwo == 1) {
                            currBoard[r][i] = "_";
                            validMoves[r][i] = true;
                            break;
                        }
                    }


                    int didContinueThree = 1, didFindOppositePieceThree = 0;
                    for (int i = r + 1; i < row; i++) {
                        if (currBoard[i][c].equals(".") && didFindOppositePieceThree == 0) {
                            didContinueThree = 0;
                            break;
                        }
                        if (currBoard[i][c].equals(oppositePiece) && didContinueThree == 1) {
                            didFindOppositePieceThree = 1;
                        }
                        else if (!currBoard[i][c].equals(oppositePiece) && !currBoard[i][c].equals(".") && didContinueThree == 1) {
                            break;
                        }
                        else if (currBoard[i][c].equals(".") && didFindOppositePieceThree == 1 && didContinueThree == 1) {
                            currBoard[i][c] = "_";
                            validMoves[i][c] = true;
                            break;
                        }
                    }


                    int didContinueFour = 1, didFindOppositePieceFour = 0;
                    for (int i = r - 1; i >= 0; i--) {
                        if (currBoard[i][c].equals(".") && didFindOppositePieceFour == 0) {
                            didContinueFour = 0;
                            break;
                        }
                        if (currBoard[i][c].equals(oppositePiece) && didContinueFour == 1) {
                            didFindOppositePieceFour = 1;
                        }
                        else if (!currBoard[i][c].equals(oppositePiece) && !currBoard[i][c].equals(".") && didContinueFour == 1) {
                            break;
                        }
                        else if (currBoard[i][c].equals(".") && didFindOppositePieceFour == 1 && didContinueFour == 1) {
                            currBoard[i][c] = "_";
                            validMoves[i][c] = true;
                            break;
                        }
                    }


                    int didContinueFive = 1, didFindOppositePieceFive = 0;
                    for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
                        if (currBoard[i][j].equals(".") && didFindOppositePieceFive == 0) {
                            break;
                        }
                        else if (currBoard[i][j].equals(oppositePiece) && didContinueFive == 1) {
                            didFindOppositePieceFive = 1;
                        }
                        else if (!currBoard[i][j].equals(oppositePiece) && !currBoard[i][j].equals(".")) {
                            break;
                        }
                        else if (currBoard[i][j].equals(".") && didFindOppositePieceFive == 1) {
                            currBoard[i][j] = "_";
                            validMoves[i][j] = true;
                            break;
                        }
                    }


                    int didContinueSix = 1, didFindOppositePieceSix = 0;
                    for (int i = r - 1, j = c + 1; i >= 0 && j < col; i--, j++) {
                        if (currBoard[i][j].equals(".") && didFindOppositePieceSix == 0) {
                            didContinueSix = 0;
                            break;
                        }
                        if (currBoard[i][j].equals(oppositePiece) && didContinueSix == 1) {
                            didFindOppositePieceSix = 1;
                        }
                        else if (!currBoard[i][j].equals(oppositePiece) && !currBoard[i][j].equals(".")) {
                            break;
                        }
                        else if (currBoard[i][j].equals(".") && didFindOppositePieceSix == 1) {
                            currBoard[i][j] = "_";
                            validMoves[i][j] = true;
                            break;
                        }
                    }


                    //Checks to the lower right diagonally
                    int didContinueSeven = 1, didFindOppositePieceSeven = 0;
                    for (int i = r + 1, j = c + 1; i < row && j < col; i++, j++) {
                        if (currBoard[i][j].equals(".") && didFindOppositePieceSeven == 0) {
                            didContinueSeven = 0;
                            break;
                        }
                        if (currBoard[i][j].equals(oppositePiece) && didContinueSeven == 1) {
                            didFindOppositePieceSeven = 1;
                        }
                        else if (!currBoard[i][j].equals(oppositePiece) && !currBoard[i][j].equals(".")) {
                            break;
                        }
                        else if (currBoard[i][j].equals(".") && didFindOppositePieceSeven == 1) {
                            currBoard[i][j] = "_";
                            validMoves[i][j] = true;
                            break;
                        }
                    }


                    //Checks to the lower left diagonally
                    int didContinueEight = 1, didFindOppositePieceEight = 0;
                    for (int i = r + 1, j = c - 1; i < row && j >= 0; i++, j--) {
                        if (currBoard[i][j].equals(".") && didFindOppositePieceEight == 0) {
                            didContinueEight = 0;
                            break;
                        }
                        if (currBoard[i][j].equals(oppositePiece) && didContinueEight == 1) {
                            didFindOppositePieceEight = 1;
                        }
                        else if (!currBoard[i][j].equals(oppositePiece) && !currBoard[i][j].equals(".")) {
                            break;
                        }
                        else if (currBoard[i][j].equals(".") && didFindOppositePieceEight == 1) {
                            currBoard[i][j] = "_";
                            validMoves[i][j] = true;
                            break;
                        }
                    }

                }

            }

        }
        return validMoves;
    }
    public void clearUnderscores() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (currBoard[i][j] == "_") {
                    currBoard[i][j] = ".";
                }
            }
        }
    }
    public String[][] getCurrBoard() {
        return this.currBoard;
    }

    public int countNumX() {
        int numX = 0;
        for (int i = 0; i < currBoard.length; i++) {
            for (int j = 0; j < currBoard[i].length; j++) {
                if (currBoard[i][j] == "X") {
                    numX++;
                }
            }
        }
        return numX;
    }

    public int countNumO() {
        int numO = 0;
        for (int i = 0; i < currBoard.length; i++) {
            for (int j = 0; j < currBoard[i].length; j++) {
                if (currBoard[i][j] == "O") {
                    numO++;
                }
            }
        }
        return numO;
    }

    public boolean isFull() {
        return (countNumX() + countNumO()) == currBoard.length * currBoard.length;
    }

    public void showValidMoves(Player player) {
        System.out.println("Your turns:");
        for (int i = 0; i < player.validMoves.length; i++) {
            for (int j = 0; j < player.validMoves[i].length; j++) {
                if (player.validMoves[i][j]) {
                    System.out.print("[" + (i + 1) + " " + (j + 1) + "] ");
                }
            }
        }
        System.out.println();
    }
}
