package model;

public class Rook extends Piece{
    public Rook(String name, int x, int y, boolean isBlack) {
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
        return this.x == x || this.y == y;
    }

    @Override
    public boolean isBlockedByPiece(Piece piece, int endX, int endY) {
        if (isAllowedMove(endX,endY)) {
            int displacement = Math.max(Math.abs(endX - this.x), Math.abs(endY - this.y));
            int[] intermediateX = new int[displacement - 1];
            int[] intermediateY = new int[displacement - 1];
            calculateIntermediateRookPositions(endX, endY, intermediateX, intermediateY);
            return isPieceOnIntermediatePositions(piece, intermediateX, intermediateY);
        }
        else return true;
    }


    public void calculateIntermediateRookPositions(int endX, int endY, int[] intermediateX, int[] intermediateY) {
        if (this.x == endX) {
            int direction = endY > this.y ? 1 : -1;
            for (int i = 0; i < intermediateX.length; ++i) {
                intermediateX[i] = this.x;
                intermediateY[i] = this.y + (i + 1) * direction;
            }
        } else if (this.y == endY) {
            int direction = endX > this.x ? 1 : -1;
            for (int i = 0; i < intermediateX.length; ++i) {
                intermediateX[i] = this.x + (i + 1) * direction;
                intermediateY[i] = this.y;
            }
        }
    }
}
