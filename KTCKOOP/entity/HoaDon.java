package entity;

import java.io.Serializable;
import java.util.Date;

/**
* Lớp cơ sở trừu tượng biểu diễn một hóa đơn
* Triển khai Serializable để cho phép duy trì đối tượng
*/
public abstract class HoaDon implements Serializable {
    protected static final long serialVersionUID = 1L;
    protected String maHoaDon;        // Invoice ID
    protected String loaiHoaDon;      // Invoice type
    protected Date ngayLap;           // Creation date
    protected String tenKhachHang;    // Customer name
    protected String maPhong;         // Room ID
    protected double donGia;          // Unit price

    
    public HoaDon(){

    }
    
    
    public HoaDon(String _maHoaDon, String _loaiHoaDon ,Date _ngayLap, String _tenKhachHang, String _maPhong, double _donGia) {
        maHoaDon = _maHoaDon;
        loaiHoaDon = _loaiHoaDon;
        ngayLap = _ngayLap;
        tenKhachHang = _tenKhachHang;
        maPhong = _maPhong;
        donGia = _donGia;
    }
    
    


    /**
     * Phương pháp trừu tượng để tính tổng số tiền
     * Phải được triển khai bởi các lớp con cụ thể
     */
    public abstract double tinhThanhTien();

    
    public String getmaHoaDon() {
        return maHoaDon;
    }

    
    public String getLoaiHoaDon() {
        return loaiHoaDon;
    }

    
    public Date getNgayLap() {
        return ngayLap;
    }
    
    
    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    
    public String getTenKhachHang() {
        return tenKhachHang;
    }

    
    public String getMaPhong() {
        return maPhong;
    }

    
    public double getDonGia() {
        return donGia;
    }
    
    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }


    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }


    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }
    
}
