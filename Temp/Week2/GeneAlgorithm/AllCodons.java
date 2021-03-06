
/**
 * Write a description of AllCodons here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;
public class AllCodons {
    public int findStopCodon(String dnaStr, int startIndex, String stopCodon){
        int currIndex = dnaStr.indexOf(stopCodon, startIndex + 3); //Tìm vị trí của stopCodon lần đầu tiên xuất hiện, bắt đầu tìm từ vị trí startIndex + 3
        while (currIndex != -1){ //Điều kiện tìm được giá trị vị trí của stopCondon
            int diff = currIndex - startIndex; //khoảng cách từ stopCodon đến startCodon,
            if (diff % 3 == 0){    //nếu khoảng cách này chia hết cho 3 thì trả về vị trí của stopCodon luôn, dùng dnaStr.substring(startIndex, currIndex + 3) để lấy ra đoạn gene
                return currIndex; //thì trả về vị trí của stopCodon luôn, dùng dnaStr.substring(startIndex, currIndex + 3) để lấy ra đoạn gene
            }else{
                currIndex = dnaStr.indexOf(stopCodon,currIndex+1);//tiếp tục dò từ vị trí currIndex+1 trở đi
            }
        }
        return dnaStr.length(); //Nếu k dò đc cái stopCodon nào, trả về độ dài string dna
    }
    public String findGene(String dna){
        int startIndex = dna.indexOf("ATG"); //vi tri cua ATG
        System.out.println("startIndex "+startIndex);
        if (startIndex == -1){
            return "";
        }
        int taaIndex = findStopCodon(dna, startIndex,"TAA");
        int tagIndex = findStopCodon(dna, startIndex,"TAG");
        int tgaIndex = findStopCodon(dna, startIndex,"TGA");
        
        int temp = Math.min(taaIndex, tagIndex);
        int minIndex = Math.min(temp, tgaIndex);
        System.out.println("taaIndex "+taaIndex+"\r\ntagIndex "+tagIndex+"\r\ntgaIndex "+tgaIndex+"\r\nminIndex "+minIndex);
        if (minIndex == dna.length()){
            return "";
        } // Gia tri nho nhat cua 3 gia tri Index
        return dna.substring(startIndex, minIndex + 3);
    }
    public static void main(String[] args){
        AllCodons ac = new AllCodons();
        //                      1         2         3         4         5  
        //            0123456789012345678901234567890123456789012345678901234
        String dna = "GATGATGCGTACGTAATGCTAGTCAGCATCATCGGATCGATCATCGACTGTAC";
        //System.out.println(ac.findStopCodon(dna,0,"TAA"));
        System.out.println("Length gene "+dna.length());
        System.out.println("Gene "+ac.findGene(dna));
    }
}
