package control;
import java.util.Date;

import database.ThemHDDAOFile;
import entity.HoaDon;
import entity.HoaDonTheoGio;
import entity.HoaDonTheoNgay;
import ui.ThongBaoThemMoiHDUI;


public class ThemMoiHDControl {
    private ThemHDDAOFile themHDDAOFile = null;
    private ThongBaoThemMoiHDUI thongBaoUI = null;

    
    public ThemMoiHDControl(ThemHDDAOFile themHDDAOFile) {
        this.themHDDAOFile = themHDDAOFile;
    }

    
    public void setThongBaoThemMoiHDUI(ThongBaoThemMoiHDUI _thongBaoUI) {
        thongBaoUI = _thongBaoUI;
    }

    
    public void taoHDTG(String maHD, Date ngayLap, String tenKH, String maPhong, double donGia, double soGioThue) {
        HoaDonTheoGio hdtg = new HoaDonTheoGio(maHD, ngayLap, tenKH, maPhong, donGia, soGioThue);
        themHD(hdtg);
    }

    
    public void taoHDTN(String maHD, Date ngayLap, String tenKH, String maPhong, double donGia, double soNgayThue) {
        HoaDonTheoNgay hdtn = new HoaDonTheoNgay(maHD, ngayLap, tenKH, maPhong, donGia, soNgayThue);
        themHD(hdtn);
    }

    
    private void themHD(HoaDon hd) {
        themHDDAOFile.addHoaDon(hd);
        if(thongBaoUI != null) {
            thongBaoUI.thongBaoThemMoiHDThanhCong();
        }
    }
}
