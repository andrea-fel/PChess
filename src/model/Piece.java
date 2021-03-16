package model;

public abstract class Piece {
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

    public boolean isCaptured() {
        return isCaptured;
    }

    public void setCaptured(boolean captured) {
        isCaptured = captured;
    }

    public abstract void setPosition(int x, int y);

    public abstract boolean isAllowedMove(int x, int y);

    public abstract boolean isBlockedByPiece(Piece piece, int endX, int endY);

    public boolean isPieceOnIntermediatePositions(Piece piece, int[] intermediateX, int[] intermediateY) {
        for (int i = 0; i < intermediateX.length; ++i) {
            if (piece.x == intermediateX[i] && piece.y == intermediateY[i]) {
                return true;
            }
        }
        return false;
    }
}
