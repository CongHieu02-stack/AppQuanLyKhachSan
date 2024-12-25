package ui;

import java.io.PrintWriter;
import entity.HoaDon;
import entity.HoaDonTheoGio;
import entity.HoaDonTheoNgay;

public class SuaHDOutputUI {
    private PrintWriter screenOut;
    
    public SuaHDOutputUI(PrintWriter screenOut) {
        this.screenOut = screenOut;
    }
    
    public void hienThiThongBaoThanhCong(HoaDon hd) {
        screenOut.println("Da sua thanh cong hoa don:");
        screenOut.println("Ma HD: " + hd.getmaHoaDon());
        screenOut.println("Loai HD: " + hd.getLoaiHoaDon());
        screenOut.println("Ngay lap: " + hd.getNgayLap());
        screenOut.println("Ten KH: " + hd.getTenKhachHang());
        screenOut.println("Ma phong: " + hd.getMaPhong());
        screenOut.println("Don gia: " + hd.getDonGia());
        
        if (hd instanceof HoaDonTheoGio) {
            screenOut.println("So gio thue: " + ((HoaDonTheoGio)hd).getSoGioThue());
        } else if (hd instanceof HoaDonTheoNgay) {
            screenOut.println("So ngay thue: " + ((HoaDonTheoNgay)hd).getSoNgayThue());
        }
    }
    
    public void hienThiThongBaoLoi() {
        screenOut.println("Khong tim thay hoa don can sua!");
    }
    
    public void hienThiThongBaoLoiNgayLap() {
        screenOut.println("Loi: Ngay lap khong hop le! Vui long nhap theo dinh dang dd/MM/yyyy");
    }
}
