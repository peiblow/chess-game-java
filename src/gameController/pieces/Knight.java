package gameController.pieces;

import board.Board;
import board.Position;
import gameController.Color;

public class Knight extends ChessPieceMoveMat{
    public Knight(Board board, Color color) {
        super(board, color, false);
    }

    @Override
    public String toString() {
        return "N";
    }

    @Override
    public boolean[][] possibleMoves() {
        Position p = getP();
        boolean[][] mat = getMat();

        setMat(new boolean[getBoard().getRows()][getBoard().getColumns()]);

        p.setValues(position.getRow() - 1, position.getColumn() - 2);
        above();

        p.setValues(position.getRow() - 2, position.getColumn() - 1);
        below();

        p.setValues(position.getRow() - 2, position.getColumn() + 1);
        left();

        p.setValues(position.getRow() - 1, position.getColumn() + 2);
        right();

        p.setValues(position.getRow() + 1, position.getColumn() + 2);
        northWest();

        p.setValues(position.getRow() + 2, position.getColumn() + 1);
        northEast();

        p.setValues(position.getRow() + 2, position.getColumn() - 1);
        southWest();

        p.setValues(position.getRow() + 1, position.getColumn() - 2);
        southEast();

        return getMat();
    }
}
