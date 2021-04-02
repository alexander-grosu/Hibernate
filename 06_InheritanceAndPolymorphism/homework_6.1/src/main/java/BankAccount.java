import java.math.BigDecimal;
import java.math.RoundingMode;

public class BankAccount {
    private double count;

    public BankAccount() {
        count = 0.0;
    }

    public BankAccount(double count){
        this.count = count;
    }

    public double getAmount() {
        BigDecimal decimalCount = new BigDecimal(count).setScale(2, RoundingMode.HALF_UP);
        System.out.println("count " + decimalCount);
        return count;
    }

    public boolean put(double amountToPut) {
        if (amountToPut > 0) {
            count += amountToPut;
            return true;
        }
        return false;
    }

    public boolean take(double amountToTake) {
        if (amountToTake <= count) {
            count -= amountToTake;
            return true;
        }
        return false;
    }

    boolean send(BankAccount nameReceiver, double amount) {
        if (amount < count) {
            if (take(amount)) {
                if (nameReceiver.put(amount)) {
                    return true;
                } else {
                    put(amount);
                }
            }
        }
        return false;
    }
}