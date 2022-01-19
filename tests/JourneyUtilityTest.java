package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.junit.Test;

import entities.Journey;
import exceptions.CustomException;
import utilities.InputUtility;
import utilities.JourneyUtility;

public class JourneyUtilityTest {
    @Test
    public void test(){
        try {
            List<String> inputs = InputUtility.readInputLines(utilities.Constants.TEST_INPUT_FILE_SINGLE_DAY);
            assertEquals(5, inputs.size());
            List<Journey> journies = JourneyUtility.parseInputtoJournies(inputs);
            assertEquals(5, journies.size());

            Journey journey = journies.get(0); //2020-08-01 10:20 2 1 
            assertEquals(6, journey.dayOfWeek);
            assertEquals("2",journey.startZone);
            assertEquals("1",journey.endZone);
            assertEquals("2-1",journey.path);
            assertEquals(8, journey.month);
            assertEquals(LocalDate.of(2020, 8, 1), journey.dt);
            assertEquals(LocalTime.of(10, 20), journey.time);
            
            journey = journies.get(1); // 2020-08-01 10:45 1 1 
            assertEquals(6, journey.dayOfWeek);
            assertEquals("1",journey.startZone);
            assertEquals("1",journey.endZone);
            assertEquals("1-1",journey.path);
            assertEquals(8, journey.month);
            assertEquals(LocalDate.of(2020, 8, 1), journey.dt);
            assertEquals(LocalTime.of(10, 45), journey.time);

            journey = journies.get(2); // 2020-08-01 16:15 1 1 
            assertEquals(6, journey.dayOfWeek);
            assertEquals("1",journey.startZone);
            assertEquals("1",journey.endZone);
            assertEquals("1-1",journey.path);
            assertEquals(8, journey.month);
            assertEquals(LocalDate.of(2020, 8, 1), journey.dt);
            assertEquals(LocalTime.of(16, 15), journey.time);

            journey = journies.get(3);// 2020-08-01 18:15 1 1 
            assertEquals(6, journey.dayOfWeek);
            assertEquals("1",journey.startZone);
            assertEquals("1",journey.endZone);
            assertEquals("1-1",journey.path);
            assertEquals(8, journey.month);
            assertEquals(LocalDate.of(2020, 8, 1), journey.dt);
            assertEquals(LocalTime.of(18, 15), journey.time);
    
        }
        catch(IOException ex){
            fail(ex.getMessage());
        } catch (CustomException ex) {
            fail(ex.getMessage());
        }
    }
  
}
