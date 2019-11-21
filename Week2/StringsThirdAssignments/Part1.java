
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
        String dna = "";
        for (String s : f.words()){
            dna += s;
        }
        //System.out.println("dna "+dna);
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

    public String findGene(String dna, int beginIndex){
        int startIndex = dna.indexOf("ATG", beginIndex);
        if (startIndex == -1){
            return "";
        }
        int taaIndex = findStopIndex(dna, startIndex, "TAA");   //System.out.println("taaIndex "+taaIndex);
        int tagIndex = findStopIndex(dna, startIndex, "TAG");   //System.out.println("tagIndex "+tagIndex);
        int tgaIndex = findStopIndex(dna, startIndex, "TGA");   //System.out.println("tgaIndex "+tgaIndex);
        // int minIndex = Math.min(taaIndex, tagIndex);
        // minIndex = Math.min(minIndex, tgaIndex);               //System.out.println("minIndex "+minIndex);

        // if (minIndex == dna.length()){
        // return "";
        // }
        int minIndex = 0;
        if (taaIndex == -1 || ((tagIndex != -1) && (tagIndex < taaIndex))){
            minIndex = tagIndex;
        }else{ minIndex = tagIndex; }
        if (minIndex == -1 || ((tgaIndex != -1) && (tgaIndex < minIndex))){
            minIndex = tgaIndex;
        }
        if (minIndex == -1){
            return "";
        }
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
        int startIndex = dna.indexOf("ATG");
        while (startIndex != -1){
            String currGene = findGene(dna, startIndex);
            if (currGene.isEmpty()){
                break;
            }
            System.out.println("currGene "+currGene);
            startIndex = dna.indexOf(currGene, startIndex) + currGene.length();
        }
    }

    public StorageResource getAllGenes(String dna){
        StorageResource sr = new StorageResource();
        int startIndex = dna.indexOf("ATG");
        while (startIndex != -1){
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
        System.out.println(dna);
        System.out.println("dna.length() "+dna.length());
        StorageResource allGenes = getAllGenes(dna);
        for (String s : allGenes.data()){
            System.out.println(s);
        }
        System.out.println("Number of Gene "+allGenes.size());
    }
}


