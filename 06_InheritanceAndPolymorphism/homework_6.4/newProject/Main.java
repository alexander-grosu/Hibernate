import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        DecimalFormat formatter = new DecimalFormat("#0.00");

       Company c1 = new Company();
       Company c2 = new Company();
       c1.hireAll(new TopManager(c1), 11);
        System.out.println(c1.getEmployeeList());
        System.out.println(c2.getTopSalaryStaff(3));


    }
}
