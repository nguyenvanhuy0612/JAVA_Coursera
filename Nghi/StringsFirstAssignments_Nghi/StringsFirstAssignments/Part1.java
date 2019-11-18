/**
 * Part 1: Finding a Gene - Using the Simplified Algorithm
 * @author Nghi
 */
public class Part1
{
    public String findSimpleGene(String dna) {
        int start = dna.indexOf("ATG");
        if (start == -1) {
            return "";
        }
        int stop = dna.indexOf("TAA");
        if (stop == -1) {
            return "";
        }
        stop = dna.indexOf("TAA", start+3);
        if ((stop - start) % 3 == 0) {
            return dna.substring(start, stop+3);
        }
        else {
            return "";
        }
    }
   
    public void testSimpleGene() {
        String gene = "";
        String dna = "AAAATACCAGTACCACTAAGGA";
        System.out.println("DNA Strand is = " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is = " + gene);
      
        dna = "ATCATGAACAACGGA";
        System.out.println("There is a Strand = " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is = " + gene);
      
        dna = "ATCGAATCCAAT";
        System.out.println("There is a Strand = " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is = " + gene);
      
        dna = "ATCATCATGGTGGTTTAAGAC";
        System.out.println("There is a Strand = " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is = " + gene);
      
        dna = "ATGCGCCGTAA";
        System.out.println("There is a Strand = " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is = " + gene);
    }
}
