public class Main {

    public static void main(String[] args) {

        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        //TODO: напишите ваш код, результат вывести в консоль

        String[] parts = text.split("\\s");
        String sum1 = parts[2];
        String sum2 = parts[6];
        String sum3 = parts[11];

        int totalSum = Integer.parseInt(sum1) + Integer.parseInt(sum2) + Integer.parseInt(sum3);

        System.out.println(totalSum);
    }

}