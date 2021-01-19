public class Square {
    char rank;
    char column;
    Piece piece;

    public Square(int i, int j) {
        this.rank = (char) ('1' + i);
        this.column = (char) ('a' + i);
    }

    public boolean isBlack() {
        return (rank + column) % 2 == 0;
    }
}
