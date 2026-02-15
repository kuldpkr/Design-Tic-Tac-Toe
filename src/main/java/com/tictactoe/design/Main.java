package com.tictactoe.design;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Player currentPlayer = Player.X;
        GameState currentState = GameState.IN_PROGRESS;

        Board board = new Board(3, 3);
        board.printBoard();

        while(currentState == GameState.IN_PROGRESS) {
            System.out.println("Current player is: " + currentPlayer);
            System.out.println("Enter row and column (0-2) for your move:");
            Scanner scanner = new Scanner(System.in);
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            System.out.println("You entered row: " + row + ", col: " + col);

            if(board.checkAndMakeMove(currentPlayer, row, col)){
                board.printBoard();
                currentState = board.getGameState();

                if(currentState == GameState.IN_PROGRESS){
                    currentPlayer = currentPlayer == Player.X ? Player.O : Player.X;
                }
                else {
                    System.out.println("Game Over");
                    if(currentState == GameState.DRAW){
                        System.out.println("Game State: Draw");
                    }
                    else {
                        System.out.println("Game State: " + currentState + " Won");
                    }
                    break;
                }
            }
        }
    }
}
