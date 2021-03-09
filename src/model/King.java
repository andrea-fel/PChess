package model;

public class King extends Piece{
    public King(String name, int x, int y, boolean isBlack) {
        super(name, x, y, isBlack);
    }

    @Override
    public void setPosition(int x, int y) {
        if(Math.abs(this.x - x) <= 1 && Math.abs(this.y - y) <= 1) {
            this.x = x;
            this.y = y;
        }
    }
}
