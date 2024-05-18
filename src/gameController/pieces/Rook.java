package gameController.pieces;

import board.Board;
import board.Position;
import gameController.ChessPiece;
import gameController.Color;

public class Rook extends ChessPieceMoveMat {
    public Rook(Board board, Color color) {
        super(board, color, "R", true);
    }

    @Override
    public String toString() {
        return "R";
    }
}
