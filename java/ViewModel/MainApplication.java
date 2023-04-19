package ViewModel;

import Model.Persistence.CreateDataBaseNTables;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class MainApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/MainApplication.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Tournaments of Tenis");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){
        CreateDataBaseNTables.CreateDataBase();
        CreateDataBaseNTables.CreateUsersTabel();
        CreateDataBaseNTables.CreateTrials();
        CreateDataBaseNTables.CreateUsersToTrialseTable();
        CreateDataBaseNTables.CreateTenismenRequest();
        CreateDataBaseNTables.CreateUserToEmail();
        CreateDataBaseNTables.CreateTrialToMatch();
        CreateDataBaseNTables.CreateMatchScore();

        CreateDataBaseNTables.MandatoryInserts();
        launch(args);
    }

}

