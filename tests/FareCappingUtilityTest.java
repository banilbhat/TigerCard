package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;

import org.junit.Test;

import entities.FareCap;
import exceptions.CustomException;
import utilities.FareCappingUtility;
import utilities.RulesCreator;

public class FareCappingUtilityTest {
    @Test
    public void testInput(){
        try {
            RulesCreator.Test_Path = "bin\\";
            FareCappingUtility.init();
            FareCap fc11 = FareCappingUtility.fareCapMap.get("1-1");
            FareCap fc12 = FareCappingUtility.fareCapMap.get("1-2");
            FareCap fc21 = FareCappingUtility.fareCapMap.get("2-1");
            FareCap fc22 = FareCappingUtility.fareCapMap.get("2-2");
            assertEquals(100, fc11.dailyCap);
            assertEquals(500, fc11.weeklyCap);
            assertEquals(120, fc12.dailyCap);
            assertEquals(600, fc12.weeklyCap);
            assertEquals(120, fc21.dailyCap);
            assertEquals(600, fc21.weeklyCap);
            assertEquals(80, fc22.dailyCap);
            assertEquals(400, fc22.weeklyCap);
        }
        catch(CustomException ex){
            fail(ex.getMessage());
        } catch (IOException ex) {
            fail(ex.getMessage());
        }
    }
}
