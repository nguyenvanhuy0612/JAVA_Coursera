
/**
 * Write a description of Assignments here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class Assignment {

    public void findColdestDayOfYear(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord smallestSoFar = null;
        for (CSVRecord currentRow : parser){
            if (smallestSoFar == null){
                smallestSoFar = currentRow;
            }else{
                double currentTemperature = Double.parseDouble(currentRow.get("TemperatureF"));
                double smallestTemperature = Double.parseDouble(smallestSoFar.get("TemperatureF"));
                if (currentTemperature > smallestTemperature){
                    smallestSoFar = currentRow;
                }
            }
        }
    }
    
    public CSVRecord getSmallestOfTwoRow(CSVRecord smallestSoFar, CSVRecord currentRow){
        if (smallestSoFar == null){
            smallestSoFar = currentRow;
        }else{
            double currentTemperature = Double.parseDouble(currentRow.get("TemperatureF"));
            double smallestTemperature = Double.parseDouble(smallestSoFar.get("TemperatureF"));
            if (currentTemperature < smallestTemperature){
                smallestSoFar = currentRow;
            }
        }
        return smallestSoFar;
    }
    
    public CSVRecord coldestHourInFile(CSVParser parser){
        CSVRecord smallestSoFar = null;
        for (CSVRecord currentRow : parser){
            smallestSoFar = getSmallestOfTwoRow(smallestSoFar, currentRow);
        }
        //System.out.println("The smallest temperature was "+smallestSoFar.get("TemperatureF")+" at "+smallestSoFar.get("TimeEST")+" in "+smallestSoFar.get("DateUTC"));
        return smallestSoFar;
    }
    
    public void testColdestHourInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord smallestSoFar = null;
        smallestSoFar = coldestHourInFile(parser);
        System.out.println("The smallest temperature was "+smallestSoFar.get("TemperatureF")+" at "+smallestSoFar.get("TimeEST")+" in "+smallestSoFar.get("DateUTC"));
    }
}
