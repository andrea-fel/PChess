import processing.core.PApplet;

import java.util.Arrays;

public class Board {
    Square[][] square = new Square[8][8];

    public Board() {
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                square[x][y] = new Square(x, y);
            }
        }

        for (int x = 0; x < 8; ++x) {
            square[x][0].piece = new Piece(Piece.pieceName(x), false, false);
            square[x][1].piece = new Piece("P", false, false);
        }

        for (int y = 2; y < 6; ++y) {
            for (int x = 0; x < 8; ++x) {
                square[x][y].piece = new Piece("", true, true);
            }
        }

        for (int x = 0; x < 8; ++x) {
            square[x][6].piece = new Piece("P", true, false);
            square[x][7].piece = new Piece(Piece.pieceName(7-x), true, false);
        }
    }
}
