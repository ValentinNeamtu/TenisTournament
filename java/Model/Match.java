package Model;

import java.sql.Date;
import java.util.ArrayList;

public class Match {
    private int id;
    private int idTrial;
    private int time;
    private Date date;
    private Integer idPlayer1;
    private Integer idPlayer2;
    private Integer idReferee;
    private Integer winner; // 0-none yet, 1 - player 1, 2 - player 2;
    private ArrayList<Integer> scorePlayer1;
    private ArrayList<Integer> scorePlayer2;
    private String type;
    private int childMatch;

    public Match(int id, int idTrial, int time, Date date, Integer idPlayer1, Integer idPlayer2, Integer idReferee, Integer winner, String type) {
        this.id = id;
        this.idTrial = idTrial;
        this.time = time;
        this.date = date;
        this.idPlayer1 = idPlayer1;
        this.idPlayer2 = idPlayer2;
        this.idReferee = idReferee;
        this.winner = winner;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTrial() {
        return idTrial;
    }

    public void setIdTrial(int idTrial) {
        this.idTrial = idTrial;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getIdPlayer1() {
        return idPlayer1;
    }

    public void setIdPlayer1(int idPlayer1) {
        this.idPlayer1 = idPlayer1;
    }

    public Integer getIdPlayer2() {
        return idPlayer2;
    }

    public void setIdPlayer2(int idPlayer2) {
        this.idPlayer2 = idPlayer2;
    }

    public Integer getIdReferee() {
        return idReferee;
    }

    public void setIdReferee(int idReferee) {
        this.idReferee = idReferee;
    }

    public int getWinner() {
        return winner;
    }

    public void setWinner(int winner) {
        this.winner = winner;
    }

    public ArrayList<Integer> getScorePlayer1() {
        return scorePlayer1;
    }

    public void setScorePlayer1(ArrayList<Integer> scorePlayer1) {
        this.scorePlayer1 = scorePlayer1;
    }

    public ArrayList<Integer> getScorePlayer2() {
        return scorePlayer2;
    }

    public void setScorePlayer2(ArrayList<Integer> scorePlayer2) {
        this.scorePlayer2 = scorePlayer2;
    }

    public Match(int id, int idTrial, int time, Date date) {
        this.id = id;
        this.idTrial = idTrial;
        this.time = time;
        this.date = date;
        this.winner = 0;
        this.scorePlayer1 = new ArrayList<>();
        this.scorePlayer2 = new ArrayList<>();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getChildMatch() {
        return childMatch;
    }

    public void setChildMatch(int childMatch) {
        this.childMatch = childMatch;
    }

    @Override
    public String toString() {
        return "====================\nMatch\n" +
                "id = " + id +
                "\n idTrial = " + idTrial +
                "\n time = " + time +
                "\n date = " + date +
                "\n idPlayer1 = " + idPlayer1 +
                "\n idPlayer2 = " + idPlayer2 +
                "\n idReferee = " + idReferee +
                "\n winner = " + winner +
                "\n type = " + type +
                "\n==================";
    }
}
