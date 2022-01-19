import java.util.List;

import entities.Journey;
import utilities.FareCalculator;
import utilities.InputUtility;
import utilities.JourneyUtility;
import utilities.RulesCreator;

public class Main {

    public static void main(String args[]){
        try {
            RulesCreator.init();
            List<String> inputlines = InputUtility.readInputLines("inputs\\input.txt");
            List<Journey> journies = JourneyUtility.parseInputtoJournies(inputlines);
            FareCalculator  fareCalculator = new FareCalculator(journies);
            System.out.println("total fare: "+ fareCalculator.calculateFare());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}