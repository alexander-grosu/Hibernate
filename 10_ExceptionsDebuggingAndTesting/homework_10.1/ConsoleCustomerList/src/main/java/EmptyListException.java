public class EmptyListException extends IllegalStateException {
    @Override
    public String getMessage() {
        return "Empty list. Couldn't find customers.";
    }
}
