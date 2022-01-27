package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import entities.Journey;
import entities.JourniesPerWeek;
import exceptions.CustomException;
import utilities.Constants;
import utilities.FareCappingUtility;
import utilities.FarePricingUtility;
import utilities.InputUtility;
import utilities.JourneyUtility;
import utilities.RulesCreator;

public class JourniesPerWeekTest {
    @Before
    public void init() throws CustomException, IOException{
        RulesCreator.Test_Path = "bin" + File.separator;
        RulesCreator.init();
    }
    
    @Test
    public void testSingleDay() throws IOException, CustomException{
        List<String> inputlines = InputUtility.readInputLines(Constants.TEST_INPUT_FILE_SINGLE_WEEK);
        List<Journey> journies = JourneyUtility.parseInputtoJournies(inputlines);
        JourniesPerWeek journiesPerWeek = new JourniesPerWeek(journies.get(0).dt);
        for(Journey journey : journies){
            FarePricingUtility.fillFare(journey);
            journiesPerWeek.populateJourneyStructureAndFareCap(journey);
            FareCappingUtility.updateFareCap(journey, journiesPerWeek);
        }
        assertEquals(545, journiesPerWeek.calculateFare());
    }
}
