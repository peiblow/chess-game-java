package gameController.pieces;

import board.Board;
import gameController.ChessPiece;
import gameController.Color;

public class King extends ChessPiece {
    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";
    }
}
