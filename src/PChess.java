import processing.core.PApplet;
import java.util.ArrayList;
import java.util.List;

public class PChess extends PApplet {
    public int size = 100;     // taille d'une case
    List<Piece> pieces = buildPieces();
    Piece selectedPiece = null;

    private List<Piece> buildPieces() {
        List<Piece> pieces = new ArrayList<>();
        String[] names = {"T", "C", "F", "D", "R", "F", "C", "T"};
        for (int x = 0; x < 8; ++x) {
            pieces.add(new Piece(names[x], x, 0, true));
        }
        for (int x = 0; x < 8; ++x) {
            pieces.add(new Piece("P", x, 1, true));
        }
        for (int x = 0; x < 8; ++x) {
            pieces.add(new Piece("P", x, 6, false));
        }
        for (int x = 0; x < 8; ++x) {
            pieces.add(new Piece(names[x], x, 7, false));
        }
        return pieces;
    }

    @Override
    public void settings() {
        size(8 * size, 8 * size);
    }

    @Override
    public void draw() {
        drawCases();
        drawPieces();
    }

    @Override
    public void mousePressed() {
        int x = mouseX / size;  // donne la colonne dans laquelle se trouve la souri
        int y = mouseY / size;  // donne la ligne dans laquelle se trouve la souri
        for (Piece p : pieces) {
            if (x == p.x && y == p.y) {
                selectedPiece = p;
            }
        }
    }

    @Override
    public void mouseReleased() {
        int x = mouseX / size;  // donne la colonne dans laquelle se trouve la souri
        int y = mouseY / size;  // donne la ligne dans laquelle se trouve la souri
        for (Piece p : pieces) {
            if (p == selectedPiece) {
                p.x = x;
                p.y = y;
                selectedPiece = null;
                break;
            }
        }
    }

    /**
     * dessine les pièces
     */
    private void drawPieces() {
        textAlign(CENTER, CENTER);
        textSize(size * 0.4f);
        noStroke();
        for (Piece p : pieces) {
            drawPiece(p);
        }
    }

    /**
     * dessine les cases
     */
    private void drawCases() {
        stroke(255);
        for (int x = 0; x < 8; ++x) {
            for (int y = 0; y < 8; ++y) {
                if ((x + y) % 2 == 0) fill(255);
                else fill(0);
                rect(x * size, y * size, size, size);
            }
        }
    }

    /**
     * dessine une pièce
     *
     * @param piece est une instance de Piece
     */
    private void drawPiece(Piece piece) {
        if (piece != selectedPiece) {
            if (piece.isBlack) fill(165, 42, 42);
            else fill(244, 226, 198);
            ellipse(size * (piece.x + 0.5f), size * (piece.y + 0.5f), size * 0.8f, size * 0.8f);
            if (piece.isBlack) fill(255);
            else fill(0);
            text(piece.name, size * piece.x, size * (piece.y - 0.4f / 7f), size, size);
        } else {
            if (piece.isBlack) fill(165, 42, 42);
            else fill(244, 226, 198);
            ellipse(mouseX, mouseY, size * 0.8f, size * 0.8f);
            if (piece.isBlack) fill(255);
            else fill(0);
            text(piece.name, mouseX - size / 2f, mouseY - size / 1.8f, size, size);
        }
    }

    public static void main(String[] args) {
        PApplet.runSketch(new String[]{"PChess"}, new PChess());
    }
}