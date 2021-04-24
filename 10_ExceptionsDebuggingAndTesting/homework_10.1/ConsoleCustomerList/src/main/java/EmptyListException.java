public class EmptyListException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Empty list. Couldn't find customers.";
    }
}
