package Model.Persistence;

import Model.Trial;
import Model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TrialsPersistence {
        public static ObservableList<Trial> SelectAllTrials(){
            ArrayList<Trial> trials = new ArrayList<>();

            String url = "jdbc:mysql://localhost:3306/tema1";
            String username = "root";
            String password = "sssabb";
            String sql = "SELECT * " +
                    "   FROM trials;";

            try(Connection conn = DriverManager.getConnection(url, username, password);
                PreparedStatement stmt = conn.prepareStatement(sql)){
                ResultSet resultSet = stmt.executeQuery();

                while(resultSet.next()){

                    String sql2 = "Select idUser from userstotrials where idtrial = " + resultSet.getInt("id") + ";";
                    PreparedStatement stmt2 = conn.prepareStatement(sql2);
                    ResultSet resultSet2 = stmt2.executeQuery();

                    ArrayList<User> competitors = new ArrayList<>();
                    ArrayList<User> referees = new ArrayList<>();

                    while(resultSet2.next()){

                        String sql3 = "Select * from users where id = " + resultSet2.getInt("idUser") +
                                " AND usertype = 'tenismen' " + ";";
                        PreparedStatement stmt3 = conn.prepareStatement(sql3);
                        ResultSet resultSet3 = stmt3.executeQuery();

                        while(resultSet3.next()){
                            User competitor = new User(resultSet3.getString("fullName"),
                                    resultSet3.getInt("id"));

                            competitors.add(competitor);
                        }


                        String sql4 = "Select * from users where id = " + resultSet2.getInt("idUser") +
                                " AND usertype = 'referee' " + ";";
                        PreparedStatement stmt4 = conn.prepareStatement(sql4);
                        ResultSet resultSet4 = stmt4.executeQuery();

                        while(resultSet4.next()){
                            User referee = new User(resultSet4.getString("fullName"),
                                    resultSet4.getInt("id"));

                            referees.add(referee);
                        }
                    }


                    Trial trial = new Trial(resultSet.getString("category"),
                                            resultSet.getInt("id"));
                    trial.setCompetitors(competitors);
                    trial.setReferees(referees);
                    trials.add(trial);
                }

            }catch (Exception e){
                e.printStackTrace();
            }

            return FXCollections.observableList(trials);

        }

    public static ObservableList<Trial> SelectAllTrialsForReferees(int idReferee){
        ArrayList<Trial> trials = new ArrayList<>();

        String url = "jdbc:mysql://localhost:3306/tema1";
        String username = "root";
        String password = "sssabb";
        String sql = "SELECT * " +
                "   FROM trials where trials.id IN " +
                "   (SELECT idtrial FROM userstotrials where idUser =" + idReferee + ");";

        try(Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement stmt = conn.prepareStatement(sql)){
            ResultSet resultSet = stmt.executeQuery();

            while(resultSet.next()){

                String sql2 = "Select idUser from userstotrials where idtrial = " + resultSet.getInt("id") + ";";
                PreparedStatement stmt2 = conn.prepareStatement(sql2);
                ResultSet resultSet2 = stmt2.executeQuery();

                ArrayList<User> competitors = new ArrayList<>();
                ArrayList<User> referees = new ArrayList<>();

                while(resultSet2.next()){

                    String sql3 = "Select * from users where id = " + resultSet2.getInt("idUser") +
                            " AND usertype = 'tenismen' " + ";";
                    PreparedStatement stmt3 = conn.prepareStatement(sql3);
                    ResultSet resultSet3 = stmt3.executeQuery();

                    while(resultSet3.next()){
                        User competitor = new User(resultSet3.getString("fullName"),
                                resultSet3.getInt("id"));

                        competitors.add(competitor);
                    }


                    String sql4 = "Select * from users where id = " + resultSet2.getInt("idUser") +
                            " AND usertype = 'referee' " + ";";
                    PreparedStatement stmt4 = conn.prepareStatement(sql4);
                    ResultSet resultSet4 = stmt4.executeQuery();

                    while(resultSet4.next()){
                        User referee = new User(resultSet4.getString("fullName"),
                                resultSet4.getInt("id"));

                        referees.add(referee);
                    }
                }


                Trial trial = new Trial(resultSet.getString("category"),
                                        resultSet.getInt("id"));
                trial.setCompetitors(competitors);
                trial.setReferees(referees);
                trials.add(trial);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return FXCollections.observableList(trials);

    }
}
