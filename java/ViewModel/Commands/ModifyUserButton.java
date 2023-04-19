package ViewModel.Commands;

import Model.User;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ModifyUserButton {
    public void execute(String age, String type, String name, String password, User user){

        String url = "jdbc:mysql://localhost:3306/tema1";
        String username = "root";
        String passwordDB = "sssabb";
        String sql;
        if(user != null) {
            int id = user.getID();

            if (!age.equals("")) {
                sql = "UPDATE users SET years = " + "'" + age + "'" + " where id = " + user.getID() + ";";
                try (Connection conn = DriverManager.getConnection(url, username, passwordDB);
                     PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.executeUpdate();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

            if (!type.equals("")) {
                sql = "UPDATE users SET usertype = " + "'" + type + "'" + " where id = " + user.getID() + ";";
                try (Connection conn = DriverManager.getConnection(url, username, passwordDB);
                     PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.executeUpdate();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

            if (!name.equals("")) {
                sql = "UPDATE users SET fullName = " + "'" + name + "'" + " where id = " + user.getID() + ";";
                try (Connection conn = DriverManager.getConnection(url, username, passwordDB);
                     PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.executeUpdate();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

            if (!password.equals("")) {
                sql = "UPDATE users SET password = " + "'" + password + "'" + " where id = " + user.getID() + ";";
                try (Connection conn = DriverManager.getConnection(url, username, passwordDB);
                     PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.executeUpdate();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Nothing SELECTED");
            alert.setHeaderText("SELECT A USER TO MODIFY");
            alert.showAndWait();
        }
    }
}
