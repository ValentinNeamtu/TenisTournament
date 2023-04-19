package ViewModel.Commands;

import Model.Request;
import Model.Trial;
import javafx.scene.control.Alert;
import javafx.scene.control.ToggleGroup;

import java.sql.*;

public class AcceptRequest {
    public void execute(Request request){
        if(request != null){
            //delete from the tenismenRequest table
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


            //add the new user and the new use to email entry

            String name = request.getTenismenName();

            String age = String.valueOf(request.getTenismenAge());



            if(name.equals("") || age.equals("")){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Fields");
                alert.setHeaderText("Please insert all the information needed!");
                alert.showAndWait();
            }else{
                url = "jdbc:mysql://localhost:3306/tema1";
                username = "root";
                String password = "sssabb";
                sql = "INSERT INTO users (fullName, userType, password, years) VALUES "+
                        "('" + name +"', "+
                        "'tenismen'," +
                        null + "," +
                        Integer.parseInt(age) + ");";
                try(Connection conn = DriverManager.getConnection(url, username, password);
                    PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.executeUpdate();

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

                int idOfLastUser = -1;
                int idTrial = request.getTrialID();

                sql = "SELECT id FROM users WHERE fullname = '"+
                        name +"'AND years =  "+
                        Integer.parseInt(age);

                try(Connection conn = DriverManager.getConnection(url, username, password);
                    PreparedStatement stmt = conn.prepareStatement(sql)) {
                    ResultSet resultSet = stmt.executeQuery();

                    while(resultSet.next()){
                        idOfLastUser = resultSet.getInt("id");
                    }

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

                sql = "INSERT INTO usertoemail (userID, email) VALUES (" +
                        idOfLastUser + ", '" + request.getTenismenEmail() +
                        "' );";

                try(Connection conn = DriverManager.getConnection(url, username, password);
                    PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.executeUpdate();

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }
}
