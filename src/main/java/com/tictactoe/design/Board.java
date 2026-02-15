package com.tictactoe.design;

public class Board {
    private Player[][] board;

    public Board(int rows, int cols) {
        this.board = new Player[rows][cols];
    }

    public boolean checkAndMakeMove(Player player, int row, int col){
        if(checkValidCell(row, col)){
            if(board[row][col] == null){
                board[row][col] = player;
                return true;
            }
            else {
                System.out.println("Cell already Occupied. Please try again!");
                return false;
            }
        }
        else {
            System.out.println("Provided cell is out of bounds of the board " + row + " " + col + " Please try again!");
            return false;
        }
    }

    public void printBoard() {
        for (Player[] players : board) {
            for (int j = 0;j < players.length;j++) {
                System.out.print(players[j] == null ? "-" : players[j]);
                if (j < players.length - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }

    public boolean checkValidCell(int row, int col){
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
    }

    public GameState getGameState() {
        // Check horizontally
        for (Player[] players : board) {
            if (players[0] == null)
                return GameState.IN_PROGRESS;

            if (players[0] == players[1] && players[1] == players[2]) {
                return players[0] == Player.X ? GameState.X : GameState.O;
            }
        }

        // Check vertically
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == null)
                return GameState.IN_PROGRESS;

            if (board[0][i] == board[1][i] && board[1][i] == board[2][i]){
                return board[0][i] == Player.X ? GameState.X : GameState.O;
            }
        }

        // Check diagonally
        for(int i = 0; i < board.length; i++){
            if(board[i][i] == null)
                return GameState.IN_PROGRESS;
        }

        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]){
            return board[0][0] == Player.X ? GameState.X : GameState.O;
        }

        for(int i = 0; i < board.length; i++){
            if(board[i][board.length - 1 - i] == null)
                return GameState.IN_PROGRESS;
        }

        if (board[0][board.length - 1] == board[1][board.length - 2] && board[1][board.length - 2] == board[2][board.length - 3]){
            return board[0][board.length - 1] == Player.X ? GameState.X : GameState.O;
        }

        return GameState.DRAW;
    }
}
