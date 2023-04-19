package View;

import Model.Match;
import Model.Persistence.CreateDataBaseNTables;
import Model.Persistence.UserPersistence;
import Model.Trial;
import Model.User;
import ViewModel.Commands.FoundMatchScore;
import ViewModel.RefereeHomeViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class RefereeView {
    @FXML
    Label lblTitle;

    @FXML
    ListView<Match> lstTrials;

    private User user;

    RefereeHomeViewModel refereeHomeViewModel = new RefereeHomeViewModel();

    public void setUser(User user){
        this.user = user;
    }

    public void RefereeHomeLogOutButton(ActionEvent event) throws IOException {
        refereeHomeViewModel.RefereeHomeLogOutButton(event);
    }

    public void RefereeHomeShowProgramButton(){
        lstTrials.setItems(refereeHomeViewModel.RefereeHomeShowProgramButton(user.getID()));
    }

    public void setScore(javafx.event.ActionEvent event) throws IOException {

        Match match = lstTrials.getSelectionModel().getSelectedItem();

        String player1Name;
        String player2Name;

        player1Name = UserPersistence.getUserName(match.getIdPlayer1());
        player2Name = UserPersistence.getUserName(match.getIdPlayer2());



        FXMLLoader fxmlLoader = new FXMLLoader(RefereeView.class.getResource("/View/MatchScore.fxml"));
        Parent parent = fxmlLoader.load();
        Scene scene = new Scene(parent);
        MatchScoreView matchScoreView = fxmlLoader.getController();
        matchScoreView.setPlayer1(player1Name);
        matchScoreView.setPlayer2(player2Name);
        matchScoreView.setLblPlayer1(player1Name);
        matchScoreView.setLblPlayer2(player2Name);
        matchScoreView.setMatchId(match.getId());
        matchScoreView.setTrialId(match.getIdTrial());
        matchScoreView.setReferee(user);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();

    }

}
