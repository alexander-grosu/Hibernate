import net.sf.saxon.value.StringValue;

import javax.management.StringValueExp;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {

        int day = 31;
        int month = 12;
        int year = 1990;

        System.out.println(collectBirthdays(year, month, day));

    }

    public static String collectBirthdays(int year, int month, int day) {

        //TODO реализуйте метод для построения строки в следующем виде
        //0 - 31.12.1990 - Mon
        //1 - 31.12.1991 - Tue
        Calendar bDay = new GregorianCalendar(year,month,day);
        Calendar today = new GregorianCalendar();
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy - EE");
        int i = 0;
        while(bDay.getTime().before(today.getTime())){
            bDay.add(Calendar.YEAR,1);
            i++;
        }

        return i+" - "+df.format(bDay.getTime());
    }
}


