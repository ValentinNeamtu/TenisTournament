package View;

import ViewModel.MainApplicationViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class MainApplicationView {
    @FXML
    TextField txtID;

    @FXML
    TextField txtPassword;

    MainApplicationViewModel mainApplicationViewModel = new MainApplicationViewModel();

    public void loginButton(javafx.event.ActionEvent event) throws IOException {
        mainApplicationViewModel.setTxtID(txtID.getText());
        mainApplicationViewModel.setTxtPassword(txtPassword.getText());
        mainApplicationViewModel.loginButton(event);
    }

    public void trialsListButton(javafx.event.ActionEvent event) throws IOException {
        mainApplicationViewModel.trialsListButton(event);
    }

}
