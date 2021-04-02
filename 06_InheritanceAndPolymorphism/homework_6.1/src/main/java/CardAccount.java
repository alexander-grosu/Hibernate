public class CardAccount extends BankAccount {
   private static final double ONE_PERCENT = 0.01;

    public CardAccount(){
        super();
    }

    public CardAccount(double count){
        super(count);
    }

    @Override
    public boolean take(double amountToTake) {
            super.take(amountToTake + amountToTake * ONE_PERCENT);
            return true;
    }
}