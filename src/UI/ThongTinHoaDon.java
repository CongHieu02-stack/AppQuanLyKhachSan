package UI;

import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import Control.ThemHoaDon;
import java.util.Date;

public class ThongTinHoaDon {
private PrintWriter SysOut = null;
private Scanner SysIn = null;
private String MaHoaDonPrompt,NgayHoaDonPrompt, TenKhachHangPrompt, MaPhongPrompt, DonGiaPrompt;
private SimpleDateFormat DateHoaDon = null;
private ThemHoaDon themHoaDon = null;
public ThongTinHoaDon()
{

}
public ThongTinHoaDon(PrintWriter sysout, 
Scanner sysin, ThemHoaDon themhoadoncontrol ) {

this(sysout, sysin);
themHoaDon = themhoadoncontrol;

}
public ThongTinHoaDon(PrintWriter _SysOut, Scanner _SysIn)
{
    SysOut = _SysOut;
    SysIn = _SysIn;
    MaHoaDonPrompt = "Ma Hoa Don: ";
    NgayHoaDonPrompt = "Ngay Hoa Don(dd/MM/yyyy): ";
    TenKhachHangPrompt = "Ten Khach Hang: ";
    MaPhongPrompt = "Ma Phong: ";
    DonGiaPrompt = "Don Gia: ";
    DateHoaDon = new SimpleDateFormat("dd/MM/yyyy");
}

public void Them()
{ 
    SysOut.println("Nhap Loai hoa don");
    SysOut.flush();
    SysOut.println("G.Hoa Don Gio");
    SysOut.flush();
    SysOut.println("N.Hoa Don Ngay");
    SysOut.flush();
    SysOut.print("====> ");
    SysOut.flush();
    String LoaiHD = SysIn.nextLine();
    SysOut.print(TenKhachHangPrompt);
    SysOut.flush();
    String HoTen = SysIn.nextLine();
    SysOut.print(MaHoaDonPrompt);
    SysOut.flush();
    String MaHoaDon = SysIn.nextLine();
    SysOut.print(MaPhongPrompt);
    SysOut.flush();
    String MaPhong = SysIn.nextLine();
    SysOut.print(NgayHoaDonPrompt);
    SysOut.flush();
    String NgayThangHD = SysIn.nextLine();
    Date NgayHD = null;
    try
    {
        NgayHD = DateHoaDon.parse(NgayThangHD);
    } catch(ParseException e)
    {
        e.printStackTrace();
    }
    SysOut.print(DonGiaPrompt);
    SysOut.flush();
    int DonGia = SysIn.nextInt();

    if("G".equalsIgnoreCase(LoaiHD))
    {
        SysOut.print("Nhap So Gio thue: ");
        SysOut.flush();
        int TimeHD = SysIn.nextInt();
        themHoaDon.TaoHoaDonG(HoTen, MaHoaDon, MaPhong, NgayHD, DonGia, TimeHD);
        
    }
    if("N".equalsIgnoreCase(LoaiHD))
    {
        SysOut.print("Nhap So Ngay Thue: ");
        SysOut.flush();
        int DateHD = SysIn.nextInt();
        themHoaDon.TaoHoaDonN(HoTen, MaHoaDon, MaPhong, NgayHD, DonGia, DateHD);
        
    }
 
}
}