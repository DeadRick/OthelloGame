package org.example;

public interface Board {
    public void printBoard();
    public void updateBoard(int row, int column, Player player);
    public boolean isFull();
}


