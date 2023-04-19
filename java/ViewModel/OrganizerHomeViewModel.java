package ViewModel;

import Model.Match;
import Model.Trial;
import Model.User;
import ViewModel.Commands.*;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.io.IOException;

public class OrganizerHomeViewModel {

    private String txtNewAge;
    private String txtNewAgeZone;
    private String txtNewTime;
    private String txtNewName;
    private String dtpckNewDate;
    private String txtFilterName;
    private String txtFilterAge;
    private String txtFilterEmail;

    User selectedUser;
    Match selectedMatch;
    ObservableList<User> users;
    ObservableList<Match> matches;

    ShowTrialsExtendedALLButton showTrialsExtendedALLButton = new ShowTrialsExtendedALLButton();
    SignOutButton signOutButton = new SignOutButton();
    ShowTenismenAndRefereesButton showTenismenAndRefereesButton = new ShowTenismenAndRefereesButton();
    ModifyUserButton modifyUserButton = new ModifyUserButton();
    DeleteUserButton deleteUserButton = new DeleteUserButton();
    CreateNewUserButton createNewUserButton = new CreateNewUserButton();
    DeleteMatchButton deleteMatchButton = new DeleteMatchButton();
    CreateNewTrialButton createNewTrialButton = new CreateNewTrialButton();
    RemoveTenismenFromMatchButton removeTenismenFromMatchButton = new RemoveTenismenFromMatchButton();
    AddTenismenToMatchButton addTenismenToMatchButton = new AddTenismenToMatchButton();
    AddRefereeToMatchButton addRefereeToMatchButton = new AddRefereeToMatchButton();
    RemoveRefereeFromMatchButton removeRefereeFromMatchButton = new RemoveRefereeFromMatchButton();
    FilterTenismenButton filterTenismenButton = new FilterTenismenButton();
    SaveFilterButton saveFilterButton = new SaveFilterButton();
    ShowMatchesButton showMatchesButton = new ShowMatchesButton();

    public void organizerLogOutButton(javafx.event.ActionEvent event) throws IOException {
        signOutButton.execute(event);
    }

    public ObservableList<User> organizerShowUsers(){
        return showTenismenAndRefereesButton.execute();
    }

    public ObservableList<Match> organizerShowTrials(){
       return showMatchesButton.execute();
    }

    public void organizerModifyUser(){
        if(selectedUser == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("NONE SELECTED");
            alert.setHeaderText("IF YOUN WANT TO MODIFY, SELECT AN USER!");
            alert.showAndWait();
        }else{
            modifyUserButton.execute(txtNewAge, "", txtNewName, "", selectedUser);
        }
    }

    public void organizerDeleteUser(){
        if(selectedUser == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("NONE SELECTED");
            alert.setHeaderText("IF YOUN WANT TO DELETE, SELECT AN USER!");
            alert.showAndWait();
        }else{
            deleteUserButton.execute(selectedUser);
        }

    }

    public void organizerAddTenismen(){
        createNewUserButton.execute("tenismen", txtNewAge, txtNewName, "");
    }

    public void organizerDeleteTrial(){
        if(selectedMatch == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("NONE SELECTED");
            alert.setHeaderText("IF YOUN WANT TO DELETE, SELECT A TRIAL!");
            alert.showAndWait();
        }else {
            deleteMatchButton.execute(selectedMatch);
        }
    }

    public void OrganizerAddTrial(){
        createNewTrialButton.execute(dtpckNewDate, txtNewTime, txtNewAgeZone);
    }

    public void organizerRemoveFromTrial(){
        removeTenismenFromMatchButton.execute(selectedMatch, selectedUser);
    }

    public void organizerAddToTrial(){
       addTenismenToMatchButton.execute(selectedMatch, selectedUser);
    }

    public void organizerAddRefereeToTrial(){
        addRefereeToMatchButton.execute(selectedMatch, selectedUser);
    }

    public void organizerRemoveRefereeFromTrial(){
       removeRefereeFromMatchButton.execute(selectedMatch, selectedUser);
    }

    public ObservableList<User> filterButton(){
        return filterTenismenButton.execute( txtFilterName, txtFilterAge, txtFilterEmail);
    }

    public void saveFilter() throws IOException {
        saveFilterButton.execute(users);
    }

    public void setTxtNewAge(String txtNewAge) {
        this.txtNewAge = txtNewAge;
    }

    public void setTxtNewAgeZone(String txtNewAgeZone) {
        this.txtNewAgeZone = txtNewAgeZone;
    }

    public void setTxtNewTime(String txtNewTime) {
        this.txtNewTime = txtNewTime;
    }

    public void setTxtNewName(String txtNewName) {
        this.txtNewName = txtNewName;
    }

    public void setDtpckNewDate(String dtpckNewDate) {
        this.dtpckNewDate = dtpckNewDate;
    }

    public void setTxtFilterName(String txtFilterName) {
        this.txtFilterName = txtFilterName;
    }

    public void setTxtFilterAge(String txtFilterAge) {
        this.txtFilterAge = txtFilterAge;
    }

    public void setTxtFilterEmail(String txtFilterEmail) {
        this.txtFilterEmail = txtFilterEmail;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }

    public void setSelectedMatch(Match selectedMatch) {
        this.selectedMatch = selectedMatch;
    }

    public void setUsers(ObservableList<User> users) {
        this.users = users;
    }

    public void setMatches(ObservableList<Match> matches) {
        this.matches = matches;
    }
}
