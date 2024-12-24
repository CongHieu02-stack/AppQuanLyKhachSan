package UI;

import java.io.PrintWriter;
import java.util.Scanner;

import Control.XoaHDControl;
import Entity.HoaDon;

public class TimKiemHoaDonCUI {
    private PrintWriter SysOut;
    private Scanner SysIn;
    private XoaHDControl xoaHDControl;

    public TimKiemHoaDonCUI(PrintWriter sysOut, Scanner sysIn, XoaHDControl xoaHDControl) {
        this.SysOut = sysOut;
        this.SysIn = sysIn;
        this.xoaHDControl = xoaHDControl;
    }

    // Phương thức tìm kiếm hóa đơn
    public void timKiemHoaDon() {
        SysOut.print("Nhập mã hóa đơn cần tìm: ");
        SysOut.flush();
        String maHD = SysIn.nextLine();

        HoaDon hoaDon = xoaHDControl.timHoaDonByMaHD(maHD);
        if (hoaDon != null) {
            SysOut.println("Hóa đơn tìm thấy: ");
            SysOut.println("Mã hóa đơn: " + hoaDon.getMaHoaDon());
            SysOut.println("Tên khách hàng: " + hoaDon.getTenKhach());
            SysOut.println("Mã phòng: " + hoaDon.getMaPhong());
            SysOut.println("Ngày hóa đơn: " + hoaDon.getNgayHD());
            SysOut.println("Đơn giá: " + hoaDon.getDonGia());
        } else {
            SysOut.println("Không tìm thấy hóa đơn với mã: " + maHD);
        }
    }
}
