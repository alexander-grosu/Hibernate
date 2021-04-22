public class Operator implements Employee {
    private static final long OPERATOR_SALARY = (long) 45000.0;
    private static Company company;
    private long salary;

    public Operator(Company company){
        this.salary = OPERATOR_SALARY;
        this.company = company;
    }

    @Override
    public Employee getMonthSalary() {
        return (long) salary;
    }
}
