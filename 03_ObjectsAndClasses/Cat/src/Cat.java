public class Cat {
    public double originWeight;
    public double weight;
    public static int count = 0;
    public String name;
    public boolean isDead;

    public static Colors catColors;
    public static final int EYE_COUNT = 2;
    public static final double MIN_WEIGHT = 1_000;
    public static final double MAX_WEIGHT = 9_000;
    private double feedDrinkWeight;
    private double lostWeight;

    public Cat() {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        count++;
    }

    public Cat(String name, Colors catColors) {
        this();
        this.name = name;
        this.catColors = catColors;
    }

    public String getName() {
        return name;
    }

    ///количество глаз обьктов
    public static int getEyeCount() {
        return EYE_COUNT * Cat.count;
    }

    ///количество обьектов
    public static int getCount() {
        return count;
    }

    public void meow() {
        /// условие - если обьект сломался , вышел из строя - мы не можем применять к нему методы, менять его параметры
        if (weight < MIN_WEIGHT || weight > MAX_WEIGHT) {
            isDead = true;
            System.out.println("no Meow");
        } else {
            isDead = false;
            weight = weight - 200;
            lostWeight = lostWeight + 200;
            System.out.println("Meow");
        }
    }

    public void feed() {
        /// условие - если обьект сломался , вышел из строя - мы не можем применять к нему методы, менять его параметры
        if (weight < MIN_WEIGHT || weight > MAX_WEIGHT) {
            isDead = true;
            System.out.println("no Feed");
        } else {
            isDead = false;
            weight = weight + 300;
            feedDrinkWeight = feedDrinkWeight + 300;
            System.out.println("Feed");
        }
    }

    public void drink() {
        /// условие - если обьект сломался , вышел из строя - мы не можем применять к нему методы, менять его параметры
        if (weight < MIN_WEIGHT || weight > MAX_WEIGHT) {
            isDead = true;
            System.out.println("no Drink");
        } else {
            isDead = false;
            weight = weight + 150;
            feedDrinkWeight = feedDrinkWeight + 150;
            System.out.println("Drink");
        }
    }

    public double getWeight() {
        return weight;
    }

    public double getFeedDrinkWeight() {
        return feedDrinkWeight;
    }

    public double getLostWeight() {
        return lostWeight;
    }

    public String getStatus() {
        if (weight < MIN_WEIGHT) {
            ///если вес обьекта становится меньше минимального count--; (число обьектов уменьшается, вышел из строя, умер, сломался)
            Cat.count--;
            return "Dead";
        } else if (weight > MAX_WEIGHT) {
            ///если вес обьекта становится больше максимального count--; (число обьектов уменьшается, вышел из строя, умер, сломался)
            Cat.count--;
            return "Exploded";
        } else if (weight > originWeight) {
            return "Sleeping";
        } else {
            return "Playing";
        }
    }
}