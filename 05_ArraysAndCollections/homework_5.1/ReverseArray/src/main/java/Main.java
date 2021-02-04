import java.util.Arrays;

public class Main {
    public static void main(String[] args) {


        String line[] = {"Каждый", "охотник", "желает", "знать", "где", "сидит", "фазан"};
        String str = "Samuel Leroy Jackson";
        String[] massive = str.split("\\s+");

        System.out.println(Arrays.toString(ReverseArray.reverse((line))) + "\n" + Arrays.toString(ReverseArray.reverse((massive))));
    }
}
