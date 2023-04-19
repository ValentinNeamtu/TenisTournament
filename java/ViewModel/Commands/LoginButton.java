package ViewModel.Commands;

import Model.Admin;
import Model.User;
import View.AdminHomeView;
import View.RefereeView;
import ViewModel.AdminHomeViewModel;
import ViewModel.MainApplicationViewModel;
import ViewModel.RefereeHomeViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class LoginButton {
    public void execute(ActionEvent event, String txtID, String txtPassword) throws IOException {

        if(txtID.equals("") == true || txtPassword.equals("") == true){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please insert all the information needed!");
            alert.showAndWait();
        }else {
            int ID = Integer.parseInt(txtID);
            User u =  new Admin("daw", "awd", 12);


            String url = "jdbc:mysql://localhost:3306/tema1";
            String username = "root";
            String password = "sssabb";
            String sql = "SElECT * FROM users WHERE id = " + ID + ";";

            try(Connection conn = DriverManager.getConnection(url, username, password);
                PreparedStatement stmt = conn.prepareStatement(sql)) {
                ResultSet resultSet = stmt.executeQuery();

                while(resultSet.next()){
                    if(txtPassword.equals(resultSet.getString("password"))){
                        if(resultSet.getString("userType").equals("admin")){
                            FXMLLoader fxmlLoader = new FXMLLoader(MainApplicationViewModel.class.getResource("/View/AdminHome.fxml"));
                            Parent parent = fxmlLoader.load();
                            Scene scene = new Scene(parent);
                            AdminHomeView adminHomeView = fxmlLoader.getController();
                            adminHomeView.getLblTitle().setText("Welcome back " + resultSet.getString("fullName") + " !");
                            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            appStage.setUserData(resultSet);
                            appStage.setScene(scene);
                            appStage.show();
                        }

                        if(resultSet.getString("userType").equals("organizer")){
                            FXMLLoader fxmlLoader = new FXMLLoader(MainApplicationViewModel.class.getResource("/View/OrganizerHome.fxml"));
                            Parent parent = fxmlLoader.load();
                            Scene scene = new Scene(parent);
                            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            appStage.setUserData(resultSet);
                            appStage.setScene(scene);
                            appStage.show();
                        }

                        if(resultSet.getString("userType").equals("referee")){
                            FXMLLoader fxmlLoader = new FXMLLoader(MainApplicationViewModel.class.getResource("/View/RefereeHome.fxml"));
                            Parent parent = fxmlLoader.load();
                            Scene scene = new Scene(parent);
                            RefereeView refereeView = fxmlLoader.getController();
                            refereeView.setUser(new User(resultSet.getString("fullname"), resultSet.getInt("id")));
                            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            appStage.setUserData(resultSet);
                            appStage.setScene(scene);
                            appStage.show();
                        }

                    }else{
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Invalid Fields");
                        alert.setHeaderText("User ID or Password are wrong!");
                        alert.showAndWait();
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
