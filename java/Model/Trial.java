package Model;

import java.util.ArrayList;
import java.util.Date;

public class Trial {
    private ArrayList<User> referees = new ArrayList<User>();
    private ArrayList<User> competitors = new ArrayList<User>();

    private int id;
    private String category;

    public Trial(String category, int id) {
        this.id = id;
        this.category = category;
    }

    public Trial(ArrayList<User> competitors, int id) {
        this.competitors = competitors;
        this.id = id;
    }

    public ArrayList<User> getReferees() {
        return referees;
    }

    public void setReferees(ArrayList<User> referees) {
        this.referees = referees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<User> getCompetitors() {
        return competitors;
    }

    public void setCompetitors(ArrayList<User> competitors) {
        this.competitors = competitors;
    }

    @Override
    public String toString() {
        return
                " referees = " + referees.size() +
                "\n competitors = " + competitors.size() +
                "\n category = " + category +
                "\n id=" + id ;
    }
}
