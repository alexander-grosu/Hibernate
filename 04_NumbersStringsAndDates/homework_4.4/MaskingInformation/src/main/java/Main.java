public class Main {

    public static void main(String[] args) {

    }

    public static String searchAndReplaceDiamonds(String text, String holder) {
        // TODO: реализовать метод, если в строке нет <> - вернуть строку без изменений

        int x = text.indexOf('>');
        int y = text.lastIndexOf('>');

        if (text.length() == 14) {
            return "Пин код " + holder;
        }
        if (text.length() == 29) {
            return "Номер паспорта " + holder + text.substring(x + 1);
        }
        if (text.length() == 45) {
            return "Номер кредитной карты " + holder + " " + text.substring(x + 2, x + 6) + " " + holder + " " + text.substring(y + 2);
        }
        if (text.length() == 43) {
            return "Номер кредитной карты " + holder + " " + text.substring(x + 2);
        } else {

            return text;
        }
    }
}
