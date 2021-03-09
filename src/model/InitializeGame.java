package model;

import java.util.ArrayList;
import java.util.List;

public class InitializeGame {
    public static List<Piece> buildPieces() {
        List<Piece> pieces = new ArrayList<>();
        pieces.add(new Rook("T", 0, 0, true));
        pieces.add(new Knight("C", 1, 0, true));
        pieces.add(new Bishop("F", 2, 0, true));
        pieces.add(new Queen("D", 3, 0, true));
        pieces.add(new King("R", 4, 0, true));
        pieces.add(new Bishop("F", 5, 0, true));
        pieces.add(new Knight("C", 6, 0, true));
        pieces.add(new Rook("T", 7, 0, true));
        for (int x = 0; x < 8; ++x) {
            pieces.add(new Pawn("P", x, 1, true));
        }

        for (int x = 0; x < 8; ++x) {
            pieces.add(new Pawn("P", x, 6, false));
        }
        pieces.add(new Rook("T", 0, 7, false));
        pieces.add(new Knight("C", 1, 7, false));
        pieces.add(new Bishop("F", 2, 7, false));
        pieces.add(new Queen("D", 3, 7, false));
        pieces.add(new King("R", 4, 7, false));
        pieces.add(new Bishop("F", 5, 7, false));
        pieces.add(new Knight("C", 6, 7, false));
        pieces.add(new Rook("T", 7, 7, false));
        return pieces;
    }
}
