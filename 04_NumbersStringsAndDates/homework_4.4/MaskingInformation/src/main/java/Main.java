public class Main {

    public static void main(String[] args) {


    }
        public static String searchAndReplaceDiamonds (String text, String holder){
            // TODO: реализовать метод, если в строке нет <> - вернуть строку без изменений

            return text.replaceAll("<[0-9].+?>", holder);
        }

    }
