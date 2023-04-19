package ViewModel.Commands;

import Model.Match;
import Model.Trial;
import Model.User;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RemoveRefereeFromMatchButton {
    public void execute(Match match, User user){
        if(match != null && user != null){

            if(user.getID() != match.getIdReferee()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Fields");
                alert.setHeaderText("User is not a Referee!");
                alert.showAndWait();
            }else{
                String url = "jdbc:mysql://localhost:3306/tema1";
                String username = "root";
                String passwordDB = "sssabb";
                String sql = "UPDATE matches SET idReferee = NULL WHERE id = " + match.getId();

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
