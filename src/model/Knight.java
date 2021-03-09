package model;

public class Knight extends Piece{
    public Knight(String name, int x, int y, boolean isBlack) {
        super(name, x, y, isBlack);
    }

    @Override
    public void setPosition(int x, int y) {
        boolean frontMove = Math.abs(this.x - x) == 1 && Math.abs(this.y - y) == 2;
        boolean sideMove = Math.abs(this.x - x) == 2 && Math.abs(this.y - y) == 1;
        if (frontMove || sideMove) {
            this.x = x;
            this.y = y;
        }
    }
}