package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import utilities.FareCappingUtility;

public class JourniesPerWeek {
    List<JourniesPerDay> journiesPerDayList;
    double totalFare;
    public double fareCap;
    public int topRank;
    public LocalDate maxDatePossible;
    public JourniesPerWeek(LocalDate dt){
        journiesPerDayList = new ArrayList<>();
        totalFare = 0;
        topRank = -1;
        calculateMaxDatePossible(dt);
    }
    public double calculateFare() {
        for(JourniesPerDay journiesPerDay: journiesPerDayList){
            journiesPerDay.calculateFare();
        }
        totalFare = 0;
        for(JourniesPerDay journiesPerDay: journiesPerDayList){
            if(totalFare + journiesPerDay.totalFare >= fareCap){
                totalFare = fareCap;
                break;
            }
            totalFare += journiesPerDay.totalFare;
        }
        // System.out.println("Farecap for  week:" + maxDatePossible  + " = " + fareCap);
        // System.out.println("Fare for  week :" + maxDatePossible + " = " + totalFare);
        return totalFare;
    }
    public void calculateMaxDatePossible(LocalDate dt){
        int dayOfWeek = dt.getDayOfWeek().getValue();
        maxDatePossible = dt.plusDays(7 - dayOfWeek);
    }
    
    public void populateJourneyStructureAndFareCap(Journey journey) {
        int curJourneyListSize  = journiesPerDayList.size();
        JourniesPerDay curDayJourney = curJourneyListSize == 0 ? null: journiesPerDayList.get(curJourneyListSize -1);
        if(curDayJourney == null || curDayJourney.dt.compareTo(journey.dt) != 0){
            curDayJourney = new JourniesPerDay(journey.dt);
            journiesPerDayList.add(curDayJourney);
        }
        curDayJourney.add(journey);
        FareCappingUtility.updateFareCap(journey, curDayJourney);
    }
    
}
