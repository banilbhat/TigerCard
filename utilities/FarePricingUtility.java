package utilities;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import entities.*;
import exceptions.CustomException;

public class FarePricingUtility {
    public static HashMap<String, FarePrice> farePriceMap;
    public static void init() throws CustomException, IOException{
        farePriceMap = new HashMap<>();
        // weekendPeakTimes = new ArrayList<>();
        List<String> pricingLines = InputUtility.readInputLines(RulesCreator.Test_Path +"inputs\\farepricing.txt");
        parseInputtoFarePricing(pricingLines);
    }

    private static void parseInputtoFarePricing(List<String> pricingLines) throws CustomException {
        for(String priceLine:pricingLines){
            priceLine = priceLine.trim();
            String[] input = priceLine.split(" ");
            if(input.length <= 2){
                throw new CustomException("invalid farepricing input:" + priceLine);
            }
            try{
                double peakPrice = Double.parseDouble(input[1]);
                double normalPrice = Double.parseDouble(input[2]);
                FarePrice  fp = new FarePrice(peakPrice, normalPrice);
                farePriceMap.put(input[0], fp);
            }
            catch(Exception ex){
                throw new CustomException("Invalid Price input. cannot convert to double: " + priceLine);
            }
        }
    }

    public static double fillFare(Journey journey) {
        Boolean isWithinPeak = PeakRulesUtility.isWithinPeak(journey);
        FarePrice fp = farePriceMap.get(journey.path);
        // System.out.println("Journey Details: " + journey);
        journey.applicableFare = isWithinPeak? fp.peakPrice:fp.normalPrice;
        // System.out.println("journey date: " + journey.dt + " journey time: " + journey.time + " journey path: " + journey.path +  " farePrice: " + journey.applicableFare + " day of week: " + journey.dayOfWeek);
        return journey.applicableFare;
    }
}
