package ViewModel;

import Model.Trial;
import ViewModel.Commands.ShowTrialMatchesButton;
import ViewModel.Commands.ShowTrialsButton;
import ViewModel.Commands.TrialsSignUpButton;
import javafx.collections.ObservableList;

import java.io.IOException;

public class TrialSignUpViewModel {

    private String txtName;
    private String txtAge;
    private String txtEmail;

    private ObservableList<Trial> trials;
    private Trial selectedTrial;
    private int idTrial;

    ShowTrialsButton showTrialsButton = new ShowTrialsButton();
    TrialsSignUpButton trialsSignUpButton = new TrialsSignUpButton();
    ShowTrialMatchesButton showTrialMatchesButton = new ShowTrialMatchesButton();

    public ObservableList<Trial> showTournamentsButton(){

        return showTrialsButton.execute();
    }

    public void signUpButton(){
        trialsSignUpButton.execute(txtName, txtAge, txtEmail, selectedTrial);
    }

    public void setTxtName(String txtName) {
        this.txtName = txtName;
    }

    public void setTxtAge(String txtAge) {
        this.txtAge = txtAge;
    }

    public void setTxtEmail(String txtEmail) {
        this.txtEmail = txtEmail;
    }

    public void setTrials(ObservableList<Trial> trials) {
        this.trials = trials;
    }

    public void setIdTrial(int id){
        this.idTrial = id;
    }

    public void setSelectedTrial(Trial selectedTrial) {
        this.selectedTrial = selectedTrial;
    }

    public void showTrialMatches(javafx.event.ActionEvent event) throws IOException {
        showTrialMatchesButton.execute(event, idTrial);
    }
}
