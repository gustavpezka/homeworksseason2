package homeworks2_2;

public class MyArrayDataException extends NumberFormatException{

    public MyArrayDataException(int cell1, int cell2){
        super(String.format("Exception: Wrong data type in cell: %d - %d, foo!", cell1, cell2));
    }
}
