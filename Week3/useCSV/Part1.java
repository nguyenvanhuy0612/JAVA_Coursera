
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
public class Part1 {

    public CSVParser tester() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        return parser;
    }

    public String countryInfo(CSVParser parser, String country) {
        String countryName = "NOT FOUND";
        for (CSVRecord record : parser){
            String currCountry = record.get("Country");
            if (currCountry.contains(country)){
                countryName = record.get("Country") + ": "+record.get("Exports")+ ": "+record.get("Value (dollars)");
                return countryName;
            }
        }
        return countryName;
    }

    public void testCountryInfo() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        
        System.out.println(countryInfo(parser, "Malaysia"));
        System.out.println(countryInfo(parser, "Germany"));
    }

}
