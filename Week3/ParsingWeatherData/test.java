
/**
 * Write a description of test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
import java.util.*;
public class test {
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public void sampleMethod() {
        // put your code here
        DirectoryResource dr =  new DirectoryResource();
        Iterable <File> f = dr.selectedFiles();
        System.out.println(f);
        
        
    }

}
