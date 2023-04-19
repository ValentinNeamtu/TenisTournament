package ViewModel.Commands;

import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateNewTrialButton {
    public void execute(String dtpckNewDate, String time, String ageZone){
        String date = dtpckNewDate;

        if(date.equals("") || time.equals("") || ageZone.equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Insert all the required data!");
            alert.showAndWait();
        }else{
            String url = "jdbc:mysql://localhost:3306/tema1";
            String username = "root";
            String passwordDB = "sssabb";
            String sql = "INSERT INTO trials (dateOfTrial, timeOfTrial, ageZone) VALUES ("+
                    "'" + date + "'" + "," + Integer.parseInt(time) + ", " + Integer.parseInt(ageZone) + ");";

            try(Connection conn = DriverManager.getConnection(url, username, passwordDB);
                PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
