import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Company {
    public static double income;
    ArrayList<Employee> employeeList = new ArrayList<>();

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setIncome(double income) {
        //income setter
        Company.income = income;
    }

    public static double getIncome() {
        //income getter
        return income;
    }

    public ArrayList<Employee> hireAll(Employee employee, int count) {
        //add multiple employees
        for (int i = 0; i < count; i++) {
            employeeList.add(employee);
        }
        return employeeList;
    }

    public void hire(Employee employee) {
        //add one employee
        employeeList.add(employee);
    }

    public void fire (int count) {
        //delete employee
        for (int i = 0; i < count; i++) {
            employeeList.remove(employeeList.get(0));
        }
    }

    public List <Employee> getLowestSalaryStaff(int count){
        employeeList.sort(Comparator.comparing(Employee::getMonthSalary));
        ArrayList<Employee> result = new ArrayList<>();
        for (int i = 0; i < count; i++){
            result.add(employeeList.get(i));
        }
        return result;
    }


    public List <Employee> getTopSalaryStaff(int count){
        employeeList.sort(Comparator.comparing(getEmployee()::getMonthSalary).reversed());
        ArrayList<Employee> result = new ArrayList<>();
        for (int i = 0; i < count; i++){
            result.add(employeeList.get(i));
        }
        return result;
    }

    private static Object getEmployee() {
        return Employee;
    }

}