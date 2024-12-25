package entity;

import java.util.Date;

/**
* Lớp biểu diễn hóa đơn theo giờ mở rộng lớp HoaDon cơ sở
* Được sử dụng để lập hóa đơn cho khách hàng dựa trên số giờ thuê
*/
public class HoaDonTheoGio extends HoaDon{
    private double soGioThue;
    
    public HoaDonTheoGio(){

    }

    public HoaDonTheoGio(String _maHoaDon, Date _ngayLap, String _tenKhachHang, String _maPhong, double _donGia, double _soGioThue) {
        super(_maHoaDon, "Gio", _ngayLap, _tenKhachHang, _maPhong, _donGia);
        soGioThue = _soGioThue;
    }


    @Override
    public double tinhThanhTien() {
        if (soGioThue > 24 && soGioThue < 30) {
            return 24 * donGia;
        } else if (soGioThue <= 24) {
            return soGioThue * donGia;
        } else {
            return -1; // Không hợp lệ cho thuê theo giờ
        }
    }

    public double getSoGioThue(){
        return soGioThue;
    }

    public void setSoGioThue(int soGioThue){
        this.soGioThue = soGioThue;
    }
}
