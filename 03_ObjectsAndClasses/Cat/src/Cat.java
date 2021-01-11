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
    private double peeLostWeight;

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
        if (weight < MIN_WEIGHT || weight > MAX_WEIGHT) {
            isDead = true;
            System.out.println("no Meow");
        } else {
            isDead = false;
            weight = weight - 200;
            System.out.println("Meow");
        }
    }

    public void feed() {
        if (weight < MIN_WEIGHT || weight > MAX_WEIGHT) {
            isDead = true;
            System.out.println("no Feed");
        } else {
            isDead = false;
            weight = weight - 70;
            weight = weight + 300;
            feedDrinkWeight = feedDrinkWeight + 300;
            System.out.println("Feed");
        }
    }

    public void drink() {
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

    public void pee() {
        if (weight < MIN_WEIGHT || weight > MAX_WEIGHT) {
            isDead = true;
            System.out.println("no Pee");
        } else {
            isDead = false;
            weight = weight - 70;
            peeLostWeight = peeLostWeight + 70;
            System.out.println("Pee");
        }
    }

    public double getWeight() {
        return weight;
    }

    public double getFeedDrinkWeight() {
        return feedDrinkWeight;
    }

    public double getLostWeight() {
        return peeLostWeight;
    }

    public String getStatus() {
        if (weight < MIN_WEIGHT) {
            Cat.count--;
            return "Dead";
        } else if (weight > MAX_WEIGHT) {
            Cat.count--;
            return "Exploded";
        } else if (weight > originWeight) {
            return "Sleeping";
        } else {
            return "Playing";
        }
    }
}