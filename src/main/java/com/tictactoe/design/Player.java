package com.tictactoe.design;

public enum Player {
    X("X"),
    O("O");

    private final String displayName;

    Player(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
