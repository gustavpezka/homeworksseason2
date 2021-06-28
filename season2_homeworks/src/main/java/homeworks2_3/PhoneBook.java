
package homeworks2_3;

import java.util.HashMap;
import java.util.HashSet;

public class PhoneBook {
    HashMap<String, HashSet<String>> phoneBook = new HashMap<>();

    public void add(String number, String name){
        if (phoneBook.containsKey(name)){
            HashSet<String> numberSet = phoneBook.get(name);
            numberSet.add(number);
            phoneBook.put(name, numberSet);
        }else{
            HashSet<String> numberSet = new HashSet<>();
            numberSet.add(number);
            phoneBook.put(name, numberSet);
        }

    }

    public HashSet<String> getNumber(String name){
        return phoneBook.get(name);
    }
}
