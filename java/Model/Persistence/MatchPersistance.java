package Model.Persistence;

import Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MatchPersistance {
    public static ObservableList<Match> SelectAllMatches(){
        ArrayList<Match> matches = new ArrayList<>();

        String url = "jdbc:mysql://localhost:3306/tema1";
        String username = "root";
        String password = "sssabb";
        String sql = "SELECT * " +
                "   FROM matches WHERE parent1 IS null;";

        try(Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement stmt = conn.prepareStatement(sql)){
            ResultSet resultSet = stmt.executeQuery();

            while(resultSet.next()){

                Match match = new Match(resultSet.getInt("id"),
                                        resultSet.getInt("idTrial"),
                                        resultSet.getInt("matchtime"),
                                        resultSet.getDate("matchDate"),
                                        resultSet.getInt("idplayer1"),
                                        resultSet.getInt("idplayer2"),
                                        resultSet.getInt("idReferee"),
                                        resultSet.getInt("winner"),
                                        resultSet.getString("type"));
                matches.add(match);

            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return FXCollections.observableList(matches);

    }

    public static ArrayList<Match> SelectAllMatchesWithId(int id) {
        ArrayList<Match> matches = new ArrayList<>();

        String url = "jdbc:mysql://localhost:3306/tema1";
        String username = "root";
        String password = "sssabb";
        String sql = "SELECT * " +
                "   FROM matches WHERE idTrial = " + id ;

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {

                Match match = new Match(resultSet.getInt("id"),
                        resultSet.getInt("idTrial"),
                        resultSet.getInt("matchtime"),
                        resultSet.getDate("matchDate"),
                        resultSet.getInt("idplayer1"),
                        resultSet.getInt("idplayer2"),
                        resultSet.getInt("idReferee"),
                        resultSet.getInt("winner"),
                        resultSet.getString("type"));
                matches.add(match);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return matches;
    }

    public static ArrayList<Integer> selectAllScores(int matchId){
        ArrayList<Integer> scores = new ArrayList<>();

        String url = "jdbc:mysql://localhost:3306/tema1";
        String username = "root";
        String password = "sssabb";
        String sql = "SELECT scorePlayer1, scorePlayer2 " +
                "   FROM matchestoscore WHERE idMatch = " + matchId ;

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {

                Integer i1 = resultSet.getInt("scorePlayer1");
                Integer i2 = resultSet.getInt("scorePlayer2");
                scores.add(i1);
                scores.add(i2);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return scores;
    }

    public static ObservableList<Match> SelectAllMatchesForReferee(int idReferee){
        ArrayList<Match> matches = new ArrayList<>();

        String url = "jdbc:mysql://localhost:3306/tema1";
        String username = "root";
        String password = "sssabb";
        String sql = "SELECT * " +
                "   FROM matches WHERE idReferee = " + idReferee;

        try(Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement stmt = conn.prepareStatement(sql)){
            ResultSet resultSet = stmt.executeQuery();

            while(resultSet.next()){

                Match match = new Match(resultSet.getInt("id"),
                        resultSet.getInt("idTrial"),
                        resultSet.getInt("matchtime"),
                        resultSet.getDate("matchDate"),
                        resultSet.getInt("idplayer1"),
                        resultSet.getInt("idplayer2"),
                        resultSet.getInt("idReferee"),
                        resultSet.getInt("winner"),
                        resultSet.getString("type"));
                matches.add(match);

            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return FXCollections.observableList(matches);

    }
}
