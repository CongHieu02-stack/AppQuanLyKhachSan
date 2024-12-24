package Database;

import java.util.ArrayList;

import Entity.HoaDon;
import Entity.HoaDonGio;
import Entity.HoaDonNgay;

public class ArrayListMockDatabase {
    // private static ArrayList<HoaDon> Database = null;
    public static ArrayList<HoaDon> danhSachHoaDon = new ArrayList<>();
    private static ArrayList<HoaDon> Arr;

    public static void initDatabase() {
        InsertHoaDon(new HoaDonGio("phu", "xy", "b31", null, 10000, 5));
        InsertHoaDon(new HoaDonGio("tran", "xyz", "b11", null, 10000, 5));
        InsertHoaDon(new HoaDonNgay("an", "xyb", "b21", null, 10000, 3));
    }

    public static void InsertHoaDon(HoaDon HD) {
        danhSachHoaDon.add(HD);
    }

    public static ArrayList<HoaDon> getAllHd() {
        return danhSachHoaDon;
    }

    public static void xoaHoaDon(String maHD) {
        boolean xoa = danhSachHoaDon.removeIf(hoaDon -> hoaDon.getMaHoaDon().equals(maHD));

        if (xoa) {
            System.out.println("Da xoa hoa don co ma: " + maHD);
        } else {
            System.out.println("Ma hoa don khong hop le");
        }
    }

    public HoaDon timHoaDonTheoMa(String maHD) {
        for (HoaDon HD : danhSachHoaDon) {
            if (HD.getMaHoaDon().equals(maHD)) {
                return HD;
            }
        }
        return null;
    }

    public static ArrayList<HoaDon> getDanhSachHoaDon() {
        return Arr;

    }
}