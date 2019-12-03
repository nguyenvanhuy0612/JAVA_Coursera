
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

    //Temperature

    public CSVRecord getLowestTemperatureOfTwoRow(CSVRecord lowestSoFar, CSVRecord currentRow){
        String currTemp = currentRow.get("TemperatureF");
        if (!currTemp.matches("-?\\d+(\\.\\d+)?")){
            return lowestSoFar; //maybe null
        }
        if (lowestSoFar == null){
            return currentRow; //not null
        }
        String lowestTemp = lowestSoFar.get("TemperatureF");
        double currentTemperature = Double.parseDouble(currTemp);
        double lowestTemperature = Double.parseDouble(lowestTemp);
        if (lowestTemperature > currentTemperature && currentTemperature != -9999){
            return currentRow; //not null
        }
        return lowestSoFar; //not null
    }

    public CSVRecord coldestHourInFile(CSVParser parser){
        CSVRecord lowestSoFar = null;
        for (CSVRecord currentRow : parser){
            lowestSoFar = getLowestTemperatureOfTwoRow(lowestSoFar, currentRow);
        }
        return lowestSoFar; //maybe null but rarely occurs (1), if not null, lowestTemp was found
    }

    public String fileWithColdestTemperature(){
        File fileLowestTemp = null;
        CSVRecord lowestTempRow = null;

        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVParser currentParser = fr.getCSVParser();
            CSVRecord currentRecord = coldestHourInFile(currentParser);// Row in file f that min temperature .with (1), currentRecord is rarely null
            if (lowestTempRow == null){
                lowestTempRow = currentRecord;
                fileLowestTemp = f;
            }else{
                String currTemp = currentRecord.get("TemperatureF");
                String lowestTemp = lowestTempRow.get("TemperatureF");
                double currentTemperature = Double.parseDouble(currTemp);
                double lowestTemperature = Double.parseDouble(lowestTemp);
                if (lowestTemperature > currentTemperature && currentTemperature != -9999){
                    lowestTempRow = currentRecord;
                    fileLowestTemp = f;
                }
            }
        }
        return fileLowestTemp.getName(); //not null
    }

    //=======================================================================================
    //Humidity

    public CSVRecord getLowestHumidityOfTwoRow(CSVRecord lowestSoFar, CSVRecord currentRow){
        String currHum = currentRow.get("Humidity");
        if (!currHum.matches("-?\\d+(\\.\\d+)?")){
            return lowestSoFar; //maybe null
        }
        if (lowestSoFar == null){
            return currentRow; //not null
        }
        String lowestHum = lowestSoFar.get("Humidity");
        double currentHumidity = Double.parseDouble(currHum);
        double lowestHumidity = Double.parseDouble(lowestHum);
        if (lowestHumidity > currentHumidity){
            return currentRow; //not null
        }
        return lowestSoFar; //not null
    }

    public CSVRecord lowestHumidityInFile(CSVParser parser){
        CSVRecord lowestSoFar = null;
        for (CSVRecord currentRow : parser){
            lowestSoFar = getLowestHumidityOfTwoRow(lowestSoFar, currentRow);
        }
        return lowestSoFar;
    }

    public CSVRecord lowestHumidityInManyFiles(){
        CSVRecord lowestHumRow = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVParser currentParser = fr.getCSVParser();
            CSVRecord currentRecord = lowestHumidityInFile(currentParser);  //rarely null
            if (lowestHumRow == null){
                lowestHumRow = currentRecord;
            }else{
                double currentHumidity = Double.parseDouble(currentRecord.get("Humidity"));
                double lowestHumidity = Double.parseDouble(lowestHumRow.get("Humidity"));
                if (lowestHumidity > currentHumidity){
                    lowestHumRow = currentRecord;
                }
            }
        }
        return lowestHumRow;
    }

    public String fileWithLowestHumidity(){
        File fileLowestHum = null;
        CSVRecord lowestHumRow = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVParser currentParser = fr.getCSVParser();
            CSVRecord currentRecord = lowestHumidityInFile(currentParser);  //rarely null
            if (lowestHumRow == null){
                lowestHumRow = currentRecord;
                fileLowestHum = f;
            }else{
                double currentHumidity = Double.parseDouble(currentRecord.get("Humidity"));
                double lowestHumidity = Double.parseDouble(lowestHumRow.get("Humidity"));
                if (lowestHumidity > currentHumidity){
                    lowestHumRow = currentRecord;
                    fileLowestHum = f;
                }
            }
        }
        return fileLowestHum.getName();
    }

    //=======================================================================================
    //Average Temperature

    public double averageTemperatureInFile(CSVParser parser){
        double totalTemperature = 0;
        int totaRow = 0;
        for (CSVRecord currentRow : parser){
            String currTemp = currentRow.get("TemperatureF");
            if (currTemp.matches("-?\\d+(\\.\\d+)?") && !currTemp.equals("-9999")){
                double currentTemperature = Double.parseDouble(currTemp);
                totalTemperature += currentTemperature;
                totaRow++;
            }
        }
        return totalTemperature/totaRow;
    }

    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value){
        double totalTemperature = 0;
        int totalRow = 0;
        for (CSVRecord currentRow : parser){
            String currHum = currentRow.get("Humidity");
            String currTemp = currentRow.get("TemperatureF");                                                                           //currHum.intern() != "N\\A"
            if (currHum.matches("-?\\d+(\\.\\d+)?") && currTemp.matches("-?\\d+(\\.\\d+)?") && Double.parseDouble(currHum) >= value){   //https://www.javatpoint.com/java-string-intern
                totalTemperature += Double.parseDouble(currTemp);
                totalRow++;
            }
        }
        if (totalRow == 0){
            System.out.println("No temperature with that humidity");
            return -1;
        }
        return totalTemperature/totalRow;
    }

    //=======================================================================================
    //TEST

    public void testColdestHourInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord lowestSoFar = coldestHourInFile(parser);
        System.out.println("The lowest temperature was "+lowestSoFar.get("TemperatureF")+" at "+lowestSoFar.get(0)+" in "+lowestSoFar.get("DateUTC"));
    }

    public void testFileWithColdestTemperature(){
        String fileName = fileWithColdestTemperature();
        System.out.println("Coldest day was in the file "+fileName);
        //System.out.println("File: "+"nc_weather\\2014\\"+fileName);

        FileResource fr = new FileResource("nc_weather\\2014\\"+fileName);
        CSVParser parser = fr.getCSVParser();
        CSVRecord lowestTemp = coldestHourInFile(parser);
        System.out.println("Coldest temperature on that day was "+lowestTemp.get("TemperatureF"));
        System.out.println("All the Temperature on the coldest day were: ");

        parser = fr.getCSVParser();// Xai lai cai parser can khai bao bien lai parser
        for (CSVRecord row : parser){       
            System.out.println(row.get("DateUTC")+" "+row.get("TemperatureF"));
        }
    }

    public void testLowestHumidityInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord lowestHumidity = lowestHumidityInFile(parser);
        System.out.println("Lowest Humidity was "+lowestHumidity.get("Humidity")+" at "+lowestHumidity.get("DateUTC"));
    }

    public void testLowestHumidityInManyFiles(){
        CSVRecord lowestInFile = lowestHumidityInManyFiles();
        System.out.println("Lowest Humidity was "+lowestInFile.get("Humidity")+" at "+lowestInFile.get("DateUTC"));
    }

    public void testFileWithLowestHumidity(){
        String fileName = fileWithLowestHumidity();
        System.out.println("Lowest Humidity of day was in the file "+fileName);
        System.out.println("File: "+"nc_weather\\2014\\"+fileName);

        FileResource fr = new FileResource("nc_weather\\2014\\"+fileName);
        CSVParser parser = fr.getCSVParser();
        CSVRecord lowestHum = coldestHourInFile(parser);
        System.out.println("Lowest Humidity on that day was "+lowestHum.get("Humidity"));
        System.out.println("All the Humidity on the coldest day were: ");

        parser = fr.getCSVParser();// Xai lai cai parser can khai bao bien lai parser
        for (CSVRecord row : parser){       
            System.out.println(row.get("DateUTC")+" "+row.get("Humidity"));
        }
    }

    public void testAverageTemperatureInFile(){
        FileResource fr = new FileResource();
        System.out.println("Average temperature in file is " + averageTemperatureInFile(fr.getCSVParser()) + ".");
    }

    public void testAverageTemperatureWithHighHumidityInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double avgTemperature = averageTemperatureWithHighHumidityInFile(parser, 80);
        if ( avgTemperature != -1){
            System.out.println("Average Temp when high Humidity is "+avgTemperature);
        }
    }
}
