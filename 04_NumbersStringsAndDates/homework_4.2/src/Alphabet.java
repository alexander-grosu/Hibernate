public class Alphabet {
public static void main (String[] args){
    char ch;

    System.out.println("Latin Alphabet");
    for (ch = 'a'; ch <= 'z'; ch++) {
        System.out.print(ch + " ");
    }
    System.out.println();
    for (ch = 'A'; ch <= 'Z'; ch++) {
        System.out.print(ch + " ");
    }
    System.out.println();
    System.out.println("Russian Alphabet");
    for (ch = 'а'; ch <= 'я'; ch++) {
        System.out.print(ch + " ");
    }
    System.out.println();
    for (ch = 'А'; ch <= 'Я'; ch++) {
        System.out.print(ch + " ");
    }
    System.out.println();
    System.out.println("Greek Alphabet");
    for (ch = 'α'; ch <= 'ω'; ch++) {
        System.out.print(ch + " ");
    }
    System.out.println();
    for (ch = 'Α'; ch <= 'Ω'; ch++) {
        System.out.print(ch + " ");
    }
    System.out.println();
    System.out.println("Arabic numbers");
    for (ch = '0'; ch <= '9'; ch++) {
        System.out.print(ch + " ");
    }
}
}
