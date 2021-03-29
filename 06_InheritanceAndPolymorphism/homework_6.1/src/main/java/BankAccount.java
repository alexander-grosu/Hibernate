import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;

public class BankAccount {

    public double count;
    private static Calendar lastIncome;

    public double getAmount() {
        BigDecimal decimalCount = new BigDecimal(count).setScale(2, RoundingMode.HALF_UP);
        System.out.println(decimalCount);
        return count;
    }

    public void put(double amountToPut) {
        if (amountToPut > 0) {
            lastIncome = Calendar.getInstance();
            count += amountToPut;
        }
    }

    public void take(double amountToTake) {
        if (amountToTake <= count) {
            count -= amountToTake;
        }
    }

    boolean send(BankAccount nameReceiver, double amount) {
        if (amount < count) {
            count -= amount;
            nameReceiver.count += amount;
            return true;
        } else {
            return false;
        }
    }

    public Calendar getLastIncome() {
        return lastIncome;
    }
}