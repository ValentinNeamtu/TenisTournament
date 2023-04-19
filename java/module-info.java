module com.example.tema2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.google.gson;
    requires  org.apache.commons.csv;
    requires java.desktop;
    //requires java.mail;


    opens ViewModel to javafx.fxml;
    exports ViewModel;
    opens Model to javafx.fxml, com.google.gson;
    exports  Model;
    exports View;
    opens View to javafx.fxml;


}