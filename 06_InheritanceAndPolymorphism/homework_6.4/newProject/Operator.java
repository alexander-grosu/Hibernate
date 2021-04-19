public class Operator implements Employee {
    private static final double OPERATOR_SALARY = 45000.0;
    private static Company company;
    private double salary;

    public Operator(Company company){
        this.salary = OPERATOR_SALARY;
        this.company = company;
    }

    @Override
    public double getMonthSalary() {
        return salary;
    }
}
