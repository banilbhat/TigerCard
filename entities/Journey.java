package entities;
import java.time.LocalDate;
import java.time.LocalTime;

import utilities.DateTime;

public class Journey {
    
    public Journey(LocalDate dt, LocalTime t, String startZone, String endZone) {
        this.dt = dt;
        this.month = dt.getMonthValue();
        this.dayOfWeek = DateTime.getDayOfWeek(dt);
        this.time = t;
        this.startZone = startZone.trim();
        this.endZone = endZone.trim();
        this.path = startZone + "-" + endZone;
    }

    public int dayOfWeek;
    public LocalDate dt;
    public LocalTime time;
    public String startZone;
    public String endZone;
    public String path;
    public double applicableFare;
    public int month;
}