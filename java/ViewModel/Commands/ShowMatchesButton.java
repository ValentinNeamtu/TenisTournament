package ViewModel.Commands;

import Model.Match;
import Model.Persistence.MatchPersistance;
import javafx.collections.ObservableList;

public class ShowMatchesButton {
    public ObservableList<Match> execute(){
        return MatchPersistance.SelectAllMatches();
    }
}
