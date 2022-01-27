package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import entities.Journey;
import exceptions.CustomException;
import utilities.Constants;
import utilities.FareCalculator;
import utilities.InputUtility;
import utilities.JourneyUtility;
import utilities.RulesCreator;

public class FareCalculatorTest {

    @Before
    public void init() throws CustomException, IOException{
        RulesCreator.Test_Path = "bin" + File.separator;
        RulesCreator.init();
    }

    @Test
    public void testdailyCap() throws CustomException, IOException{
        List<String> inputlines = InputUtility.readInputLines(Constants.TEST_INPUT_FILE_SINGLE_DAY);
        List<Journey> journies = JourneyUtility.parseInputtoJournies(inputlines);
        FareCalculator  fareCalculator = new FareCalculator(journies);
        assertEquals(120,fareCalculator.calculateFare());
    }  
    @Test
    public void testdailyCap1() throws CustomException, IOException{
        List<String> inputlines = InputUtility.readInputLines(Constants.TEST_INPUT_FILE_WEEKENDONLY);
        List<Journey> journies = JourneyUtility.parseInputtoJournies(inputlines);
        FareCalculator  fareCalculator = new FareCalculator(journies);
        assertEquals(220,fareCalculator.calculateFare());
    }

    @Test
    public void testdailyCap2() throws CustomException, IOException{
        List<String> inputlines = InputUtility.readInputLines(Constants.TEST_INPUT_FILE_2WEEKS_1);
        List<Journey> journies = JourneyUtility.parseInputtoJournies(inputlines);
        FareCalculator  fareCalculator = new FareCalculator(journies);
        assertEquals(450,fareCalculator.calculateFare());
    }

    
    @Test
    public void testdailyCap3() throws CustomException, IOException{
        List<String> inputlines = InputUtility.readInputLines(Constants.TEST_INPUT_FILE_SINGLE_WEEK);
        List<Journey> journies = JourneyUtility.parseInputtoJournies(inputlines);
        FareCalculator  fareCalculator = new FareCalculator(journies);
        assertEquals(545,fareCalculator.calculateFare());
    }
    
    @Test
    public void testCap4() throws CustomException, IOException{
        List<String> inputlines = InputUtility.readInputLines(Constants.TEST_INPUT_FILE_2WEEKS_2);
        List<Journey> journies = JourneyUtility.parseInputtoJournies(inputlines);
        FareCalculator  fareCalculator = new FareCalculator(journies);
        assertEquals(755,fareCalculator.calculateFare());
    }

    @Test
    public void testCap5() throws CustomException, IOException{
        List<String> inputlines = InputUtility.readInputLines(Constants.TEST_INPUT_FILE_2WEEKS_3);
        List<Journey> journies = JourneyUtility.parseInputtoJournies(inputlines);
        FareCalculator  fareCalculator = new FareCalculator(journies);
        assertEquals(305,fareCalculator.calculateFare());
    }
}
