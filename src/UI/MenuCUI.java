package UI;

import java.io.PrintWriter;
import java.util.Scanner;

import Control.XoaHDControl;
import Control.InDSHoaDonControl;
import Control.TimHoaDonControl;
import Database.ArrayListMockDatabase;
import Entity.HoaDon;

public class MenuCUI {
    private PrintWriter SysOut;
    private Scanner SysIn;
    private ThongTinHoaDon ttHD;
    private InDSHoaDonControl inDShdControl;
    private XoaHDControl XoaHDControl;
    private ArrayListMockDatabase Arr;
    private TimHoaDonControl timHD;

    public MenuCUI() {
        SysOut = new PrintWriter(System.out);
    }

    public void setInDsHoaDon(InDSHoaDonControl indshoadoncontrol) {
        inDShdControl = indshoadoncontrol;
    }

    public MenuCUI(PrintWriter systemout, Scanner systemin) {
        SysOut = systemout;
        SysIn = systemin;
    }

    public MenuCUI(PrintWriter systemout, Scanner systemin, ThongTinHoaDon thongtinhoadon) {
        this(systemout, systemin);
        ttHD = thongtinhoadon;

    }

    public void ConTrolLop() {
        SysOut.println("~ Chuc nang ~");
        SysOut.println("1.Them");
        SysOut.println("2.Xoa");
        SysOut.println("3.Sua");
        SysOut.println("4.Tim Kiem");
        SysOut.println("5.Tinh Tong So Luong Tung Loai Thue Phong");
        SysOut.println("6.Tinh Trung Binh Thanh Tien Cua Tung Hoa Don");
        SysOut.println("7.In Danh Sach Hoa Don");
        while (true) {
            SysOut.print("Nhap vao chuc nang: ");
            SysOut.flush();
            String command = SysIn.nextLine();// user nhập vào từ bàn phím
            command = command.trim();
            if ("1".equalsIgnoreCase(command)) {
                ThemHD();
                continue;
            }

            if ("2".equalsIgnoreCase(command)) {
                XoaHoaDon();
                continue;
            }
            if ("4".equalsIgnoreCase(command)) {
                TimHoaDon();
                continue;
            }
            if ("7".equalsIgnoreCase(command)) {
                inDSHD();
                continue;
            }
            if ("8".equalsIgnoreCase(command)) {

                break;
            }
        }

    }

    public void ThemHD() {
        ttHD.Them();
    }

    private void inDSHD() {
        inDShdControl.inDsHD();
    }

    public void XoaHoaDon() {
        SysOut.print("Nhap ma hoa don can xoa: ");
        SysOut.flush();
        String maHD = SysIn.nextLine();
        XoaHDControl.XoaHD(maHD);
    }

    public void TimHoaDon() {
        SysOut.print("Nhập mã hóa đơn cần tìm: ");
        SysOut.flush();
        String maHD = SysIn.nextLine();
        HoaDon HD = Arr.timHoaDonTheoMa(maHD);
        if (HD != null) {
            System.out.println("Mã HD: " + HD.getMaHoaDon());
            System.out.println("Ngày HD: " + HD.getNgayHD());
            System.out.println("Tên khách: " + HD.getTenKhach());
            System.out.println("Mã phòng: " + HD.getMaPhong());
            System.out.println("Đơn giá: " + HD.getDonGia());
            System.out.println("Thành tiền: " + HD.TinhHD());
        } else {
            System.out.println("Không tìm thấy hóa đơn!");
        }
    }
}
