package folder;

import java.math.BigDecimal;

public class Manager implements Employee {
    private static final double salary = 50_000;
    private String status = "Manager";
    private static final double Max = 140_000.0;
    private static final double Min = 115_000.0;


    @Override
    public double getMonthSalary() {

        return  BigDecimal.valueOf(salary + ((Math.random() * (Max - Min)) + Min * 0.05))
                .setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    @Override
    public String getStatus() {
        return status;
    }
}
