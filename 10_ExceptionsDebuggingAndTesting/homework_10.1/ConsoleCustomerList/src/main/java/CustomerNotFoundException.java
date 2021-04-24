public class CustomerNotFoundException extends Exception {

    @Override
    public String getMessage() {
        return "Couldn't find customer";
    }
}
