package ui;

import java.io.PrintWriter;
import entity.HoaDon;

public class XoaHDOutputUI {
    private PrintWriter screenOut;
    
    public XoaHDOutputUI(PrintWriter screenOut) {
        this.screenOut = screenOut;
    }
    
    public void hienThiThongBaoThanhCong(HoaDon hd) {
        screenOut.println("Da xoa thanh cong hoa don:");
        screenOut.println("Ma HD: " + hd.getmaHoaDon());
        screenOut.println("Ten KH: " + hd.getTenKhachHang());
    }
    
    public void hienThiThongBaoLoi() {
        screenOut.println("Khong tim thay hoa don can xoa!");
    }
    
    public void hienThiThongBaoHuyXoa() {
        screenOut.println("Da huy xoa hoa don!");
    }
}
