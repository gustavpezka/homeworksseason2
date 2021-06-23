
package homeworks2_3;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String[]array = {"uniform", "inevitable", "anticipate", "characteristic", "imminent",
                "critical", "determine", "differentiate", "imminent", "glaring", "hypothesis",
                "imminent", "inevitable", "intuition", "justify", "omit", "relevant", "inevitable",
                "uniform", "trivial",};
        WordArraysAnalyzer analyzer = new WordArraysAnalyzer();
        analyzer.findSimilar(array);

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("01", "Fireman");
        phoneBook.add("02", "Policeman");
        phoneBook.add("03", "Medicman");
        phoneBook.add("04", "Gasman");
        phoneBook.add("012", "Fireman");
        phoneBook.add("013", "Fireman");
        phoneBook.add("014", "Policeman");

        System.out.println(phoneBook.getNumber("Fireman"));
    }
}
