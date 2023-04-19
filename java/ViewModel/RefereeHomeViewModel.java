package ViewModel;

import Model.Match;
import Model.Trial;
import ViewModel.Commands.ShowMatchesForReferee;
import ViewModel.Commands.SignOutButton;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import java.io.IOException;

public class RefereeHomeViewModel {

    ObservableList<Match> matches ;

    SignOutButton signOutButton = new SignOutButton();
    ShowMatchesForReferee showMatchesForReferee = new ShowMatchesForReferee();

    public void RefereeHomeLogOutButton(ActionEvent event) throws IOException {
        signOutButton.execute(event);
    }

    public ObservableList<Match> RefereeHomeShowProgramButton(int id){
        return showMatchesForReferee.execute(matches, id);
    }

    public ObservableList<Match> getTrials() {
        return matches;
    }

    public void setTrials(ObservableList<Match> trials) {
        this.matches = trials;
    }

}
