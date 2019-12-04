
/**
 * Write a description of Assignment here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;
import org.apache.commons.csv.*;

public class Temporary_test2 {
    
    public StorageResource getLargestOfTwoRow(CSVRecord currentRow, CSVRecord largestSoFar){
        
        StorageResource sr = new StorageResource();
        
        if (largestSoFar == null){
            largestSoFar = currentRow;
        }else{
            double currentTemperature = Double.parseDouble(currentRow.get("TemperatureF"));
            double largestTemperature = Double.parseDouble(largestSoFar.get("TemperatureF"));
            if (currentTemperature >= largestTemperature){
                
                largestSoFar = currentRow;
                if (currentTemperature > largestTemperature){
                    sr.clear();
                    sr.add(largestSoFar.toString());
                }else{
                    sr.add(largestSoFar.toString());
                }
            }
        }
        
        
        
        return null;
    }
}
