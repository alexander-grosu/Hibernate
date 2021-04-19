import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        DecimalFormat formatter = new DecimalFormat("#0.00");

        Company company1 = new Company();
        Company company2 = new Company();

        company1.setIncome(10_000_000);
        Manager m1 = new Manager(company1);
        TopManager tm1 = new TopManager(company1);


        System.out.println( formatter.format(m1.getMonthSalary()));
        System.out.println( formatter.format(tm1.getMonthSalary()));

        company2.setIncome(11_000_000);
        TopManager t1 = new TopManager(company2);
        System.out.println();
        System.out.println(formatter.format(t1.getMonthSalary()));
        company2.hireAll(new TopManager(company2), 5);
        company2.getSortedSalaryToMax(5);
        company2.hireAll(new Manager(company2),10);
        System.out.println();
        company2.getSortedSalaryToMax(15);

    }
}
