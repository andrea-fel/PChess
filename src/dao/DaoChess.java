package dao;

import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoChess {
    public List<Piece> fetch() {
        List<Piece> pieces = new ArrayList<>();
        Statement statement;
        try (Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost/demo", "chess", "chess")) {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT name, x, y, isBlack, isCaptured FROM piece ORDER BY y, x");
            while(resultSet.next()) {
                String name = resultSet.getString("name");
                int x = resultSet.getInt("x");
                int y = resultSet.getInt("y");
                boolean isBlack = resultSet.getBoolean("isBlack");
                boolean isCaptured = resultSet.getBoolean("isCaptured");
                switch(name) {
                    case "Pion":
                        pieces.add(new Pawn(name, x, y, isBlack));
                        break;
                    case "Tour":
                        pieces.add(new Rook(name, x, y, isBlack));
                        break;
                    case "Cheval":
                        pieces.add(new Knight(name, x, y, isBlack));
                        break;
                    case "Fou":
                        pieces.add(new Bishop(name, x, y, isBlack));
                        break;
                    case "Roi":
                        pieces.add(new King(name, x, y, isBlack));
                        break;
                    case "Dame":
                        pieces.add(new Queen(name, x, y, isBlack));
                        break;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return pieces;
    }
}
