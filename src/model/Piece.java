package model;

public class Piece {
    protected final String name;
    protected int x;
    protected int y;
    protected final boolean isBlack;
    protected boolean isCaptured = false;

    public Piece(String name, int x, int y, boolean isBlack) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.isBlack = isBlack;
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isBlack() {
        return isBlack;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isCaptured() {
        return isCaptured;
    }

    public boolean isAllowedMove(int x, int y){
        return true;
    }

    public boolean isBlockedByPiece(Piece piece, int endX, int endY) {
        return false;
    }

    public boolean IsPieceOnIntermediatePositions(Piece piece, int[] intermediateX, int[] intermediateY) {
        for (int i = 0; i < intermediateX.length; ++i) {
            if (piece.x == intermediateX[i] && piece.y == intermediateY[i]) {
                return true;
            }
        }
        return false;
    }
}
