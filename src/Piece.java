public class Piece {
    String name;
    boolean isBlack;
    boolean isCaptured;
    Square square;

    public Piece() {
        square = new Square(this);
    }
}
