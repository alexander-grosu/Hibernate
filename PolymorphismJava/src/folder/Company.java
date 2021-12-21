package folder;

import java.util.*;

public class Company {

    public static double income;
    ArrayList<Employee> employees = new ArrayList<>();

    public Company(double income){
        this.income = income;
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
    public ArrayList<Employee> hireAll(Employee employee, int count) {
        for (int i = 0; i < count; i++) {
           employees.add(employee);
        }
        return employees;
    }
    public List<Employee> getTopSalaryStaff(int count) {
        employees.sort(new EmployeeComparator().reversed());
        List<Employee> result = new ArrayList<>();
        for (int i = 0; i < count; i++)
            result.add(employees.get(i));
        return result;
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        employees.sort(new EmployeeComparator());
        List<Employee> result = new ArrayList<>();
        for (int i = 0; i < count; i++)
            result.add(employees.get(i));
        return result;
    }


    public ArrayList<Employee> getEmployees() {
        return employees;
    }

}
