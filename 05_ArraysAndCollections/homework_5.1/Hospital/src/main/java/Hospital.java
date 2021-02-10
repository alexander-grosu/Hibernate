import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Hospital {
    public static final float minTemp = 32.0F;
    public static final float maxTemp = 40.0F;
    public static final float minNormalTemp = 36.2F;
    public static final float maxNormalTemp = 36.9F;

    public static float[] generatePatientsTemperatures(int patientsCount) {

        float[] temperature = new float[patientsCount];
        for (int i = 0; i < patientsCount; i++) {
            temperature[i] = (float) (minTemp + ((maxTemp - minTemp) * Math.random()));
        }
        return temperature;
    }

    public static String getReport(float[] temperatureData) {


        /*
        TODO: Напишите код, который выводит среднюю температуру по больнице,количество здоровых пациентов,
            а также температуры всех пациентов.
        */

        float sum=0;
        int k =0;
        float averageTemp =0;
        int z =0;
        for (int i =0; i< temperatureData.length; i++){
            sum+=temperatureData[i];
            k++;
            averageTemp = sum/k;
            if(Math.round(temperatureData[i]*100.0)/100.0 > minNormalTemp && Math.round(temperatureData[i]*100.0)/100.0 < maxNormalTemp){
                z++;
            }
        }
        String temp = Arrays.toString(temperatureData);

        String report = "Температуры пациентов: " + temp +
                "\nСредняя температура: " + Math.round(averageTemp*100.0)/100.0 +
                "\nКоличество здоровых: " + z;

        return report;
    }
}
