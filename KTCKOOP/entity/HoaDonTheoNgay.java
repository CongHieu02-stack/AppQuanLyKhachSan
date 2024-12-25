package entity;
import java.util.Date;

/**
* Lớp biểu diễn hóa đơn hàng ngày mở rộng lớp HoaDon cơ sở
* Được sử dụng để lập hóa đơn cho khách hàng dựa trên số ngày thuê
*/
public class HoaDonTheoNgay extends HoaDon {
    private double soNgayThue;
    
    public HoaDonTheoNgay(){

    }

    public HoaDonTheoNgay(String _maHoaDon, Date _ngayLap, String _tenKhachHang, String _maPhong, double _donGia, double _soNgayThue) {
        super(_maHoaDon, "Ngay",_ngayLap, _tenKhachHang, _maPhong, _donGia);
        soNgayThue = _soNgayThue;
    }

    @Override
    public double tinhThanhTien() {
        if (soNgayThue > 7) {
            return (7 * donGia) + ((soNgayThue - 7) * donGia * 0.8);
        } else {
            return soNgayThue * donGia;
        }
    }

    public double getSoNgayThue(){
        return soNgayThue;
    }

    public void setSoNgayThue(int soNgayThue){
        this.soNgayThue = soNgayThue;
    }
}

