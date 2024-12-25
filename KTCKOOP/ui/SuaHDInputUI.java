package ui;

import java.io.PrintWriter;
import java.util.Scanner;

public class SuaHDInputUI {
    private PrintWriter screenOut;
    private Scanner keyBoard;
    
    public SuaHDInputUI(PrintWriter screenOut, Scanner keyBoard) {
        this.screenOut = screenOut;
        this.keyBoard = keyBoard;
    }
    
    public String nhapMaHD() {
        screenOut.print("Nhap ma hoa don can sua: ");
        screenOut.flush();
        return keyBoard.nextLine().trim();
    }
    
    public String nhapTenKH() {
        screenOut.print("Nhap ten khach hang moi: ");
        screenOut.flush();
        return keyBoard.nextLine().trim();
    }
    
    public String nhapMaPhong() {
        screenOut.print("Nhap ma phong moi: ");
        screenOut.flush();
        return keyBoard.nextLine().trim();
    }
    
    public String nhapLoaiHD() {
        screenOut.print("Nhap loai hoa don (GIO/NGAY): ");
        screenOut.flush();
        return keyBoard.nextLine().trim().toUpperCase();
    }
    
    public double nhapDonGia() {
        screenOut.print("Nhap don gia moi: ");
        screenOut.flush();
        double donGia = keyBoard.nextDouble();
        keyBoard.nextLine(); // consume newline
        return donGia;
    }
    
    public double nhapSoGio() {
        screenOut.print("Nhap so gio thue: ");
        screenOut.flush();
        double soGio = keyBoard.nextDouble();
        keyBoard.nextLine(); // consume newline
        return soGio;
    }
    
    public double nhapSoNgay() {
        screenOut.print("Nhap so ngay thue: ");
        screenOut.flush();
        double soNgay = keyBoard.nextDouble();
        keyBoard.nextLine(); // consume newline
        return soNgay;
    }
    
    public String nhapNgayLap() {
        screenOut.print("Nhap ngay lap moi (dd/MM/yyyy): ");
        screenOut.flush();
        return keyBoard.nextLine().trim();
    }
}
