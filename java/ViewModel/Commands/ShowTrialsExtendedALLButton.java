package ViewModel.Commands;

import Model.Persistence.TrialsPersistence;
import Model.Trial;
import javafx.collections.ObservableList;

public class ShowTrialsExtendedALLButton {
    public ObservableList<Trial> execute(){
        ObservableList<Trial> trials = TrialsPersistence.SelectAllTrials();
        return  trials;
    }
}
