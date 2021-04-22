public class TopManager implements Employee {
    private static final double TOP_MANAGER_BONUS_PERCENT = 1.5; // 150%
    private static final double TOP_MANAGER_SALARY = 150_000.0;
    private final long salary;
    private static Company company;

    public TopManager(Company company){
        if (Company.getIncome() > 10_000_000) {
            this.salary = (long) (TOP_MANAGER_SALARY * TOP_MANAGER_BONUS_PERCENT);
        } else {
            this.salary = (long) TOP_MANAGER_SALARY;
        }
        this.company = company;
    }

    @Override
    public Employee getMonthSalary() {
        return (long) salary;
    }
}
