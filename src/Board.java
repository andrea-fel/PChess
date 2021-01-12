import processing.core.PApplet;

public class Board extends PApplet{

    public static void main(String[] args) {
        PApplet.runSketch(new String[]{"Board"}, new Board());
    }

    int square = 50;

    @Override
    public void settings() {
        size(400, 400);
    }

    @Override
    public void setup() {
        drawChess();
    }

    @Override
    public void draw() {
    }

    void drawChess() {
        int beige = color(244, 226, 198);
        int brown = color(101, 67, 33);
        for(int y = 0; y < 8; ++y) {
            for(int x = 0; x < 8; ++x) {
                int col = ((x + y) % 2 == 0) ? beige : brown;
                fill(col);
                stroke(col);
                rect(x*square, y*square, square, square);
            }
        }
    }
}
