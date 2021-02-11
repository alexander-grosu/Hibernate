import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //Распечатайте сгенерированный в классе TwoDimensionalArray.java двумерный массив
        char[][] array = new char[5][5];
        System.out.println(Arrays.deepToString(TwoDimensionalArray.getTwoDimensionalArray(array.length)));
    }
}
