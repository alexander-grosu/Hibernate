import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int boxesInContainer = 27;
        int containersInTruck = 12;
        int container = 0;
        int truck = 0;
        System.out.println("Введите цифру - количество контейнеров:");
        Scanner scanner = new Scanner(System.in);
        String boxes = scanner.nextLine();

        for (int i = 0; i <= Integer.parseInt(boxes); i++) {
            if (i % (boxesInContainer * containersInTruck) == 0) {
                truck++;
                System.out.println("truck: " + truck);
            }
            if (i % boxesInContainer == 0) {
                container++;
                System.out.println("\n\t\t" + "container: " + container);
            }
            if (i < (Integer.parseInt(boxes))) {
                System.out.println("\n\t\t\t\t" + "boxes: " + i);
            }
        }
    }
}