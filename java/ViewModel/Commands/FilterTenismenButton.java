package ViewModel.Commands;

import Model.Tenismen;
import Model.Trial;
import Model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

import java.sql.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class FilterTenismenButton {
    public ObservableList<User> execute(String name, String ageTxt, String email){
        ArrayList<Tenismen> tenismen = new ArrayList<>();


        String url = "jdbc:mysql://localhost:3306/tema1";
        String username = "root";
        String password = "sssabb";
        String sql = "SELECT users.*, usertoemail.email FROM users JOIN usertoemail where users.id = usertoemail.userID;";

        try(Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet resultSet = stmt.executeQuery();

            while(resultSet.next()){
                Tenismen t = new Tenismen(resultSet.getString("fullName"),
                                          resultSet.getInt("id"),
                                          resultSet.getString("email"),
                                          resultSet.getInt("years"));
                tenismen.add(t);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        int age;
        if(!ageTxt.equals("")){
            age = Integer.valueOf(ageTxt);
        } else {
            age = 0;
        }

        tenismen = (ArrayList<Tenismen>) tenismen.stream()
                .filter(t -> name.isEmpty() || t.getFullName().equals(name))
                .filter(t -> age == 0 || t.getAge() == age)
                .filter(t -> email.isEmpty() || t.getEmail().equals(email))
                .collect(Collectors.toList());

        ArrayList<User> users = new ArrayList<>(tenismen);

        return FXCollections.observableList(users);
    }
}
