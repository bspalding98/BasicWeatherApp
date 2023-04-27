package com.example.fxapplications.checkers;

import com.example.fxapplications.checkers.constants.PieceType;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

import static com.example.fxapplications.checkers.CheckersApp.TILES_SIZE;   // Importing static, so it's universal in the scope (no need for CheckersApp.TILE_SIZE)

// StackPane because the piece are just two ellipses - THis allows to be stacked on top??
// StackPane: "StackPane lays out its children in a back-to-front stack"
    // 0th child being the bottom and the last child on top. if a border and/or padding have been set. the children will be laid out within those insets.
public class Piece extends StackPane {

    private final PieceType type;

    // Mouse click of current piece to move and destination to move
    private double mouseX, mouseY;
    private double oldX, oldY;

    public Piece(PieceType type, int x, int y) {    // constructor
        this.type = type;

        move(x, y);

        // Background of piece for 3D look
        Ellipse bg = ellipseBuilding(new Ellipse(TILES_SIZE * 0.3125, TILES_SIZE * 0.26)); // background ellipse
        bg.setFill(Color.BLACK);
        bg.setTranslateY((TILES_SIZE - TILES_SIZE * 0.26 * 2) / 2 + TILES_SIZE * 0.07);

        // Top piece
        Ellipse ellipse = ellipseBuilding(new Ellipse(TILES_SIZE * 0.3125, TILES_SIZE * 0.26)); // background ellipse
        ellipse.setFill(type == PieceType.RED ? Color.valueOf("#c40003") : Color.valueOf("#fff9f4"));
        ellipse.setTranslateY((TILES_SIZE - TILES_SIZE * 0.26 * 2) / 2);

        getChildren().addAll(bg, ellipse);

        // When we click the piece we get the x and y coords of the piece/mouse click
        setOnMousePressed(e -> {
            mouseX = e.getSceneX();
            mouseY = e.getSceneY();
        });
        // While dragging we get the new cords/relocate position we want to move it to
        setOnMouseDragged(e -> relocate(e.getSceneX() - mouseX + oldX, e.getSceneY() - mouseY + oldY));
    }

    public Ellipse ellipseBuilding(Ellipse ellipse) {
        ellipse.setStroke(Color.BLACK);
        ellipse.setStrokeWidth(TILES_SIZE * 0.03);
        ellipse.setTranslateX((TILES_SIZE - TILES_SIZE * 0.3125 * 2) /2);
        return ellipse;
    }

    public void move(int x, int y) {
        oldX = x * TILES_SIZE;
        oldY = y * TILES_SIZE;
        relocate(oldX, oldY);
    }

    // If piece cannot perform the move, move back to where it was
    public void abortMove() {
        relocate(oldX, oldY);
    }


    public PieceType getType() {
        return type;
    }

    public double getOldX() {
        return oldX;
    }

    public double getOldY() {
        return oldY;
    }
}
