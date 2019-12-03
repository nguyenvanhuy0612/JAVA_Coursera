
/**
 * Write a description of HottestDay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class CSVMax {

    public CSVRecord getLargestOfTwoRow(CSVRecord currentRow, CSVRecord largestSoFar){
        if (largestSoFar == null){
            largestSoFar = currentRow;
        }else{
            double currentTemperature = Double.parseDouble(currentRow.get("TemperatureF"));
            double largestTemperature = Double.parseDouble(largestSoFar.get("TemperatureF"));
            if (currentTemperature > largestTemperature){
                largestSoFar = currentRow;
            }
        }
        return largestSoFar;
    }

    public CSVRecord hottestHourInFile(CSVParser parser){
        CSVRecord largestSoFar = null;
        for (CSVRecord currentRow : parser){
            /*
            if (largestSoFar == null){
            largestSoFar = currentRow;
            }else{
            double currentTemperature = Double.parseDouble(currentRow.get("TemperatureF"));
            double largestTemperature = Double.parseDouble(largestSoFar.get("TemperatureF"));
            if (currentTemperature > largestTemperature){
            largestSoFar = currentRow;
            }
            }
             */

            largestSoFar = getLargestOfTwoRow(currentRow, largestSoFar);

        }
        System.out.println("largestSoFar: " +largestSoFar.toString());
        return largestSoFar;
    }

    public CSVRecord hottestInManyDays(){
        CSVRecord largestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord currentRowInFile = hottestHourInFile(fr.getCSVParser());
            /*
            if (largestSoFar == null){
            largestSoFar = currentRowInFile;
            }else{
            double currentTemperature = Double.parseDouble(currentRowInFile.get("TemperatureF"));
            double largestTemperature = Double.parseDouble(largestSoFar.get("TemperatureF"));
            if (currentTemperature > largestTemperature){
            largestSoFar = currentRowInFile;
            }
            }
             */
            largestSoFar = getLargestOfTwoRow(currentRowInFile, largestSoFar);
        }
        return largestSoFar;
    }

    public void testHottestInDay(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord largest = hottestHourInFile(parser);
        System.out.println("Maximum Temperature "+ largest.get("TemperatureF") + " at " + largest.get("TimeEST"));
    }

    public void testHottestInManyDays(){
        CSVRecord largest = hottestInManyDays();
        System.out.println("Largest temperature was "+ largest.get("TemperatureF") + " at " + largest.get("DateUTC"));
    }
}
