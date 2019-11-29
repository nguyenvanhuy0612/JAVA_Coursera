
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
        CSVRecord largestSoFar = null;
        for (CSVRecord currentRow : parser){
            if (largestSoFar == null){
                largestSoFar = currentRow;
            }else{
                double currentTemperature = Double.parseDouble(currentRow.get("TemperatureF"));
                double largestTemperature = Double.parseDouble(largestSoFar.get("TemperatureF"));
                if (currentTemperature > largestTemperature){
                    largestSoFar = currentRow;
                }
            }
        }
    }

}
