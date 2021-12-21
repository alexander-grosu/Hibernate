package folder;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee> {

    @Override
    public int compare(@NotNull Employee o1, @NotNull Employee o2) {
        if (o1.getMonthSalary() > o2.getMonthSalary()) {
            return 1;
        }
        if (o1.getMonthSalary() < o2.getMonthSalary()) {
            return -1;
        }
            return 0;
    }
}
