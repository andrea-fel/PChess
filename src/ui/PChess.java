package ui;

import model.*;
import processing.core.PApplet;

import java.util.List;

public class PChess extends PApplet {
    public int size = 100;     // taille d'une case
    List<Piece> pieces;
    Piece selectedPiece = null;
    boolean isBlackTurn = false;
    boolean write = false;

    public PChess(List<Piece> pieces) {
        this.pieces = pieces;
    }

    @Override
    public void settings() {
        size(8 * size, 8 * size + 50);
    }

    @Override
    public void draw() {
        drawCases();
        drawPieces();
        drawInfoBar(write);
    }

    @Override
    public void mousePressed() {
        int x = mouseX / size;  // donne la colonne dans laquelle se trouve la souri
        int y = mouseY / size;  // donne la ligne dans laquelle se trouve la souri
        write = false;
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
        checkIfSelectedPieceIsBlocked(x, y);
        checkIfSelectedPieceTakesPiece(x, y);
        moveSelectedPiece(x, y);
    }

    public void moveSelectedPiece(int x, int y) {
        for (Piece p : pieces) {
                if (p == selectedPiece) {
                    p.setPosition(x, y);
                    selectedPiece = null;
                    isBlackTurn = !isBlackTurn;
                    break;
                }
            }
    }

    public void checkIfSelectedPieceTakesPiece(int x, int y) {
        try {
            if (selectedPiece.getName().equals("P") && Math.abs(selectedPiece.getX() - x) == 1) {
                int counter = 0;
                for (Piece p : pieces) {
                    if (p.getX() == x && p.getY() == y && !p.isCaptured()) {
                        if (selectedPiece.isBlack() != p.isBlack()) p.setCaptured(true);
                        else selectedPiece = null;
                        break;
                    }
                    counter++;
                }
                if (counter == pieces.size()) selectedPiece = null;
            } else {
                for (Piece p : pieces) {
                    if (p.getX() == x && p.getY() == y && !p.isCaptured()) {
                        if (selectedPiece.isBlack() != p.isBlack()) p.setCaptured(true);
                        else selectedPiece = null;
                    }
                }
            }
        } catch(NullPointerException ex) {
            write = true;
        }
    }

    public void checkIfSelectedPieceIsBlocked(int x, int y) {
        try {
            for (Piece p : pieces) {
                if (selectedPiece.isBlockedByPiece(p, x, y) && !p.isCaptured()) {
                    selectedPiece = null;
                    break;
                }
            }
        } catch(NullPointerException ex) {
            write = true;
        }
    }

    private void drawInfoBar(boolean condition) {
        if (condition) {
            textSize(32);
            text("Move not allowed", 180, 820);
        }
        else {
            fill(100);
            rect(0, 8 * size, 8 * size, 50);
        }
    }


    /**
         * dessine les pièces
         */
        private void drawPieces () {
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
        private void drawCases () {
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
        private void drawPiece (Piece piece){
            textSize(20);
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
    }