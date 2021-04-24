public class CustomerEmptyListException extends Exception {

    @Override
    public String getMessage() {
        return "Customer list is empty";
    }
}
