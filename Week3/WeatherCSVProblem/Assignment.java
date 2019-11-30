
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

    public CSVRecord getLowestTemperatureOfTwoRow(CSVRecord lowestSoFar, CSVRecord currentRow){
        if (lowestSoFar == null){
            lowestSoFar = currentRow;
        }else{
            double currentTemperature = Double.parseDouble(currentRow.get("TemperatureF"));
            double lowestTemperature = Double.parseDouble(lowestSoFar.get("TemperatureF"));
            if (lowestTemperature > currentTemperature && currentTemperature != -9999){
                lowestSoFar = currentRow;
            }
        }
        return lowestSoFar; //maybe null
    }

    public CSVRecord coldestHourInFile(CSVParser parser){
        CSVRecord lowestSoFar = null;
        for (CSVRecord currentRow : parser){
            lowestSoFar = getLowestTemperatureOfTwoRow(lowestSoFar, currentRow);
        }
        //System.out.println("The lowest temperature was "+lowestSoFar.get("TemperatureF")+" at "+lowestSoFar.get("TimeEDT")+" in "+lowestSoFar.get("DateUTC"));
        return lowestSoFar; //maybe null
    }

    public String fileWithColdestTemperature(){
        File fileWithColdestTemp = null;
        CSVRecord lowestTemp = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVParser currentParser = fr.getCSVParser();
            CSVRecord currentRecord = coldestHourInFile(currentParser);
            if (lowestTemp == null){
                lowestTemp = currentRecord;
            }else{
                double currentTemperature = Double.parseDouble(currentRecord.get("TemperatureF"));
                double lowestTemperature = Double.parseDouble(lowestTemp.get("TemperatureF"));
                if (lowestTemperature > currentTemperature && currentTemperature != -9999){
                    lowestTemp = currentRecord;
                    fileWithColdestTemp = f;
                }
            }
        }
        String fileName = fileWithColdestTemp.getName();
        System.out.println("Coldest day was in the file "+fileName);
        System.out.println("Coldest temperature on that day was "+lowestTemp.get("TemperatureF"));

        FileResource fr = new FileResource(fileWithColdestTemp);
        System.out.println("All the Temperature on the coldest day were: "); 
        for (CSVRecord row : fr.getCSVParser()){       
            System.out.println(row.get("DateUTC")+" "+row.get("TemperatureF"));
        }
        return fileName; //not null
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
        return lowestSoFar; //maybe null
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

    public void testColdestHourInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord lowestSoFar = coldestHourInFile(parser);
        System.out.println("The lowest temperature was "+lowestSoFar.get("TemperatureF")+" at "+lowestSoFar.get("TimeEDT")+" in "+lowestSoFar.get("DateUTC"));
    }
    
    public void testFileWithColdestTemperature(){
        String abc = fileWithColdestTemperature();
    }
    
    public void testLowestHumidityInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord lowestHumidity = lowestHumidityInFile(parser);
        System.out.println("Lowest Humidity was "+lowestHumidity.get("Humidity")+" at "+lowestHumidity.get("DateUTC"));
    }

    public void testAverageTemperatureInFile(){
        FileResource fr = new FileResource();
        System.out.println("Average temperature in file is " + averageTemperatureInFile(fr.getCSVParser()) + ".");
    }

    public void testAverageTemperatureWithHighHumidityInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double avgTemperature = averageTemperatureWithHighHumidityInFile(parser, 80);
        if ( avgTemperature > 0){
            System.out.println("Average Temp when high Humidity is "+avgTemperature);
        }
    }
}
