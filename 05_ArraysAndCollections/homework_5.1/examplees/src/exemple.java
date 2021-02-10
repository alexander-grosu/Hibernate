import java.util.Scanner;
import java.util.TreeSet;

public class exemple {
    public static void main(String[] args) {

        boolean program;


        String[] value = new String[3];
        value[0] = "LIST";
        value[1] = "ADD";
        value[2] = "EXIT";


        TreeSet<String> eMail = new TreeSet<>();


        while (program = true) {
            String scanner = new Scanner(System.in).nextLine().trim();

            String[] operation = scanner.split("\\s+");
            String finishValue = scanner.replaceFirst("\\w\\s+", "");

            if (operation[0].equals(value[0])) {
                for (String item : eMail) {
                    System.out.println(item);
                }
            } else if (operation[0].equals(value[1]) && finishValue.matches("([A-Za-z0-9\\.]+\\@[A-Za-z0-9]+\\.[A-Za-z0-9]+)")) {
                eMail.add(finishValue);
            } else if (operation[0].equals(value[2])) {
                break;
            } else {
                System.out.println("Некорректный ввод");
            }
        }
    }

}