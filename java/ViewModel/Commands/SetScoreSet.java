package ViewModel.Commands;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SetScoreSet {
    public void execute(int Set, int player, int score, int matchId){

        String url = "jdbc:mysql://localhost:3306/tema1";
        String username = "root";
        String password = "sssabb";
        String sql = "";

        if(player == 1){
            sql = "UPDATE matchestoscore SET ScorePlayer1 =" + score + " " +
                    "WHERE idMatch = "+ matchId+" AND setNumber = " + Set;
        }else{
            sql = "UPDATE matchestoscore SET ScorePlayer2 =" + score + " " +
                    "WHERE idMatch = "+ matchId+" AND setNumber = " + Set;
        }



        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
