
/**
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;

public class Part4 {
    public void getURL(){
        URLResource ur = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        String result = "";
        for (String s : ur.words()){
            String sLower = s.toLowerCase();
            //System.out.println(sLower);
            int pos1 = sLower.indexOf("youtube.com");
            if ( pos1 != -1){
                int begin = sLower.indexOf("\"") + 1;
                int end = sLower.indexOf("\"",pos1);
                result += s.substring(begin,end)+"\r\n";
            }
        }
        System.out.println(result);
    }
    public static void main(String[] args){
        Part4 p4 = new Part4();
        p4.getURL();
    }
    
        
}
