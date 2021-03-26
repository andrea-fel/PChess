package model;

public class Queen extends Piece{
    public Queen(String name, int x, int y, boolean isBlack) {
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
        boolean straightMove = this.x == x ^ this.y == y;
        boolean diagonalMove = Math.abs(this.x - x) == Math.abs(this.y - y) && Math.abs(this.x - x) != 0;
        return straightMove || diagonalMove;
    }

    @Override
    public boolean isBlockedByPiece(Piece piece, int endX, int endY) {
        if (isAllowedMove(endX, endY)) {
            int displacement = Math.max(Math.abs(endX - this.x), Math.abs(endY - this.y));
            int[] intermediateX = new int[displacement - 1];
            int[] intermediateY = new int[displacement - 1];
            calculateIntermediateQueenPositions(endX, endY, intermediateX, intermediateY);
            return isPieceOnIntermediatePositions(piece,intermediateX,intermediateY);
        } else return true;
    }

    public void calculateIntermediateQueenPositions(int endX, int endY, int[] intermediateX, int[] intermediateY) {
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
        } else if ((this.x - endX) == (this.y - endY)) {
            int direction = endX > this.x ? 1 : -1;
            for (int i = 0; i < intermediateX.length; ++i) {
                intermediateX[i] = this.x + (i + 1) * direction;
                intermediateY[i] = this.y + (i + 1) * direction;
            }
        } else {
            int direction = endX > this.x ? 1 : -1;
            for (int i = 0; i < intermediateX.length; ++i) {
                intermediateX[i] = this.x + (i + 1) * direction;
                intermediateY[i] = this.y - (i + 1) * direction;
            }
        }
    }
}
