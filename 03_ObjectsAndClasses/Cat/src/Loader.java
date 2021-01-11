public class Loader {
    public static void main(String[] args) {
        Cat Mashka = new Cat();
        System.out.println("Mashka weight: " + Mashka.getWeight());
        Cat Barsik = new Cat();
        System.out.println("Barsik weight: " + Barsik.getWeight());
        Cat Murka = new Cat();
        System.out.println("Murka weight: " + Murka.getWeight());
        Cat Vasya = new Cat();
        System.out.println("Vasya weight: " + Vasya.getWeight());

        ///создаем котов используя константы ENUM
        Cat cat1 = new Cat("Pufik", Colors.BLACK);
        System.out.println(cat1.getName() + " weight: " + cat1.getWeight() + ", color: " + cat1.catColors);
        Cat cat2 = new Cat("Garfield", Colors.RED);
        System.out.println(cat2.getName() + " weight: " + cat2.getWeight() + ", color: " + cat2.catColors);
        Cat cat3 = new Cat("Jackie", Colors.BROWN);
        System.out.println(cat3.getName() + " weight: " + cat3.getWeight() + ", color: " + cat3.catColors);
        Cat cat4 = new Cat("Dorian", Colors.GREY);
        System.out.println(cat4.getName() + " weight: " + cat4.getWeight() + ", color: " + cat4.catColors);

        System.out.println("Cats count is: " + Cat.getCount());


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

        ///применяем метод FEED & MEOW в циклах до статуса EXPLODED & DEAD
        while (Vasya.getWeight() >= Cat.MIN_WEIGHT || Vasya.getWeight() <= Cat.MAX_WEIGHT) {
            System.out.println("Vasya weight: " + Vasya.getWeight());
            Vasya.feed();
            if (Vasya.getWeight() < Cat.MIN_WEIGHT || Vasya.getWeight() > Cat.MAX_WEIGHT) {
                System.out.println("Vasya: " + Vasya.getStatus());
                /// количество еды которую сьел кот
                System.out.println("Vasya feed weight: " + Vasya.getFeedDrinkWeight());
                break;
            }
        }
        while (Murka.getWeight() >= Cat.MIN_WEIGHT || Murka.getWeight() <= Cat.MAX_WEIGHT) {
            System.out.println("Murka weight: " + Murka.getWeight());
            Murka.meow();
            if (Murka.getWeight() < Cat.MIN_WEIGHT || Murka.getWeight() > Cat.MAX_WEIGHT) {
                System.out.println("Murka: " + Murka.getStatus());
                break;
            }
        }
        Murka.pee();
        System.out.println("Murka weight: " + Murka.getWeight());
        Murka.pee();
        System.out.println("Murka weight: " + Murka.getWeight());

        ///КОЛИЧЕСТВО обьектов и их глаз
        System.out.println("Cats count is: " + Cat.getCount() + " , eyes count is: " + Cat.getEyeCount());
    }
}