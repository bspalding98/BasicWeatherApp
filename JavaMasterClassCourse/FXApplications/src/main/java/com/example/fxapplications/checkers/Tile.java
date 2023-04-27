package com.example.fxapplications.checkers;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle {

    private Piece piece;

    public Tile(boolean light, int x, int y) {  // constructor
        setWidth(CheckersApp.TILES_SIZE);
        setHeight(CheckersApp.TILES_SIZE);

        // Same as translate in this case - Think it means it moves in this set distance
        relocate(x * CheckersApp.TILES_SIZE, y * CheckersApp.TILES_SIZE);

        setFill(light ? Color.valueOf("#feb") : Color.valueOf("582"));  // Can run single line ifs in any method
    }


    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public boolean hasPiece() { // Checks if it has a piece
        return piece != null;
    }

}
