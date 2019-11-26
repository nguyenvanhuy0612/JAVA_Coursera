
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
public class Part1 {

    public void tester() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        
        //System.out.println(countryInfo(parser, "Malaysia"));
        //parser = fr.getCSVParser();
        //System.out.println(countryInfo(parser, "Germany"));

        //parser = fr.getCSVParser();
        //System.out.println(countryInfo(parser, "Nauru"));

        //parser = fr.getCSVParser();
        //listExportersTwoProducts(parser, "gold", "diamonds");
        //listExportersTwoProducts(parser, "fish", "nuts");

        //parser = fr.getCSVParser();
        //System.out.println("numberOfExporters: " + numberOfExporters(parser, "gold"));
        //System.out.println("numberOfExporters: " + numberOfExporters(parser, "gold"));

        //parser = fr.getCSVParser();
        bigExporters(parser, "$999,999,999,999");

        //parser = fr.getCSVParser();
        //bigExporters1(parser, "$999,999,999,999");
    }

    public String countryInfo(CSVParser parser, String country) {
        String countryName = "NOT FOUND";
        for (CSVRecord record : parser){
            System.out.println(record);
            String currCountry = record.get("Country");
            if (currCountry.contains(country)){
                countryName = record.get("Country") + ": "+record.get("Exports")+ ": "+record.get("Value (dollars)");
                return countryName;
            }
        }
        return countryName;
    }

    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2){
        for (CSVRecord record : parser){
            if (record.get("Exports").contains(exportItem1) && record.get("Exports").contains(exportItem2)){
                System.out.println(record.get("Country"));
            }
        } 
    }

    public int numberOfExporters(CSVParser parser, String exportItem){
        int count = 0;
        for (CSVRecord record : parser){
            if (record.get("Exports").contains(exportItem)){
                count++;
            }
        }
        return count;
    }

    public double convertToDouble(String input){
        String currString = input.replace("$", "");
        currString = currString.replace(",", "");

        // try {
        // Double.parseDouble(currString);
        // }   catch (Exception e){
        // System.out.println("wrong value dolla format");
        
        // return 1;
        // }

        double stringToNumber = Double.parseDouble(currString);
        return stringToNumber;
    }

    public void bigExporters(CSVParser parser, String amount){
        double amountNum = convertToDouble(amount);
        for (CSVRecord record : parser){
            String valueItem = record.get("Value (dollars)");
            double valueNum = convertToDouble(valueItem);
            if (valueNum > amountNum){
                System.out.println(record.get("Country")+" "+valueItem);
            }
        }
    }

    public void bigExporters1(CSVParser parser, String amount){
        for (CSVRecord record : parser){
            if (record.get("Value (dollars)").length() > amount.length()){
                System.out.println(record.get("Country")+" "+record.get("Value (dollars)"));
            }
        }
    }
}
