import edu.duke.URLResource;
/**
 * Part 4: Finding Web Links
 * @author Nghi
 */
public class Part4
{
    public void findURLs(String URL){
        int count = 0;
        URLResource urls = new URLResource(URL);
        
        for(String currURL : urls.words()){
            String lowCaseURL = currURL.toLowerCase();
            int pos = lowCaseURL.indexOf("youtube.com");
            if(pos > -1){
                int start = currURL.lastIndexOf("href=\"", pos);
                int stop = currURL.indexOf("\">", pos);
                count++;
                String originalURL = currURL.substring(start + 6, stop); 
                System.out.println("URL "+ count+": " + originalURL);
            }
        }
    }

    public static void main(String[] args){      
        Part4 part4 = new Part4();
        String URL = "https://www.dukelearntoprogram.com/course2/data/manylinks.html" ;    
        part4.findURLs(URL);  
    }
}
