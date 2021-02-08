public class Hospital {
    public static final float minTemp = 32.0F;
    public static final float maxTemp = 40.0F;
    public static final float minNormalTemp = 36.2F;
    public static final float maxNormalTemp = 36.9F;

    public static float[] generatePatientsTemperatures(int patientsCount) {

        float [] temperature = new float[patientsCount];
        for(int i =0; i < patientsCount; i++) {
            temperature[i] = (float) (minTemp + ((maxTemp - minTemp)* Math.random()));
        }
        return temperature;
    }

    public static String getReport(float[] temperatureData) {
        /*
        TODO: Напишите код, который выводит среднюю температуру по больнице,количество здоровых пациентов,
            а также температуры всех пациентов.
        */

        String report =
                "Температуры пациентов: " + 0 +
                        "\nСредняя температура: " + 0 +
                        "\nКоличество здоровых: " + 0;

        return report;
    }
}
