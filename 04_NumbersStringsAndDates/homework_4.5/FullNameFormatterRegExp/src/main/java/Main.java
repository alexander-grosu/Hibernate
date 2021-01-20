import java.util.Scanner;

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

            String[] space = input.split(" ");
            if (space.length != 3 ) {
                System.out.println("Введенная строка не является ФИО");
                break;
            }
            String surName = space[0];
            String name = space[1];
            String lastName = space[2];


                System.out.println("Фамилия: " + surName);
                System.out.println("Имя: " + name);
                System.out.println("Отчество: " + lastName);
            }
        }
    }

