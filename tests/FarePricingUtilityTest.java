package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import entities.FarePrice;
import entities.Journey;
import exceptions.CustomException;
import utilities.FarePricingUtility;
import utilities.JourneyUtility;
import utilities.RulesCreator;

public class FarePricingUtilityTest {
    @Test
    public void testInput(){
        try {
            RulesCreator.Test_Path = "bin" + File.separator;
            FarePricingUtility.init();
            FarePrice fp11 = FarePricingUtility.farePriceMap.get("1-1");
            FarePrice fp12 = FarePricingUtility.farePriceMap.get("1-2");
            FarePrice fp21 = FarePricingUtility.farePriceMap.get("2-1");
            FarePrice fp22 = FarePricingUtility.farePriceMap.get("2-2");
            assertEquals(25, fp11.normalPrice);
            assertEquals(30, fp11.peakPrice);
            assertEquals(30, fp12.normalPrice);
            assertEquals(35, fp12.peakPrice);
            assertEquals(30, fp21.normalPrice);
            assertEquals(35, fp21.peakPrice);
            assertEquals(20, fp22.normalPrice);
            assertEquals(25, fp22.peakPrice);
        }
        catch(CustomException ex){
            fail(ex.getMessage());
        } catch (IOException ex) {
            fail(ex.getMessage());
        }
    }
    @Test
    public void testFillFare() throws CustomException, IOException{
        RulesCreator.Test_Path = "bin" + File.separator;
        RulesCreator.init();
        List<String> inputLines = new ArrayList<String>();
        inputLines.add("2020-08-01 10:20 2 1");
        inputLines.add("2020-08-01 10:45 1 1"); 
        inputLines.add("2020-08-01 16:15 1 1");
        List<Journey> journies = null;
        journies = JourneyUtility.parseInputtoJournies(inputLines);
        Journey journey = journies.get(0);
        FarePricingUtility.fillFare(journey);
        assertEquals(journey.applicableFare, 35);

        journey = journies.get(1);
        FarePricingUtility.fillFare(journey);
        assertEquals(journey.applicableFare, 30);

        journey = journies.get(2);
        FarePricingUtility.fillFare(journey);
        assertEquals(journey.applicableFare, 25);
    }
}
