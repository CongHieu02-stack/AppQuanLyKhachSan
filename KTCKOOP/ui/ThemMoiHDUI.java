package ui;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import control.ThemMoiHDControl;


public class ThemMoiHDUI {
    private PrintWriter screenOut = null;        
    private Scanner keyBoardInput = null;        

    
    private String maHoaDonPrompt, loaiHoaDonPrompt, ngayLapPrompt, tenKhachHangPrompt, 
                   maPhongPrompt, donGiaPrompt, soGioThuePrompt, soNgayThuePrompt;

    private ThemMoiHDControl themHDControl = null;  

    
    public ThemMoiHDUI(){

    }

    
    public ThemMoiHDUI(PrintWriter _screenOut, Scanner _keyBoardInput, ThemMoiHDControl _themMoiHDControl) {
        this(_screenOut, _keyBoardInput);
        themHDControl = _themMoiHDControl;
    }

    
    public ThemMoiHDUI(PrintWriter _screenOut, Scanner _keyBoardInput) {
        screenOut = _screenOut;
        keyBoardInput = _keyBoardInput;
        maHoaDonPrompt = "MA HOA DON: ";
        loaiHoaDonPrompt = "HOA DON [\"GIO\" / \"NGAY\"]: ";
        ngayLapPrompt = "NGAY LAP HOA DON: ";
        tenKhachHangPrompt = "TEN CUA KHACH HANG: ";
        maPhongPrompt = "MA PHONG: ";
        donGiaPrompt = "DON GIA: ";
        soGioThuePrompt = "SO GIO THUE: ";
        soNgayThuePrompt = "SO NGAY THUE: ";        
    }

    
    public void nhapThongTinHD() {
        screenOut.print(maHoaDonPrompt);screenOut.flush();
        String maHoaDon = keyBoardInput.nextLine();
        screenOut.print(loaiHoaDonPrompt);screenOut.flush();
        String loaiHoaDon = keyBoardInput.nextLine();
        screenOut.print(ngayLapPrompt);screenOut.flush();
        String ngayLap = keyBoardInput.nextLine();// dd/MM/yyyy
        //convert ngaySinh kiểu chuỗi thành ngaySinh 
        //kiểu java.util.Date
        Date ngayLapJava = null;
        SimpleDateFormat spDateF = new SimpleDateFormat("dd/MM/yyyy");
        try {
            ngayLapJava = spDateF.parse(ngayLap);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        screenOut.print(tenKhachHangPrompt);screenOut.flush();
        String tenKhachHang = keyBoardInput.nextLine();
        screenOut.print(maPhongPrompt);screenOut.flush();
        String maPhong = keyBoardInput.nextLine();
        screenOut.print(donGiaPrompt);screenOut.flush();
        double donGia = Double.parseDouble(keyBoardInput.nextLine());

        if("Gio".equalsIgnoreCase(loaiHoaDon)){
            screenOut.print(soGioThuePrompt); screenOut.flush();
            double soGioThue = keyBoardInput.nextDouble();
            themHDControl.taoHDTG(maHoaDon, ngayLapJava, tenKhachHang, maPhong, donGia, soGioThue);
        }
        if("Ngay".equalsIgnoreCase(loaiHoaDon)){
            screenOut.print(soNgayThuePrompt); screenOut.flush();
            double soNgayThue = keyBoardInput.nextDouble();
            themHDControl.taoHDTN(maHoaDon, ngayLapJava, tenKhachHang, maPhong, donGia, soNgayThue);
        }
        
    }
}
