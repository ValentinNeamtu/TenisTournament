package ViewModel.Commands;

import Model.Persistence.RequestPersistance;
import Model.Persistence.TrialsPersistence;
import Model.Request;
import Model.Trial;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;

public class ShowRequestsButton {
    public ObservableList<Request> execute(){
        return FXCollections.observableList(RequestPersistance.SelectAllRequests());
    }
}
