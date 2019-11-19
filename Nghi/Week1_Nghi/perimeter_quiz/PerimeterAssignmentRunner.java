 

import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public int getNumPoints (Shape s) { //has one parameter Shape s
        int numPoints = 0; //an integer that is the number of points in Shape s
        
        for(Point p : s.getPoints()){ //for each Point p in an point array of Shape s
            numPoints += 1; //increase numPoints +1
        }
        return numPoints; // return numPoints once method getNumPoints is called
    }

    public double getAverageLength(Shape s) {
        double length = getPerimeter(s);    
        double numSides = (double) getNumPoints(s); //No need but should
        double avgLength = length / numSides;
        return avgLength;
    }

    public double getLargestSide(Shape s) {
        Point lastPoint = s.getLastPoint();
        double largestSide = 0.0;
        
        for(Point p : s.getPoints()){
            double dist = lastPoint.distance(p);
            if(dist > largestSide) {
                largestSide = dist;
            }
            lastPoint = p;
        }
        return largestSide;
    }

    public double getLargestX(Shape s) {
        Point lastPoint = s.getLastPoint();
        int lastPointX = lastPoint.getX();
        double largestX = (double) lastPointX;
        
        for(Point p : s.getPoints()){
            int newX = p.getX();
            if(newX > largestX) {
                largestX = (double) newX;
            }
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        DirectoryResource dr = new DirectoryResource();
        double largestPerim = 0.0;
        FileResource largestFile = null;

        for(File f : dr.selectedFiles()){ //for each File f in an file array which is selected by dr.selecedFiles() method.            
            FileResource file = new FileResource(f); //Create a FileResource file that opens a file represented by the File f.            
            Shape shape = new Shape(file); //Create a Shape shape from a File file with x,y coordinates of points, in order, one pair of x,y per line.
            double perim = getPerimeter(shape);
            if(perim > largestPerim) {
                largestPerim = perim;
            }
        }
        return largestPerim;
    }

    public String getFileWithLargestPerimeter() {
        DirectoryResource dr = new DirectoryResource();
        double largestPerim = 0.0;
        File largestFile = null;

        for(File f : dr.selectedFiles()){
            FileResource file = new FileResource(f);
            Shape shape = new Shape(file);
            double perim = getPerimeter(shape);
            if(perim > largestPerim) {
                largestPerim = perim; 
                largestFile = f;
            }
        }

        return largestFile.getName();
    }

    public void testPerimeterMultipleFiles() {
        double largest = getLargestPerimeterMultipleFiles();
        System.out.println("Largest perimeter is: " + largest);
    }

    public void testFileWithLargestPerimeter() {
        String file = getFileWithLargestPerimeter();
        System.out.println("Largest perimeter file is: " + file);
    }
    
    public double getPerimeter (Shape s) {
        double totalPerim = 0.0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            totalPerim = totalPerim + currDist;
            prevPt = currPt;
        }
        return totalPerim;
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
        System.out.println("perimeter = "+ peri);
        System.out.println("numPoints = "+ getNumPoints(triangle));
        System.out.println("largestSide = "+ getLargestSide(triangle));
    }
    
    public void testPerimeter () {   
        FileResource fr = new FileResource(); //Create a FileResource fr that opens the file chosen using a file selection dialog box.
        Shape s = new Shape(fr); //Create a Shape shape from a File file with x,y coordinates of points, in order, one pair of x,y per line.
        double length = getPerimeter(s);
        int numPoints = getNumPoints(s);
        double averageLength = getAverageLength(s);
        double largestSide = getLargestSide(s);
        double largestX = getLargestX(s);
        
        System.out.println("Perimeter = " + length);
        System.out.println("Number of Points = " + numPoints);
        System.out.println("Average Length = " + averageLength);
        System.out.println("Largest Side = " + largestSide);
        System.out.println("Largest X = " + largestX );
        testPerimeterMultipleFiles();
        testFileWithLargestPerimeter();
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}