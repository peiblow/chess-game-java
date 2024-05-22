package gameController.pieces;

import board.Board;
import board.Position;
import gameController.Color;

public class Queen extends ChessPieceMoveMat {
    public Queen(Board board, Color color) {
        super(board, color, true);
    }

    @Override
    public String toString() {
        return "Q";
    }

    @Override
    public boolean[][] possibleMoves() {
        Position p = getP();
        boolean[][] mat = getMat();

        setMat(new boolean[getBoard().getRows()][getBoard().getColumns()]);

        p.setValues(position.getRow() - 1, position.getColumn());
        above();

        p.setValues(position.getRow() + 1, position.getColumn());
        below();

        p.setValues(position.getRow(), position.getColumn() - 1);
        left();

        p.setValues(position.getRow(), position.getColumn() + 1);
        right();

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
