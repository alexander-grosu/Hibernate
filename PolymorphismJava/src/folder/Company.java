package folder;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Company {
    private static double income = 0.0;
    ArrayList<Employee> employees = new ArrayList<>();

    public static void setIncome(double income) {
        Company.income = income;
    }
    public static double getIncome() {
        return income;
    }
    public void hire(Employee employee){
        employees.add(employee);
    }
    public void fire(Employee employee){
        employees.remove(employee);
    }
    public void fireAll(){
        employees.clear();
    }
    public  List<Employee> getDescendingOrderSalary(){
        employees.sort((o1, o2) -> (int) (o2.getMonthSalary() - o1.getMonthSalary()));
        return employees;
    }
    public List<Employee> getTopSalaryStaff(int count) {
        return getSortList(count, (o1, o2) -> (int) (o2.getMonthSalary() - o1.getMonthSalary()));
    }
    public List<Employee> getLowestSalaryStaff(int count) {
        return getSortList(count, (o1, o2) -> (int) (o1.getMonthSalary() - o2.getMonthSalary()));
    }
    private @NotNull List<Employee> getSortList(int count,Comparator<Employee> comparator) {
        employees.sort(comparator);
        List<Employee> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(employees.get(i));
        }
        return result;
    }
    public ArrayList<Employee> getEmployees() {
        return employees;
    }
}
