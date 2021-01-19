public class Main {

    public static void main(String[] args) {

    }

    public static String splitTextInToWords(String text) {
        //TODO реализуйте метод
        ///первый вариант я сделал еще длинее, 6 раз replace - \\d=""  \\s\\s=" "  \\;=""  \\.=""  \\-=""  \\s="\n" и получилась длиная строка но верная, тесты правельные были
        return text.replaceAll("[^a-zA-Z\\s\\-\\’]", "").replaceAll("\\-","\n").replaceAll("\\s+", "\n");
    }

}