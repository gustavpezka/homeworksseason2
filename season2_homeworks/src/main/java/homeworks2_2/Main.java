
package homeworks2_2;

import java.lang.reflect.Array;

public class Main {
    private static int count;

    public static void main(String[] args) {
        String[][] goodArray = {
                {"2","3","4","9"},
                {"6","3","5","2"},
                {"8","7","3","6"},
                {"5","4","9","1"},
        };

        String[][] badArray = {
                {"2","3","4","9"},
                {"6","3"},
                {"8","7","3","6"},
                {"5","4","9","1"},
        };

        String[][] uglyArray = {
                {"2","3","4","9"},
                {"6","3","5","2"},
                {"U","G","L","Y"},
                {"5","4","9","1"},
        };


        Main main = new Main();
        try {
            //main.methodSum(goodArray);
            main.methodSum(badArray);
            //main.methodSum(uglyArray);
            System.out.println(count);
        }catch (MyArraySizeException ex){
            System.out.println(ex.getMessage());
        }catch (MyArrayDataException ex1){
            System.out.println(ex1.getMessage());
        }
    }

    public void methodSum(String[][] array) throws MyArrayDataException, MyArraySizeException {
        if(array.length != 4){
            throw new MyArraySizeException();
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4){
                throw new MyArraySizeException();
            }
            for (int j = 0; j < array[i].length; j++) {
                try {
                    count += Integer.parseInt(array[i][j]);
                }catch (NumberFormatException e){
                    throw new MyArrayDataException(i,j);
                }
            }
        }
    }
}
