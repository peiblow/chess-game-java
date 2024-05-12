package gameController.pieces;

import board.Board;
import gameController.ChessPiece;
import gameController.Color;

public class Rook extends ChessPiece {

    public Rook(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "R";
    }
}
