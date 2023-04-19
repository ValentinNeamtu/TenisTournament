package ViewModel.Commands;

import Model.User;
import javafx.scene.control.ToggleGroup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteUserButton {
    public void execute(User user){
        String url = "jdbc:mysql://localhost:3306/tema1";
        String username = "root";
        String passwordDB = "sssabb";
        String sql = "DELETE FROM users where id = " + user.getID() + ";";

        try(Connection conn = DriverManager.getConnection(url, username, passwordDB);
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        sql = "DELETE FROM userstotrials where idUser =" + user.getID() + ";";

        try(Connection conn = DriverManager.getConnection(url, username, passwordDB);
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        sql = "DELETE FROM usertoemail where userid =" + user.getID() + ";";

        try(Connection conn = DriverManager.getConnection(url, username, passwordDB);
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
