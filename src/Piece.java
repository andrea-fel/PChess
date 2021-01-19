public class Piece {
    String name;
    boolean isBlack;
    boolean isCaptured;
//    Square square;
//
//    public Piece() {
//        square = new Square(this);
//    }

    public Piece(String name, boolean isBlack, boolean isCaptured) {
        this.name = name;
        this.isBlack = isBlack;
        this.isCaptured = isCaptured;
    }
}
