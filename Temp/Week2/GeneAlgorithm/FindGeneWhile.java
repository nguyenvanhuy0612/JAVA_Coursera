
/**
 * Write a description of FindGeneWhile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;

public class FindGeneWhile {
    public String findGen(String dna){
        String DNA = dna.toUpperCase();
        //Find first occurrence of "ATG" call its index "startIndex"
        int startIndex = DNA.indexOf("ATG");
        int currIndex = DNA.indexOf("TAA",startIndex + 3);
        while (currIndex != -1){
            if ((currIndex - startIndex) % 3 == 0){
                return dna.substring(startIndex,currIndex+3);
            }else{
                currIndex = DNA.indexOf("TAA",currIndex + 1);
            }
        }
        return "";
    }

    public static void main(String[] args){
        FindGeneWhile fg = new FindGeneWhile();

        FileResource fr = new FileResource();
        String str ="";
        for (String s : fr.words()){
            str += s;
        }
        String result = fg.findGen(str);
        System.out.println("Gene "+result+"\r\n"+result.length());
    }
}
