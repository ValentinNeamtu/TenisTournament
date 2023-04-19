package View;

import Model.Match;
import Model.User;
import ViewModel.Commands.OrganizerToRequests;
import ViewModel.OrganizerHomeViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;

public class OrganizerHomeView {

    @FXML
    TextField txtNewAge;

    @FXML
    TextField txtNewAgeZone;

    @FXML
    TextField txtNewTime;

    @FXML
    TextField txtNewName;

    @FXML
    DatePicker dtpckNewDate;

    @FXML
    TextField txtFilterName;

    @FXML
    TextField txtFilterAge;

    @FXML
    TextField txtFilterEmail;

    @FXML
    ListView<Match> lstMatches;

    @FXML
    ListView<User> lstUsers;

    @FXML
    TextField txtDesiredTrial;


    OrganizerHomeViewModel organizerHomeViewModel = new OrganizerHomeViewModel();
    OrganizerToRequests organizerToRequests = new OrganizerToRequests();

    public void organizerLogOutButton(javafx.event.ActionEvent event) throws IOException {
        organizerHomeViewModel.organizerLogOutButton(event);
    }

    public void organizerShowUsers(){
        lstUsers.setItems(organizerHomeViewModel.organizerShowUsers());
    }

    public void organizerShowTrials(){
        lstMatches.setItems(organizerHomeViewModel.organizerShowTrials());
    }

    public void organizerModifyUser(){
        organizerHomeViewModel.setTxtNewAge(txtNewAge.getText());
        organizerHomeViewModel.setTxtNewName(txtNewName.getText());
        organizerHomeViewModel.setSelectedUser(lstUsers.getSelectionModel().getSelectedItem());
        organizerHomeViewModel.organizerModifyUser();
    }

    public void organizerAddTenismen(){
        organizerHomeViewModel.setTxtNewAge(txtNewAge.getText());
        organizerHomeViewModel.setTxtNewName(txtNewName.getText());
        organizerHomeViewModel.organizerAddTenismen();
    }

    public void organizerAddTrial(){
        organizerHomeViewModel.setTxtNewTime(txtNewTime.getText());
        organizerHomeViewModel.setTxtNewAgeZone(txtNewAgeZone.getText());
        organizerHomeViewModel.setDtpckNewDate(dtpckNewDate.getValue().toString());
        organizerHomeViewModel.OrganizerAddTrial();
    }

    public void organizerDeleteUser(){
        organizerHomeViewModel.setSelectedUser(lstUsers.getSelectionModel().getSelectedItem());
        organizerHomeViewModel.organizerDeleteUser();
    }

    public void organizerDeleteTrial(){
        organizerHomeViewModel.setSelectedMatch(lstMatches.getSelectionModel().getSelectedItem());
        organizerHomeViewModel.organizerDeleteTrial();
    }

    public void organizerRemoveFromTrial(){
        organizerHomeViewModel.setSelectedMatch(lstMatches.getSelectionModel().getSelectedItem());
        organizerHomeViewModel.setSelectedUser(lstUsers.getSelectionModel().getSelectedItem());
        organizerHomeViewModel.organizerRemoveFromTrial();
    }

    public void organizerAddToTrial(){
        organizerHomeViewModel.setSelectedMatch(lstMatches.getSelectionModel().getSelectedItem());
        organizerHomeViewModel.setSelectedUser(lstUsers.getSelectionModel().getSelectedItem());
        organizerHomeViewModel.organizerAddToTrial();
    }

    public void organizerAddRefereeToTrial(){
        organizerHomeViewModel.setSelectedMatch(lstMatches.getSelectionModel().getSelectedItem());
        organizerHomeViewModel.setSelectedUser(lstUsers.getSelectionModel().getSelectedItem());
        organizerHomeViewModel.organizerAddRefereeToTrial();
    }

    public void organizerRemoveRefereeFromTrial(){
        organizerHomeViewModel.setSelectedMatch(lstMatches.getSelectionModel().getSelectedItem());
        organizerHomeViewModel.setSelectedUser(lstUsers.getSelectionModel().getSelectedItem());
        organizerHomeViewModel.organizerRemoveRefereeFromTrial();
    }

    public void organizerToRequests(javafx.event.ActionEvent event) throws IOException {
        organizerToRequests.execute(event);
    }

    public void filterButton(){
        organizerHomeViewModel.setUsers(lstUsers.getItems());
        organizerHomeViewModel.setTxtFilterAge(txtFilterAge.getText());
        organizerHomeViewModel.setTxtFilterEmail(txtFilterEmail.getText());
        organizerHomeViewModel.setTxtFilterName(txtFilterName.getText());
        lstUsers.setItems(organizerHomeViewModel.filterButton());
    }

    public void saveFilter() throws IOException {
        organizerHomeViewModel.setUsers(lstUsers.getItems());
        organizerHomeViewModel.saveFilter();
    }
}
