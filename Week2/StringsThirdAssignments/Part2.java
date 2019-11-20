
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


    /*
    public int countChar(String dna, char cr) {
        int count = 0;
        for (int i = 0; i < dna.length(); i++){
            if (dna.charAt(i) == cr){
                count++;
            }
        }
        return count;
    }

    public double cgRatio(String dna) {
        int cNum = countChar(dna,'C');
        int gNum = countChar(dna,'G');
        double Ratio = (double) cNum/gNum;
        return Ratio;
    }
    
    public void testcgRatio(
    
    */
   
public class Part2 {
    
   public double cgRatio(String dna){
       int cIndex = dna.indexOf("C");
       int gIndex = dna.indexOf("G");
       int countC = 0;
       while (true){
           if (
           
           countC++;
           cIndex = dna.indexOf("C",cIndex+1);
           break;
        }
       System.out.println(countC);
       
       
       return 1;
    }
   
   
   
}
