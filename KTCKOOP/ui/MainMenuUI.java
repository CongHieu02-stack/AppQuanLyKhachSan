package ui;

import java.io.PrintWriter;
import java.util.Scanner;

import control.AVGHDControl;
import control.TongHDControl;
import control.InDSHDControl;
import control.SuaHDControl;
import control.TimKiemHDControl;
import control.XoaHDControl;


public class MainMenuUI {
    private PrintWriter screenOut = null;        
    private Scanner keyBoardInput = null;        
    private String loiNhac = "->";               
    private String command = " ";                
    private ThemMoiHDUI themHDUIRemote = null;
    private InDSHDControl inDSHD = null;
    private AVGHDControl avgHDRemote = null; 
    private TongHDControl tongHDRemote = null;
    private SuaHDControl suaHDControl = null;
    private TimKiemHDControl timKiemHDControl = null;
    private XoaHDControl xoaHDControl = null;
    
    public MainMenuUI() {
        
    }
    
    public MainMenuUI(PrintWriter _screenOut, Scanner _keyBoardInput,
			ThemMoiHDUI _themMoiHDUI) {
		this(_screenOut, _keyBoardInput);
		themHDUIRemote = _themMoiHDUI;
	}
    
    /**
     * Trình xây dựng khởi tạo đầu ra màn hình và đầu vào bàn phím
     */
    public MainMenuUI(PrintWriter _screenOut, Scanner _keyBoardInput) {
        screenOut = _screenOut;
        keyBoardInput = _keyBoardInput;
    }

    
    public void controlLoop() {
        screenOut.println("go lenh \"help\" de duoc ho tro");
        screenOut.flush();
        
        while(true) {
            screenOut.print(loiNhac);
            screenOut.flush();
            command = keyBoardInput.nextLine();
            command = command.trim();
            
            if("help".equalsIgnoreCase(command)) {
                help();
                continue;
            }

            if("add".equalsIgnoreCase(command)) {
				addSV();
				continue;
			}

            if("sum".equalsIgnoreCase(command)){
                sumHD();
                continue;
            }
            
            if("avg".equalsIgnoreCase(command)) {
                avgHD();
                continue;
            }

            if("show".equalsIgnoreCase(command)) {
                inDSHD();
                continue;
            }

            if("edit".equalsIgnoreCase(command)) {
                suaHD();
                continue;
            }

            if("search".equalsIgnoreCase(command)) {
                timKiemHD();
                continue;
            }

            if("delete".equalsIgnoreCase(command)) {
                xoaHD();
                continue;
            }

            if("exit".equalsIgnoreCase(command)){
                break;
            }
        }
    }

    private void inDSHD() {
        inDSHD.inDSHD();                
    }

    public void setInDSHD(InDSHDControl inDSHDControl) {
        this.inDSHD = inDSHDControl;  // Đảm bảo set đúng đối tượng
    }
    
    private void help() {
        screenOut.println("~~~~~Console Help Menu~~~~~");
        screenOut.println("[HELP] Ho tro su dung phan mem");
        screenOut.println("[ADD] Them hoa don");
        screenOut.println("[DELETE] Xoa hoa don");
        screenOut.println("[EDIT] Sua hoa don");
        screenOut.println("[SEARCH] Tim kiem hoa don");
        screenOut.println("[SUM] Tinh tong");
        screenOut.println("[AVG] Tinh trung binh");
        screenOut.println("[SHOW] In hoa don");
        screenOut.println("[EXIT] Thoat khoi phan mem");
        screenOut.println("~~~~~Console Help Menu~~~~~");
    }

    private void addSV() {
		themHDUIRemote.nhapThongTinHD();
	}
    
    private void sumHD() {
        tongHDRemote.tinhTongDtTheoLoai();
    }

    public void setTongHDRemote(TongHDControl tongHDControl) {
        this.tongHDRemote = tongHDControl;
    }
    
    private void avgHD() {
        avgHDRemote.tinhAVGDtTheoThang();
    }

    public void setAVGHDRemote(AVGHDControl avgHDControl) {
        this.avgHDRemote = avgHDControl;
    }

    public void setSuaHDControl(SuaHDControl suaHDControl) {
        this.suaHDControl = suaHDControl;
    }

    private void suaHD() {
        suaHDControl.suaHoaDon();
    }

    public void setTimKiemHDControl(TimKiemHDControl timKiemHDControl) {
        this.timKiemHDControl = timKiemHDControl;
    }

    private void timKiemHD() {
        timKiemHDControl.timHoaDon();
    }

    public void setXoaHDControl(XoaHDControl xoaHDControl) {
        this.xoaHDControl = xoaHDControl;
    }

    private void xoaHD() {
        xoaHDControl.xoaHoaDon();
    }

}
