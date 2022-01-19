package tests;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import utilities.InputUtility;

public class InputUtilityTest {
    @Test
    public void testInput(){
        try {
            List<String> inputs = InputUtility.readInputLines(utilities.Constants.TEST_INPUT_FILE_SINGLE_DAY);
            assertEquals(5, inputs.size());
        }
        catch(IOException ex){
            fail("Exception raised while reading the file");
        }
    }
    
}
