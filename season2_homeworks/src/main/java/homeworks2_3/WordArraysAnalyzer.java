
package homeworks2_3;

import java.util.HashMap;
import java.util.Map;

public class WordArraysAnalyzer {
    private HashMap<String, Integer> map = new HashMap<>();

    public void findSimilar(String[] array){

        for (String s : array) {
            map.put(s, 0);
        }

        for (String word:array) {
            for (Map.Entry<String,Integer> entry : map.entrySet()){
                if (entry.getKey().equals(word)){
                    entry.getValue();
                    entry.setValue(entry.getValue() + 1);
                }
            }
        }

        map.forEach((key,value) -> System.out.println("Word: " + key + " is in array " + value + " times"));
    }
}
