import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //Распечатайте сгенерированный в классе TwoDimensionalArray.java двумерный массив
        char[][] array = new char[7][7];
        System.out.println(Arrays.deepToString(TwoDimensionalArray.getTwoDimensionalArray(array.length)).replaceAll("\\]\\,\\s\\[","\n").replaceAll("[^X\\s]",""));
        System.out.println(Arrays.deepToString(TwoDimensionalArray.getTwoDimensionalArray(array.length)));
    }

}
