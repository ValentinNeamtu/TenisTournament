package ViewModel.Commands;

import Model.*;
import javafx.scene.control.Alert;

import java.sql.*;

public class AddRefereeToMatchButton {
    public void execute(Match match, User user){
        if(match != null && user != null) {


            if (user instanceof Tenismen) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Fields");
                alert.setHeaderText("User is not a referee!");
                alert.showAndWait();
            } else {

                Integer idReferee = null;



                String url = "jdbc:mysql://localhost:3306/tema1";
                String username = "root";
                String passwordDB = "sssabb";
                String sql = "Select idReferee FROM matches where id = " + match.getId() ;

                try (Connection conn = DriverManager.getConnection(url, username, passwordDB);
                     PreparedStatement stmt = conn.prepareStatement(sql)) {
                    ResultSet resultSet = stmt.executeQuery();

                    while(resultSet.next()){
                        idReferee = resultSet.getInt("idReferee");
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

                if(idReferee == 0){

                    sql = "UPDATE matches SET idReferee = " + user.getID() + " WHERE id = " + match.getId();

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
