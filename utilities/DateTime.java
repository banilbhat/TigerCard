package utilities;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

public class DateTime {

    // parse string of format HH:MM
    public static LocalTime parseTime(String strTime){
        strTime = strTime.trim();
        return LocalTime.parse(strTime);
    }

    public static LocalDate parseDate(String strDate){
        strDate = strDate.trim();
        return LocalDate.parse(strDate);
    }

    public static int getDayOfWeek(LocalDate dt){
        DayOfWeek day = dt.getDayOfWeek();
        int dayofWeek = day.getValue();
        return dayofWeek;
    }
    
}
