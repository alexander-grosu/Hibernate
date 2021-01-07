public class Main {

  public static void main(String[] args) {
    Container container = new Container();
    container.count += 7843;
    int sum = sumDigits(7843);
    System.out.println(sum);
  }

  public static int sumDigits(Integer number) {
    String s = Integer.toString(number);
    Integer sum = 0;
    for (int i = 0; i < s.length(); i++) {
      sum += Integer.parseInt(String.valueOf(s.charAt(i)));
    }
    return sum;
  }
}