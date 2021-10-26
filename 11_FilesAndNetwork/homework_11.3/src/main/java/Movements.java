import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Movements {
    List<String> incomeExpenseList = new ArrayList<>();
    Map<String, Double> expenseMap = new HashMap<>(); /// map для вывода списка расходов по названиям организаций
    double income = 0.0;
    double expense = 0.0;

    public Movements(String pathMovementsCsv) {
        try (BufferedReader br = new BufferedReader(new FileReader(pathMovementsCsv))) {
            String line;
            while ((line = br.readLine()) != null) {

                incomeExpenseList.add(line);
            }
            for (int i = 1; i < incomeExpenseList.size(); i++){
                if (incomeExpenseList.get(i).split(",").length == 8) {
                    expense += Double.parseDouble(incomeExpenseList.get(i).split(",")[7]);
                    income += Double.parseDouble((incomeExpenseList.get(i).split(",")[6]));
                }
                if (incomeExpenseList.get(i).split(",").length == 9) {
                    expense += Double.parseDouble((incomeExpenseList.get(i).split(",")[7].concat(".")
                            .concat(incomeExpenseList.get(i).split(",")[8])).replaceAll("\\\"", ""));
                    income += Double.parseDouble((incomeExpenseList.get(i).split(",")[6]));
                }


            }
            System.out.println(income);
            System.out.println(expense);

        } catch (IOException
                | RuntimeException e) {
            e.printStackTrace();
        }
    }

    public double getExpenseSum() {
        return expense;
    }

    public double getIncomeSum() {
        return income;
    }
}
