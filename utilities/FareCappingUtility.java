package utilities;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import entities.FareCap;
import entities.Journey;
import entities.JourniesPerDay;
import entities.JourniesPerMonth;
import entities.JourniesPerWeek;
import exceptions.CustomException;

public class FareCappingUtility {

    public static HashMap<String, FareCap> fareCapMap;
    public static void init() throws CustomException, IOException{

        fareCapMap = new HashMap<>();
        // weekendPeakTimes = new ArrayList<>();
        List<String> pricingLines = InputUtility.readInputLines(RulesCreator.Test_Path + "inputs" +File.separator+"farecapping.txt");
        parseInputtoFarePricing(pricingLines);
    }

    private static void parseInputtoFarePricing(List<String> pricingLines) throws CustomException {
        for(String priceLine:pricingLines){
            priceLine = priceLine.trim();
            String[] input = priceLine.split(" ");
            if(input.length <= 3){
                throw new CustomException("invalid farecapping input:" + priceLine);
            }
            try{
                int rank = Integer.parseInt(input[0]);
                String strPath = input[1];
                String[] zones = strPath.split("-");
                String from = zones[0];
                String to =  zones[1]; 
                double dailyCap = Double.parseDouble(input[2]);
                double weeklyCap = Double.parseDouble(input[3]);
                FareCap  fp = new FareCap(from, to, rank, dailyCap, weeklyCap);
                fareCapMap.put(fp.path, fp);
            }
            catch(Exception ex){
                throw new CustomException("Invalid Price input :" + priceLine) ;
            }
        }
    }

    public static void updateFareCap(Journey journey, JourniesPerMonth curMonthJourney) {
        FareCap fp = fareCapMap.get(journey.path);
        if(isNoRank(curMonthJourney.topRank) || curMonthJourney.topRank > fp.rank){
            curMonthJourney.topRank = fp.rank;
            curMonthJourney.fareCap = fp.dailyCap;
        }
    }

    public static void updateFareCap(Journey journey, JourniesPerWeek curWeekJourney) {
        FareCap fp = fareCapMap.get(journey.path);
        if(isNoRank(curWeekJourney.topRank) || curWeekJourney.topRank > fp.rank){
            curWeekJourney.topRank = fp.rank;
            curWeekJourney.fareCap = fp.weeklyCap;
        }
    }

    public static void updateFareCap(Journey journey, JourniesPerDay curDayJourney) {
        FareCap fp = fareCapMap.get(journey.path);
        if(isNoRank(curDayJourney.topRank) || curDayJourney.topRank > fp.rank){
            curDayJourney.topRank = fp.rank;
            curDayJourney.fareCap = fp.dailyCap;
        }
    }

    public static Boolean isNoRank(int rank){
        return rank == Constants.NO_RANK;
    }
}
