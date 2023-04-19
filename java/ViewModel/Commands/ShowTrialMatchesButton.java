package ViewModel.Commands;

import View.TrialMatchesView;
import ViewModel.TrialSignUpViewModel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ShowTrialMatchesButton {
    public void execute(javafx.event.ActionEvent event, int id) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TrialSignUpViewModel.class.getResource("/View/TrialMatches.fxml"));
        Parent parent = fxmlLoader.load();
        Scene scene = new Scene(parent);
        TrialMatchesView trialMatchesView = fxmlLoader.getController();
        trialMatchesView.setTrialID(id);
        trialMatchesView.setLblTitle(String.valueOf(id));
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setUserData(id);
        appStage.setScene(scene);
        appStage.show();
    }

}
