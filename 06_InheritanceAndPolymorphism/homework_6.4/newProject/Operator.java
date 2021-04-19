public class Operator implements Employee {
    private static final double OPERATOR_SALARY = 45000.0;

    @Override
    public double getMonthSalary() {
        return OPERATOR_SALARY;
    }
}
