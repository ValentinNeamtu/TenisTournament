package Model.Persistence;

import Model.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserPersistence {
    public static String userType(int ID, String userPassword){
        String url = "jdbc:mysql://localhost:3306/tema1";
        String username = "root";
        String password = "sssabb";
        String sql = "SELECT userType FROM users WHERE users.id = " + ID +
                     "AND users.password = " + userPassword;

        String type = "NAN";

        try(Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement stmt = conn.prepareStatement(sql)){



        }catch (Exception e){
            e.printStackTrace();
        }

        return type;
    }

    public static ArrayList<User> SelectAllUsersWithPassword(){
        ArrayList<User> users = new ArrayList<>();

        String url = "jdbc:mysql://localhost:3306/tema1";
        String username = "root";
        String password = "sssabb";
        String sql = "SELECT * " +
                "   FROM users WHERE password IS NOT null;";

        try(Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement stmt = conn.prepareStatement(sql)){
            ResultSet resultSet = stmt.executeQuery();

            while(resultSet.next()){

                String type = resultSet.getString("usertype");

                if(type.equals("referee")){
                    Referee referee = new Referee(resultSet.getString("fullname"),
                            resultSet.getString("password"),
                            resultSet.getInt("id"));
                    users.add(referee);
                }

                if(type.equals("admin")){
                    Admin admin = new Admin(resultSet.getString("fullname"),
                            resultSet.getString("password"),
                            resultSet.getInt("id"));
                    users.add(admin);
                }

                if(type.equals("organizer")){
                    Organizer organizer = new Organizer(resultSet.getString("fullname"),
                            resultSet.getString("password"),
                            resultSet.getInt("id"));
                    users.add(organizer);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return users;

    }

    public static ArrayList<User> SelectAllTensimenAndReferees(){
        ArrayList<User> users = new ArrayList<>();

        String url = "jdbc:mysql://localhost:3306/tema1";
        String username = "root";
        String password = "sssabb";
        String sql = "SELECT * " +
                "   FROM users WHERE (usertype = 'tenismen' OR usertype = 'referee');";

        try(Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement stmt = conn.prepareStatement(sql)){
            ResultSet resultSet = stmt.executeQuery();

            while(resultSet.next()){

                String type = resultSet.getString("usertype");

                if(type.equals("referee")){
                    Referee referee = new Referee(resultSet.getString("fullname"),
                                                  resultSet.getString("password"),
                                                  resultSet.getInt("id"));
                    users.add(referee);
                }

                if(type.equals("tenismen")){
                    Tenismen tenismen = new Tenismen(resultSet.getString("fullname"),
                            resultSet.getInt("id"));
                    users.add(tenismen);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return users;

    }

    public static String getUserName(int id){
        String name = "";
        String url = "jdbc:mysql://localhost:3306/tema1";
        String username = "root";
        String password = "sssabb";
        String sql = "SELECT fullName " +
                "   FROM users WHERE id = " + id;

        try(Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement stmt = conn.prepareStatement(sql)){
            ResultSet resultSet = stmt.executeQuery();

            while(resultSet.next()){

                name = resultSet.getString("fullName");

            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return name;
    }

}
