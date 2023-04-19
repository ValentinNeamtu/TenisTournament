package View;

import Model.User;
import ViewModel.AdminHomeViewModel;
import ViewModel.Commands.SignOutButton;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AdminHomeView {
    @FXML
    TextField txtNewPassword;

    @FXML
    TextField txtNewName;

    @FXML
    TextField txtNewType;

    @FXML
    TextField txtNewAge;

    @FXML
    Label lblTitle;

    @FXML
    ListView<User> lstUsers;

    AdminHomeViewModel adminHomeViewModel = new AdminHomeViewModel();

    SignOutButton signOutButton = new SignOutButton();

    public void adminHomeBackButton(javafx.event.ActionEvent event) throws IOException {
        signOutButton.execute(event);
    }

    public void adminHomeShowUsersButton(){
        lstUsers.setItems(adminHomeViewModel.adminHomeShowUsersButton());
    }

    public void adminHomeCreateNewButton(){
        adminHomeViewModel.setTxtNewAge(txtNewAge.getText());
        adminHomeViewModel.setTxtNewName(txtNewName.getText());
        adminHomeViewModel.setTxtNewPassword(txtNewPassword.getText());
        adminHomeViewModel.setTxtNewType(txtNewType.getText());
        adminHomeViewModel.adminHomeCreateNewButton();
    }

    public void adminHomeDeleteButton(){
        adminHomeViewModel.setSelectedUser(lstUsers.getSelectionModel().getSelectedItem());
        adminHomeViewModel.adminHomeDeleteButton();
    }

    public void adminHomeModifyButton(){
        adminHomeViewModel.setTxtNewAge(txtNewAge.getText());
        adminHomeViewModel.setTxtNewName(txtNewName.getText());
        adminHomeViewModel.setTxtNewPassword(txtNewPassword.getText());
        adminHomeViewModel.setTxtNewType(txtNewType.getText());
        adminHomeViewModel.setSelectedUser(lstUsers.getSelectionModel().getSelectedItem());
        adminHomeViewModel.adminHomeModifyButton();
    }

    public Label getLblTitle(){
        return this.lblTitle;
    }
}
