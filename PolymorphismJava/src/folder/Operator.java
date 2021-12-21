package folder;

public class Operator implements Employee {
    private double salary = 25_000;
    private String status = "Operator";

    @Override
    public double getMonthSalary() {
        return salary;
    }

    @Override
    public String getStatus() {
        return status;
    }
}
