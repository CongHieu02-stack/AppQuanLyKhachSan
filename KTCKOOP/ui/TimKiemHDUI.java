package ui;

import java.io.PrintWriter;
import java.util.Scanner;
import entity.HoaDon;
import entity.HoaDonTheoGio;
import entity.HoaDonTheoNgay;

public class TimKiemHDUI {
    private PrintWriter screenOut;
    private Scanner keyBoard;
    
    public TimKiemHDUI(PrintWriter screenOut, Scanner keyBoard) {
        this.screenOut = screenOut;
        this.keyBoard = keyBoard;
    }
    
    public String nhapMaHD() {
        screenOut.print("Nhap ma hoa don can tim: ");
        screenOut.flush();
        return keyBoard.nextLine().trim();
    }
    
    public void hienThiKetQua(HoaDon hd) {
        if (hd == null) {
            screenOut.println("Khong tim thay hoa don!");
            return;
        }
        
        screenOut.println("Tim thay hoa don:");
        screenOut.println("Ma HD: " + hd.getmaHoaDon());
        screenOut.println("Ten KH: " + hd.getTenKhachHang());
        screenOut.println("Ma phong: " + hd.getMaPhong());
        screenOut.println("Don gia: " + hd.getDonGia());
        screenOut.println("Ngay lap: " + hd.getNgayLap());
        
        if (hd instanceof HoaDonTheoGio) {
            screenOut.println("So gio thue: " + ((HoaDonTheoGio)hd).getSoGioThue());
        } else if (hd instanceof HoaDonTheoNgay) {
            screenOut.println("So ngay thue: " + ((HoaDonTheoNgay)hd).getSoNgayThue());
        }
    }
}
