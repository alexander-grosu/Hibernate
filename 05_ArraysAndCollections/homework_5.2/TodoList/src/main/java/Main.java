import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static ArrayList<String> list = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);
    public static String command;
    public static String number;
    public static String name;

    public static void main(String[] args) {

        System.out.println("чтобы увидеть список команд введите: HELP");
        command = scanner.nextLine();
        String regex1 = "(^ADD\\s\\d+\\s(\\s?\\w+)+$)"; //add + index
        String regex2 = "(^LIST$)"; //output
        String regex3 = "(^ADD\\s(\\s?\\w+)+$)"; //add
        String regex4 = "(^EDIT\\s\\d+\\s(\\s?\\w+)+$)"; //set or edit + index
        String regex5 = "(^DELETE\\s\\d+$)";  // delete or remove + index
        String regex6 = "(^CLEAR$)"; // clear
        String regex7 = "(^EXIT$)"; // exit
        String regex8 = "(^HELP$)"; // help
        String regex9 = "(^SIZE$)"; // size
        String regex10 = "(^SUBLIST\\s+\\d+\\s+\\d+$)"; // sublist
        String regex11 = "(^CONTAINS\\s+(\\s?\\w+)+$)";

        while (true) {
            if (Pattern.compile(regex1).matcher(command).matches()) {  // Add + index
                name = command.replaceAll("ADD\\s\\d+\\s", "");
                number = command.replaceAll("^ADD\\s", "").replaceAll("\\s(\\s?\\w+)+$", "");
                int index = Integer.parseInt(number);
                if (index <= list.size() && 0 <= list.size()) {
                    list.add(index, name);
                    System.out.println("добавлено дело '" + name+"'");
                } else {
                    System.out.println("ошибка! попробуйте снова, введите индекс от 0 до " + list.size());
                }
                command = scanner.nextLine();


            } else if (Pattern.compile(regex10).matcher(command).matches()) {   // subList
                int indexFrom = Integer.parseInt(command.replaceAll("^SUBLIST\\s+", "").replaceAll("\\s+\\d+$", ""));
                int indexTo = Integer.parseInt(command.replaceAll("^SUBLIST\\s+\\d+\\s+", ""));
                if (indexFrom >= 0 && indexTo > indexFrom && indexTo < list.size() || indexFrom > 0 && indexTo > indexFrom && indexTo <= list.size()) {
                    list.subList(indexFrom, indexTo);  // arrayList sublist
                    int i = 0;
                    for (String sublist : list.subList(indexFrom,indexTo)){ //output arrayListSubList elements
                        i++;
                        System.out.println(i + ". " + sublist);
                    }
                } else if (list.isEmpty()) {
                    System.out.println("ошибка, список пуст! введите HELP");
                } else {
                    System.out.println("ошибка, SIZE = " + list.size() + ", введите команду правильно и укажите: " +
                            "\n\t\t indexFrom >= 0 и indexTo > indexFrom && indexTo < SIZE" +
                            "\n\t\t or" +
                            "\n\t\t indexFrom > 0 и indexTo > indexFrom && indexTo <= SIZE");
                }
                command = scanner.nextLine();

            } else if (Pattern.compile(regex2).matcher(command).matches()) {
                if (list.isEmpty()) {
                    System.out.println("список пуст! введите HELP или EXIT");
                } else {
                    int i = 0;
                    for (String element : list) {
                        i++;
                        System.out.println(i +". " + element); // OUTPUT arrayList elements
                    }
                }
                command = scanner.nextLine();

            } else if (Pattern.compile(regex11).matcher(command).matches()) {    // list contains
                String containsElement = command.replaceAll("^CONTAINS\\s","");
                System.out.println("list contains '" + containsElement + "' = " + list.contains(containsElement));
                command = scanner.nextLine();

            } else if (Pattern.compile(regex5).matcher(command).matches()) {
                number = command.replaceAll("^DELETE\\s", "");  // DELETE + INDEX
                int index = Integer.parseInt(number);
                if (index < list.size() && index >= 0 && list.size() > 0) {
                    System.out.println("удалено дело '" + list.get(index)+ "'");
                    list.remove(index);
                } else if (list.isEmpty()) {
                    System.out.println("ошибка! список пуст, введите ADD or HELP");
                } else if (list.size() > 0 && index >= list.size()) {
                    System.out.println("ошибка! list size = " + list.size() + ", введите индекс >= 0 & индекс < size");
                }
                command = scanner.nextLine();

            } else if (Pattern.compile(regex9).matcher(command).matches()) {   // List size
                System.out.println("List size: " + list.size());
                command = scanner.nextLine();

            } else if (Pattern.compile(regex3).matcher(command).matches()) {  // ADD
                name = command.replaceAll("ADD\\s", "");
                list.add(name);
                System.out.println("добавлено дело '" + name + "'");
                command = scanner.nextLine();

            } else if (Pattern.compile(regex6).matcher(command).matches()) {  // CLEAR LIST
                list.clear();
                System.out.println("список дел успешно удален! введите HELP или EXIT");
                command = scanner.nextLine();

            } else if (Pattern.compile(regex8).matcher(command).matches()) {  // Help or Menu
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

            } else if (Pattern.compile(regex7).matcher(command).matches()) {    // EXIT
                System.out.println("Работа программы завершена!");
                break;

            } else if (Pattern.compile(regex4).matcher(command).matches()) {     // SET + INDEX
                name = command.replaceAll("EDIT\\s\\d+\\s", "");
                number = command.replaceAll("^EDIT\\s", "").replaceAll("\\s(\\s?\\w+)+$", "");
                int index = Integer.parseInt(number);
                if (list.size() > 0 && index >= 0 && index < list.size()) {
                    System.out.println("дело '" + list.get(index) + "' -> заменено на: " + name);
                    list.set(index, name);
                } else if (list.isEmpty()) {
                    System.out.println("ошибка! список пуст, введите ADD or HELP");
                } else if (list.size() > 0 && index >= list.size()) {
                    System.out.println("ошибка! size = " + list.size() + " введите индекс >= 0 && индекс < size");
                }
                command = scanner.nextLine();

            } else {
                System.out.println("ошибка! команда введена некорректно, попробуйте снова");
                command = scanner.nextLine();
            }
        }
    }
}