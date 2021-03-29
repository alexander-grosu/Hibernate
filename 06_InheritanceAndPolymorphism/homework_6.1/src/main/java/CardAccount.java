public class CardAccount extends BankAccount {

    @Override
    public void take(double amountToTake) {
        double percent = 0.01;
        double finalPercent = percent * amountToTake;
        if (amountToTake + finalPercent <= count) {
            count -= amountToTake + finalPercent;
        }
    }
}