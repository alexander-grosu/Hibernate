public class IndividualBusinessman extends Client {

    public IndividualBusinessman(){
        super();
    }

    public IndividualBusinessman(double count){
        super(count);
    }

    @Override
    public void put(double amountToPut) {
        if (amountToPut > 0 && amountToPut < 1000.0) {
            super.put(amountToPut - amountToPut * ONE_PERCENT);
        }

        if (amountToPut >= 1000.0) {
            super.put(amountToPut - amountToPut * HALF_PERCENT);
        }
    }
}