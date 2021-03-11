public class Main {

    public static void main(String[] args) {

    }

    public static String searchAndReplaceDiamonds(String text, String holder) {
        // TODO: реализовать метод, если в строке нет <> - вернуть строку без изменений

        String result = text;
        int indexOpen = result.indexOf('<');
        int indexClose = result.indexOf('>');

        while (indexOpen > 0 && indexClose > 0) {
            result = result.substring(0, indexOpen) + holder + result.substring(indexClose + 1);
            indexOpen = result.indexOf('<');
            indexClose = result.indexOf('>');
        }
        
        return result;
    }
}