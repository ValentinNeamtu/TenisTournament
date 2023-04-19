package Model.Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CreateDataBaseNTables {
    public static void CreateDataBase(){
        String url = "jdbc:mysql://localhost:3306/mysql";

        String username = "root";
        String password = "sssabb";

        String sql = "CREATE DATABASE IF NOT EXISTS TEMA1";

        try(Connection conn = DriverManager.getConnection(url, username, password);
        PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void CreateUsersTabel(){
        String url = "jdbc:mysql://localhost:3306/tema1";
        String username = "root";
        String password = "sssabb";
        String sql = "CREATE TABLE IF NOT EXISTS users (" +
                "id int NOT NULL AUTO_INCREMENT," +
                "    fullName varchar(255) NOT NULL," +
                "    userType varchar(255) NOT NULL," +
                "    password varchar(255)," +
                "    years int NOT NULL," +
                "    PRIMARY KEY (id)" +
                ");";

        try(Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void CreateTrialToMatch(){
        String url = "jdbc:mysql://localhost:3306/tema1";
        String username = "root";
        String password = "sssabb";
        String sql = "CREATE TABLE IF NOT EXISTS matches(" +
                "id int NOT NULL AUTO_INCREMENT," +
                "    matchTime int NOT NULL," +
                "    matchDate Date NOT NULL," +
                "    winner int," +
                "    idPlayer1 int," +
                "    idPlayer2 int," +
                "    idReferee int," +
                "    idTrial int NOT NULL," +
                "    type varchar(250) NOT NULL, " +
                "    parent1 int," +
                "    parent2 int," +
                "    PRIMARY KEY (id)" +
                ");";

        try(Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void CreateMatchScore(){
        String url = "jdbc:mysql://localhost:3306/tema1";
        String username = "root";
        String password = "sssabb";
        String sql = "CREATE TABLE IF NOT EXISTS matchestoscore (" +
                "id int NOT NULL AUTO_INCREMENT," +
                "    idMatch int NOT NULL," +
                "    scorePlayer1 int NOT NULL," +
                "    scorePlayer2 int NOT NULL," +
                "    setNumber varchar(20) NOT NULL," +
                "    PRIMARY KEY (id)" +
                ");";

        try(Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void CreateUserToEmail(){
        String url = "jdbc:mysql://localhost:3306/tema1";
        String username = "root";
        String password = "sssabb";
        String sql = "CREATE TABLE IF NOT EXISTS usertoemail (" +
                "   id int NOT NULL AUTO_INCREMENT," +
                "   userID int NOT NULL," +
                "   email varchar(100) NOT NULL," +
                "   PRIMARY KEY (id)" +
                ");";

        try(Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void CreateTenismenRequest(){
        String url = "jdbc:mysql://localhost:3306/tema1";
        String username = "root";
        String password = "sssabb";
        String sql = "CREATE TABLE IF NOT EXISTS tenismenrequest (" +
                "   id int NOT NULL AUTO_INCREMENT," +
                "   tenismenName varchar(250) NOT NULL," +
                "   tenismenEmail varchar(250) NOT NULL," +
                "   tenismenAge int NOT NULL," +
                "   trialID int NOT NULL," +
                "   PRIMARY KEY (id)" +
                ");";

        try(Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void CreateTrials(){
        String url = "jdbc:mysql://localhost:3306/tema1";
        String username = "root";
        String password = "sssabb";
        String sql = "CREATE TABLE IF NOT EXISTS trials (" +
                "   id int NOT NULL AUTO_INCREMENT," +
                "   category varchar(255) NOT NULL," +
                "   PRIMARY KEY (id)" +
                ");";

        try(Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void CreateUsersToTrialseTable(){
        String url = "jdbc:mysql://localhost:3306/tema1";
        String username = "root";
        String password = "sssabb";
        String sql = "CREATE TABLE IF NOT EXISTS UsersToTrials (" +
                "idEntry int NOT NULL AUTO_INCREMENT," +
                "    idUser int NOT NULL," +
                "    idTrial int NOT NULL," +
                "    PRIMARY KEY (idEntry)" +
                ");";

        try(Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void MandatoryInserts(){
        String url = "jdbc:mysql://localhost:3306/tema1";
        String username = "root";
        String password = "sssabb";
        String sql = "SELECT * FROM users WHERE id = 1";

        int gasit = 1;
        try(Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement stmt = conn.prepareStatement(sql)){
            ResultSet resultSet = stmt.executeQuery(sql);
            if(!resultSet.next()){
                sql = "Insert into trials (category) values('masculin')";

                try(Connection conn1 = DriverManager.getConnection(url, username, password);
                    PreparedStatement stmt1 = conn.prepareStatement(sql)){
                    stmt1.executeUpdate();
                }catch (Exception e){
                    e.printStackTrace();
                }

                sql = "Insert into trials (category) values('feminin')";

                try(Connection conn1 = DriverManager.getConnection(url, username, password);
                    PreparedStatement stmt1 = conn.prepareStatement(sql)){
                    stmt1.executeUpdate();
                }catch (Exception e){
                    e.printStackTrace();
                }

                sql = "Insert into users (fullName, userType, password, years) values('Valentin', 'admin', '1234', 13)";

                try(Connection conn1 = DriverManager.getConnection(url, username, password);
                    PreparedStatement stmt1 = conn.prepareStatement(sql)){
                    stmt1.executeUpdate();
                }catch (Exception e){
                    e.printStackTrace();
                }

                sql = "Insert into matches (matchtime, matchdate, idTrial, type) " +
                        "values(1000, '2023-01-01', 1, 'S1')";

                try(Connection conn1 = DriverManager.getConnection(url, username, password);
                    PreparedStatement stmt1 = conn.prepareStatement(sql)){
                    stmt1.executeUpdate();
                }catch (Exception e){
                    e.printStackTrace();
                }

                sql = "Insert into matches (matchtime, matchdate, idTrial, type) " +
                        "values(1000, '2023-01-01', 1, 'S2')";

                try(Connection conn1 = DriverManager.getConnection(url, username, password);
                    PreparedStatement stmt1 = conn.prepareStatement(sql)){
                    stmt1.executeUpdate();
                }catch (Exception e){
                    e.printStackTrace();
                }

                sql = "Insert into matches (matchtime, matchdate, idTrial, type) " +
                        "values(1000, '2023-01-01', 1, 'S3')";

                try(Connection conn1 = DriverManager.getConnection(url, username, password);
                    PreparedStatement stmt1 = conn.prepareStatement(sql)){
                    stmt1.executeUpdate();
                }catch (Exception e){
                    e.printStackTrace();
                }

                sql = "Insert into matches (matchtime, matchdate, idTrial, type) " +
                        "values(1000, '2023-01-01', 1, 'S4')";

                try(Connection conn1 = DriverManager.getConnection(url, username, password);
                    PreparedStatement stmt1 = conn.prepareStatement(sql)){
                    stmt1.executeUpdate();
                }catch (Exception e){
                    e.printStackTrace();
                }

                sql = "Insert into matches (matchtime, matchdate, idTrial, type) " +
                        "values(1000, '2023-01-01', 1, 'S5')";

                try(Connection conn1 = DriverManager.getConnection(url, username, password);
                    PreparedStatement stmt1 = conn.prepareStatement(sql)){
                    stmt1.executeUpdate();
                }catch (Exception e){
                    e.printStackTrace();
                }

                sql = "Insert into matches (matchtime, matchdate, idTrial, type) " +
                        "values(1000, '2023-01-01', 1, 'S6')";

                try(Connection conn1 = DriverManager.getConnection(url, username, password);
                    PreparedStatement stmt1 = conn.prepareStatement(sql)){
                    stmt1.executeUpdate();
                }catch (Exception e){
                    e.printStackTrace();
                }

                sql = "Insert into matches (matchtime, matchdate, idTrial, type) " +
                        "values(1000, '2023-01-01', 1, 'S7')";

                try(Connection conn1 = DriverManager.getConnection(url, username, password);
                    PreparedStatement stmt1 = conn.prepareStatement(sql)){
                    stmt1.executeUpdate();
                }catch (Exception e){
                    e.printStackTrace();
                }

                sql = "Insert into matches (matchtime, matchdate, idTrial, type) " +
                        "values(1000, '2023-01-01', 1, 'S8')";

                try(Connection conn1 = DriverManager.getConnection(url, username, password);
                    PreparedStatement stmt1 = conn.prepareStatement(sql)){
                    stmt1.executeUpdate();
                }catch (Exception e){
                    e.printStackTrace();
                }

                sql = "Insert into matches (matchtime, matchdate, idTrial, type, parent1, parent2) " +
                        "values(1000, '2023-02-01', 1, 'PreSem1', 1, 2)";

                try(Connection conn1 = DriverManager.getConnection(url, username, password);
                    PreparedStatement stmt1 = conn.prepareStatement(sql)){
                    stmt1.executeUpdate();
                }catch (Exception e){
                    e.printStackTrace();
                }

                sql = "Insert into matches (matchtime, matchdate, idTrial, type, parent1, parent2) " +
                        "values(1000, '2023-02-01', 1, 'PreSem2', 3, 4)";

                try(Connection conn1 = DriverManager.getConnection(url, username, password);
                    PreparedStatement stmt1 = conn.prepareStatement(sql)){
                    stmt1.executeUpdate();
                }catch (Exception e){
                    e.printStackTrace();
                }
                sql = "Insert into matches (matchtime, matchdate, idTrial, type, parent1, parent2) " +
                        "values(1000, '2023-02-01', 1, 'PreSem3', 5, 6)";

                try(Connection conn1 = DriverManager.getConnection(url, username, password);
                    PreparedStatement stmt1 = conn.prepareStatement(sql)){
                    stmt1.executeUpdate();
                }catch (Exception e){
                    e.printStackTrace();
                }

                sql = "Insert into matches (matchtime, matchdate, idTrial, type, parent1, parent2) " +
                        "values(1000, '2023-02-01', 1, 'PreSem4', 7, 8)";

                try(Connection conn1 = DriverManager.getConnection(url, username, password);
                    PreparedStatement stmt1 = conn.prepareStatement(sql)){
                    stmt1.executeUpdate();
                }catch (Exception e){
                    e.printStackTrace();
                }

                sql = "Insert into matches (matchtime, matchdate, idTrial, type, parent1, parent2) " +
                        "values(1000, '2023-02-01', 1, 'Sem1', 9, 10)";

                try(Connection conn1 = DriverManager.getConnection(url, username, password);
                    PreparedStatement stmt1 = conn.prepareStatement(sql)){
                    stmt1.executeUpdate();
                }catch (Exception e){
                    e.printStackTrace();
                }

                sql = "Insert into matches (matchtime, matchdate, idTrial, type, parent1, parent2) " +
                        "values(1000, '2023-02-01', 1, 'Sem2', 11, 12)";

                try(Connection conn1 = DriverManager.getConnection(url, username, password);
                    PreparedStatement stmt1 = conn.prepareStatement(sql)){
                    stmt1.executeUpdate();
                }catch (Exception e){
                    e.printStackTrace();
                }

                sql = "Insert into matches (matchtime, matchdate, idTrial, type, parent1, parent2) " +
                        "values(1000, '2023-02-01', 1, 'Final', 13, 14)";

                try(Connection conn1 = DriverManager.getConnection(url, username, password);
                    PreparedStatement stmt1 = conn.prepareStatement(sql)){
                    stmt1.executeUpdate();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void OptionalMatchScoreInsert(int idMatch){
        String url = "jdbc:mysql://localhost:3306/tema1";
        String username = "root";
        String password = "sssabb";
        String sql = "INSERT INTO matchestoscore (idMatch, scorePlayer1, scorePlayer2, setNumber) " +
                "     VALUES("+ idMatch + ", 0, 0, 1)";

        try(Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.execute();
        }catch (Exception e){
            e.printStackTrace();
        }

        sql = "INSERT INTO matchestoscore (idMatch, scorePlayer1, scorePlayer2, setNumber) " +
                "     VALUES("+ idMatch + ", 0, 0, 2)";

        try(Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.execute();
        }catch (Exception e){
            e.printStackTrace();
        }

        sql = "INSERT INTO matchestoscore (idMatch, scorePlayer1, scorePlayer2, setNumber) " +
                "     VALUES("+ idMatch + ", 0, 0, 3)";

        try(Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
