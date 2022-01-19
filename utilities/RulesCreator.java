package utilities;

import java.io.IOException;

import exceptions.CustomException;

public class RulesCreator {
    public static String Test_Path = "";
    public static void init() throws CustomException, IOException{
        PeakRulesUtility.init();
        FarePricingUtility.init();
        FareCappingUtility.init();
    }
}
