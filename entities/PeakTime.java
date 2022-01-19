package entities;
import java.time.LocalTime;

public class PeakTime {
    LocalTime start;
    LocalTime end;

    public PeakTime(LocalTime peakStart, LocalTime peakEnd) {
        this.start = peakStart;
        this.end = peakEnd;
    }

    public Boolean isWithinPeakTime(LocalTime time){
        if(time.compareTo(start) == 0 || time.compareTo(end) == 0 ) 
            return true;
        if(time.compareTo(start) > 0 && time.compareTo(end) < 0)
            return true;
        return false;        
    }
}