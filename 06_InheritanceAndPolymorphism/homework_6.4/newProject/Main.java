import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        DecimalFormat formatter = new DecimalFormat("#0.00");

        Company comp1111 = new Company();
        comp1111.setIncome(1000000000);
        comp1111.hireAll(new TopManager(comp1111), 100);
        //.forEach(Employee::getMonthSalary);
    }
}
