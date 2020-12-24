public class Cat
{
    public static String catCopy;
    public double originWeight;
    public double weight;
    public static int count = 0;
    public String name;

    public static Colors catColors;
    public static final int EYE_COUNT = 2;
    public static final double MIN_WEIGHT = 1_000;
    public static final double MAX_WEIGHT = 9_000;
    private double feedDrinkWeight;
    private double peeLostWeight;

    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        count ++;
    }

    public static Cat catCopy (Cat cat1)
    {
        Cat cat = new Cat();
        cat.weight = cat1.weight;
        cat.catColors = cat1.catColors;
        return cat;
    }

    public Cat catCopy() {
        return Cat.catCopy(this);
    }

    public Cat (String name,Colors catColors) {
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

    /// CAT COLORS SETTER & GETTER
    public void setColorCat(Colors catColors){
        this.catColors = catColors;
    }

    public Colors getColorCat() {
        return catColors;
    }
    /// setter для веса
    public void setWeight (double weight) {
        this.weight = weight;
    }

    public void meow()
    {
        weight = weight - 200;
        System.out.println("Meow");
    }

    public void feed()
    {
        weight = weight + 300; feedDrinkWeight = feedDrinkWeight + 300;
        System.out.println("Feed");
    }

    public void drink()
    {
        weight = weight + 150; feedDrinkWeight = feedDrinkWeight + 150;
        System.out.println("Drink");
    }

    public void pee()
    {
        weight = weight - 70; peeLostWeight = peeLostWeight + 70;
        System.out.println("Pee");
    }

    public double getWeight()
    {
        return weight;
    }

    public double getFeedDrinkWeight() {
        return feedDrinkWeight;
    }

    public double getLostWeight() {
        return peeLostWeight;
    }

    public String getStatus()
    {
        if(weight < MIN_WEIGHT) {
            return "Dead";
        }
        else if(weight > MAX_WEIGHT) {
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }
}