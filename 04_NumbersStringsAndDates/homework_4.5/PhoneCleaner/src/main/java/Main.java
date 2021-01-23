
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        boolean result = input.matches("((\\+7|8){1})?(\\s\\(\\d{3}\\)\\s|\\s\\d{3}\\s|\\(\\d{3}\\)|\\d{3}|\\-\\d{3}\\-)(\\d{7}|\\d{3}\\-\\d{2}\\-\\d{2})");
        if (result) {
            System.out.println(input.replaceAll("(8){1}", "7").replaceAll("\\D",""));
        } else {
            System.out.println("Неверный формат номера");
        }
        }
    }

