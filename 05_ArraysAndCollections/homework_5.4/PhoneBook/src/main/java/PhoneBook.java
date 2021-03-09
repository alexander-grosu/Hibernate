import java.util.*;

public class PhoneBook {
    Map<String, String> phoneContacts = new TreeMap<>();

    public void addContact(String phone, String name) {
        // проверьте корректность формата имени и телефона
        // если такой номер уже есть в списке, то перезаписать имя абонента
        if (phoneContacts.containsKey(phone)) {
            phoneContacts.remove(phone);
            phoneContacts.put(phone, name);
        } else {
            phoneContacts.put(phone, name);
        }
        System.out.println("контакт сохранен");
    }

    public String getNameByPhone(String phone) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку
        if (phoneContacts.containsKey(phone)) {
            System.out.println(phoneContacts.get(phone) + " - " + phone);
        } else {
            System.out.println("указанный контакт отсутствует в списке");
        }
        return "";

    }

    public String getPhonesByName(String name) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet
        if (phoneContacts.containsValue(name)) {
            System.out.println(phoneContacts.get(name));
        } else {
            System.out.println("указанный контакт отсутствует в списке");
        }
        return name + " - " + phoneContacts.get(name);
    }


    public Set<String> getAllContacts() {
        // формат одного контакта "Имя - Телефон"
        // если контактов нет в телефонной книге - вернуть пустой TreeSet
        if (phoneContacts.isEmpty()) {
            System.out.println("список пуст");
        } else {
            for (Map.Entry<String, String> contacts : phoneContacts.entrySet()) {
                System.out.println(contacts.getValue() + " - " + contacts.getKey());
            }
        }
        return new TreeSet<>();
    }
}