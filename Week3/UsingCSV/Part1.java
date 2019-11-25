
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
        String countryName = "";
        for (CSVRecord record : parser){
            String currCountry = record.get("Country");
            if (currCountry.contains(country)){
                countryName = countryName + record.get("Country") + ": "+record.get("Exports")+ ": "+record.get("Value (dollars)");
            }
        }
        if (countryName.isEmpty()){
            return "NOT FOUND";
        }
        return countryName;
    }
    
    public void testCountryInfo() {
        CSVParser ps = tester();
        System.out.println(countryInfo(ps, "Germany"));
        System.out.println(countryInfo(ps, "Malaysia"));
    }

}
