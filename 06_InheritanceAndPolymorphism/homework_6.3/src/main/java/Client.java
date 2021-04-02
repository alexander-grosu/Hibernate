public abstract class Client {

    private double count;
    public static final double HALF_PERCENT = 0.005;
    public static final double ONE_PERCENT = 0.01;

    public Client() {
        count = 0.0;
    }

    public Client(double count) {
        this.count = count;
    }

    public double getAmount() {
        return count;
    }

    public void put(double amountToPut) {
        if (amountToPut > 0) {
            count += amountToPut;
        }
    }

    public void take(double amountToTake) {
        if (amountToTake <= count && amountToTake > 0) {
            count -= amountToTake;
        }
    }
}