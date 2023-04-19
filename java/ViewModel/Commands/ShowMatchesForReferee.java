package ViewModel.Commands;

import Model.Match;
import Model.Persistence.MatchPersistance;
import Model.Persistence.TrialsPersistence;
import Model.Trial;
import javafx.collections.ObservableList;

public class ShowMatchesForReferee {
    public ObservableList<Match> execute(ObservableList<Match> matches, int id){
        matches = MatchPersistance.SelectAllMatchesForReferee(id);
        return  matches;
    }
}
