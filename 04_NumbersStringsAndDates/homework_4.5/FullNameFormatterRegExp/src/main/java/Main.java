import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }
            //TODO:напишите ваш код тут, результат вывести в консоль.
            //При невалидном ФИО вывести в консоль: Введенная строка не является ФИО

            Pattern pattern = Pattern.compile("((^[А-Я]{1}[а-я]{1,}\\s[А-Я]{1}[а-я]{1,}\\s[А-Я]{1}[а-я]{1,}$)|(^[А-Я]{1}[а-я]{1,}\\-[А-Я]{1}[а-я]{1,}\\s[А-Я]{1}[а-я]{1,}\\s[А-Я]{1}[а-я]{1,}$))");
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()){

                matcher.group().split("\\s","\n");

                System.out.println(surname);
                System.out.println(name);
                System.out.println(lastname);
            }
            }
        }
    }
}