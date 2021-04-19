public class TopManager implements Employee {
    private static final double TOP_MANAGER_BONUS_PERCENT = 1.5; // 150%
    private static final double TOP_MANAGER_SALARY = 150_000.0;
    private double salary;
    private static Company company;

    public TopManager(Company company){
        if (Company.getIncome() > 10_000_000) {
            this.salary = TOP_MANAGER_SALARY * TOP_MANAGER_BONUS_PERCENT;
        } else {
            this.salary = TOP_MANAGER_SALARY;
        }
        this.company = company;
    }

    @Override
    public double getMonthSalary() {
        return salary;
    }
}
