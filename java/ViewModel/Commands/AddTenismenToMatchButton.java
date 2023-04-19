package ViewModel.Commands;

import Model.Match;
import Model.Referee;
import Model.Trial;
import Model.User;
import javafx.scene.control.Alert;

import java.sql.*;

public class AddTenismenToMatchButton {
    public void execute(Match match, User user){
        if(match != null && user != null) {


            if (user instanceof Referee) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Fields");
                alert.setHeaderText("User is not a competitor!");
                alert.showAndWait();
            } else {

                Integer idPlayer1 = null;
                Integer idPlayer2 = null;


                String url = "jdbc:mysql://localhost:3306/tema1";
                String username = "root";
                String passwordDB = "sssabb";
                String sql = "Select idPlayer1, idPlayer2 FROM matches where id = " + match.getId() ;

                try (Connection conn = DriverManager.getConnection(url, username, passwordDB);
                     PreparedStatement stmt = conn.prepareStatement(sql)) {
                    ResultSet resultSet = stmt.executeQuery();

                    while(resultSet.next()){
                        idPlayer1 = resultSet.getInt("idPlayer1");
                        idPlayer2 = resultSet.getInt("idPlayer2");
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

                if(idPlayer1 == 0){

                    sql = "UPDATE matches SET idPlayer1 = " + user.getID() + " WHERE id = " + match.getId();

                    try (Connection conn = DriverManager.getConnection(url, username, passwordDB);
                         PreparedStatement stmt = conn.prepareStatement(sql)) {
                         stmt.executeUpdate();

                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }

                }else if(idPlayer2 == 0){
                    sql = "UPDATE matches SET idPlayer2 = " + user.getID() + " WHERE id = " + match.getId();

                    try (Connection conn = DriverManager.getConnection(url, username, passwordDB);
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
