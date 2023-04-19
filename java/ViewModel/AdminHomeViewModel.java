package ViewModel;

import Model.User;
import ViewModel.Commands.*;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.SQLException;

public class AdminHomeViewModel {


    private ObservableList<User> user;
    private User selectedUser;

    private String txtNewType;
    private String txtNewAge;
    private String txtNewName;
    private String txtNewPassword;

    ShowALLUsersButton showALLUsersButton = new ShowALLUsersButton();
    CreateNewUserButton createNewUserButton = new CreateNewUserButton();
    DeleteUserButton deleteUserButton = new DeleteUserButton();
    ModifyUserButton modifyUserButton = new ModifyUserButton();

    public ObservableList<User> adminHomeShowUsersButton(){
        return showALLUsersButton.execute();
    }

    public void adminHomeCreateNewButton(){
        createNewUserButton.execute(txtNewType, txtNewAge, txtNewName, txtNewPassword);
    }

    public void adminHomeDeleteButton(){
        deleteUserButton.execute(selectedUser);
    }

    public void adminHomeModifyButton(){
        modifyUserButton.execute(txtNewAge, txtNewType, txtNewName, txtNewPassword, selectedUser);
    }

    public void setTxtNewType(String txtNewType) {
        this.txtNewType = txtNewType;
    }

    public void setTxtNewAge(String txtNewAge) {
        this.txtNewAge = txtNewAge;
    }

    public void setTxtNewName(String txtNewName) {
        this.txtNewName = txtNewName;
    }

    public void setTxtNewPassword(String txtNewPassword) {
        this.txtNewPassword = txtNewPassword;
    }

    public void setUser(ObservableList<User> user) {
        this.user = user;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }
}
