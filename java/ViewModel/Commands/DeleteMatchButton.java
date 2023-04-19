package ViewModel.Commands;

import Model.Match;
import Model.Trial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteMatchButton {
    public void execute(Match match) {

        String url = "jdbc:mysql://localhost:3306/tema1";
        String username = "root";
        String passwordDB = "sssabb";
        String sql = "DELETE FROM matches where id = " + match.getId() + ";";

        try (
                Connection conn = DriverManager.getConnection(url, username, passwordDB);
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.executeUpdate();
        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }

       /* sql = "DELETE FROM userstotrials where iduser = " + match.getId() + ";";

        try (Connection conn = DriverManager.getConnection(url, username, passwordDB);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/
    }
}
