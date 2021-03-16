package model;

public class King extends Piece{
    public King(String name, int x, int y, boolean isBlack) {
        super(name, x, y, isBlack);
    }

    @Override
    public void setPosition(int x, int y) {
        if(isAllowedMove(x,y)) {
            this.x = x;
            this.y = y;
        }
    }

    @Override
    public boolean isAllowedMove(int x, int y) {
        return Math.abs(this.x - x) <= 1 && Math.abs(this.y - y) <= 1;
    }

    @Override
    public boolean isBlockedByPiece(Piece piece, int endX, int endY) {
        if(isAllowedMove(endX,endY)) return false;
        else return true;
    }
}
