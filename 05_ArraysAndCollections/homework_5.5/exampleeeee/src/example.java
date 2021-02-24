import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class example {

    public static void main(String[] args) {
        String deals;
        String nameOfDeal;
        int indexDeal;
        System.out.println("\nВыберите действие, введите HELP");
        Scanner scanner = new Scanner(System.in);
        deals = scanner.nextLine();
        List<String> toDoList = new ArrayList<>();

        while (true) {
            if (!(deals.equals("ADD") || deals.equals("HELP")|| deals.equals("CLEAR") || deals.equals("ADD INDEX") || deals.equals("EXIT") || deals.equals("EDIT") || deals.equals("LIST") || deals.equals("DELETE"))) {
                System.out.println("Ошибка! Введите команду правильно: HELP, ADD, ADD INDEX, DELETE, EDIT, LIST, CLEAR or EXIT ");
                deals = scanner.nextLine();

            } else if (deals.equals("HELP")) {
                System.out.println("Выберите действие и введите одну из комманд: " +
                        "\n\t ADD - чтобы добавить новое дело в (конец списка) " +
                        "\n\t ADD INDEX - чтобы добавить дело по индексу " +
                        "\n\t EDIT - чтобы заменить старое дело  на новое дело по индексу " +
                        "\n\t DELETE - чтобы удалить дело по индексу " +
                        "\n\t LIST - чтобы увидеть список дел  " +
                        "\n\t CLEAR - чтобы удалить весь список " +
                        "\n\t EXIT - чтобы выйти " +
                        "\n\t ! *** index равен номеру дела минус 1 ");
                deals = scanner.nextLine();

            } else if (deals.equals("ADD")) {
                System.out.println("Введите название дела: ");
                Scanner scanner1 = new Scanner(System.in);
                nameOfDeal = scanner1.nextLine();
                toDoList.add(nameOfDeal);
                System.out.println("Введите команду: HELP, ADD, LIST or EXIT ");
                deals = scanner.nextLine();
                
            } else if (deals.equals("ADD INDEX")) {
                int size2 = toDoList.size() - 1;
                Scanner scanner2 = new Scanner(System.in);
                System.out.println("Введите название нового дела: ");
                nameOfDeal = scanner2.nextLine();
                System.out.println("Введите индекс дела от 0 до " + size2);
                indexDeal = scanner2.nextInt();
                if (indexDeal > size2) {
                    System.out.println("Ошибка! Такого индекса нет, попробуйте снова.");
                } else {
                    toDoList.add(indexDeal, nameOfDeal);
                    System.out.println("Введите команду: HELP, ADD, ADD INDEX, LIST or EXIT ");
                    deals = scanner.nextLine();
                }

            } else if (deals.equals("CLEAR")) {
                if (toDoList.size() <= 0) {
                    System.out.println("Список пуст! Введите команду: HELP or EXIT ");
                    deals = scanner.nextLine();
                } else {
                    toDoList.clear();
                    System.out.println("Список удален! Введите команду: HELP or EXIT ");
                    deals = scanner.nextLine();
                }

            } else if (deals.equals("EDIT")) {
                if (toDoList.size() <= 0) {
                    System.out.println("Список пуст! Введите команду: HELP, ADD or EXIT ");
                    deals = scanner.nextLine();
                } else {
                    int size2 = toDoList.size() - 1;
                    Scanner scanner3 = new Scanner(System.in);
                    System.out.println("Введите название нового дела: ");
                    nameOfDeal = scanner3.nextLine();
                    System.out.println("Введите индекс дела от 0 до " + size2);
                    indexDeal = scanner3.nextInt();
                    if (indexDeal > size2) {
                        System.out.println("Ошибка! Такого индекса нет, попробуйте снова.");
                    } else {
                        toDoList.set(indexDeal, nameOfDeal);
                        System.out.println("Введите команду: HELP, EDIT, LIST or EXIT ");
                        deals = scanner.nextLine();
                    }
                }

            } else if (deals.equals("DELETE")) {
                int size2 = toDoList.size() - 1;
                if (toDoList.size() <= 0) {
                    System.out.println("Список пуст! Введите команду: HELP, ADD or EXIT ");
                    deals = scanner.nextLine();
                } else {
                    System.out.println("Введите индекс дела от 0 до " + size2);
                    Scanner scanner4 = new Scanner(System.in);
                    indexDeal = scanner4.nextInt();
                    int number = indexDeal +1;
                    if (indexDeal > size2) {
                        System.out.println("Ошибка!");
                    } else {
                        toDoList.remove(indexDeal);
                        System.out.println("Дело №" + number + " успешно удалено! введите HELP, LIST or EXIT");
                        deals = scanner.nextLine();
                    }
                }

            } else if (deals.equals("LIST")) {
                if (toDoList.size() <= 0) {
                    System.out.println("Список пуст! Введите команду: HELP, ADD or EXIT");
                    deals = scanner.nextLine();
                } else {
                    int serialNumber = 0;
                    for (String elementList : toDoList) {
                        serialNumber++;
                        System.out.println("№ " + serialNumber + "  " + elementList);
                    }
                    System.out.println("\nВведите команду: HELP or EXIT ");
                    deals = scanner.nextLine();
                }

            } else if (deals.equals("EXIT")) {
                System.out.println("РАБОТА ПРОГРАММЫ ЗАВЕРШЕНА");
                break;
            }
        }
    }
}