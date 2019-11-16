
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;

public class Part3 {
    public boolean twoOccurrences(String stringa, String stringb){
        int pos1 = stringb.indexOf(stringa);
        if (pos1 == -1){
            return false;
        }
        int pos2 = stringb.indexOf(stringa,pos1+1);
        if (pos2 == -1){
            return false;
        }
        return true;
    }
    public void testtwoOccurrences(){
        String stra = "yby";
        String strb = "A story ybyby Abby Long";
        System.out.println(twoOccurrences(stra,strb));
    }
    public String lastPart(String stringa, String stringb){
        int pos1 = stringb.indexOf(stringa);
        if (pos1 == -1){
            return stringb;
        }
        return stringb.substring(pos1+stringa.length());
    }
    public void testlastPart(){
        String stra = "yby";
        String strb = "A story ybyby Abby Long";
        System.out.println("The part of the string after "+stra+" in "+strb+" is "+lastPart(stra,strb));
    }
}

