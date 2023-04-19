package ViewModel.Commands;

import ViewModel.TrialSignUpViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SignOutButton{

    public void execute(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(TrialSignUpViewModel.class.getResource("/View/MainApplication.fxml"));
        Parent parent = fxmlLoader.load();
        Scene scene = new Scene(parent);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        appStage.setScene(scene);
        appStage.show();
    }
}
