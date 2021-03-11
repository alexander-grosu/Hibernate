import java.util.*;
import java.util.regex.Pattern;

public class PhoneBook {
    Map<String, String> mapPhone = new HashMap<>();
    private Set<String> newSet = new TreeSet<>();

    public void addContact(String phone, String name) {
        // проверьте корректность формата имени и телефона
        // если такой номер уже есть в списке, то перезаписать имя абонента
        String regexName = "^(([А-Я]{1}[а-я]{1,14}\\s[А-Я]{1}[а-я]{1,14})|([А-Я]{1}[а-я]{1,14}\\s[А-Я]{1}[а-я]{1,14}\\s[А-Я]{1}[а-я]{1,14})|([А-Я]{1}[а-я]{1,14})|([А-Я]{1}[а-я]{1,15}\\s[А-Я]{1}[а-я]{1,14}\\s[А-Я]{1}[а-я]{1,14}\\-[А-Я]{1}[а-я]{1,14}))$";
        String regexNumber = "^[0-9]{11}$";
        if (Pattern.compile(regexName).matcher(name).matches() && Pattern.compile(regexNumber).matcher(phone).matches()) {
            if (mapPhone.containsKey(phone)) {
                mapPhone.remove(phone);
            }
            mapPhone.put(phone, name);
            System.out.println("контакт сохранен");
        } else {
            System.out.println("имя или номер введен некорректно");
        }
    }

    public void printList() {
        for (Map.Entry<String, String> mapToSet : mapPhone.entrySet()) {
            //newSet.add(mapToSet.getValue() + " - " + mapToSet.getKey());

            System.out.println(mapToSet.getValue() + " - " + mapToSet.getKey()); /// это выводит элементы мэп
        }
//        for (String printSetElements : newSet) {
//            System.out.println(printSetElements);
//        }
    }

    public void printContactByPhone(String phone) {
        if (mapPhone.containsKey(phone)) {
            System.out.println(mapPhone.get(phone) + " - " + phone);
        } else {
            System.out.println("контакта с таким номером в списке нет");
        }
    }

    public void printContactByName(String name) {
        for (Map.Entry<String, String> entry : mapPhone.entrySet()) {
            if (name.equals(entry.getValue())) {
                if (mapPhone.containsValue(name)) {
                    System.out.println(name + " - " + entry.getKey());
                } else {
                    System.out.println("контакта с таким именим нет");
                }
            }
        }
    }

    public String getNameByPhone(String phone) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку
        if (mapPhone.containsKey(phone)) {
            return mapPhone.get(phone) + " - " + phone;
        } else {
            return "";
        }
    }

    public String getPhonesByName(String name) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet
        for (Map.Entry<String, String> entry : mapPhone.entrySet()) {
            if (name.equals(entry.getValue())) {
                return name + " - " + entry.getKey();
            }
        }
        return "";
    }


    public Object getAllContacts() {
        // формат одного контакта "Имя - Телефон"
        // если контактов нет в телефонной книге - вернуть пустой TreeSet
        if (!mapPhone.isEmpty()) {
            for (Map.Entry<String, String> mapToSet : mapPhone.entrySet()) {
                newSet.add(mapToSet.getValue() + " - " + mapToSet.getKey());
            }
            return newSet;
        } else {
            return new TreeSet<>();
        }
    }
}