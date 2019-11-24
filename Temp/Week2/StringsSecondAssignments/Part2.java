
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;
public class Part2 {
    public String collectDNA(){
        FileResource f = new FileResource();
        String dna = "";
        for (String s : f.words()){
            dna += s;
        }
        //System.out.println("dna "+dna);
        return dna;
    }
    
    public int howMany(String stringa, String stringb){
        int currCount = stringb.indexOf(stringa);
        int totalCount = 0;
        while ( currCount != -1){
            totalCount += 1;
            currCount = stringb.indexOf(stringa, currCount + stringa.length());
        }
        return totalCount;
    }
    
    public void testHowMany(){
        String stra = "AA";
        String strb = "ATAAAAA";
        System.out.println("howMany "+howMany(stra, strb));
        System.out.println("howMany "+howMany("ABA", "ABABAAABAA"));
    }
}














