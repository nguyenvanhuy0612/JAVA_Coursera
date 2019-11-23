
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;
import edu.duke.*;

public class Part1 {
    public String collectDNA(){
        FileResource f = new FileResource();
        String dna = f.asString();
        //for (String s : f.words()){
            //dna += s;
        //}
        return dna;
    }

    public int findStopIndex(String dna, int startIndex, String stopCodon){ //System.out.println("findStopIndex");
        int currIndex = dna.indexOf(stopCodon, startIndex + 3);
        while (currIndex != -1){
            int distance = currIndex - startIndex;
            if (distance %3 == 0){
                return currIndex;
            }
            currIndex = dna.indexOf(stopCodon, currIndex + 1);
        }
        // return dna.length();
        return -1;
    }

    public void testFindStopCodon(){
        String dna = "ATGCGTGATTAA";
        System.out.println("findStopIndex "+findStopIndex(dna, 0, "TAA"));
    }

    public int findPositiveInterger(int num1, int num2) {
        if (num1*num2 == 1){
            return -1;
        }
        if (num1*num2 < 0){
            return -1*num1*num2;
        }
        return Math.min(num1,num2);
    }

    public String findGene(String dna, int beginDNAIndex){
        int startIndex = dna.indexOf("ATG", beginDNAIndex);
        if (startIndex == -1){return ""; }

        int taaIndex = findStopIndex(dna, startIndex, "TAA");
        int tagIndex = findStopIndex(dna, startIndex, "TAG");
        int tgaIndex = findStopIndex(dna, startIndex, "TGA");
        
        int minIndex = findPositiveInterger(findPositiveInterger(taaIndex, tagIndex), tgaIndex);

        if (minIndex == -1){ return ""; }

        return dna.substring(startIndex, minIndex + 3);
    }

    public void testFindGene(){
        String dna = collectDNA();
        dna = dna.toUpperCase();
        System.out.println(dna);
        System.out.println("dna.length() "+dna.length());
        System.out.println(findGene(dna, 0));
    }

    public void printAllGenes(String dna){
        int beginGene = dna.indexOf("ATG");
        while (true){
            String currGene = findGene(dna, beginGene);
            if (currGene.isEmpty()){
                break;
            }
            System.out.println("currGene "+currGene);
            beginGene = dna.indexOf(currGene, beginGene) + currGene.length();
        }
    }

    public StorageResource getAllGenes(String dna){
        StorageResource sr = new StorageResource();
        int startIndex = dna.indexOf("ATG");
        while (true){
            String currGene = findGene(dna, startIndex);
            if (currGene.isEmpty()){
                break;
            }
            sr.add(currGene);
            startIndex = dna.indexOf(currGene, startIndex) + currGene.length();
        }
        return sr;
    }

    public void testPrintAllGenes(){
        String dna = collectDNA();
        dna = dna.toUpperCase();
        System.out.println(dna);
        System.out.println("dna.length() "+dna.length());
        printAllGenes(dna);
    }

    public void testGetAllGenes(){
        String dna = collectDNA();
        dna = dna.toUpperCase();
        //System.out.println(dna);
        System.out.println("dna.length() "+dna.length());
        StorageResource allGenes = getAllGenes(dna);
        for (String s : allGenes.data()){
            System.out.println(s);
        }
        System.out.println("Number of Gene "+allGenes.size());
    }
}

