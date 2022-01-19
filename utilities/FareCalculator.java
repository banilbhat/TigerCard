package utilities;
import java.util.ArrayList;
import java.util.List;

import entities.Journey;
import entities.JourniesPerWeek;

public class FareCalculator {
    List<Journey> journies;
    public double totalFare;
    List<JourniesPerWeek> journiesPerWeekList;        
    public FareCalculator(List<Journey> journies) {
        this.journies = journies;
    }

    public double calculateFare() {
        populateJourneyStructureAndFareCap();
        return calculateFares();
    }

    private double calculateFares() {
        double totalFare = 0;
        for(JourniesPerWeek journiesPerWeek: journiesPerWeekList){
            totalFare += journiesPerWeek.calculateFare();
        }
        return totalFare;
    }

    private void populateJourneyStructureAndFareCap() {
        journiesPerWeekList = new ArrayList<>();
        JourniesPerWeek curWeekJourney = null;
        for(Journey journey:journies){
            FarePricingUtility.fillFare(journey);
            if(curWeekJourney == null || curWeekJourney.maxDatePossible.compareTo(journey.dt) < 0 ){
                curWeekJourney = new JourniesPerWeek(journey.dt);
                journiesPerWeekList.add(curWeekJourney);
            }
            curWeekJourney.populateJourneyStructureAndFareCap(journey);
            FareCappingUtility.updateFareCap(journey, curWeekJourney);
        }
    }



}
