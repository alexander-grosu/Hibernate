import java.util.Calendar;

public class DepositAccount extends BankAccount {
    private Calendar nowTime;
    private Calendar lastIncome = super.getLastIncome();


    @Override
    public void take(double amountToTake) {
        nowTime = Calendar.getInstance();
        nowTime.add(Calendar.MONTH, -1);

        if (lastIncome != null && lastIncome.before(nowTime) && amountToTake <= count && amountToTake > 0) {
            count -= amountToTake;
        }
    }
}