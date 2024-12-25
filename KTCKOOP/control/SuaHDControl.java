package control;

import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import entity.HoaDon;
import entity.HoaDonTheoGio;
import entity.HoaDonTheoNgay;
import ui.SuaHDInputUI;
import ui.SuaHDOutputUI;
import database.SuaHDDAOFile;

public class SuaHDControl {
    private SuaHDDAOFile suaHDDAOFile;
    private SuaHDInputUI suaHDUI;
    private SuaHDOutputUI outputUI;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
    public SuaHDControl(SuaHDDAOFile suaHDDAOFile, SuaHDInputUI suaHDUI, SuaHDOutputUI outputUI) {
        this.suaHDDAOFile = suaHDDAOFile;
        this.suaHDUI = suaHDUI;
        this.outputUI = outputUI;
    }

    public void suaHoaDon() {
        String maHD = suaHDUI.nhapMaHD();
        ArrayList<HoaDon> dsHD = suaHDDAOFile.getDSHD();
        boolean found = false;
        
        for (int i = 0; i < dsHD.size(); i++) {
            HoaDon hd = dsHD.get(i);
            if (hd.getmaHoaDon().equals(maHD)) {
                String tenKH = suaHDUI.nhapTenKH();
                String maPhong = suaHDUI.nhapMaPhong();
                double donGia = suaHDUI.nhapDonGia();
                
                try {
                    String ngayLapStr = suaHDUI.nhapNgayLap();
                    Date ngayLap = dateFormat.parse(ngayLapStr);
                    hd.setNgayLap(ngayLap);
                } catch (ParseException e) {
                    outputUI.hienThiThongBaoLoiNgayLap();
                    return;
                }
                
                hd.setTenKhachHang(tenKH);
                hd.setMaPhong(maPhong);
                hd.setDonGia(donGia);
                
                // Handle specific invoice type updates
                String loaiHD = suaHDUI.nhapLoaiHD();
                if (loaiHD.equals("GIO")) {
                    double soGio = suaHDUI.nhapSoGio();
                    if (!(hd instanceof HoaDonTheoGio)) {
                        hd = new HoaDonTheoGio(hd.getmaHoaDon(), hd.getNgayLap(), hd.getTenKhachHang(), 
                                               hd.getMaPhong(), hd.getDonGia(), (int)soGio);
                    } else {
                        ((HoaDonTheoGio)hd).setSoGioThue((int)soGio);
                    }
                } else if (loaiHD.equals("NGAY")) {
                    double soNgay = suaHDUI.nhapSoNgay();
                    if (!(hd instanceof HoaDonTheoNgay)) {
                        hd = new HoaDonTheoNgay(hd.getmaHoaDon(), hd.getNgayLap(), hd.getTenKhachHang(),
                                              hd.getMaPhong(), hd.getDonGia(), (int)soNgay);
                    } else {
                        ((HoaDonTheoNgay)hd).setSoNgayThue((int)soNgay);
                    }
                }
                
                dsHD.set(i, hd);  // Update the invoice in the list
                found = true;
                outputUI.hienThiThongBaoThanhCong(hd);
                break;
            }
        }
        
        if (!found) {
            outputUI.hienThiThongBaoLoi();
            return;
        }
        
        suaHDDAOFile.setDSHD(dsHD);  // Save changes to file
    }
}
