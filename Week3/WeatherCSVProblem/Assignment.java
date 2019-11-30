
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
        CSVRecord lowestSoFar = null;
        for (CSVRecord currentRow : parser){
            if (lowestSoFar == null){
                lowestSoFar = currentRow;
            }else{
                double currentTemperature = Double.parseDouble(currentRow.get("TemperatureF"));
                double lowestTemperature = Double.parseDouble(lowestSoFar.get("TemperatureF"));
                if (currentTemperature > lowestTemperature){
                    lowestSoFar = currentRow;
                }
            }
        }
    }

    /*
     * 
     * New algorithm
     * 
     */

    public CSVRecord getLowestTemperatureOfTwoRow(CSVRecord lowestSoFar, CSVRecord currentRow){
        if (lowestSoFar == null){
            lowestSoFar = currentRow;
        }else{
            double currentTemperature = Double.parseDouble(currentRow.get("TemperatureF"));
            double lowestTemperature = Double.parseDouble(lowestSoFar.get("TemperatureF"));
            if (currentTemperature < lowestTemperature){
                lowestSoFar = currentRow;
            }
        }
        return lowestSoFar;
    }

    public CSVRecord getLowestHumidityOfTwoRow(CSVRecord lowestSoFar, CSVRecord currentRow){
        if (lowestSoFar == null){
            lowestSoFar = currentRow;
        }else{
            double currentHumidity = Double.parseDouble(currentRow.get("Humidity"));
            double lowestHumidity = Double.parseDouble(lowestSoFar.get("Humidity"));
            if (currentHumidity < lowestHumidity){
                lowestSoFar = currentRow;
            }
        }
        return lowestSoFar;
    }

    public CSVRecord coldestHourInFile(CSVParser parser){
        CSVRecord lowestSoFar = null;
        for (CSVRecord currentRow : parser){
            lowestSoFar = getLowestTemperatureOfTwoRow(lowestSoFar, currentRow);
        }
        //System.out.println("The lowest temperature was "+lowestSoFar.get("TemperatureF")+" at "+lowestSoFar.get("TimeEST")+" in "+lowestSoFar.get("DateUTC"));
        return lowestSoFar;
    }

    public void testColdestHourInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord lowestSoFar = null;
        lowestSoFar = coldestHourInFile(parser);
        System.out.println("The lowest temperature was "+lowestSoFar.get("TemperatureF")+" at "+lowestSoFar.get("TimeEST")+" in "+lowestSoFar.get("DateUTC"));
    }

    public CSVRecord lowestHumidityInFile(CSVParser parser){
        CSVRecord lowestSoFar = null;
        for (CSVRecord currentRow : parser){
            lowestSoFar = getLowestHumidityOfTwoRow(lowestSoFar, currentRow);
        }
        System.out.println(lowestSoFar.toString());
        System.out.println("This return the first record that was found with lowest humidity");
        return lowestSoFar;
    }

    public void testLowestHumidityInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord lowestHumidity = lowestHumidityInFile(parser);
        System.out.println("Lowest Humidity was "+lowestHumidity.get("Humidity")+" at "+lowestHumidity.get("DateUTC"));
    }

    public double averageTemperatureInFile(CSVParser parser){
        double totalTemperature = 0;
        int totaRow = 0;
        for (CSVRecord currentRow : parser){
            double currentTemperature = Double.parseDouble(currentRow.get("TemperatureF"));
            totalTemperature += currentTemperature;
            totaRow++;
        }
        return totalTemperature/totaRow;
    }

    public void testAverageTemperatureInFile(){
        FileResource fr = new FileResource();
        System.out.println("Average temperature in file is " + averageTemperatureInFile(fr.getCSVParser()) + ".");
    }

    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value){
        double totalTemperature = 0;
        int totalRow = 0;

        for (CSVRecord currentRow : parser){
            double currentHumidity = Double.parseDouble(currentRow.get("Humidity"));
            if (currentHumidity >= value){
                double currentTemperature = Double.parseDouble(currentRow.get("TemperatureF"));
                totalTemperature += currentTemperature;
                totalRow++;
            }
        }
        if (totalRow == 0){
            System.out.println("No temperature with that humidity");
            totalRow = -1;
        }
        return totalTemperature/totalRow;
    }
    
    public void testAverageTemperatureWithHighHumidityInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        
    }
}
