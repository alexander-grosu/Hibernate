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
        int patientCount = 0;
        float averageTemp = 0;
        int healthCount = 0;

        StringBuilder txtTemp = new StringBuilder();
        for (float tempElements : temperatureData) {
            //DecimalFormat decimalFormat = new DecimalFormat( "#.0" );
            //String tempDat1 = decimalFormat.format(tempElements);
            String tempDat2 = String.format("%.1f", tempElements);
            txtTemp.append(tempDat2).append(" ");
            patientCount++;
            sum += tempElements;
            averageTemp = sum / patientCount;

            if (tempElements >= MIN_NORMAL_TEMP && tempElements <= MAX_NORMAL_TEMP) {
                healthCount++;
            }
        }

        String tempOfPatients = txtTemp.toString().trim().replaceAll("\\,", "\\.");
        double scale = Math.pow(10, 2);
        double averageTemperature = Math.round(averageTemp * scale) / scale;

        String report = "Температуры пациентов: " + tempOfPatients +
                "\nСредняя температура: " + averageTemperature +
                "\nКоличество здоровых: " + healthCount;

        return report;
    }
}