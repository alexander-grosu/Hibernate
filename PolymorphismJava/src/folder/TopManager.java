package folder;

public class TopManager implements Employee {
    private double salary = 150_000;
    private String status = "Top Manager";

    @Override
    public double getMonthSalary() {
        if(Company.income >= 100_000_000){
             return salary * 1.5;
        }
        return salary;
    }

    @Override
    public String getStatus() {
        return status;
    }
}
