import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        //System.out.println("LastPt "+prevPt);
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            //System.out.println(currPt);
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim  += currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int num=0;
        for (Point currPt : s.getPoints()){
            num += 1;
            //System.out.println("File thu "+num +" co X,Y = "+currPt);
        }
        //System.out.println("Vay so diem la "+num);
        return num;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        /* double Perim = getPerimeter(s); //chu vi
        System.out.println(Perim);
        int num = getNumPoints(s);  // so diem
        System.out.println(num);
        double AvgLeng = Perim/num; // chieu dai trung binh =  chu vi / so diem
        //return AvgLeng; 
        */
       
        return getPerimeter(s)/getNumPoints(s);
    }

    public double getLargestSide(Shape s) {
        // Put code here
        Point prevPt = s.getLastPoint(); // Diem cuoi cung
        double compDist = 0;
        for (Point currPt : s.getPoints()) { 
            double currDist = prevPt.distance(currPt); //khoang cach tu diem prevPt den diem currPt

            
            if (compDist < currDist){
                compDist = currDist;

            }
            prevPt = currPt;
        }
        
        return compDist;
    }

    public double getLargestX(Shape s) {
        // Put code here
        Point prevPt = s.getLastPoint();
        double largX = prevPt.getX();
        
        for (Point currPt : s.getPoints()) {
            double currX = currPt.getX();
            
            if (largX < currX){
                largX = currX;
            }
        }
        return largX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        double largPerim = 0.0, currPerim = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape sp = new Shape(fr);
            currPerim = getPerimeter(sp);
            if (largPerim < currPerim){
                largPerim = currPerim;
            }
            
        }
        //System.out.println("Return of getLargestPerimeterMultipleFiles() method: "+largPerim);
        
        return largPerim;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        String fileName = "";
        double largPerim = 0.0, currPerim = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape sp = new Shape(fr);
            currPerim = getPerimeter(sp);
            
            System.out.println("Chu vi hinh "+f.getName()+" la "+currPerim);
            if (currPerim >= largPerim){
                if (currPerim == largPerim){
                    fileName = fileName + "; "+f.getName();
                } else{
                    largPerim = currPerim;
                    fileName = f.getName();
                }
            }
            
        }
        System.out.println("Hinh "+fileName+" co chi vi lon nhat, va bang "+largPerim);
        
        return fileName;
    }

    public void testPerimeter() {
        FileResource fr = new FileResource();
        Shape sp = new Shape(fr);
        //System.out.println("Chu vi = " +getPerimeter(sp)+" So diem "+getNumPoints(sp));
        //System.out.println("Chieu dai trung binh cua moi canh la "+getAverageLength(sp));
        //System.out.println("Chieu dai canh lon nhat "+getLargestSide(sp));
        //System.out.println("X lon nhat "+getLargestX(sp));
        //getNumPoints(sp);
        //System.out.println(getAverageLength(sp));
        System.out.println(getPerimeter(sp));
        
        
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        System.out.println("The Largest Perimeter is "+getLargestPerimeterMultipleFiles());
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        getFileWithLargestPerimeter();
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
            System.out.println(f.getName());
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
        //pr.testPerimeterMultipleFiles();
        //pr.testFileWithLargestPerimeter();
        //pr.printFileNames();
        //pr.testPerimeter();
        //pr.getFileWithLargestPerimeter();
        //pr.printFileNames();
    }
}
