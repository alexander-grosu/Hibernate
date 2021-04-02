import java.util.Calendar;

public class DepositAccount extends BankAccount {
    private Calendar nowTime;
    private Calendar lastIncome;

    public DepositAccount(){
        super();
    }

    public DepositAccount(double count){
        super(count);
    }


    @Override
    public boolean put(double amountToPut) {
        lastIncome = Calendar.getInstance();
        super.put(amountToPut);
        return true;
    }

    @Override
    public boolean take(double amountToTake) {
        nowTime = Calendar.getInstance();
        nowTime.add(Calendar.MONTH, -1);

        if (lastIncome != null && lastIncome.before(nowTime) && amountToTake > 0) {
            super.take(amountToTake);
            return true;
        }
        return false;
    }
}