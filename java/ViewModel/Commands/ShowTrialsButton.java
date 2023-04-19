package ViewModel.Commands;

import Model.Persistence.TrialsPersistence;
import Model.Trial;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;

public class ShowTrialsButton {
    public ObservableList<Trial> execute(){
        return TrialsPersistence.SelectAllTrials();
    }
}
