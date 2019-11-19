/**
 * Part 3: Problem Solving with Strings
 * @author Nghi
 */
public class Part3
{
    public boolean twoOccurrences (String stringa, String stringb) {
        int occurrence1 = stringb.indexOf(stringa);
        if (occurrence1 == -1) {
            return false;
        }
        else {
            int occurrence2 = stringb.indexOf(stringa, occurrence1+1);
            if (occurrence2 == -1)
                return false;
            return true;
        }
        
    }
    
    public String lastPart(String stringa, String stringb){
        int occurrence = stringb.indexOf(stringa); 
        int startFrom = stringa.length(); 
        String finalPart = stringb.substring(startFrom+occurrence); 
        if (occurrence == -1){
            return stringb;
        }
        else {         
            return finalPart;
        }     
    }
    
    public void testing(){
        String stringa = "by";
        String stringb = "A story by Abby Long";
        System.out.println("stringa: "+stringa + "; stringb: " + stringb);
        System.out.println(twoOccurrences(stringa, stringb));
        
        stringa = "a";
        stringb = "banana";
        System.out.println("stringa: "+stringa + "; stringb: " + stringb);
        System.out.println(twoOccurrences(stringa, stringb));
        
        stringa = "atg";
        stringb = "ctgtatgta";
        System.out.println("stringa: "+stringa + "; stringb: " + stringb);
        System.out.println(twoOccurrences(stringa, stringb));
        
        stringa = "an";
        stringb = "banana";
        System.out.println("The part of the string after " + stringa + " in " +stringb +" is "+ lastPart(stringa, stringb));
        
        stringa = "zoo";
        stringb = "forest";
        System.out.println("The part of the string after " + stringa + " in " +stringb +" is "+ lastPart(stringa, stringb));
    }    
}
