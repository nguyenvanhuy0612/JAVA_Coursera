
/**
 * Write a description of chuvi here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class ChuVi {
    public double TinhChuVi(Shape hinh){
        double TongChuVi = 0;
        Point DiemTruoc = hinh.getLastPoint();
        for (Point DiemHienTai : hinh.getPoints()){
            double KhoangCachHaiDiem = DiemTruoc.distance(DiemHienTai);
            TongChuVi = TongChuVi + KhoangCachHaiDiem;
            DiemTruoc = DiemHienTai;
        }
        return TongChuVi;
    }
    
    public double NhapHinh(){
        FileResource fr = new FileResource("vd2.txt");
        Shape s = new Shape(fr);
        double chieudaichuvi = TinhChuVi(s);
        return chieudaichuvi;
    }

    public static void main(String[] args){
        ChuVi cv = new ChuVi();
        System.out.println("Chieu dai cua chu vi la "+cv.NhapHinh());
    }
}
