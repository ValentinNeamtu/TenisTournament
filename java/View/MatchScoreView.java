package View;

import Model.Match;
import Model.Persistence.MatchPersistance;
import Model.User;
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

public class MatchScoreView {

    @FXML
    Label lblPlayer1;

    @FXML
    Label lblPlayer2;

    @FXML
    Spinner<Integer> spnS1P1;

    @FXML
    Spinner<Integer> spnS1P2;

    @FXML
    Spinner<Integer> spnS2P1;

    @FXML
    Spinner<Integer> spnS2P2;

    @FXML
    Spinner<Integer> spnS3P1;

    @FXML
    Spinner<Integer> spnS3P2;

    @FXML
    Button btnShowScore;

    private String player1Name;
    private String player2Name;
    private int trialId;
    private int matchId;
    private User referee;

    SetScoreSet setScoreSet = new SetScoreSet();
    DeterminatePlayerAndSet determinatePlayerAndSet = new DeterminatePlayerAndSet();

    SpinnerValueFactory<Integer> valueFactory1 = new SpinnerValueFactory<Integer>() {
        @Override
        public void decrement(int steps) {
            setValue(getValue() - steps);// this decrements the value
            saveData();
        }

        @Override
        public void increment(int steps) {
            setValue(getValue() + steps);
            saveData();
        }
    };

    SpinnerValueFactory<Integer> valueFactory2 = new SpinnerValueFactory<Integer>() {
        @Override
        public void decrement(int steps) {
            setValue(getValue() - steps);// this decrements the value
            saveData();
        }

        @Override
        public void increment(int steps) {
            setValue(getValue() + steps);
            saveData();
        }
    };

    SpinnerValueFactory<Integer> valueFactory3 = new SpinnerValueFactory<Integer>() {
        @Override
        public void decrement(int steps) {
            setValue(getValue() - steps);// this decrements the value
            saveData();
        }

        @Override
        public void increment(int steps) {
            setValue(getValue() + steps);
            saveData();
        }
    };

    SpinnerValueFactory<Integer> valueFactory4 = new SpinnerValueFactory<Integer>() {
        @Override
        public void decrement(int steps) {
            setValue(getValue() - steps);// this decrements the value
            saveData();
        }

        @Override
        public void increment(int steps) {
            setValue(getValue() + steps);
            saveData();
        }
    };

    SpinnerValueFactory<Integer> valueFactory5 = new SpinnerValueFactory<Integer>() {
        @Override
        public void decrement(int steps) {
            setValue(getValue() - steps);// this decrements the value
            saveData();
        }

        @Override
        public void increment(int steps) {
            setValue(getValue() + steps);
            saveData();
        }
    };

    SpinnerValueFactory<Integer> valueFactory6 = new SpinnerValueFactory<Integer>() {
        @Override
        public void decrement(int steps) {
            setValue(getValue() - steps);// this decrements the value
            saveData();
        }

        @Override
        public void increment(int steps) {
            setValue(getValue() + steps);
            saveData();
        }
    };

    public void saveData(){
        setScoreSet.execute(1, 1, spnS1P1.getValue(), matchId);
        setScoreSet.execute(1, 2, spnS1P2.getValue(), matchId);
        setScoreSet.execute(2, 1, spnS2P1.getValue(), matchId);
        setScoreSet.execute(2, 2, spnS2P2.getValue(), matchId);
        setScoreSet.execute(3, 1, spnS3P1.getValue(), matchId);
        setScoreSet.execute(3, 2, spnS3P2.getValue(), matchId);
    }

    public void showScore(javafx.event.ActionEvent event){
        spnS1P1.setValueFactory(valueFactory1);
        spnS1P2.setValueFactory(valueFactory2);
        spnS2P1.setValueFactory(valueFactory3);
        spnS2P2.setValueFactory(valueFactory4);
        spnS3P1.setValueFactory(valueFactory5);
        spnS3P2.setValueFactory(valueFactory6);

        ArrayList<Integer> scores = MatchPersistance.selectAllScores(matchId);

        spnS1P1.getValueFactory().setValue(scores.get(0));
        spnS1P2.getValueFactory().setValue(scores.get(1));
        spnS2P1.getValueFactory().setValue(scores.get(2));
        spnS2P2.getValueFactory().setValue(scores.get(3));
        spnS3P1.getValueFactory().setValue(scores.get(4));
        spnS3P2.getValueFactory().setValue(scores.get(5));

        System.out.println(spnS1P1.getId());

    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public void backButton(javafx.event.ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/RefereeHome.fxml"));
        Parent parent = fxmlLoader.load();
        Scene scene = new Scene(parent);
        RefereeView refereeView = fxmlLoader.getController();
        refereeView.setUser(referee);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    }

    public void setReferee(User referee) {
        this.referee = referee;
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

    public void setPlayer1(String player1) {
        this.player1Name = player1;
    }

    public void setPlayer2(String player2) {
        this.player2Name = player2;
    }
}
