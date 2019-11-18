/**
 * Part 2: Finding a Gene - Using the Simplified Algorithm Reorganized
 * @author Nghi
 */
public class Part2
{
    public String findSimpleGene(String dna, String startCodon, String stopCodon) {     
        String dnaUpperCase = dna.toUpperCase();
        int start = dnaUpperCase.indexOf(startCodon);
        if (start == -1) {
            return "";
        }
        int stop = dnaUpperCase.indexOf(stopCodon);
        if (stop == -1) {
            return "";
        }
        stop = dnaUpperCase.indexOf(stopCodon, start+3);
        if ((stop - start) % 3 == 0) {
            return dna.substring(start, stop+3);
        }
        else {
            return "";
        }
    }
   
    public void testSimpleGene() {
        String gene = "";
        //String dna = "AAATACCAGTACCACTAAGGA";
        String dna = "aaataccagtaccactaagga";
        System.out.println("DNA Strand is = " + dna);
        gene = findSimpleGene(dna,"ATG", "TAA");
        System.out.println("Gene is = " + gene);
      
        dna = "ATCATGAACAACGGA";
        System.out.println("There is a Strand = " + dna);
        gene = findSimpleGene(dna,"ATG", "TAA");
        System.out.println("Gene is = " + gene);
      
        dna = "ATCGAATCCAAT";
        System.out.println("There is a Strand = " + dna);
        gene = findSimpleGene(dna,"ATG", "TAA");
        System.out.println("Gene is = " + gene);
      
        //dna = "ATCATCATGGTGGTTTAAGAC";
        dna = "atcatcatggtggtttaagac";
        System.out.println("There is a Strand = " + dna);
        gene = findSimpleGene(dna,"ATG", "TAA");
        System.out.println("Gene is = " + gene);
      
        dna = "ATGCGCCGTAA";
        System.out.println("There is a Strand = " + dna);
        gene = findSimpleGene(dna,"ATG", "TAA");
        System.out.println("Gene is = " + gene);
    }
}
