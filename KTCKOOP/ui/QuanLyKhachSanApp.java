package ui;
import java.io.PrintWriter;
import java.util.Scanner;

import control.AVGHDControl;
import control.InDSHDControl;
import control.ThemMoiHDControl;
import control.SuaHDControl;
import control.TimKiemHDControl;
import control.XoaHDControl;
import database.AVGHDDAOFile;
import database.ArrayListCoSoDuLieu;
import database.InDSHDDAOFile;
import database.ThemHDDAOFile;
import database.TongHDDAOFile;
import database.TimKiemHDDAOFile;
import database.XoaHDDAOFile;
import database.SuaHDDAOFile;
import control.TongHDControl;


public class QuanLyKhachSanApp {
/* Điểm vào chính:
* 1. Khởi tạo cơ sở dữ liệu
* 2. Tạo các đối tượng DAO để truy cập cơ sở dữ liệu
* 3. Tạo các đối tượng Bộ điều khiển và kết nối chúng với DAO
* 4. Tạo các đối tượng UI để tương tác với người dùng
* 5. Kết nối mọi thứ lại với nhau
* 6. Bắt đầu vòng lặp điều khiển chính
*/
    public static void main(String[] args) {
        // Khởi tạo cơ sở dữ liệu với dữ liệu mẫu
        ArrayListCoSoDuLieu.initDatabase();
        
        
        String dataFile = "HD.data";
        InDSHDDAOFile inDSHDDAOFile = new InDSHDDAOFile(dataFile);
        AVGHDDAOFile avgHDDAOFile = new AVGHDDAOFile(dataFile);        
        TongHDDAOFile tongHDDAOFile = new TongHDDAOFile(dataFile);        
        TimKiemHDDAOFile timKiemHDDAOFile = new TimKiemHDDAOFile(dataFile);
        ThemHDDAOFile themHDDAOFile = new ThemHDDAOFile(dataFile);
        XoaHDDAOFile xoaHDDAOFile = new XoaHDDAOFile(dataFile);
        SuaHDDAOFile suaHDDAOFile = new SuaHDDAOFile(dataFile);

        // Thiết lập luồng I/O cho tương tác của người dùng
        PrintWriter screenOutRemote = new PrintWriter(System.out, true);
        Scanner keyBoardInputRemote = new Scanner(System.in);

        // Đầu tiên hãy tạo các thành phần UI
        InDSHDUI inDSHDUI = new InDSHDUI(screenOutRemote);  
        TongHDOutputUI tongHDOutputUI = new TongHDOutputUI(screenOutRemote);              
        AVGHDOutputUI avgHDOutputUI = new AVGHDOutputUI(screenOutRemote);
        SuaHDInputUI suaHDUI = new SuaHDInputUI(screenOutRemote, keyBoardInputRemote);
        SuaHDOutputUI suaHDOutputUI = new SuaHDOutputUI(screenOutRemote);
        TimKiemHDUI timKiemHDUI = new TimKiemHDUI(screenOutRemote, keyBoardInputRemote);
        XoaHDInputUI xoaHDInputUI = new XoaHDInputUI(screenOutRemote, keyBoardInputRemote);
        XoaHDOutputUI xoaHDOutputUI = new XoaHDOutputUI(screenOutRemote);

        // Sau đó tạo bộ điều khiển
        ThemMoiHDControl themHDControlRemote = new ThemMoiHDControl(themHDDAOFile);
        AVGHDControl avgHDControlRemote = new AVGHDControl(avgHDDAOFile, avgHDOutputUI);
        TongHDControl tongHDControlRemote = new TongHDControl(tongHDDAOFile, tongHDOutputUI);
        SuaHDControl suaHDControl = new SuaHDControl(suaHDDAOFile, suaHDUI, suaHDOutputUI);
        TimKiemHDControl timKiemHDControl = new TimKiemHDControl(timKiemHDDAOFile, timKiemHDUI);
        XoaHDControl xoaHDControl = new XoaHDControl(xoaHDDAOFile, xoaHDInputUI, xoaHDOutputUI);

        // Tạo và cấu hình bộ điều khiển hiển thị hóa đơn
        InDSHDControl inDSHDControl = new InDSHDControl(inDSHDDAOFile, inDSHDUI);
        inDSHDControl.setInDSHDDAOFile(inDSHDDAOFile);

        // Tạo và cấu hình UI cho thông báo hóa đơn mới
        ThongBaoThemMoiHDUI tbThemMoiHD = new ThongBaoThemMoiHDUI(screenOutRemote);
        themHDControlRemote.setThongBaoThemMoiHDUI(tbThemMoiHD);

        // Tạo UI để thêm hóa đơn mới
        ThemMoiHDUI themMoiHDUIRemote = new ThemMoiHDUI(screenOutRemote, 
                keyBoardInputRemote, themHDControlRemote);
        
        // Tạo và cấu hình giao diện người dùng menu chính
        MainMenuUI mainMenuUIRemote = new MainMenuUI(screenOutRemote, 
                keyBoardInputRemote, themMoiHDUIRemote);
        mainMenuUIRemote.setInDSHD(inDSHDControl);
        mainMenuUIRemote.setTongHDRemote(tongHDControlRemote);
        mainMenuUIRemote.setSuaHDControl(suaHDControl);
        mainMenuUIRemote.setTimKiemHDControl(timKiemHDControl);
        mainMenuUIRemote.setXoaHDControl(xoaHDControl);
        mainMenuUIRemote.setAVGHDRemote(avgHDControlRemote);

        // Bắt đầu vòng lặp ứng dụng chính
        mainMenuUIRemote.controlLoop();
    }
}
