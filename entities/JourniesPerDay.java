package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JourniesPerDay{
    List<Journey> journies;
    public double fareCap;
    public double totalFareWithoutCap;
    public double totalFare;
    public int topRank;
    public LocalDate dt;
    public JourniesPerDay(LocalDate dt){
        journies = new ArrayList<>();
        topRank = -1;
        totalFareWithoutCap = 0;
        this.dt = dt;
    }

    public void add(Journey journey) {
        journies.add(journey);
        totalFareWithoutCap += journey.applicableFare;
    }

    public double calculateFare() {
        totalFare = 0;
        for(Journey journey: journies){
            if(totalFare + journey.applicableFare >= fareCap){
                totalFare = fareCap;
                break;
            }
            totalFare+=journey.applicableFare;
        }
        // System.out.println("Farecap for  day:" + dt + " = " + fareCap);
        // System.out.println("Fare for  day:" + dt + " = " + totalFare);
        return totalFare;
    }    
}