package UI;

import java.io.PrintWriter;
import Control.XoaHDControl;

public class XoaHoaDonCUI {
    private PrintWriter Sysout;
    private XoaHDControl xoaHDControl; // Đối tượng XoaHDControl

    // Constructor nhận vào PrintWriter
    public XoaHoaDonCUI(PrintWriter sysout) {
        Sysout = sysout;
    }

    // Setter để truyền đối tượng XoaHDControl vào
    public void setXoaHDControl(XoaHDControl xoaHDControl) {
        this.xoaHDControl = xoaHDControl;
    }

    // Phương thức xóa hóa đơn
    public void xoaHoaDon(String maHD) {
        if (xoaHDControl != null) {
            xoaHDControl.XoaHD(maHD);
            Sysout.println("Đã xóa hóa đơn với mã: " + maHD);
        } else {
            Sysout.println("XoaHDControl chưa được khởi tạo!");
        }
    }
}
