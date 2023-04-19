package Model.Persistence;

import Model.Request;
import Model.Trial;
import Model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RequestPersistance {
    public static ArrayList<Request> SelectAllRequests(){
        ArrayList<Request> requests = new ArrayList<>();

        String url = "jdbc:mysql://localhost:3306/tema1";
        String username = "root";
        String password = "sssabb";
        String sql = "SELECT * " +
                "   FROM tenismenrequest ;";

        try(Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement stmt = conn.prepareStatement(sql)){
            ResultSet resultSet = stmt.executeQuery();

            while(resultSet.next()){
                Request request = new Request(resultSet.getString("tenismenname"),
                        resultSet.getString("tenismenEmail"),
                        resultSet.getInt("id"),
                        resultSet.getInt("tenismenAge"),
                        resultSet.getInt("trialid"));
                requests.add(request);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return requests;

    }
}
