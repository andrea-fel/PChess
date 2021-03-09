package model;

public class Pawn extends Piece {

    public Pawn(String name, int x, int y, boolean isBlack) {
        super(name, x, y, isBlack);
    }

    @Override
    public void setPosition(int x, int y) {
        int move1 = isBlack ? 1 : -1;
        int move2 = isBlack ? 2 : -2;
        int checkInitial = isBlack ? 1 : 6;
        boolean firstMove = this.y == checkInitial && this.x == x && this.y + move2 == y;
        boolean otherMove = this.x == x && this.y + move1 == y;
        if (firstMove || otherMove) {
            this.y = y;
        }

    }
}
