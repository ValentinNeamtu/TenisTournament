package ViewModel;

import ViewModel.Commands.LoginButton;
import ViewModel.Commands.TrialsButton;
import ViewModel.Commands.TrialsSignUpButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class MainApplicationViewModel {

    private String txtID;
    private String txtPassword;

    LoginButton loginButton = new LoginButton();
    TrialsButton trialsButton = new TrialsButton();

    public void loginButton(javafx.event.ActionEvent event) throws IOException {
        loginButton.execute(event, txtID, txtPassword);
    }

    public void trialsListButton(javafx.event.ActionEvent event) throws IOException {
        trialsButton.execute(event);
    }


    public String getTxtID() {
        return txtID;
    }

    public void setTxtID(String txtID) {
        this.txtID = txtID;
    }

    public String getTxtPassword() {
        return txtPassword;
    }

    public void setTxtPassword(String txtPassword) {
        this.txtPassword = txtPassword;
    }
}
