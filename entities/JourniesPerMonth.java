package entities;

import java.util.ArrayList;
import java.util.List;

public class JourniesPerMonth {
    List<JourniesPerWeek> journiesPerWeekList;

    double totalFare;
    public double fareCap;
    public int month;
    public int topRank;
    public JourniesPerMonth(int month){
        journiesPerWeekList = new ArrayList<>();
        totalFare = 0;
        this.month = month;
    }

    public void calculateFare() {
        totalFare = 0;
        for(JourniesPerWeek journiesPerWeek: journiesPerWeekList){
            if(totalFare + journiesPerWeek.totalFare >= fareCap){
                totalFare = fareCap;
                break;
            }
            totalFare += journiesPerWeek.totalFare;
        }
    }

    public void add(Journey journey) {
        // int weeklistSize = journiesPerWeekList.size();
        // if( weeklistSize == 0 || journiesPerWeekList.get(weeklistSize -1) != journey.month){
        //     JourniesPerWeek curWeekJourney = new JourniesPerWeek(journey);
        //     curWeekJourney.add(journey);
        //     journiesPerWeekList.add(curWeekJourney);
        // }
    }
}
