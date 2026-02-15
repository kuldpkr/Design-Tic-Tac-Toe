package com.tictactoe.design;

public enum Player {
    X("Player 1"),
    O("Player 2");

    private final String displayName;

    Player(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
