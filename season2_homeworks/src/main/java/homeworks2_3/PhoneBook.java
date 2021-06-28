
package homeworks2_3;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {
    HashMap<String, String> phoneBook = new HashMap<>();

    public void add(String number, String name){
        phoneBook.put(number, name);
    }

    public ArrayList<String> getNumber(String name){
        ArrayList<String> numbersList = new ArrayList<>();
        for (HashMap.Entry entry : phoneBook.entrySet()){
            if(entry.getValue().equals(name)){
                numbersList.add((String)entry.getKey());
            }
        }
        return numbersList;
    }
}
