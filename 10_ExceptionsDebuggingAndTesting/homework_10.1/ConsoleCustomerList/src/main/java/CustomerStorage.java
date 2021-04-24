import java.util.HashMap;
import java.util.Map;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        String[] components = data.split("\\s+");
        if (components.length != 4) {
            throw new ArrayIndexOutOfBoundsException("Error. CustomerStorage class, String[] components.length != 4.");
        }
        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
        if (!name.matches("^[А-Я]{1}[а-я]{1,10}\\s+[А-Я]{1}[а-я]{1,10}$")) {
            throw new IllegalArgumentException("Error. incorrect name format.");
        }
        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
        if (!components[INDEX_PHONE].matches("^\\+[7]{1}[0-9]{10}$")) {
            throw new IllegalArgumentException("Error. incorrect phone format.");
        }
        if (!components[INDEX_EMAIL].matches("^([a-z]+\\.?[a-z]+\\@[a-z]+\\.[a-z]+|[a-z]+\\-?[a-z]+\\@[a-z]+\\.[a-z]+)$")) {
            throw new IllegalArgumentException("Error. incorrect e-mail format.");
        }
    }

    public void listCustomers() throws CustomerEmptyListException {
        if (storage.isEmpty()) {
            throw new CustomerEmptyListException();
        }
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) throws CustomerNotFoundException {
        if (!storage.containsKey(name)) {
            throw new CustomerNotFoundException();
        }
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}