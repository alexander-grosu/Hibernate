import java.util.Arrays;
import java.util.List;
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
            temperature[i] = (float) (minTemp + (maxTemp - minTemp) * Math.random());
        }
        return temperature;
    }

    public static String getReport(float[] temperatureData) {


        /*
        TODO: Напишите код, который выводит среднюю температуру по больнице,количество здоровых пациентов,
            а также температуры всех пациентов.
        */

        float sum = 0;
        int k = 0;
        float temperaturaMedie = 0;
        int bonneSante = 0;
        String t = "";
        for (int i = 0; i < temperatureData.length; i++) {
            sum += temperatureData[i];
            k++;
            temperaturaMedie = sum / k;
            if (Math.round(temperatureData[i] * 100.0) / 100.0 > minNormalTemp && Math.round(temperatureData[i] * 100.0) / 100.0 < maxNormalTemp) {
                bonneSante++;
            }
        }


        String value = Arrays.toString(temperatureData);
        String elements = value.replaceAll(("[^\\d\\d\\.\\d\\s]"),"");

        String report = "Температуры пациентов: " + elements +
                "\nСредняя температура: " + Math.round(temperaturaMedie * 100.0) / 100.0 +
                "\nКоличество здоровых: " + bonneSante;

        return report;
    }
}
