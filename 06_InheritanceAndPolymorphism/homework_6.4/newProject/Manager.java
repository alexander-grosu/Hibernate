public class Manager implements Employee {
    private static final long MANAGER_PERCENT = (long) 0.05; // 5%
    private static final long MIN_INCOME = (long) 115_000.0;
    private static final long MAX_INCOME = (long) 140_000.0;
    private static final long MANAGER_SALARY = (long) 75_000.0;
    private Company company;
    private final long salary;

    public Manager(Company company) {
        this.salary = (long) (MANAGER_SALARY + (MIN_INCOME + (MAX_INCOME - MIN_INCOME) * Math.random()) * MANAGER_PERCENT);
        this.company = company;
    }


    @Override
    public Employee getMonthSalary() {
       return (long) salary;
    }
}
