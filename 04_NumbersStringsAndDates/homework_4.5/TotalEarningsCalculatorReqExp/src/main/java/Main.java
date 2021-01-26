import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String salary;
        salary = "Коля заработал 50000 рублей, Федя - 45800 рубля, а Саша - 23000 рублей";

        System.out.println("Сумма заработка друзей: " + calculateSalarySum(salary) + " руб.");
    }

    public static int calculateSalarySum(String text) {
        //TODO: реализуйте метод
        int sum = 0;
        Matcher m = Pattern.compile("\\d+").matcher(text);
        while (m.find()) {
            sum += Integer.parseInt(m.group());
        }
        return sum;
    }
}