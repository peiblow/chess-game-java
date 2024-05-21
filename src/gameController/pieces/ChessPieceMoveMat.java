package gameController.pieces;

import board.Board;
import board.Position;
import gameController.ChessPiece;
import gameController.Color;

public abstract class ChessPieceMoveMat extends ChessPiece {
    private boolean[][] mat;
    private final Position p = new Position(0, 0);
    private final Boolean multipleMoves;

    public ChessPieceMoveMat(Board board, Color color, Boolean multipleMoves) {
        super(board, color);

        this.multipleMoves = multipleMoves;
        this.mat = new boolean[board.getRows()][board.getColumns()];
    }

    public boolean[][] getMat() {
        return mat;
    }

    public Position getP() {
        return p;
    }

    public void setMat (boolean[][] mat) {
        this.mat = mat;
    }

    private boolean canMove (Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || isThereOpponentPiece(position);
    }

    public void above() {
        if (!this.multipleMoves) {
            if (getBoard().positionExists(p) && canMove(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
        } else {
            while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                    mat[p.getRow()][p.getColumn()] = true;
                    p.setRow(p.getRow() - 1);
            }

            if (getBoard().positionExists(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
        }
    }
    public void below() {
        if (!this.multipleMoves) {
            if (getBoard().positionExists(p) && canMove(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
        } else {
            while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                if (canMove(p)) {
                    mat[p.getRow()][p.getColumn()] = true;
                    p.setRow(p.getRow() + 1);
                }
            }

            if (getBoard().positionExists(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
        }
    }
    public void left() {
        if (!this.multipleMoves) {
            if (getBoard().positionExists(p) && canMove(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
        } else {
            while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                if (canMove(p)) {
                    mat[p.getRow()][p.getColumn()] = true;
                    p.setColumn(p.getColumn() - 1);
                }
            }

            if (getBoard().positionExists(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
        }
    }
    public void right() {
        if (!this.multipleMoves) {
            if (getBoard().positionExists(p) && canMove(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
        } else {
            while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                if (canMove(p)) {
                    mat[p.getRow()][p.getColumn()] = true;
                    p.setColumn(p.getColumn() + 1);
                }
            }

            if (getBoard().positionExists(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
        }
    }
    public void northWest() {
        if (!this.multipleMoves) {
            if (getBoard().positionExists(p) && canMove(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
        } else {
            while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                if (canMove(p)) {
                    mat[p.getRow()][p.getColumn()] = true;
                    p.setRow(p.getRow() - 1);
                    p.setColumn(p.getColumn() - 1);
                }
            }

            if (getBoard().positionExists(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
        }
    }
    public void northEast() {
        if (!this.multipleMoves) {
            if (getBoard().positionExists(p) && canMove(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
        } else {
            while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                if (canMove(p)) {
                    mat[p.getRow()][p.getColumn()] = true;
                    p.setRow(p.getRow() - 1);
                    p.setColumn(p.getColumn() + 1);
                }
            }

            if (getBoard().positionExists(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
        }
    }
    public void southWest() {
        if (!this.multipleMoves) {
            if (getBoard().positionExists(p) && canMove(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
        } else {
            while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                if (canMove(p)) {
                    mat[p.getRow()][p.getColumn()] = true;
                    p.setRow(p.getRow() + 1);
                    p.setColumn(p.getColumn() - 1);
                }
            }

            if (getBoard().positionExists(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
        }
    }
    public void southEast() {
        if (!this.multipleMoves) {
            if (getBoard().positionExists(p) && canMove(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
        } else {
            while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                if (canMove(p)) {
                    mat[p.getRow()][p.getColumn()] = true;
                    p.setRow(p.getRow() + 1);
                    p.setColumn(p.getColumn() + 1);
                }
            }

            if (getBoard().positionExists(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
        }
    }
}
