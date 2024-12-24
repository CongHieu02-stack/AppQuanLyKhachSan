import java.io.PrintWriter;
import java.util.Scanner;

import Control.XoaHDControl; // Đảm bảo bạn đã import đúng XoaHDControl
import Control.InDSHoaDonControl;
import Control.ThemHoaDon;
import Database.AddHdDAO;
import Database.ArrayListMockDatabase;
import Database.InDSHoaDonDAO;
import UI.InDSHoaDonCUI;
import UI.MenuCUI;
import UI.ThongBaoThemHoaDonCUI;
import UI.ThongTinHoaDon;
import UI.XoaHoaDonCUI;

public class App {
    public static void main(String[] args) {
        // Khởi tạo cơ sở dữ liệu (nếu cần thiết)
        ArrayListMockDatabase.initDatabase();

        // Khởi tạo các đối tượng cần thiết
        PrintWriter SysOutRemote = new PrintWriter(System.out);
        Scanner SysInRemote = new Scanner(System.in);

        // Khởi tạo các đối tượng DAO
        AddHdDAO themHdDAORemote = new AddHdDAO();
        InDSHoaDonDAO inDhdDAORemote = new InDSHoaDonDAO();

        // Khởi tạo các đối tượng UI
        ThongBaoThemHoaDonCUI tbThemhdCUIRemote = new ThongBaoThemHoaDonCUI(SysOutRemote);
        InDSHoaDonCUI inDShdCUIRemote = new InDSHoaDonCUI(SysOutRemote);
        XoaHoaDonCUI xoaHdCuiRemote = new XoaHoaDonCUI(SysOutRemote);

        // **Khởi tạo đối tượng XoaHDControl trước khi sử dụng**
        XoaHDControl xoaHDControl = new XoaHDControl(null); // Đảm bảo đối tượng này không bị null

        // Khởi tạo các đối tượng khác (các control và UI)
        ThemHoaDon themHdRemote = new ThemHoaDon(themHdDAORemote);
        themHdRemote.setThemDAO(themHdDAORemote);
        themHdRemote.setTbThemhdCUI(tbThemhdCUIRemote);

        InDSHoaDonControl inDSControlRemote = new InDSHoaDonControl(inDhdDAORemote, inDShdCUIRemote);
        inDSControlRemote.setInDSHDDAO(inDhdDAORemote);

        ThongTinHoaDon tthdcuiRemote = new ThongTinHoaDon(SysOutRemote, SysInRemote, themHdRemote);
        MenuCUI menuCUIRemote = new MenuCUI(SysOutRemote, SysInRemote, tthdcuiRemote);
        menuCUIRemote.setInDsHoaDon(inDSControlRemote);

        xoaHdCuiRemote.setXoaHDControl(xoaHDControl);

        xoaHdCuiRemote.xoaHoaDon("01");

        menuCUIRemote.ConTrolLop(); // Chạy menu hoặc các chức năng khác
    }
}
