
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
    }
}
