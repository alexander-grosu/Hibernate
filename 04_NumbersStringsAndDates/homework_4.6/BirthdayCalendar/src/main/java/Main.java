import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        int day = 31;
        int month = 0;
        int year = 1990;

        System.out.println(collectBirthdays(year, month, day));

    }

    public static String collectBirthdays(int year, int month, int day) {

        //TODO реализуйте метод для построения строки в следующем виде
        //0 - 31.12.1990 - Mon
        //1 - 31.12.1991 - Tue
        int i = 0;
        Calendar bDay = new GregorianCalendar(year, month, day);
        Calendar today = GregorianCalendar.getInstance();
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy - EEE", Locale.ENGLISH);
        System.out.println(i + " - " + df.format(bDay.getTime()));

        while (bDay.getTime().before(today.getTime())) {
            bDay.add(Calendar.YEAR, 1);
            i++;
            System.out.println(i + " - " + df.format(bDay.getTime()));
        }
        return "";
    }
}


