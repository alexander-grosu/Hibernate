public class CustomerNotFoundException extends Exception {

    @Override
    public String getMessage() {
        return "Error. Couldn't find customer";
    }
}
