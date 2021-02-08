public class examples {

    public static void main(String[] args) {

        final float max = 40.00F;
        final float min = 32.00F;
        final float minNormalTemp = 36.20F;
        final float maxNormalTemp = 36.90F;
        int patientsCount = 30;
        int j = 0;
        float sum = 0;
        float averageTemp;
        int healthPatients = 0;

        float[] ar1 = new float[patientsCount];
        for (int i = 0; i < ar1.length; i++) {
            ar1[i] = (float) (Math.random() * (max - min) + min);
            j++;
            sum += ar1[i];
            if (ar1[i] > minNormalTemp && ar1[i] < maxNormalTemp) {
                healthPatients++;
            }
            String temp = String.format("%.2f",ar1[i]);
            System.out.println("Patient: " + j + ", temperature: " + temp);
        }
        averageTemp = sum / patientsCount;
        String tempAverage = String.format("%.2f",averageTemp);
        System.out.println("\nAverage patients temperature: " + tempAverage);
        System.out.println("Count of health patients: " + healthPatients);
    }
}