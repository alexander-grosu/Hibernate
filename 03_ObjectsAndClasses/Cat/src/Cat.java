
public class Cat
{
    private double originWeight;
    private double weight;

    private double minWeight;
    private double maxWeight;
    private double feedWeight;
    private double drinkWeight;
    private double peeLostWeight;

    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;

    }

    public void meow()
    {
        weight = weight - 200;
        System.out.println("Meow");
    }

    public void feed()
    {
        weight = weight = weight + 270; feedWeight = feedWeight + 270;
        System.out.println("Feed");
    }

    public void drink()
    {
        weight = weight + 150; drinkWeight = drinkWeight + 150;
        System.out.println("Drink");
    }

    public void pee()
    {
        weight = weight - 70; peeLostWeight = peeLostWeight + 70;
        System.out.println("Pee");
    }

    public Double getWeight()
    {
        return weight;
    }

    public double getFeedWeight() {
        return feedWeight;
    }

    public double getDrinkWeight() {
        return drinkWeight;
    }

    public double getLostWeight() {
        return peeLostWeight;
    }

    public String getStatus()
    {
        if(weight < minWeight) {
            return "Dead";
        }
        else if(weight > maxWeight) {
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