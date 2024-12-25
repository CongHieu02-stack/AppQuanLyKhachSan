package control;

import database.XoaHDDAOFile;
import entity.HoaDon;
import ui.XoaHDInputUI;
import ui.XoaHDOutputUI;

public class XoaHDControl {
    private XoaHDDAOFile xoaHDDAOFile;
    private XoaHDInputUI inputUI;
    private XoaHDOutputUI outputUI;
    
    public XoaHDControl(XoaHDDAOFile xoaHDDAOFile, XoaHDInputUI inputUI, XoaHDOutputUI outputUI) {
        this.xoaHDDAOFile = xoaHDDAOFile;
        this.inputUI = inputUI;
        this.outputUI = outputUI;
    }
    
    public void xoaHoaDon() {
        String maHD = inputUI.nhapMaHD();
        HoaDon hdCanXoa = xoaHDDAOFile.timHoaDon(maHD);
        
        if (hdCanXoa == null) {
            outputUI.hienThiThongBaoLoi();
            return;
        }
        
        if (inputUI.xacNhanXoa()) {
            xoaHDDAOFile.xoaHoaDon(maHD);
            outputUI.hienThiThongBaoThanhCong(hdCanXoa);
        } else {
            outputUI.hienThiThongBaoHuyXoa();
        }
    }
}
