
/**
 * Write a description of test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class test {
        
    public void test1(int taaIndex, int tagIndex, int tgaIndex){
        //int taaIndex = 0;   
        System.out.println("taaIndex "+taaIndex);
        //int tagIndex = 0;   
        System.out.println("tagIndex "+tagIndex);
        //int tgaIndex = 0;   
        System.out.println("tgaIndex "+tgaIndex);
        int minIndex = 0;   
        System.out.println("minIndex "+minIndex);
        
        if (taaIndex == -1 || ((tagIndex != -1) && (tagIndex < taaIndex))){
            minIndex = tagIndex;
        }else{ minIndex = tagIndex; }
        System.out.println("minIndex lan 1 "+minIndex);
        if (minIndex == -1 || ((tgaIndex != -1) && (tgaIndex < minIndex))){
            minIndex = tgaIndex;
        }
        System.out.println("minIndex lan 2 "+minIndex);
    }
    
    public double cgRatio(String dna){
        int cIndex = dna.indexOf("C");
        int gIndex = dna.indexOf("G");
        int countcg = 0, currIndex = 0;
        //System.out.println("cIndex "+cIndex);
        //System.out.println("gIndex "+gIndex);
        while (true){
            if (cIndex*gIndex == 1){
                break;
            }
            if 
            if (cIndex*gIndex < 0){
                currIndex = -1*cIndex*gIndex;
                countcg++;
                cIndex = dna.indexOf("C", currIndex+1);
                gIndex = dna.indexOf("G", currIndex+1);
            }else{
                countcg += 2;
                cIndex = dna.indexOf("C", cIndex+1);
                gIndex = dna.indexOf("G", gIndex+1);
            }
            
        }
        return (double) countcg/ dna.length();
    }
}
