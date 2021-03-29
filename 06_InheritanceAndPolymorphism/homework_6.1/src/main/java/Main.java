import java.util.Scanner;
import java.util.regex.Pattern;

import static java.lang.Double.parseDouble;

public class Main {

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        BankAccount bankAccount1 = new BankAccount();

        String takeRegEx = "^TAKE\\s\\d+\\.?\\d*$";
        String putRegEx = "^PUT\\s\\d+\\.?\\d*$";
        String sendRegEx = "^SEND([a-z]{1,10}[A-Z]{1}[a-z]{1,10}|[a-z]{1,20})\\s\\d+\\.?\\d*$";
        String countRegEx = "^COUNT$";
        String exitRegEx = "^EXIT$";
        String helpRegEx = "^HELP$";
        System.out.println("чтобы увидеть список команд введите HELP");

        Scanner scnnr = new Scanner(System.in);
        String command = scnnr.nextLine();

        while (true) {

            if (Pattern.compile(takeRegEx).matcher(command).matches()) {
                //код
                String str = takeRegEx.replaceAll("^TAKE\\s", "");
                double num = parseDouble(str);
                bankAccount.take(num);
                command = scnnr.nextLine();

            } else if (Pattern.compile(sendRegEx).matcher(command).matches()) {
                //код
                String name = sendRegEx.replaceAll("^SEND", "").replaceAll("\\s\\d+\\.?\\d*$", "");
                String str = sendRegEx.replaceAll("^SEND([a-z]{1,10}[A-Z]{1}[a-z]{1,10}|[a-z]{1,20})\\s", "");
                double num = Double.parseDouble(str);
                //bankAccount.send(name, num);
                command = scnnr.nextLine();

            } else if (Pattern.compile(putRegEx).matcher(command).matches()) {
                String str = putRegEx.replaceAll("^PUT\\s", "");
                double num = Double.parseDouble(str);
                bankAccount.put(num);
                command = scnnr.nextLine();

            } else if (Pattern.compile(countRegEx).matcher(command).matches()) {
                bankAccount.getAmount();
                command = scnnr.nextLine();

            } else if (Pattern.compile(helpRegEx).matcher(command).matches()) {
                System.out.println("COUNT ->  проверь сколько денег на счете \n" +
                        "PUT + double ->  пополнить счет \n" +
                        "TAKE + double ->  снять деньги со счета \n" +
                        "SEND name double ->  перевод денег на другой счет \n" +
                        "EXIT ->  завершение работы");
                command = scnnr.nextLine();

            } else if (Pattern.compile(exitRegEx).matcher(command).matches()) {
                System.out.println("работа программы завершена");
                break;

            } else {
                System.out.println("команда введена некорректно");
            }
        }
    }
}