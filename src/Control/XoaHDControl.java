package Control;

import Entity.HoaDon;
import java.util.ArrayList;

import Database.ArrayListMockDatabase;

public class XoaHDControl {
    private ArrayList<HoaDon> danhSachHoaDon;

    public XoaHDControl(ArrayList<HoaDon> danhSachHoaDon) {
        this.danhSachHoaDon = danhSachHoaDon;
    }

    // Tìm hóa đơn theo mã hóa đơn
    public HoaDon timHoaDonByMaHD(String maHD) {
        for (HoaDon hoaDon : danhSachHoaDon) {
            if (hoaDon.getMaHoaDon().equals(maHD)) {
                return hoaDon;
            }
        }
        return null; // Nếu không tìm thấy hóa đơn
    }

    // Phương thức xóa hóa đơn, có thể sử dụng sau khi tìm được hóa đơn
    public void xoaHoaDon(String maHD) {
        danhSachHoaDon.removeIf(HD -> HD.getMaHoaDon().equals(maHD));
    }

    public void XoaHD(String maHD) {
        ArrayList<HoaDon> danhSachHoaDon = ArrayListMockDatabase.getAllHd();

        // Xóa hóa đơn với mã maHD
        danhSachHoaDon.removeIf(hoaDon -> hoaDon.getMaHoaDon().equals(maHD));

        // Thông báo xóa thành công
        System.out.println("Đã xóa hóa đơn với mã: " + maHD);
    }
}