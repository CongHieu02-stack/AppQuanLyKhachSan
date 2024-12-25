package database;
import java.util.ArrayList;
import entity.HoaDon;

/**
 * Lớp mô phỏng cơ sở dữ liệu bằng cách sử dụng ArrayList để lưu trữ hóa đơn
 */
public class ArrayListCoSoDuLieu {

    /**
     * Static ArrayList lưu trữ tất cả các bản ghi hóa đơn
     */
    private static ArrayList<HoaDon> csdl = null;

    /**
     * Khởi tạo cơ sở dữ liệu bằng cách tạo một ArrayList mới trống
     * Nên gọi lệnh này trước bất kỳ thao tác nào khác
     */
    public static void initDatabase() {
        csdl = new ArrayList<HoaDon>();
        
        // Add sample invoices
       /* Date sampleDate = new Date(123, 11, 15); // 15/12/2023
        
        // Add hourly invoices
        HoaDonTheoGio hdtg1 = new HoaDonTheoGio("HD001", sampleDate, "Nguyen Van A", "P101", 50000, 2);
        csdl.add(hdtg1);
        
        HoaDonTheoGio hdtg2 = new HoaDonTheoGio("HD003", sampleDate, "Le Van C", "P103", 60000, 3); 
        csdl.add(hdtg2);
        
        // Add daily invoice  
        HoaDonTheoNgay hdtn = new HoaDonTheoNgay("HD002", sampleDate, "Tran Thi B", "P102", 500000, 3);
        csdl.add(hdtn);*/
    }
    
    /**
     * Thêm một hóa đơn mới vào cơ sở dữ liệu
     * @param hd Đối tượng hóa đơn để thêm vào cơ sở dữ liệu
     */
    public static void insertHoaDon(HoaDon hd){
        csdl.add(hd);
    }

    /**
     * Lấy tất cả các hóa đơn từ cơ sở dữ liệu
     * @return ArrayList chứa tất cả các đối tượng hóa đơn được lưu trữ
     */
    public static ArrayList<HoaDon> queryDSHD() {
        return csdl;
    }

    public static void updateDSHD(ArrayList<HoaDon> newDSHD) {
        csdl = newDSHD;
    }
}
