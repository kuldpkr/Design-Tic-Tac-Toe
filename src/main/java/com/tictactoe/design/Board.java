package com.tictactoe.design;

public class Board {
    private final Player[][] board;
    private final int size;

    public Board(int size) {
        this.size = size;
        this.board = new Player[size][size];
    }

    public boolean makeMove(Player player, int row, int col) {
        if (row < 0 || row >= size || col < 0 || col >= size || board[row][col] != null) {
            return false;
        }
        board[row][col] = player;
        return true;
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] == null ? "-" : board[i][j].getDisplayName());
                if (j < size - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }

    public Player[][] getBoard() {
        return board;
    }

    public int getSize() {
        return size;
    }
}
