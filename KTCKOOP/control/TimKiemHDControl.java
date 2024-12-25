package control;

import database.TimKiemHDDAOFile;
import entity.HoaDon;
import ui.TimKiemHDUI;

public class TimKiemHDControl {
    private TimKiemHDDAOFile timKiemHDDAOFile;
    private TimKiemHDUI timKiemHDUI;
    
    public TimKiemHDControl(TimKiemHDDAOFile timKiemHDDAOFile, TimKiemHDUI timKiemHDUI) {
        this.timKiemHDDAOFile = timKiemHDDAOFile;
        this.timKiemHDUI = timKiemHDUI;
    }
    
    public void timHoaDon() {
        String maHD = timKiemHDUI.nhapMaHD();
        HoaDon hd = timKiemHDDAOFile.timHoaDon(maHD);
        timKiemHDUI.hienThiKetQua(hd);
    }
}
