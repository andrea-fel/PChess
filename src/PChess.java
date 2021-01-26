import processing.core.PApplet;

public class PChess extends PApplet{
    Board board = new Board();

    int sqSize = 50;

    @Override
    public void settings() {
        size(sqSize * 8, sqSize * 8);
    }

    @Override
    public void setup() {
        drawBoard();
    }

    @Override
    public void draw() {
    }

    private void drawBoard() {
        for(int y = 0; y < 8; ++y) {
            for(int x = 0; x < 8; ++x) {
                drawSquare(board.square[x][y]);
                drawPiece(x, y, board.square[x][y].piece);
            }
        }
    }

    private void drawPiece(int x, int y, Piece piece) {
        if (!piece.isCaptured) {
            int col = piece.isBlack ? 0 : 255;
            fill(col);
            ellipse((x + 0.5f) * sqSize, (y + 0.5f) * sqSize, sqSize * 0.7f, sqSize * 0.7f);
            textSize(sqSize * 0.5f);
            textAlign(CENTER, CENTER);
            col = piece.isBlack ? 255 : 0;
            fill(col);
            text(piece.name, (x + 0.5f) * sqSize, (y + 0.5f) * sqSize);
        }
    }

    private void drawSquare(Square square) {
        int beige = color(244, 226, 198);
        int brown = color(101, 67, 33);
        int col = square.isBlack() ? beige : brown;
        fill(col);
        stroke(col);
        rect((square.rank - '1') * sqSize, (square.column - 'a') * sqSize, sqSize, sqSize);
    }

    public static void main(String[] args) {
        PApplet.runSketch(new String[]{"PChess"}, new PChess());
    }
}
