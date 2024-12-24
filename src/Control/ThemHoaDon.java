package Control;

import java.util.Date;

import Database.AddHdDAO;
import Entity.HoaDon;
import Entity.HoaDonGio;
import Entity.HoaDonNgay;
import UI.ThongBaoThemHoaDonCUI;
import UI.ThongTinHoaDon;

public class ThemHoaDon {
    private ThemDAO themHdDAO = null;
    private ThongBaoThemHoaDonCUI tbThemhdCUI = null;

    public ThemHoaDon() {

    }

    public void setThemDAO(ThemDAO themDAO) {
        this.themHdDAO = themDAO;
    }

    public void setTbThemhdCUI(ThongBaoThemHoaDonCUI _tbThemhdCUI) {
        tbThemhdCUI = _tbThemhdCUI;
    }

    public ThemHoaDon(ThemDAO themhoadondao) {
        this.themHdDAO = themhoadondao;
    }

    public void TaoHoaDonG(String hoten, String mahd, String maphong, Date ngayhd, int donGia, int sogiohd) {
        HoaDonGio hdgio = new HoaDonGio(mahd, hoten, maphong, ngayhd, donGia, sogiohd);
        DoThemHoaDon(hdgio);
    }

    public void TaoHoaDonN(String hoten, String mahd, String maphong, Date ngayhd, int dongia, int songay) {
        HoaDonNgay hdngay = new HoaDonNgay(mahd, hoten, maphong, ngayhd, dongia, songay);
        DoThemHoaDon(hdngay);
    }

    private void DoThemHoaDon(HoaDon HD) {
        themHdDAO.ThemHoaDon(HD);
        tbThemhdCUI.InThongBao("Them Thanh Cong.");
    }
}
