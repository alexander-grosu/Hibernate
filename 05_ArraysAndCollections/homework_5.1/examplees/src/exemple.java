import java.math.BigDecimal;

public class exemple {
    public static void main(String[] args) {
        int patientsCount = 30;
        int j =0;
        float sum =0.0F;
        float min = 32.0F;
        float max = 40.0F;
        float[] temperature = new float[patientsCount];
        for(int i =0; i < temperature.length; i++){
            temperature[i] = (float) (min + (max - min) * Math.random());
            sum+=temperature[i];
            j++;
            System.out.println("patient " + j + " temperature " + temperature[i]);
        }
        System.out.println("средняя температура пациентов " + (sum/patientsCount));
    }
}
