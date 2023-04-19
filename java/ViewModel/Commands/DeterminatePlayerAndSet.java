package ViewModel.Commands;

import java.util.ArrayList;

public class DeterminatePlayerAndSet {
    public ArrayList<Integer> execute(String btnName){//ex of String "btnS1P1"
        ArrayList<Integer> result = new ArrayList<>();
        result.add((int) btnName.charAt(4));
        result.add((int) btnName.charAt(6));
        return  result;
    }
}
