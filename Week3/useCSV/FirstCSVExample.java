
/**
 * Write a description of FirstCSVExample here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
public class FirstCSVExample {

    public void readFood() {
        FileResource fr = new FileResource();
        CSVParser ps = fr.getCSVParser();
        for (CSVRecord record : ps){
           System.out.print(record.get("Name") + " ");
           System.out.print(record.get("Favorite Food") + " ");
           System.out.println(record.get("Favorite Color") + " ");
        }
    }

}