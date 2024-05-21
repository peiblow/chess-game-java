package gameController.pieces;

import board.Board;
import board.Position;
import gameController.ChessPiece;
import gameController.Color;

public class Bishop extends ChessPieceMoveMat {
    public Bishop(Board board, Color color) {
        super(board, color, true);
    }

    @Override
    public String toString() {
        return "B";
    }

    @Override
    public boolean[][] possibleMoves() {
        Position p = getP();
        boolean[][] mat = getMat();

        setMat(new boolean[getBoard().getRows()][getBoard().getColumns()]);

        p.setValues(position.getRow() - 1, position.getColumn() - 1);
        northWest();

        p.setValues(position.getRow() - 1, position.getColumn() + 1);
        northEast();

        p.setValues(position.getRow() + 1, position.getColumn() - 1);
        southWest();

        p.setValues(position.getRow() + 1, position.getColumn() + 1);
        southEast();

        return getMat();
    }
}
