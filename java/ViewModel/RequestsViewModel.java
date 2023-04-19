package ViewModel;

import Model.Request;
import ViewModel.Commands.AcceptRequest;
import ViewModel.Commands.RejectRequest;
import ViewModel.Commands.RequestsBackToOrganizerButton;
import ViewModel.Commands.ShowRequestsButton;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class RequestsViewModel {

    private Request selectedRequest;

    RequestsBackToOrganizerButton requestsBackToOrganizerButton = new RequestsBackToOrganizerButton();
    ShowRequestsButton showRequestsButton = new ShowRequestsButton();
    RejectRequest rejectRequest = new RejectRequest();
    AcceptRequest acceptRequest = new AcceptRequest();

    public ObservableList<Request> showRequestsButton(){
        return showRequestsButton.execute();
    }

    public void rejectRequest(){
        rejectRequest.execute(selectedRequest);
    }

    public void acceptRequest(){
        acceptRequest.execute(selectedRequest);
    }

    public void setSelectedRequest(Request selectedRequest) {
        this.selectedRequest = selectedRequest;
    }
}
