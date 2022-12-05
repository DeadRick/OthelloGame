package org.example;

public abstract class Player {

    protected boolean[][] validMoves;
    private boolean didForfeitTurn = false;
    private String pieceIdentifier = "";
    private String className = "";

    public abstract void chooseMove(ReversiBoard board);

    public abstract boolean hasValidMoveLeft();

    public boolean[][] getValidMovesArray() {
        return this.validMoves;
    }

    public void setValidMovesArray(boolean[][] moves) {
        this.validMoves = moves;
    }

    public boolean getDidForfeitTurn() {
        return this.didForfeitTurn;
    }

    public void setDidForfeitTurn(boolean value) {
        this.didForfeitTurn = value;
    }

    public String getPieceIdentifier() {
        return this.pieceIdentifier;
    }
    public void setPieceIdentifier(String id) {
        if(id.equals("X") || id.equals("O")) {
            this.pieceIdentifier = id;
        }
    }
    public String getClassName() {
        return this.className;
    }

    public void setClassName(String name) {
        this.className = name;
    }


}
