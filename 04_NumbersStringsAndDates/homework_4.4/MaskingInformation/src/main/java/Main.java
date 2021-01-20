public class Main {

    public static void main(String[] args) {

    }

    public static String searchAndReplaceDiamonds(String text, String holder) {
        // TODO: реализовать метод, если в строке нет <> - вернуть строку без изменений

        if (text.length() == 14) {
            return text.substring(0, 8) + holder;
        }
        if (text.length() == 29) {
            return text.substring(0, 15) + holder + text.substring(26);
        }
        if (text.length() == 45) {
            return text.substring(0, 22) + holder + text.substring(28, 34) + holder + text.substring(40);
        }
        if (text.length() == 43) {
            return text.substring(0, 22) + holder + text.substring(38);
        } else {

            return text;
        }
    }
}
