
/**
 * Write a description of test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class test {
    Part1 p1 = new Part1();

    public String findGene(String dna, int beginIndex){
        int startIndex = dna.indexOf("ATG", beginIndex);
        if (startIndex == -1){
            return "";
        }
        int taaIndex = p1.findStopIndex(dna, startIndex, "TAA");
        int tagIndex = p1.findStopIndex(dna, startIndex, "TAG"); 
        int tgaIndex = p1.findStopIndex(dna, startIndex, "TGA");
        int minIndex = 0;
        
        if (taaIndex*tagIndex == 1){ minIndex = -1;}
        else if (taaIndex*tagIndex == -1){ minIndex = -1*taaIndex*tagIndex;}
        else{ minIndex = Math.min(taaIndex,tagIndex);}
        
        
        
        return dna.substring(startIndex, minIndex + 3);
    }

    public double cgRatio(String dna){
        int cIndex = dna.indexOf("C");
        int gIndex = dna.indexOf("G");
        int countcg = 0;
        System.out.println("dna.length() "+dna.length());
        //System.out.println("gIndex "+gIndex);
        while (true){
            if (cIndex*gIndex == 1){
                break;
            }

            if (Math.min(cIndex, gIndex) == -1 ){
                countcg++;
                if (cIndex == -1){
                    gIndex = dna.indexOf("G", gIndex+1);
                }else{
                    cIndex = dna.indexOf("C", cIndex+1);
                }
                
            }else{
                countcg += 2;
                cIndex = dna.indexOf("C", cIndex+1);
                gIndex = dna.indexOf("G", gIndex+1);
            }

        }
        return (double) countcg/ dna.length();
    }
}
