package ViewModel.Commands;

import Model.Match;
import Model.Trial;
import Model.User;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RemoveTenismenFromMatchButton {
    public void execute(Match match, User user){
        if(match != null && user != null){
            int p1 = 0;
            int p2 = 0;

            if(match.getIdPlayer1() == user.getID()){
                p1 = user.getID();
            }

            if(match.getIdPlayer2() == user.getID()){
                p2 = user.getID();
            }

            if(p1 == p2 && p2 == 0){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Fields");
                alert.setHeaderText("User is not a competitor!");
                alert.showAndWait();
            }else{

                if(p1 != 0){
                    String url = "jdbc:mysql://localhost:3306/tema1";
                    String username = "root";
                    String passwordDB = "sssabb";
                    String sql = "UPDATE matches SET idPlayer1 = NULL WHERE id = " + match.getId();

                    try(Connection conn = DriverManager.getConnection(url, username, passwordDB);
                        PreparedStatement stmt = conn.prepareStatement(sql)) {
                        stmt.executeUpdate();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }else{
                    String url = "jdbc:mysql://localhost:3306/tema1";
                    String username = "root";
                    String passwordDB = "sssabb";
                    String sql = "UPDATE matches SET idPlayer2 = NULL WHERE id = " + match.getId();

                    try(Connection conn = DriverManager.getConnection(url, username, passwordDB);
                        PreparedStatement stmt = conn.prepareStatement(sql)) {
                        stmt.executeUpdate();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
