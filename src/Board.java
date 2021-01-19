import processing.core.PApplet;

public class Board {
    Square[][] square = new Square[8][8];

    public Board() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                square[i][j] = new Square(i, j);
            }
        }

        for (int i = 0; i < 8; ++i) {
            square[0][i].piece = new Piece(pieceName(i), false, false);
            square[1][i].piece = new Piece("pawn", false, false);
        }

        for (int i = 0; i < 8; ++i) {
            square[7][i].piece = new Piece(pieceName(7-i), true, false);
            square[6][i].piece = new Piece("pawn", true, false);
        }
    }

    public static String pieceName(int i) {
        String[] names = {"rook", "knight", "bishop", "queen", "king", "bishop", "knight", "rook"};
        return names[i];
    }
}
