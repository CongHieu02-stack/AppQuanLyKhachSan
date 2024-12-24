package UI;

import java.io.PrintWriter;
import java.util.ArrayList;

import Entity.HoaDon;

public class InDSHoaDonCUI {
    private PrintWriter SysOut = null;

    public InDSHoaDonCUI(PrintWriter sysout) {
        SysOut = sysout;
    }

    public void indshd(ArrayList<HoaDon> dshd) {
        for (HoaDon hoadon : dshd) {
            SysOut.println(hoadon.toString());
            SysOut.printf("Tien Phong: %f\n", hoadon.TinhHD());
        }
    }
}
