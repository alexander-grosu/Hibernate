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
        String dataRegEx = "^[А-Я]{1}[а-я]{1,10}\\s+[А-Я]{1}[а-я]{1,10}\\s+[a-z]+\\.?[a-z]+\\@[a-z]+\\.[a-z]+\\s+\\+[7]{1}[0-9]{10}$";

        if (!data.matches(dataRegEx)) {
            throw new IllegalArgumentException("Wrong! incorrect name,surname,email or phone format.");
        }

        String[] components = data.split("\\s+");
        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}