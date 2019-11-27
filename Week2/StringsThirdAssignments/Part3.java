
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;
public class Part3 {
    
    Part1 p1 = new Part1();    
    Part2 p2 = new Part2();

    public void processGenes(StorageResource sr){
        //int numStringLonger9 = 0;
        //int numStringcgRatio035 = 0;
        
        int longestGene = 0;
        StorageResource geneSizeLarge9 = new StorageResource();
        StorageResource geneRatioHigher035 = new StorageResource();

        for (String currGene : sr.data()){
            if (currGene.length() > 9){
                geneSizeLarge9.add(currGene);
                //numStringLonger9++;
            }

            if (p2.cgRatio(currGene) > 0.35){
                geneRatioHigher035.add(currGene);
                //numStringcgRatio035++;
            }

            if (currGene.length() > longestGene){
                longestGene = currGene.length();
            }
        }

        // print all the Strings in sr that are longer than 9 characters
        System.out.println("==============================================");
        for (String gene : geneSizeLarge9.data()){
            System.out.println("geneSizeLarge9 "+gene);
        }

        // print the number of Strings in sr that are longer than 9 characters
        System.out.println("==============================================");
        System.out.println("numStringLonger9 "+geneSizeLarge9.size());
        System.out.println("==============================================");

        // print the Strings in sr whose C-G-ratio is higher than 0.35
        for (String gene : geneRatioHigher035.data()){
            System.out.println("geneRatioHigher035 "+gene);
        }

        // print the number of strings in sr whose C-G-ratio is higher than 0.35
        System.out.println("==============================================");
        System.out.println("numStringcgRatio035 "+geneRatioHigher035.size());
        System.out.println("==============================================");

        // print the length of the longest gene in sr
        System.out.println("longestGene "+longestGene);
        System.out.println("==============================================");

    }
    
    public void testProcessGenes(){
        String dna = p1.collectDNA();
        //dna = dna.toUpperCase();
        //System.out.println(dna);
        //System.out.println("==============================================");
        System.out.println("dna.length() "+dna.length());
        processGenes(p1.getAllGenes(dna));
    }
}
