import gameController.ChessMatch;
import gameController.ChessPiece;
import gameController.ChessPosition;
import gameController.Color;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UI {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static ChessPosition readChessPosition(Scanner scanner) {
        try {
            String s = scanner.nextLine();
            char column = s.charAt(0);
            int row = Integer.parseInt(s.substring(1));

            return new ChessPosition(column, row);
        } catch (RuntimeException e) {
            throw new InputMismatchException("Error reading Chess Position. Valid value are from a1 to h8.");
        }
    }

    public static void printMatch(ChessMatch chessMatch, List<ChessPiece> captured) {
        printBoard(chessMatch.getPieces());

        System.out.println();
        printCapturedPieces(captured);
        System.out.println("Turn: " + chessMatch.getTurn());
        if (!chessMatch.isCheckMate()) {
            System.out.println("Waiting player " + chessMatch.getCurrentPlayer() + " make an move");
            if (chessMatch.isCheck()) {
                System.out.println("CHECK!");
            }
        } else {
            System.out.println("And the winner by CHECKMATE is.....");
            System.out.println(chessMatch.getCurrentPlayer());
        }
    }

    public static void printBoard(ChessPiece[][] pieces) {
        for (int i = 0; i < pieces.length; i++) {
            System.out.print((8-i) + " ");
            for (int j = 0; j < pieces.length; j++) {
                printPiece(pieces[i][j], false);
            }
            System.out.println();
        }

        System.out.println("  a b c d e f g h");
    }

    public static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves) {
        for (int i = 0; i < pieces.length; i++) {
            System.out.print((8-i) + " ");
            for (int j = 0; j < pieces.length; j++) {
                printPiece(pieces[i][j], possibleMoves[i][j]);
            }
            System.out.println();
        }

        System.out.println("  a b c d e f g h");
    }

    private static void printPiece(ChessPiece chessPiece, boolean background) {
        if (background) {
            System.out.print(ANSI_BLUE_BACKGROUND);
        }

        if (chessPiece == null) {
            System.out.print("-" + ANSI_RESET);
        } else {
            if(chessPiece.getColor() == Color.WHITE) {
                System.out.print(ANSI_WHITE + chessPiece + ANSI_RESET);
            } else {
                System.out.print(ANSI_YELLOW + chessPiece + ANSI_RESET);
            }
        }

        System.out.print(" ");
    }

    private static void printCapturedPieces(List<ChessPiece> captured) {
        List<ChessPiece> whitePiecesCaptured = captured.stream().filter(x -> x.getColor() == Color.WHITE).toList();
        List<ChessPiece> blackPiecesCaptured = captured.stream().filter(x -> x.getColor() == Color.BLACK).toList();

        System.out.println("Captured Pieces: ");
        System.out.print(" - White: ");
        System.out.print(ANSI_WHITE);
        System.out.println(Arrays.toString(whitePiecesCaptured.toArray()));
        System.out.print(ANSI_RESET);

        System.out.print(" - Black: ");
        System.out.print(ANSI_YELLOW);
        System.out.println(Arrays.toString(blackPiecesCaptured.toArray()));
        System.out.print(ANSI_RESET);
    }
}
