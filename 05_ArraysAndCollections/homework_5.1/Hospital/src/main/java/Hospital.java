import java.text.DecimalFormat;

public class Hospital {
    public static final float MIN_TEMP = 32.0F;
    public static final float MAX_TEMP = 40.0F;
    public static final float MIN_NORMAL_TEMP = 36.2F;
    public static final float MAX_NORMAL_TEMP = 36.9F;

    public static float[] generatePatientsTemperatures(int patientsCount) {

        float[] temperature = new float[patientsCount];
        for (int i = 0; i < patientsCount; i++) {
            temperature[i] = (float) (MIN_TEMP + (MAX_TEMP - MIN_TEMP) * Math.random());
        }
        return temperature;
    }

    public static String getReport(float[] temperatureData) {
        float sum = 0;
        int k = 0;
        float temperaturaMedie = 0;
        int bonneSante = 0;

        StringBuilder txtTemp = new StringBuilder();
        for (float temperatureDatum : temperatureData) {
            DecimalFormat decimalFormat = new DecimalFormat( "#.#" );
            String tempDat1 = decimalFormat.format(temperatureDatum);
            //String tempDat2 = String.format("%.2f", temperatureDatum);
            txtTemp.append(tempDat1).append(" ");
            k++;
            sum += temperatureDatum;
            temperaturaMedie = sum / k;

            if (temperatureDatum > MIN_NORMAL_TEMP && temperatureDatum < MAX_NORMAL_TEMP) {
                bonneSante++;
            }
        }
        String report = "Температуры пациентов: " + txtTemp.toString().trim() +
                "\nСредняя температура: " + Math.round(temperaturaMedie * 100.0) / 100.0 +
                "\nКоличество здоровых: " + bonneSante;

        return report;
    }
}