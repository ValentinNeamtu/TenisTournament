package ViewModel.Commands;

import Model.Tenismen;
import Model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.collections.ObservableList;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.io.IOException;
import java.util.ArrayList;



public class SaveFilterButton {
    public void execute(ObservableList<User> users) throws IOException {
        /**
         * GSON FILE CREATION
         */
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String FILE_Name_GSON = "saves/filteredData.json";

        ArrayList<Tenismen> tenismen = new ArrayList<>();

        for(User u : users){
            tenismen.add((Tenismen) u);
        }

        try(FileWriter writer = new FileWriter(FILE_Name_GSON)){
            gson.toJson(tenismen, writer);
        }catch (IOException e){
            e.printStackTrace();
        }

        /**
         * CSV FILE CREATOR
         */

        String FILE_Name_CSV = "saves/filteredData.csv";

        File file = new File(FILE_Name_CSV);
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        bufferedWriter.write("FullName, ID, email, age");
        bufferedWriter.newLine();

        for(Tenismen t : tenismen){
            bufferedWriter.write(t.getFullName() + ", " + t.getID() + ", "+
                                 t.getEmail() + ", " + t.getAge());
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        fileWriter.close();

        /**
         * XML FILE CREATOR
         */

        XMLEncoder encoder = new XMLEncoder(
                new BufferedOutputStream(
                        new FileOutputStream("saves/filteredData.xml")
                )
        );

        encoder.writeObject(tenismen);
        encoder.close();

        /**
         * txtFile CREATOR
         */

        try{
            FileWriter  writer = new FileWriter("saves/filteredData.txt");
            BufferedWriter bufferedWriter1 = new BufferedWriter(writer);

            for(Tenismen t : tenismen){
                bufferedWriter1.write(t.getFullName() + " , id = " + t.getID());
                bufferedWriter1.newLine();
            }

            bufferedWriter1.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
