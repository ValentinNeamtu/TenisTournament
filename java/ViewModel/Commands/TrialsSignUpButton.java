package ViewModel.Commands;

import Model.Persistence.SendEmail;
import Model.Trial;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import java.sql.*;

public class TrialsSignUpButton {

    public void execute(String name, String age, String email, Trial t){

        if(name.equals("") || age.equals("") || email.equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please insert all the information needed!");
            alert.showAndWait();
        }else{
            String url = "jdbc:mysql://localhost:3306/tema1";
            String username = "root";
            String password = "sssabb";
            String sql = "INSERT INTO tenismenrequest (tenismenName, tenismenEmail,tenismenAge, trialID) VALUES "+
                    "('" + name +"', "+
                    "'" + email + "'," +
                    age + ", "+
                    t.getId() + ");";

            try(Connection conn = DriverManager.getConnection(url, username, password);
                PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public void execute1(TextField txtName, TextField txtAge, ToggleGroup toggleGroup){
        String name = txtName.getText().toString();
        String age = txtAge.getText().toString();

        Trial t = (Trial) toggleGroup.getSelectedToggle().getUserData();
        int txtSelectedBtn = t.getId();

        if(name.equals("") || age.equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please insert all the information needed!");
            alert.showAndWait();
        }else{
            String url = "jdbc:mysql://localhost:3306/tema1";
            String username = "root";
            String password = "sssabb";
            String sql = "INSERT INTO users (fullName, userType, password, years) VALUES "+
                    "('" + name +"', "+
                    "'tenismen'," +
                    null + "," +
                    Integer.parseInt(age) + ");";
            /*
            String sql2 = "INSERT INTO usersToTrials (idUser) VALUES "+
                    name +", "+
                    "tenismen " +
                    null +
                    age + ";";
            */
            try(Connection conn = DriverManager.getConnection(url, username, password);
                PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            int idOfLastUser = -1;
            int idTrial = txtSelectedBtn;

            System.out.println("****\n****\n****\n" + txtSelectedBtn);

            sql = "SELECT id FROM users WHERE fullname = '"+
                    name +"'AND years =  "+
                    Integer.parseInt(age);

            try(Connection conn = DriverManager.getConnection(url, username, password);
                PreparedStatement stmt = conn.prepareStatement(sql)) {
                ResultSet resultSet = stmt.executeQuery();

                while(resultSet.next()){
                    idOfLastUser = resultSet.getInt("id");
                }

                //PreparedStatement stmt2 = conn.prepareStatement(sql2);
                //stmt2.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            sql = "INSERT INTO usersToTrials (idUser, idTrial) VALUES (" +
                    idOfLastUser + "," + idTrial +
                    ");";

            try(Connection conn = DriverManager.getConnection(url, username, password);
                PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
