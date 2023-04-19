package View;

import Model.Trial;
import ViewModel.Commands.SignOutButton;
import ViewModel.TrialSignUpViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.List;

public class TrialSignUpView {
    @FXML
    Button btnBack;

    @FXML
    Button btnSignUp;

    @FXML
    TextField txtName;

    @FXML
    Label lblName;

    @FXML
    TextField txtEmail;

    @FXML
    Button btnShowTrials;

    @FXML
    TextField txtAge;

    @FXML
    ListView<Trial> lstTrials;

    SignOutButton signOutButton = new SignOutButton();
    TrialSignUpViewModel trialSignUpViewModel = new TrialSignUpViewModel();

    public void tournamentSignUpBackButton(javafx.event.ActionEvent event) throws IOException {
       signOutButton.execute(event);
    }

    public void showTrialsButton(){
        lstTrials.setItems(trialSignUpViewModel.showTournamentsButton());
    }

    public void signUpButton(){
        trialSignUpViewModel.setTxtAge(txtAge.getText());
        trialSignUpViewModel.setTxtEmail(txtEmail.getText());
        trialSignUpViewModel.setTxtName(txtName.getText());
        trialSignUpViewModel.setSelectedTrial(lstTrials.getSelectionModel().getSelectedItem());
        trialSignUpViewModel.signUpButton();
    }

    public void showTrialMatches(javafx.event.ActionEvent event) throws IOException {
        if(lstTrials.getSelectionModel().getSelectedItem() != null){
            Trial t = lstTrials.getSelectionModel().getSelectedItem();
            trialSignUpViewModel.setIdTrial(t.getId());
            trialSignUpViewModel.showTrialMatches(event);
        }
    }
}
