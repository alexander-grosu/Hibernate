import java.util.ArrayList;

public class TodoList {

    ArrayList<String> todoList = new ArrayList<>();


    public void add(String todo) {
        // TODO: добавьте переданное дело в конец списка
        todoList.add(todo);
        System.out.println("добавлено дело '" + todo + "'");
    }

    public void add(int index, String todo) {
        // TODO: добавьте дело на указаный индекс,
        //  проверьте возможность добавления
        if (index < todoList.size() && index >= 0) {
            todoList.add(index, todo);
            System.out.println("добавлено дело '" + todo + "'");
        } else {
            todoList.add(todoList.size(), todo);
            System.out.println("добавлено дело '" + todo + "'");
        }

    }

    public void subList(int indexFrom, int indexTo) {
        if (todoList.isEmpty()) {
            System.out.println("ошибка! список пуст");
        } else if (todoList.size() < 2) {
            System.out.println("ошибка! слишком короткий список");
        } else if (indexFrom >= 0 && indexTo < (todoList.size()) && indexTo > indexFrom || indexFrom > 0 && indexTo <= todoList.size() && indexFrom < indexTo) {

            for (String element : todoList.subList(indexFrom, indexTo)) {
                indexFrom++;
                System.out.println(indexFrom + ". " + element);
            }
        } else {
            System.out.println("ошибка, size = " + todoList.size() +
                    "\n введите SUBLIST + fromIndex >= 0 && toIndex > fromIndex && toIndex < " + todoList.size() +
                    "\n или " +
                    "\n введите SUBLIST + fromIndex > 0 && toIndex > fromIndex && toIndex <= " + todoList.size());
        }
    }

    public void listContains(String todo) {
        System.out.println("список содержит '" + todo + "' = " + todoList.contains(todo));
    }

    public void list() {
        if (todoList.isEmpty()) {
            System.out.println("список пуст!");
        } else {
            int i = 0;
            for (String element : todoList) {
                i++;
                System.out.println(i + ".  " + element);
            }
        }

    }

    public void clearList() {
        if (todoList.isEmpty()) {
            System.out.println("ошибка! список пуст");
        } else {
            todoList.clear();
            System.out.println("список успешно удален");
        }
    }

    public void listSize() {
        System.out.println("list size: " + todoList.size());
    }

    public void edit(String todo, int index) {
        // TODO: заменить дело на index переданным todo индекс,
        //  проверьте возможность изменения
        if (todoList.isEmpty()) {
            System.out.println("ошибка! список пуст");
        } else if (index >= 0 && index < todoList.size()) {
            System.out.println("дело '" + todoList.get(index) + "' заменено на '" + todo + "'");
            todoList.set(index, todo);
        } else {
            System.out.println("ошибка! введите индекс от 0 до " + (todoList.size() - 1));
        }
    }

    public void delete(int index) {
        // TODO: удалить дело находящееся по переданному индексу,
        //  проверьте возможность удаления дела
        if (todoList.isEmpty()) {
            System.out.println("ошибка! список пуст");
        } else if (index >= 0 && index < todoList.size()) {
            System.out.println("дело '" + todoList.get(index) + "' удалено");
            todoList.remove(index);
        } else {
            System.out.println("ошибка! введите индекс от 0 до " + (todoList.size() - 1));
        }
    }

    public ArrayList<String> getTodos() {
        // TODO: вернуть список дел
        return todoList;
    }
}