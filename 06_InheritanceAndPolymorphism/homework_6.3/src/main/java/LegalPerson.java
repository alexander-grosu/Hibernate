public class LegalPerson extends Client {

    public LegalPerson() {
        super();
    }

    public LegalPerson(double count) {
        super(count);
    }

    @Override
    public void take(double amountToTake) {
        super.take(amountToTake + amountToTake * ONE_PERCENT);
    }
}