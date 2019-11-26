
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Part2 {
    
    public int countIndex(String dna, String input){
        int currIndex = dna.indexOf(input);
        int count = 0;
        while (currIndex != -1){
            count++;
            currIndex = dna.indexOf(input, currIndex + input.length());
        }
        return count;
    }

    public double cgRatio(String dna){
        int cIndex = countIndex(dna, "C");
        int gIndex = countIndex(dna, "G");
        //System.out.println("cIndex "+cIndex);
        //System.out.println("gIndex "+gIndex);
        return (double) (cIndex + gIndex)/ dna.length();
    }

    public void testcgRatio(){
        String dna = "ATGCCATAGG";
        System.out.println("dna "+dna);
        System.out.println("cgRatio "+cgRatio(dna));
    }
    
    public int countCTG(String dna) {
        return countIndex(dna, "CTG");
    }
    
    public void testcountCTG(){
        String dna = "CTGATGCCTGCTGCATACTGGCTCTG";
        System.out.println("dna "+dna);
        System.out.println("countCTG "+countCTG(dna));
    }
}
