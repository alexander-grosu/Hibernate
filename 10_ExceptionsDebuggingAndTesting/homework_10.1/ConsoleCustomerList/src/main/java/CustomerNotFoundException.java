import java.util.NoSuchElementException;

public class CustomerNotFoundException extends NoSuchElementException {

    @Override
    public String getMessage() {
        return "Error. Couldn't find customer.";
    }
}
