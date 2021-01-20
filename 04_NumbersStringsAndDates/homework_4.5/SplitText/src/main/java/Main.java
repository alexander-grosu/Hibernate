public class Main {

    public static void main(String[] args) {

    }

    public static String splitTextInToWords(String text) {
        
        return text.replaceAll("[^a-zA-Z\\s\\-\\’]", "").replaceAll("\\-","\n").replaceAll("\\s+", "\n");
    }

}