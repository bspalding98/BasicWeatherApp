package com.example.fxapplications.checkers;

import com.example.fxapplications.checkers.constants.MoveType;

public class MoveResult {

    private final MoveType type;
    private Piece piece;

    public MoveResult(MoveType type, Piece piece) {  // constructor
        this.type = type;
        this.piece = piece;
    }

    // When we don't have a piece to reference
    // When we move or move one piece normal and don't have a piece to reference ?????
    public MoveResult(MoveType type) {  // constructor 2
        this(type, null);
    }

    public MoveType getType() {
        return type;
    }

    public Piece getPiece() {
        return piece;
    }
}
