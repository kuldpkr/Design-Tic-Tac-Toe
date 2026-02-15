package com.tictactoe.design;

import java.util.Scanner;

public class Game {
    private final Board board;
    private Player currentPlayer;
    private GameState gameState;
    private int moves;

    public Game(int size) {
        this.board = new Board(size);
        this.currentPlayer = Player.X;
        this.gameState = GameState.IN_PROGRESS;
        this.moves = 0;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (gameState == GameState.IN_PROGRESS) {
            board.printBoard();
            System.out.println("Player " + currentPlayer.getDisplayName() + "'s turn.");
            System.out.print("Enter row and column: ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (board.makeMove(currentPlayer, row, col)) {
                moves++;
                if (checkWin(row, col)) {
                    gameState = GameState.WIN;
                    board.printBoard();
                    System.out.println("Player " + currentPlayer.getDisplayName() + " wins!");
                } else if (moves == board.getSize() * board.getSize()) {
                    gameState = GameState.DRAW;
                    board.printBoard();
                    System.out.println("It's a draw!");
                } else {
                    currentPlayer = (currentPlayer == Player.X) ? Player.O : Player.X;
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
        scanner.close();
    }

    private boolean checkWin(int row, int col) {
        int size = board.getSize();
        Player[][] currentBoard = board.getBoard();
        Player player = currentBoard[row][col]; // Current player made this move at row,col

        // Check row
        boolean win = true;
        for (int i = 0; i < size; i++) {
            if (currentBoard[row][i] != player) {
                win = false;
                break;
            }
        }
        if (win) return true;

        // Check column
        win = true;
        for (int i = 0; i < size; i++) {
            if (currentBoard[i][col] != player) {
                win = false;
                break;
            }
        }
        if (win) return true;

        // Check diagonal
        if (row == col) {
            win = true;
            for (int i = 0; i < size; i++) {
                if (currentBoard[i][i] != player) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }

        // Check anti-diagonal
        if (row + col == size - 1) {
            win = true;
            for (int i = 0; i < size; i++) {
                if (currentBoard[i][size - 1 - i] != player) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }

        return false;
    }
}
