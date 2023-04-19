package ViewModel.Commands;

import Model.Request;
import Model.Trial;
import Model.User;
import javafx.scene.control.Alert;
import javafx.scene.control.ToggleGroup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RejectRequest {
    public void execute(Request request){
        if(request != null ){
                String url = "jdbc:mysql://localhost:3306/tema1";
                String username = "root";
                String passwordDB = "sssabb";
                String sql = "DELETE FROM tenismenrequest where tenismenName = '" + request.getTenismenName() +
                        "'" + ";";

                try(Connection conn = DriverManager.getConnection(url, username, passwordDB);
                    PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.executeUpdate();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

        }
    }
}
