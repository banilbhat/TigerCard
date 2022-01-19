package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import entities.Journey;
import entities.JourniesPerDay;
import exceptions.CustomException;
import utilities.Constants;
import utilities.FareCappingUtility;
import utilities.FarePricingUtility;
import utilities.InputUtility;
import utilities.JourneyUtility;
import utilities.RulesCreator;

public class JourniesPerDayTest {
    
    @Before
    public void init() throws CustomException, IOException{
        RulesCreator.Test_Path = "bin\\";
        RulesCreator.init();
    }
    
    @Test
    public void testSingleDay() throws IOException, CustomException{
        List<String> inputlines = InputUtility.readInputLines(Constants.TEST_INPUT_FILE_SINGLE_DAY);
        List<Journey> journies = JourneyUtility.parseInputtoJournies(inputlines);
        JourniesPerDay journiesPerDay = new JourniesPerDay(journies.get(0).dt);
        for(Journey journey : journies){
            FarePricingUtility.fillFare(journey);
            journiesPerDay.add(journey);
            FareCappingUtility.updateFareCap(journey, journiesPerDay);
        }
        assertEquals(120, journiesPerDay.calculateFare());
    }
    
}
