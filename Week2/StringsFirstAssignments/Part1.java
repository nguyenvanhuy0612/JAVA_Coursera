
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;

public class Part1 {
    public String findSimpleGene(String DNA){
        String gene = "";
        
        String dna = DNA.toLowerCase();
        int start = dna.indexOf("atg");
        if (start == -1){
            return "ATG not found";
        }
        
        int end = dna.indexOf("taa",start+3);
        if (end == -1 || ((end - start)%3 != 0)){
            return "";
        } else{
            gene = DNA.substring(start,end+3);
        }
        
        return gene;
    }
    
    public void testSimpleGene(){
        String protein = "";
        FileResource fr = new FileResource();
        for (String str : fr.words()){
            protein += str;
        }
        System.out.println("File input: "+protein);
        System.out.println("Gene: "+findSimpleGene(protein));
    }
    
    public static void main(String[] args){
        Part1 p1 = new Part1();
        
        p1.testSimpleGene();
    }
    

}
