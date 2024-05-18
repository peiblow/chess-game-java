package gameController.pieces;

import board.Board;
import board.Position;
import gameController.ChessPiece;
import gameController.Color;

import java.util.*;

public class ChessPieceMoveMat extends ChessPiece {
    public boolean[][] mat;
    private final Position p = new Position(0, 0);
    private final String pieceKey;
    private final Boolean multipleMoves;

    private final HashMap<String, List<String>> chessPieceDirections = new HashMap<>();
    private final HashMap<String, DirectionalMove> directionMoveMap = new HashMap<>();

    public ChessPieceMoveMat(Board board, Color color, String pieceKey, Boolean multipleMoves) {
        super(board, color);

        this.pieceKey = pieceKey;
        this.multipleMoves = multipleMoves;

        this.mat = new boolean[board.getRows()][board.getColumns()];
        chessPieceDirections.put("R", Arrays.asList("A", "B", "L", "R"));
        chessPieceDirections.put("K", Arrays.asList("A", "B", "L", "R", "NW", "NE", "SW", "SE"));

        // Directions and respectives methods
        directionMoveMap.put("A", this::above);
        directionMoveMap.put("B", this::below);
        directionMoveMap.put("L", this::left);
        directionMoveMap.put("R", this::right);
        directionMoveMap.put("NW", this::northWest);
        directionMoveMap.put("NE", this::northEast);
        directionMoveMap.put("SW", this::southWest);
        directionMoveMap.put("SE", this::southEast);
    }

    private boolean canMove (Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || isThereOppenentPiece(position);
    }

    public void above() {
        p.setValues(position.getRow() - 1, position.getColumn());
        if (!this.multipleMoves) {
            if (getBoard().positionExists(p) && canMove(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
        } else {
            while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                    mat[p.getRow()][p.getColumn()] = true;
                    p.setRow(p.getRow() - 1);
            }

            if (getBoard().positionExists(p) && isThereOppenentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
        }
    }
    public void below() {
        p.setValues(position.getRow() + 1, position.getColumn());
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
        }
    }
    public void left() {
        p.setValues(position.getRow(), position.getColumn() - 1);
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
        }
    }
    public void right() {
        p.setValues(position.getRow(), position.getColumn() + 1);
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
        }
    }
    public void northWest() {
        p.setValues(position.getRow() - 1, position.getColumn() - 1);
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
        }
    }
    public void northEast() {
        p.setValues(position.getRow() - 1, position.getColumn() + 1);
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
        }
    }
    public void southWest() {
        p.setValues(position.getRow() + 1, position.getColumn() - 1);

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
        }
    }
    public void southEast() {
        p.setValues(position.getRow() + 1, position.getColumn() + 1);
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
        }
    }

    @Override
    public boolean[][] possibleMoves() {
        List<String> auxPieceKey = List.of("R");
        for (String direction : chessPieceDirections.get(pieceKey)) {
            DirectionalMove directionMove = directionMoveMap.get(direction);
            if (directionMove != null) {
                directionMove.move();
            }
        }
        return mat;
    }
}
