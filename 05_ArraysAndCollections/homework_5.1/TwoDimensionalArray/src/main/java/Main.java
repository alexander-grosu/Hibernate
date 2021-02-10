import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //Распечатайте сгенерированный в классе TwoDimensionalArray.java двумерный массив
        int [][] array = new int[7][7];
        System.out.println(Arrays.deepToString(TwoDimensionalArray.getTwoDimensionalArray(array.length)));
    }
}
