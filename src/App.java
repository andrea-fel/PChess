import dao.DaoChess;
import model.InitializeGame;
import model.Piece;
import processing.core.PApplet;
import ui.PChess;

import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Piece> pieces;
        if (args.length == 0) {
            InitializeGame initializeGame = new InitializeGame();
            pieces = initializeGame.buildPieces();
        } else {
            DaoChess daoChess = new DaoChess();
            pieces = daoChess.fetch();
        }

        PApplet.runSketch(new String[]{"ui.PChess"}, new PChess(pieces));
    }
}
