package model;

public class Pawn extends Piece {

    public Pawn(String name, int x, int y, boolean isBlack) {
        super(name, x, y, isBlack);
    }

    @Override
    public void setPosition(int x, int y) {
        if (isAllowedMove(x, y)) {
            this.x = x;
            this.y = y;
        }
    }

    @Override
    public boolean isAllowedMove(int endX, int endY) {
        int move1 = isBlack ? 1 : -1;
        int move2 = isBlack ? 2 : -2;
        int initialPosition = isBlack ? 1 : 6;
        boolean firstMove = this.y == initialPosition && this.x == endX && this.y + move2 == endY;
        boolean otherMove = this.x == endX && this.y + move1 == endY;
        boolean captureMove = Math.abs(endX - this.x) == 1 && this.y + move1 == endY;
        return firstMove || otherMove || captureMove;
    }

    @Override
    public boolean isBlockedByPiece(Piece piece, int endX, int endY) {
        if (isAllowedMove(endX, endY)) {
            int displacement = Math.abs(endY - this.y);
            int[] intermediateX = new int[displacement];
            int[] intermediateY = new int[displacement];
            calculateIntermediatePawnPositions(endX, endY, intermediateX, intermediateY);
            return isPieceOnIntermediatePositions(piece, intermediateX, intermediateY);
        } else return true;
    }

    public void calculateIntermediatePawnPositions(int endX, int endY, int[] intermediateX, int[] intermediateY) {
        if (endX == this.x) {
            int direction = endY > this.y ? 1 : -1;
            for (int i = 0; i < intermediateX.length; ++i) {
                intermediateX[i] = this.x;
                intermediateY[i] = this.y + (i + 1) * direction;
            }
        } else if (Math.abs(endX - this.x) == 1) {
            intermediateX[0] = -1;
            intermediateY[0] = -1;
        }
    }
}
