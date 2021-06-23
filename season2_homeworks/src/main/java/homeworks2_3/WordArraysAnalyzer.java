/*1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
        Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
        Посчитать сколько раз встречается каждое слово.

2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий
        и телефонных номеров. В этот телефонный справочник с помощью метода add() можно
        добавлять записи. С помощью метода get() искать номер телефона по фамилии.
        Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
        тогда при запросе такой фамилии должны выводиться все телефоны.
        Желательно как можно меньше добавлять своего, чего нет в задании (т.е. не надо в
        телефонную запись добавлять еще дополнительные поля (имя, отчество, адрес), делать
        взаимодействие с пользователем через консоль и т.д.). Консоль желательно не использовать
        (в том числе Scanner), тестировать просто из метода main() прописывая add() и get().*/

package homeworks2_3;

import java.util.HashMap;
import java.util.Map;

public class WordArraysAnalyzer {
    private HashMap<String, Integer> map = new HashMap<>();

    public void findSimilar(String[] array){

        for (int i = 0; i < array.length; i++) {
            map.put(array[i], 0);
        }

        for (Map.Entry<String,Integer> entry : map.entrySet()) {
            int count = 0;
            for (String word:array) {
                if (entry.getKey().equals(word)){
                    count++;
                }
            }
            entry.setValue(count);
        }
        map.forEach((key,value) -> System.out.println("Word: " + key + " is in array " + value + " times"));
    }
}
