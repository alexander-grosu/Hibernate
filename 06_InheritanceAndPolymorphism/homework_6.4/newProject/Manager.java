public class Manager implements Employee {
    private static final double MANAGER_PERCENT = 0.05; // 5%
    private static final double MIN_INCOME = 115_000.0;
    private static final double MAX_INCOME = 140_000.0;
    private static final double MANAGER_SALARY = 75_000.0;
    private Company company;
    private double salary;

    public Manager(Company company) {
        this.salary = MANAGER_SALARY + (MIN_INCOME + (MAX_INCOME - MIN_INCOME) * Math.random()) * MANAGER_PERCENT;
        this.company = company;
    }


    @Override
    public double getMonthSalary() {
       return salary;
    }
}
