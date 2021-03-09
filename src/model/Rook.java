package model;

public class Rook extends Piece{
    public Rook(String name, int x, int y, boolean isBlack) {
        super(name, x, y, isBlack);
    }

    @Override
    public void setPosition(int x, int y) {
        if (this.x == x || this.y == y) {
            this.x = x;
            this.y = y;
        }
    }
}
