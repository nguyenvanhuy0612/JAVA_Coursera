/**
 * Write a description of FindAllGene here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class FindAllGene {
    public int findStopIndex (String dna, int startIndex, String stopCodon){

        int currIndex = dna.indexOf(stopCodon, startIndex + 3);
        while (currIndex != -1){
            if ((currIndex - startIndex) %3 == 0){
                return currIndex;
            }
            currIndex = dna.indexOf(stopCodon, currIndex + 1);
        }
        return currIndex;
    }

    public String findGene(String dna, int beginIndex){
        int startIndex = dna.indexOf("ATG", beginIndex);
        if (startIndex == -1){ return "";}

        int taaIndex = findStopIndex(dna, startIndex, "TAA");
        int tagIndex = findStopIndex(dna, startIndex, "TAG");
        int tgaIndex = findStopIndex(dna, startIndex, "TGA");

        //Test taa, tag, tga
        //taaIndex = 1;
        //tagIndex = 2;

        System.out.println("startIndex "+startIndex);
        System.out.println("taaIndex "+taaIndex);
        System.out.println("tagIndex "+tagIndex);
        System.out.println("tgaIndex "+tgaIndex);

        //Find positive integer Minimum

        int temp= 0, minIndex = 0;

        if (tagIndex == -1 || (taaIndex < tagIndex) && (taaIndex != -1)){
            temp = taaIndex;
        }else {temp = tagIndex;}

        System.out.println("temp "+temp);
        if (tgaIndex == -1 || (temp < tgaIndex) && (temp != -1)){
            minIndex = temp;
        }else {minIndex = tgaIndex;}
        System.out.println("minIndex "+minIndex);

        if (minIndex == -1){ return "";}

        return dna.substring(startIndex, minIndex + 3);
    }

    public void testfindGene(){
        //                      1         2         3         4         5  
        //            0123456789012345678901234567890123456789012345678901234
        String DNA = "ATGATGCGCTACTAAAATGCCCTGTCAGCATGATCGTAGCATCGACTGTAC";

        System.out.println("dna "+DNA);
        System.out.println("findGene "+findGene(DNA, 0));

    }

    public void printAllGene(String dna){
        int startIndex = 0;

        while (true){
            String currGene = findGene(dna, startIndex);
            if (currGene.isEmpty()){
                break;
            }
            System.out.println("currGene "+currGene);
            startIndex = dna.indexOf(currGene, startIndex) + currGene.length();
        } 
    }
    
    public void testprintAllGene(){
        //                      1         2         3         4         5  
        //            0123456789012345678901234567890123456789012345678901234
        String dna = "ATGATGCGCTACTAAAATGCCCTGTCAGCATTGAGATGTAGCATCGACTGTAC";

        System.out.println("dna "+dna);
        printAllGene(dna);

    }
}
