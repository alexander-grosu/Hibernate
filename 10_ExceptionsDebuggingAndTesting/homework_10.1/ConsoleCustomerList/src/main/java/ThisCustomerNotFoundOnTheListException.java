public class ThisCustomerNotFoundOnTheListException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Error. Couldn't find customer.";
    }
}
