
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;

public class Part2 {
    public String findSimpleGene(String DNA, String startCodon, String stopCodon){
        String gene = "";
        
        String dna = DNA.toLowerCase();
        int start = dna.indexOf(startCodon);
        if (start == -1){
            return "ATG not found";
        }
        
        int end = dna.indexOf(stopCodon,start+3);
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
        System.out.println("Gene: "+findSimpleGene(protein,"atg","taa"));
    }
    
    public static void main(String[] args){
        Part2 p2 = new Part2();
        
        p2.testSimpleGene();
    }
    

}