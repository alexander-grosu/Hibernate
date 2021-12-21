import folder.*;
import org.jetbrains.annotations.NotNull;

public class Main {
    public static void main(String[] args) {

        Company Nike = new Company(111_000_000);
        Company SAMSUNG = new Company(99_000_000);


        // add employee to company
        hireOneTopManager(SAMSUNG);
        hireAllOperators(SAMSUNG,10);
        hireAllManagers(SAMSUNG,10);
        hireAllTopManagers(SAMSUNG,10);
        fireOneEmployee(SAMSUNG);
        hireAllOperators(Nike,100);

        //output
        for (Employee e : SAMSUNG.getTopSalaryStaff(13)){
            System.out.println("COMPANY SAMSUNG | " + e.getStatus() + " |  salary: " + e.getMonthSalary());
        }
    }

    //fire/hire methods
    private static void fireOneEmployee (@NotNull Company company){
        int i = company.getEmployees().size();
        if(i > 0 ) {
            company.fire(company.getEmployees().get(0));
        } else {
            System.out.println("Employee  not  found");
        }
    }

    private static void fireAllEmployee(@NotNull Company company){
        company.fireAll();
    }
    private static void hireOneManager(@NotNull Company company){
        Employee manager = new Manager();
        company.hire(manager);
    }
    private static void hireOneOperator(@NotNull Company company){
        Employee operator = new Operator();
        company.hire(operator);
    }
    private static void hireOneTopManager(@NotNull Company company){
        Employee topManager = new TopManager();
        company.hire(topManager);
    }
    private static void hireAllOperators(@NotNull Company company,int count){
        Employee operator = new Operator();
        company.hireAll(operator,count);
    }
    private static void hireAllManagers(@NotNull Company company,int count){
        Employee manager = new Manager();
        company.hireAll(manager,count);
    }
    private static void hireAllTopManagers(@NotNull Company company,int count){
        Employee topManager = new TopManager();
        company.hireAll(topManager,count);
    }
}
