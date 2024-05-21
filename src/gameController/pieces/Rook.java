package gameController.pieces;

import board.Board;
import board.Position;
import gameController.ChessPiece;
import gameController.Color;

public class Rook extends ChessPieceMoveMat {
    public Rook(Board board, Color color) {
        super(board, color, true);
    }

    @Override
    public String toString() {
        return "R";
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

        return getMat();
    }
}
