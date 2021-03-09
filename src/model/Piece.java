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
}
