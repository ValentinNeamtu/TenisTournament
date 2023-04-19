package ViewModel.Commands;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateNewUserButton {
    public void execute(String type, String age, String name, String password){

        if(type.equals("") || age.equals("") || name.equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Insert all the required data!");
            alert.showAndWait();
        }else{
            if(type.equals("admin") || type.equals("tenismen") || type.equals("referee") || type.equals("organizer")){

                if(type.equals("tenismen")){//if tenismen

                    String url = "jdbc:mysql://localhost:3306/tema1";
                    String username = "root";
                    String passwordDB = "sssabb";
                    String sql = "INSERT INTO users (fullname, usertype, years) VALUES ("+
                            "'" + name + "'" + "," + "'" + type + "'" + "," + age + ");";

                    try(Connection conn = DriverManager.getConnection(url, username, passwordDB);
                        PreparedStatement stmt = conn.prepareStatement(sql)) {
                        stmt.executeUpdate();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }

                }else{
                    if(password.equals("")){//if not tenismen, the password is a mandatory field
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Invalid Fields");
                        alert.setHeaderText("Password is a MANDATORY FIELD for this TYPE OF USER !");
                        alert.showAndWait();
                    }else{

                        String url = "jdbc:mysql://localhost:3306/tema1";
                        String username = "root";
                        String passwordDB = "sssabb";
                        String sql = "INSERT INTO users (fullname, usertype, password, years) VALUES ("+
                                "'" +  name + "'" + "," + "'" + type + "'" + "," + "'" +password + "'" + "," + age + ");";

                        try(Connection conn = DriverManager.getConnection(url, username, passwordDB);
                            PreparedStatement stmt = conn.prepareStatement(sql)) {
                            stmt.executeUpdate();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }

                    }
                }

            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Fields");
                alert.setHeaderText("Insert a VALID TYPE OF USER!");
                alert.showAndWait();
            }
        }
    }
}
