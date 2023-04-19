package ViewModel;

import Model.Match;
import Model.Persistence.MatchPersistance;

import java.util.ArrayList;

public class TrialMatchesViewModel {
    private ArrayList<Match> matches;

    public void setMatches(ArrayList<Match> matches) {
        this.matches = matches;
    }

    public ArrayList<Match> showMatches(int id){
        return MatchPersistance.SelectAllMatchesWithId(id);
    }
}
