package com.example.fxapplications.checkers.constants;

public enum PieceType {
    // This is situated that red is on top and white is below (very easy to change for horizontal boards, etc.)
    RED(1),
    WHITE(-1);

    public final int moveDir;  // Which direction they move

    PieceType(int moveDir) {    // built in constructor for ENUM
        this.moveDir = moveDir;
    }
}
