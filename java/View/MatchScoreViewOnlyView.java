package View;

import Model.Persistence.MatchPersistance;
import ViewModel.Commands.DeterminatePlayerAndSet;
import ViewModel.Commands.SetScoreSet;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class MatchScoreViewOnlyView {



        @FXML
        Label lblPlayer1;

        @FXML
        Label lblPlayer2;

        @FXML
        Label lblS1P1;

    @FXML
    Label lblS1P2;

    @FXML
    Label lblS2P1;

    @FXML
    Label lblS2P2;

    @FXML
    Label lblS3P1;

    @FXML
    Label lblS3P2;


        @FXML
        Button btnShowScore;


        private int trialId;
        private int matchId;


        public void showScore(){

            ArrayList<Integer> scores = MatchPersistance.selectAllScores(matchId);

            lblS1P1.setText(String.valueOf(scores.get(0)));
            lblS1P2.setText(String.valueOf(scores.get(1)));
            lblS2P1.setText(String.valueOf(scores.get(2)));
            lblS2P2.setText(String.valueOf(scores.get(3)));
            lblS3P1.setText(String.valueOf(scores.get(4)));
            lblS3P2.setText(String.valueOf(scores.get(5)));

        }

        public void setMatchId(int matchId) {
            this.matchId = matchId;
        }

        public void backButton(javafx.event.ActionEvent event) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/TrialMatches.fxml"));
            Parent parent = fxmlLoader.load();
            Scene scene = new Scene(parent);
            TrialMatchesView trialMatchesView = fxmlLoader.getController();
            trialMatchesView.setTrialID(trialId);
            trialMatchesView.setLblTitle("Matches for trial " + trialId);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.show();
        }

        public void setTrialId(int trialId) {
            this.trialId = trialId;
        }

        public void setLblPlayer1(String lblPlayer1) {
            this.lblPlayer1.setText(lblPlayer1);
        }

        public void setLblPlayer2(String lblPlayer2) {
            this.lblPlayer2.setText(lblPlayer2);
        }

}
