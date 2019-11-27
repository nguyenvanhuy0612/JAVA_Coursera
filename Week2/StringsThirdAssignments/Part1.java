
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;
import edu.duke.*;

public class Part1 {
    /*
     * - phương thức collectDNA sẽ lấy chuỗi dna từ file bất kì và trả về một giá trị String.
     * 
     * 
     * -trả về String
     */
    public String collectDNA(){
        FileResource f = new FileResource();
        String dna = f.asString();
        dna = dna.replaceAll("\\s+", "");
        dna = dna.toUpperCase();
        //for (String s : f.words()){
            //dna += s;
        //}
        return dna;
    }

    
    /*
     * - findStopIndex: tìm từ chuỗi dna, bắt đầu từ vị trí startIndex, với giá trị cần tìm
     * là stopCodon
     * 
     * - trả về int
     */
    public int findStopIndex(String dna, int startIndex, String stopCodon){ //System.out.println("findStopIndex");

        //Từ vị trí startIndex, ta tìm vị trí của stopCodon
        int currIndex = dna.indexOf(stopCodon, startIndex + 3);
        
        //sử dụng vòng lặp không biết trước số lần lặp lại
        //với điều kiện thoát vòng lặp là currIndex = -1: nghĩa là không tìm đc vị trí của stopCodon
        while (currIndex != -1){
            //khi đã chạy lệnh bên trong vòng while tức là điều kiện currIndex đã khác -1
            //Tìm khoảng cách từ startIndex đến stopCodon
            int distance = currIndex - startIndex;
            //nếu khoảng cách này chia hết cho 3
            if (distance %3 == 0){
                //trả về giá trị cần tìm là currIndex. Không chạy thêm lệnh nào ở hàm này nữa
                return currIndex;
            }
            //khi khoảng cách không chia hết cho 3, chúng ta sẽ tìm vị trí của điểm stopCodon
            //mới. vị trí này bắt đầu từ vị trí tìm đc stopCodon + 1
            currIndex = dna.indexOf(stopCodon, currIndex + 1);
            //mang giá trị currIndex mới đi so sánh với điều kiện trong vòng lặp while
        }
        // return dna.length();
        //Nếu k có vị trí của stopCodon, trả về -1
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
        int startIndex = 0;
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

