
public class Loader
{
    public static void main(String[] args)
    {
        Cat Mashka = new Cat();
        System.out.println("Mashka weight: " + Mashka.getWeight());
        Cat Barsik = new Cat();
        System.out.println("Barsik weight: " + Barsik.getWeight());
        Cat Murka = new Cat();
        System.out.println("Murka weight: " + Murka.getWeight());
        Cat Vasya = new Cat();
        System.out.println("Vasya weight: " + Vasya.getWeight());

///применяем методы и следим за изменением веса обьектов
        Mashka.drink();
        System.out.println("Mashka weight: " + Mashka.getWeight());
        Barsik.meow();
        System.out.println("Barsik weight: " + Barsik.getWeight());
        Murka.feed();
        System.out.println("Murka weight: " + Murka.getWeight());
///применяем метод PEE следим за весом кошки и узнаем потерянный вес
        Mashka.pee();
        System.out.println("Mashka weight: " + Mashka.getWeight());
        Mashka.pee();
        System.out.println("Mashka weight: " + Mashka.getWeight());
        System.out.println("Mashka lost weight: " + Mashka.getLostWeight());

///применяем метод FEED & MEOW до статуса EXPLODED & DEAD
        double minWeight = 1000;
        double maxWeight = 9000;
        while(Vasya.getWeight() >= minWeight || Vasya.getWeight() <= maxWeight) {
            System.out.println("Vasya weight: " + Vasya.getWeight());
            Vasya.feed();
            if (Vasya.getWeight() < minWeight || Vasya.getWeight() > maxWeight) {
                System.out.println("Vasya: " + Vasya.getStatus());
/// количество еды которую сьел кот
                System.out.println("Vasya feed weight: " + Vasya.getFeedWeight());
                break;
            }
        }
        while(Murka.getWeight() >= minWeight || Murka.getWeight() <= maxWeight) {
            System.out.println("Murka weight: " + Murka.getWeight());
            Murka.meow();
            if (Murka.getWeight() < minWeight || Murka.getWeight() > maxWeight) {
                System.out.println("Murka: " + Murka.getStatus());
                break;
            }
        }

    }
}