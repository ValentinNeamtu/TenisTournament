package ViewModel.Commands;

import Model.Persistence.UserPersistence;
import Model.User;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;

public class ShowUsersCompressedButton {
    public ToggleGroup execute(VBox VBoxUsers, ScrollPane scrUsers){
        ArrayList<User> users;
        users = UserPersistence.SelectAllUsersWithPassword();

        VBox vbox = new VBox();
        ToggleGroup toggleGroup = new ToggleGroup();
        VBoxUsers = vbox;
        VBoxUsers.setVisible(true);


        for(User u : users){
            ToggleButton b = new ToggleButton();
            b.setText("User ID : " + u.getID() + "\n"+
                    "User full name : " + u.getFullName() + "\n");

            System.out.println(b.getText().toString());

            b.setPrefWidth(scrUsers.getPrefWidth()-20);
            b.setTextAlignment(TextAlignment.CENTER);
            VBox.setMargin(b, new Insets(5,0,5,0));
            b.setToggleGroup(toggleGroup);
            b.setUserData(u);

            VBoxUsers.setVgrow(b, Priority.ALWAYS);
            VBoxUsers.getChildren().add(b);
            System.out.println(b.getText().toString());

        }

        scrUsers.setVisible(true);
        scrUsers.setContent(VBoxUsers);
        return toggleGroup;
    }
}
