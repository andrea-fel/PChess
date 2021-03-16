package model;

public class Knight extends Piece{
    public Knight(String name, int x, int y, boolean isBlack) {
        super(name, x, y, isBlack);
    }

    @Override
    public void setPosition(int x, int y) {
        if (isAllowedMove(x,y)) {
            this.x = x;
            this.y = y;
        }
    }

    @Override
    public boolean isAllowedMove(int x, int y) {
        boolean frontMove = Math.abs(this.x - x) == 1 && Math.abs(this.y - y) == 2;
        boolean sideMove = Math.abs(this.x - x) == 2 && Math.abs(this.y - y) == 1;
        return frontMove || sideMove;
    }

    @Override
    public boolean isBlockedByPiece(Piece piece, int endX, int endY) {
        if(isAllowedMove(endX,endY)) return false;
        else return true;
    }
}
