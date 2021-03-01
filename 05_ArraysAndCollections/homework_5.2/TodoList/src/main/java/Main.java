import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static String command;
    public static int index;
    public static String name;

    public static void main(String[] args) {
        TodoList todoListExemplar = new TodoList();

        System.out.println("чтобы увидеть список команд введите: HELP");
        command = scanner.nextLine();
        String regexAddIndex = "(^ADD\\s\\d+\\s(\\s?\\-?\\w+)+$)"; //add + index
        String regexList = "(^LIST$)"; //output
        String regexAdd = "(^ADD\\s(\\s?\\-?\\w+)+$)"; //add
        String regexSet = "(^EDIT\\s\\d+\\s(\\s?\\-?\\w+)+$)"; //set or edit + index
        String regexRemove = "(^DELETE\\s\\d+$)";  // delete or remove + index
        String regexClear = "(^CLEAR$)"; // clear
        String regexExit = "(^EXIT$)"; // exit
        String regexHelp = "(^HELP$)"; // help
        String regexSize = "(^SIZE$)"; // size
        String regexSubList = "(^SUBLIST\\s+\\d+\\s+\\d+$)"; // sublist
        String regexContains = "(^CONTAINS\\s+(\\s?\\w+)+$)";

        while (true) {

            if (Pattern.compile(regexAddIndex).matcher(command).matches()) {
                index = Integer.parseInt(command.replaceAll("^ADD\\s", "").replaceAll("\\s(\\s?\\-?\\w+)+$", ""));
                name = command.replaceAll("^ADD\\s\\d+\\s", "");
                todoListExemplar.add(index, name);
                command = scanner.nextLine();

            } else if (Pattern.compile(regexAdd).matcher(command).matches()) {
                name = command.replaceAll("^ADD\\s", "");
                todoListExemplar.add(name);
                command = scanner.nextLine();

            } else if (Pattern.compile(regexRemove).matcher(command).matches()) {
                index = Integer.parseInt(command.replaceAll("^DELETE\\s", ""));
                todoListExemplar.delete(index);
                command = scanner.nextLine();

            } else if (Pattern.compile(regexSet).matcher(command).matches()) {
                index = Integer.parseInt(command.replaceAll("^EDIT\\s", "").replaceAll("\\s(\\s?\\-?\\w+)+$", ""));
                name = command.replaceAll("^EDIT\\s\\d+\\s", "");
                todoListExemplar.edit(name, index);
                command = scanner.nextLine();

            } else if (Pattern.compile(regexList).matcher(command).matches()) {
                todoListExemplar.list();
                command = scanner.nextLine();

            } else if (Pattern.compile(regexHelp).matcher(command).matches()) {
                System.out.println(" ADD + String добавляет новое дело в списке" +
                        "\n ADD + int/index + String добавляет новое дело в список по индексу" +
                        "\n DELETE + int/index удаляет дело из списка по индексу" +
                        "\n CLEAR удаляет весь список" +
                        "\n EDIT + int/index + String заменяет старое дело на новое по индексу" +
                        "\n SIZE выводит размер списка" +
                        "\n LIST выводит список" +
                        "\n CONTAINS + String проверяет если список содержит этот элемент" +
                        "\n SUBLIST + indexFrom + indexTo вывоводит часть списка по индексу" +
                        "\n EXIT выход из программы" +
                        "\n выберите и введите команду:");
                command = scanner.nextLine();

            } else if (Pattern.compile(regexSubList).matcher(command).matches()) {
                int indexFrom = Integer.parseInt(command.replaceAll("^SUBLIST\\s+", "").replaceAll("\\s+\\d+$", ""));
                int indexTo = Integer.parseInt(command.replaceAll("^SUBLIST\\s+\\d+\\s+", ""));
                todoListExemplar.subList(indexFrom, indexTo);
                command = scanner.nextLine();

            } else if (Pattern.compile(regexClear).matcher(command).matches()) {
                todoListExemplar.clearList();
                command = scanner.nextLine();

            } else if (Pattern.compile(regexContains).matcher(command).matches()) {
                name = command.replaceAll("^CONTAINS\\s", "");
                todoListExemplar.listContains(name);
                command = scanner.nextLine();

            } else if (Pattern.compile(regexSize).matcher(command).matches()) {
                todoListExemplar.listSize();
                command = scanner.nextLine();

            } else if (Pattern.compile(regexExit).matcher(command).matches()) {
                System.out.println("работа программы завершена");
                break;

            } else {
                System.out.println("команда введена некорректно");
                command = scanner.nextLine();
            }

        }
    }
}