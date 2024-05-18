package gameController.pieces;

import board.Board;
import board.Position;
import gameController.ChessPiece;
import gameController.Color;

public class King extends ChessPieceMoveMat {
    public King(Board board, Color color) {
        super(board, color, "K", false);
    }

    @Override
    public String toString() {
        return "K";
    }
}
