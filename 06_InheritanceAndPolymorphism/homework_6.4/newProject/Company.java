import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

public class Company {
    public static double income;

    public static ArrayList<Employee> employeeList = new ArrayList<>();

    public void setIncome(double income) {
        //income setter
        Company.income = income;
    }

    public static double getIncome() {
        //income getter
        return income;
    }

    public Company() {
        new ArrayList<String>();
        setIncome(income);
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

    public static void getSortedSalaryToMax(int count) {
        Collections.sort(employeeList, (o1, o2) -> {
            if (o1.getMonthSalary() > o2.getMonthSalary()) {
                return 1;
            }
            else if (o1.getMonthSalary() < o2.getMonthSalary()) {
                return -1;
            }
            else {
                return 0;
            }
        });
        DecimalFormat formatter = new DecimalFormat("#0.00");
        for (Employee s : employeeList.subList(0 , count)) {
            System.out.println(formatter.format(s.getMonthSalary()));
        }
    }

    public static void getSortedSalaryToMin(int count) {
        Collections.sort(employeeList, (o1, o2) -> {
            if (o1.getMonthSalary() > o2.getMonthSalary()) {
                return -1;
            }
            else if (o1.getMonthSalary() < o2.getMonthSalary()) {
                return 1;
            }
            else {
                return 0;
            }
        });

        DecimalFormat formatter = new DecimalFormat("#0.00");
        for (Employee s : employeeList.subList(0 , count)) {
            System.out.println(formatter.format(s.getMonthSalary()));
        }
    }

    public void fire(Employee employee) {
        //delete one employee
        employeeList.remove(employee);
    }
}