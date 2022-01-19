package utilities;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Journey;
import entities.PeakTime;
import exceptions.CustomException;

public class PeakRulesUtility{
    private final static  String WEEK_DAY = "weekday";
    // private final static String WEEK_END = "weekend";
    private final static int MONDAY = 1;
    private final static int TUESDAY = 2;
    private final static int WEDNESDAY = 3;
    private final static int THURSDAY = 4;
    private final static int FRIDAY = 5;
    private final static int SATURDAY = 6;
    private final static int SUNDAY = 7;

    public static List<PeakTime> weekDayPeakTimes;
    public static List<PeakTime> weekendPeakTimes;
    
    public static void init() throws CustomException, IOException{
        weekDayPeakTimes = new ArrayList<>();
        weekendPeakTimes = new ArrayList<>();
        List<String> ruleLines = InputUtility.readInputLines(RulesCreator.Test_Path + "inputs\\peakrules.txt");
        parseInputtoPeakTimeRules(ruleLines);
    }

    public static void parseInputtoPeakTimeRules(List<String> inputlines) throws CustomException{
        for(String inputLine:inputlines){
            inputLine = inputLine.trim();
            String[] input = inputLine.split(" ");
            if(input.length <= 1){
                throw new CustomException("invalid peak rules input");
            }
            for(int i=1;i<input.length;i++){
               String[] strPeakTimes = input[i].split("-");
               PeakTime pk = new PeakTime(DateTime.parseTime(strPeakTimes[0]), DateTime.parseTime(strPeakTimes[1]));
               storePeakTime(pk, input[0]);
            }
        }
    }

    private static void storePeakTime(PeakTime pk , String day) {
        
        if(day.toLowerCase().equals(WEEK_DAY)){
            weekDayPeakTimes.add(pk);
        }
        else{
            weekendPeakTimes.add(pk);
        }
    }

    public static Boolean isWithinPeak(Journey journey) {
        switch(journey.dayOfWeek){
            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY:
                for(PeakTime pk:weekDayPeakTimes){
                    if(pk.isWithinPeakTime(journey.time))
                        return true;
                }
                break;
            case SATURDAY:
            case SUNDAY:    
                for(PeakTime pk:weekendPeakTimes){
                    if(pk.isWithinPeakTime(journey.time))
                        return true;
                }
                break;
        }
        return false;
    }
}