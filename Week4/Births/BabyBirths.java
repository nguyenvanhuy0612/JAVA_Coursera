
/**
 * Write a description of BabyBirths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;
import org.apache.commons.csv.*;
import edu.duke.*;
public class BabyBirths {

    public void printNames() {
        FileResource fr = new FileResource();
        for (CSVRecord rec : fr.getCSVParser(false)){
            int numBorn = Integer.parseInt(rec.get(2));
            if (numBorn <= 100){
                System.out.println("Name "+ rec.get(0) +
                    " Gender "+ rec.get(1) +
                    " Num Born "+ rec.get(2));
            }
        }
    }

    public void totalBirths(FileResource fr ){
        float totalBirths = 0;
        float totalGirls = 0;
        float totalBoys = 0;
        for (CSVRecord rec : fr.getCSVParser(false)){
            int numBorn = Integer.parseInt(rec.get(2));
            if (rec.get(1).intern() == "f|F"){ //[fF]
                totalGirls +=numBorn;
            }else{
                totalBoys += numBorn;
            }
        }
        System.out.println("total births: "+totalBirths);
    }

    public void testTotalBirths(){
        FileResource fr = new FileResource();
        totalBirths(fr);
    }
}
