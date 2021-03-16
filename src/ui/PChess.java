package ui;

import model.*;
import processing.core.PApplet;
import java.util.List;

public class PChess extends PApplet {
    public int size = 100;     // taille d'une case
    List<Piece> pieces = InitializeGame.buildPieces();
    Piece selectedPiece = null;
    boolean isBlackTurn = false;

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
            if (x == p.getX() && y == p.getY() && isBlackTurn == p.isBlack()) {
                selectedPiece = p;
            }
        }
    }

    @Override
    public void mouseReleased() {
        int x = mouseX / size;  // donne la colonne dans laquelle se trouve la souri
        int y = mouseY / size;  // donne la ligne dans laquelle se trouve la souri
        if (selectedPiece != null) {
            for (Piece p : pieces) {
                if (selectedPiece.isBlockedByPiece(p, x, y)) {
                    selectedPiece = null;
                    break;
                }
            }
        }
        if (selectedPiece != null) {
            for (Piece p : pieces) {
                if (p.getX() == x && p.getY() == y) {
                    if (selectedPiece.isBlack() != p.isBlack()) p.setCaptured(true);
                    else selectedPiece = null;
                }
            }
        }
        for (Piece p : pieces) {
            if (p == selectedPiece) {
                p.setPosition(x,y);
                selectedPiece = null;
                isBlackTurn = !isBlackTurn;
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
            if (!p.isCaptured()) {
                drawPiece(p);
            }
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
     * @param piece est une instance de model.Piece
     */
    private void drawPiece(Piece piece) {
        if (!piece.isCaptured()) {
            if (piece != selectedPiece) {
                if (piece.isBlack()) fill(165, 42, 42);
                else fill(244, 226, 198);
                ellipse(size * (piece.getX() + 0.5f), size * (piece.getY() + 0.5f), size * 0.8f, size * 0.8f);
                if (piece.isBlack()) fill(255);
                else fill(0);
                text(piece.getName(), size * piece.getX(), size * (piece.getY() - 0.4f / 7f), size, size);
            } else {
                if (piece.isBlack()) fill(165, 42, 42);
                else fill(244, 226, 198);
                ellipse(mouseX, mouseY, size * 0.8f, size * 0.8f);
                if (piece.isBlack()) fill(255);
                else fill(0);
                text(piece.getName(), mouseX - size / 2f, mouseY - size / 1.8f, size, size);
            }
        }
    }

    public static void main(String[] args) {
        PApplet.runSketch(new String[]{"ui.PChess"}, new PChess());
    }
}