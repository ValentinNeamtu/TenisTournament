package View;

import Model.Match;
import Model.Persistence.CreateDataBaseNTables;
import Model.Persistence.UserPersistence;
import ViewModel.Commands.FoundMatchScore;
import ViewModel.MainApplicationViewModel;
import ViewModel.TrialMatchesViewModel;
import ViewModel.TrialSignUpViewModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class TrialMatchesView {
    @FXML
    Button btnShowMatches;

    @FXML
    Label lblTitle;

    @FXML
    Button btnS1;

    @FXML
    Button btnS2;

    @FXML
    Button btnS3;

    @FXML
    Button btnS4;

    @FXML
    Button btnS5;

    @FXML
    Button btnS6;

    @FXML
    Button btnS7;

    @FXML
    Button btnS8;

    @FXML
    Button btnPreSem1;

    @FXML
    Button btnPreSem2;

    @FXML
    Button btnPreSem3;

    @FXML
    Button btnPreSem4;

    @FXML
    Button btnSem1;

    @FXML
    Button btnSem2;

    @FXML
    Button btnFinal;


    private int trialID;
    private ArrayList<Match> matches;

    TrialMatchesViewModel trialMatchesViewModel = new TrialMatchesViewModel();

    public void setLblTitle(String id){
        this.lblTitle.setText("Matches for Trial " + id);
    }

    public void setTrialID(int trialID){
        this.trialID = trialID;
    }

    public void showMatches(){
        matches = trialMatchesViewModel.showMatches(trialID);
        int poz = 1;
        for(Match m : matches){
            System.out.println(m.toString());
            StringBuilder stringBuilder = new StringBuilder();
            if(m.getIdPlayer1() != 0){
                stringBuilder.append(UserPersistence.getUserName(m.getIdPlayer1()) + " |VS| ");
            }else stringBuilder.append("NAN |VS| ");

            if(m.getIdPlayer2() != 0){
                stringBuilder.append(UserPersistence.getUserName(m.getIdPlayer2()));
            }else stringBuilder.append("NAN");

            switch (m.getId()) {
                case 1:
                    btnS1.setText(String.valueOf(stringBuilder));
                    break;

                case 2:
                    btnS2.setText(String.valueOf(stringBuilder));
                    break;

                case 3:
                    btnS3.setText(String.valueOf(stringBuilder));
                    break;

                case 4:
                    btnS4.setText(String.valueOf(stringBuilder));
                    break;

                case 5:
                    btnS5.setText(String.valueOf(stringBuilder));
                    break;

                case 6:
                    btnS6.setText(String.valueOf(stringBuilder));
                    break;

                case 7:
                    btnS7.setText(String.valueOf(stringBuilder));
                    break;

                case 8:
                    btnS8.setText(String.valueOf(stringBuilder));
                    break;

                case 9:
                    btnPreSem1.setText(String.valueOf(stringBuilder));
                    break;

                case 10:
                    btnPreSem2.setText(String.valueOf(stringBuilder));
                    break;

                case 11:
                    btnPreSem3.setText(String.valueOf(stringBuilder));
                    break;

                case 12:
                    btnPreSem4.setText(String.valueOf(stringBuilder));
                    break;

                case 13:
                    btnSem1.setText(String.valueOf(stringBuilder));
                    break;

                case 14:
                    btnSem2.setText(String.valueOf(stringBuilder));
                    break;

                case 15:
                    btnFinal.setText(String.valueOf(stringBuilder));
                    break;
            }
        }

    }

    public void backButton(javafx.event.ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TrialMatchesViewModel.class.getResource("/View/TrialSignUp.fxml"));
        Parent parent = fxmlLoader.load();
        Scene scene = new Scene(parent);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    }

    public void matchScore(javafx.event.ActionEvent event) throws IOException {

        Button button = (Button)event.getSource();
        String[] split = button.getText().split(" \\|VS\\| ");
        String player1Name = split[0];
        String player2Name = split[1];

        if(FoundMatchScore.executeFindScore(player1Name, player2Name) == 0){
            CreateDataBaseNTables.OptionalMatchScoreInsert(FoundMatchScore.executeFound(player1Name, player2Name));
        }

        FXMLLoader fxmlLoader = new FXMLLoader(TrialMatchesView.class.getResource("/View/MatchScoreViewOnly.fxml"));
        Parent parent = fxmlLoader.load();
        Scene scene = new Scene(parent);
        MatchScoreViewOnlyView matchScoreViewOnlyView = fxmlLoader.getController();
        matchScoreViewOnlyView.setLblPlayer1(player1Name);
        matchScoreViewOnlyView.setLblPlayer2(player2Name);
        matchScoreViewOnlyView.setMatchId(FoundMatchScore.executeFound(player1Name, player2Name));
        matchScoreViewOnlyView.setTrialId(trialID);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    }

}
