package ViewModel.Commands;

import Model.Match;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FoundMatchScore {
    public static Integer executeFound(String player1, String player2){
        //we get the id of the match
        ArrayList<Match> matches = new ArrayList<>();

        Integer id = 0;

        String url = "jdbc:mysql://localhost:3306/tema1";
        String username = "root";
        String password = "sssabb";
        String sql = "Select id from matches where \n" +
                "((Select id FROM users WHERE fullname = '" + player1 + "') \n" +
                "= idplayer1 AND\n" +
                "(Select id FROM users WHERE fullname = '" + player2 + "') \n" +
                "= idplayer2) \n" +
                "OR\n" +
                "((Select id FROM users WHERE fullname = '" + player1 + "') \n" +
                "= idplayer2 AND\n" +
                "(Select id FROM users WHERE fullname = '" + player2 + "') \n" +
                "= idplayer1); ";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {

                id = resultSet.getInt("id");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return id;
    }

    public static Integer executeFindScore(String player1, String player2){
        //we get the id of the match
        ArrayList<Match> matches = new ArrayList<>();

        Integer idMatch = 0;
        Integer found = 0;

        String url = "jdbc:mysql://localhost:3306/tema1";
        String username = "root";
        String password = "sssabb";
        String sql = "Select id from matches where \n" +
                "((Select id FROM users WHERE fullname = '" + player1 + "') \n" +
                "= idplayer1 AND\n" +
                "(Select id FROM users WHERE fullname = '" + player2 + "') \n" +
                "= idplayer2) \n" +
                "OR\n" +
                "((Select id FROM users WHERE fullname = '" + player1 + "') \n" +
                "= idplayer2 AND\n" +
                "(Select id FROM users WHERE fullname = '" + player2 + "') \n" +
                "= idplayer1); ";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {

                idMatch = resultSet.getInt("id");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        sql = "SELECT id FROM matchestoscore WHERE idMatch = " + idMatch;
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {

                found = resultSet.getInt("id");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return found;
    }
}
