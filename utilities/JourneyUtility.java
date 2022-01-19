package utilities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import entities.Journey;
import exceptions.CustomException;

public class JourneyUtility {

    public static List<Journey> parseInputtoJournies(List<String> inputlines) throws CustomException{
        List<Journey> journies = new ArrayList<>();
        for(String inputLine:inputlines){
            inputLine = inputLine.trim();
            String[] input = inputLine.split(" ");
            if(input.length <= 3){
                throw new CustomException("invalid input:" + inputLine);
            }
            LocalDate dt = DateTime.parseDate(input[0]);
            LocalTime time  = DateTime.parseTime(input[1]);    
            Journey journey = new Journey(dt, time, input[2], input[3]);
            journies.add(journey);
        }
        return journies;
    }

}