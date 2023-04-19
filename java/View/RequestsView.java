package View;

import Model.Request;
import ViewModel.Commands.RequestsBackToOrganizerButton;
import ViewModel.RequestsViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class RequestsView {
    @FXML
    Button btnBack;

    @FXML
    Button btnAccept;

    @FXML
    Button btnDecline;

    @FXML
    ListView<Request> lstRequests;

    RequestsBackToOrganizerButton requestsBackToOrganizerButton = new RequestsBackToOrganizerButton();
    RequestsViewModel requestsViewModel = new RequestsViewModel();

    public void backButton(javafx.event.ActionEvent event) throws IOException {
        requestsBackToOrganizerButton.execute(event);
    }

    public void showRequestsButton(){
        lstRequests.setItems(requestsViewModel.showRequestsButton());
    }

    public void rejectRequest(){
        requestsViewModel.setSelectedRequest(lstRequests.getSelectionModel().getSelectedItem());
        requestsViewModel.rejectRequest();
    }

    public void acceptRequest(){
        requestsViewModel.setSelectedRequest(lstRequests.getSelectionModel().getSelectedItem());
        requestsViewModel.acceptRequest();
    }
}
