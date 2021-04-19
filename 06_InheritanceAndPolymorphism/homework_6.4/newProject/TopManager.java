public class TopManager implements Employee {
    private static final double TOP_MANAGER_BONUS_PERCENT = 1.5; // 150%
    private static final double TOP_MANAGER_SALARY = 150_000.0;
    private double salary;

    @Override
    public double getMonthSalary() {
        if (Company.getIncome() > 10_000_000) {
            salary = TOP_MANAGER_SALARY * TOP_MANAGER_BONUS_PERCENT;
        } else {
            salary = TOP_MANAGER_SALARY;
        }
        return salary;
    }
}
