package com.example.fxapplications.checkers;

import com.example.fxapplications.checkers.constants.MoveType;
import com.example.fxapplications.checkers.constants.PieceType;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

/***
 * -> Making everything relative to TILE_SIZE, meaning that everything will change size when TILE_SIZE is altered. <-
 */

public class CheckersApp extends Application {

    public static final int TILES_SIZE = 100;
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;

    // Separate tile and pieces group - So pieces can be drawn on top of the tiles
    private final Group tileGroup = new Group();
    private final Group pieceGroup = new Group();

    // 2D array to hold tiles(board positions)
    private final Tile[][] board = new Tile[WIDTH][HEIGHT];

    private Parent createContent() {
        Pane root = new Pane();
        root.setPrefSize(WIDTH * TILES_SIZE, HEIGHT * TILES_SIZE);
        root.getChildren().addAll(tileGroup, pieceGroup);

        for(int y = 0; y < HEIGHT; y++) {
            for(int x = 0; x < WIDTH; x++) {
                Tile tile = new Tile((x + y) % 2 == 0, x, y); // Light colour is always even sum of coordinates
                board[x][y] = tile; // Setting the position on the board
                tileGroup.getChildren().addAll(tile);

                // Checks piece position and assigns a colour corresponding to that, and then adds them to the group
                Piece piece = null;
                if(y<=2 && (x + y) % 2 != 0) {
                    piece = makePiece(PieceType.RED, x, y);
                }
                if(y>=5 && (x + y) % 2 != 0) {
                    piece = makePiece(PieceType.WHITE, x, y);
                }
                if(piece != null) {
                    tile.setPiece(piece);
                    pieceGroup.getChildren().add(piece);
                }
            }
        }
        return root;
    }

    private MoveResult tryMove(Piece piece, int newX, int newY) {

        // So if the place moving to tile that has a piece or the tiles is light.
        if(board[newX][newY].hasPiece() || (newX + newY) % 2 == 0)
            return new MoveResult(MoveType.NONE);

        // Getting old position to check below
        int x0 = toBoard(piece.getOldX());
        int y0 = toBoard(piece.getOldY());

        // checking the difference in tiles to ensure you can only move one
            // Or max of two when skipping
        if((Math.abs(newX - x0) == 1) && (newY - y0 == piece.getType().moveDir)) // 1 place
            return new MoveResult(MoveType.NORMAL);
        else if((Math.abs(newX - x0) == 2) && (newY - y0 == piece.getType().moveDir * 2)) {   // 2 (skipping)

            // position skipping (where enemy should be)
            int x1 = x0 + (newX - x0) / 2;
            int y1 = y0 + (newY - y0) / 2;

            // Checking that there is an enemy piece occupying the tile being skipping
            if((board[x1][y1].hasPiece()) && (board[x1][y1].getPiece().getType() != piece.getType()))
                return new MoveResult(MoveType.KILL, board[x1][y1].getPiece());
        }
        // After everything we cannot move, so can switch turns I'm assuming
        return new MoveResult(MoveType.NONE);
    }

    // Converts from pixel coords to board coordinates
    private int toBoard(double pixel) {
        return (int)(pixel + TILES_SIZE / 2) / TILES_SIZE;  // based off center of tile
    }

//    public void mainMenu() {
////        Pane root = new Pane();
////        root.setPrefSize(WIDTH * TILES_SIZE, HEIGHT * TILES_SIZE);
//
        // Created a button here instead
//        newGameButton.setOnMousePressed(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent mouseEvent) {
//                Parent root = createContent();
//                Stage stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
//                Scene scene = new Scene(root);
//                stage.setScene(scene);
//                stage.show();
//
//            }
//        });
////        root.getChildren().add(newGameButton);
////        return root;
//    }

    @Override
    public void start(Stage primaryStage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mainMenu-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), WIDTH * TILES_SIZE, HEIGHT * TILES_SIZE);
        Scene scene = new Scene(createContent());
        primaryStage.setTitle("Checkers App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // This live updates the boards pieces and the array
    private Piece makePiece(PieceType type, int x, int y) {
        Piece piece = new Piece(type, x, y);

        piece.setOnMouseReleased(e -> {
            // Using layout to adjust final location of translates x and y - Docs of relocate and setTranslate for clarification
            int newX = toBoard(piece.getLayoutX());
            int newY = toBoard(piece.getLayoutY());

            // making result position instance to compare to update piece/s
            MoveResult result = (newX < 0 || newY < 0 || newX >= WIDTH || newY >= HEIGHT)
                    ? new MoveResult(MoveType.NONE) : tryMove(piece, newX, newY);

            // Getting old coords to remove it if needed
            int x0 = toBoard(piece.getOldX());
            int y0 = toBoard(piece.getOldY());

            switch (result.getType()) {
                case NONE -> piece.abortMove();
                case NORMAL -> {
                    piece.move(newX, newY); // Update the UI
                    board[x0][y0].setPiece(null);   // Clearing old piece in 2d array
                    board[newX][newY].setPiece(piece);   // Update the 2d Array to new position
                }
                case KILL -> {
                    piece.move(newX, newY);
                    board[x0][y0].setPiece(null);
                    board[newX][newY].setPiece(piece);
                    Piece otherPiece = result.getPiece();   // This piece being killed
                    board[toBoard(otherPiece.getOldX())][toBoard(otherPiece.getOldY())].setPiece(null); // Removing from array
                    pieceGroup.getChildren().remove(otherPiece);// Removing on UI
                }
            }
        });
        return piece;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
