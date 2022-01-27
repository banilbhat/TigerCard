package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;

import org.junit.Test;

import entities.PeakTime;
import exceptions.CustomException;
import utilities.PeakRulesUtility;
import utilities.RulesCreator;

public class PeakRulesUtilityTest {
    @Test
    public void testInput(){
        try {
            RulesCreator.Test_Path = "bin" + File.separator;
            PeakRulesUtility.init();
            assertEquals(2, PeakRulesUtility.weekDayPeakTimes.size());
            assertEquals(2, PeakRulesUtility.weekendPeakTimes.size());
            
            PeakTime pkweekDay1 = PeakRulesUtility.weekDayPeakTimes.get(0);
            assertFalse(pkweekDay1.isWithinPeakTime(LocalTime.of(6,30)));
            assertTrue(pkweekDay1.isWithinPeakTime(LocalTime.of(7,0)));
            assertTrue(pkweekDay1.isWithinPeakTime(LocalTime.of(9,0)));
            assertTrue(pkweekDay1.isWithinPeakTime(LocalTime.of(10,0)));
            assertFalse(pkweekDay1.isWithinPeakTime(LocalTime.of(11,30)));

            PeakTime pkweekDay2 = PeakRulesUtility.weekDayPeakTimes.get(1);
            assertFalse(pkweekDay2.isWithinPeakTime(LocalTime.of(16,30)));
            assertTrue(pkweekDay2.isWithinPeakTime(LocalTime.of(17,0)));
            assertTrue(pkweekDay2.isWithinPeakTime(LocalTime.of(18,30)));
            assertTrue(pkweekDay2.isWithinPeakTime(LocalTime.of(20,0)));
            assertFalse(pkweekDay2.isWithinPeakTime(LocalTime.of(20,30)));

            PeakTime pkweekEnd1 = PeakRulesUtility.weekendPeakTimes.get(0);
            assertFalse(pkweekEnd1.isWithinPeakTime(LocalTime.of(6,30)));
            assertTrue(pkweekEnd1.isWithinPeakTime(LocalTime.of(9,0)));
            assertTrue(pkweekEnd1.isWithinPeakTime(LocalTime.of(10,0)));
            assertTrue(pkweekEnd1.isWithinPeakTime(LocalTime.of(11,00)));
            assertFalse(pkweekEnd1.isWithinPeakTime(LocalTime.of(11,30)));

            PeakTime pkweekEnd2 = PeakRulesUtility.weekendPeakTimes.get(1);
            assertFalse(pkweekEnd1.isWithinPeakTime(LocalTime.of(17,30)));
            assertTrue(pkweekEnd2.isWithinPeakTime(LocalTime.of(18,0)));
            assertTrue(pkweekEnd2.isWithinPeakTime(LocalTime.of(18,30)));
            assertTrue(pkweekEnd2.isWithinPeakTime(LocalTime.of(22,0)));
            assertFalse(pkweekEnd2.isWithinPeakTime(LocalTime.of(22,30)));
        }
        catch(CustomException ex){
            fail(ex.getMessage());
        } catch (IOException ex) {
            fail(ex.getMessage());
        }
    }
}
