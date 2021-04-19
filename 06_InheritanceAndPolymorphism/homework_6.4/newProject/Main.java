public class Main {
    public static void main(String[] args) {

        Company company1 = new Company();

        company1.hireAll(new Operator(), 5);
        company1.hireAll(new Manager(), 5);
        company1.hireAll(new TopManager(), 5);



        //company1.setIncome(10_000_000);
        company1.setIncome(10_000_001);
        company1.getSortedSalaryToMin(7);

    }
}
