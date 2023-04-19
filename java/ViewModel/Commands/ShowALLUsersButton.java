package ViewModel.Commands;

import Model.Persistence.UserPersistence;
import Model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class ShowALLUsersButton {
    public ObservableList<User> execute(){
        ArrayList<User> users = new ArrayList<>();
        users = UserPersistence.SelectAllUsersWithPassword();
        return FXCollections.observableList(users);
    }
}
