public class Main {

    public static void main(String[] args) {

    }

    public static int calculateSalarySum(String text) {
        //TODO: реализуйте метод
        int sum = 0;
        String[] sumText = text.split(",");
        for (int i = 0; i < sumText.length; i++) {
            String sumReplace = sumText[i].replaceAll("[^0-9]", "").trim();
            sum += Integer.parseInt(sumReplace);
        }
        return sum;

    }
}