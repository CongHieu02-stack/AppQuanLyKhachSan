package ui;

import java.io.PrintWriter;
import java.util.Scanner;

public class XoaHDInputUI {
    private PrintWriter screenOut;
    private Scanner keyBoard;
    
    public XoaHDInputUI(PrintWriter screenOut, Scanner keyBoard) {
        this.screenOut = screenOut;
        this.keyBoard = keyBoard;
    }
    
    public String nhapMaHD() {
        screenOut.print("Nhap ma hoa don can xoa: ");
        screenOut.flush();
        return keyBoard.nextLine().trim();
    }
    
    public boolean xacNhanXoa() {
        screenOut.print("Ban co chac chan muon xoa? (Y/N): ");
        screenOut.flush();
        String answer = keyBoard.nextLine().trim().toUpperCase();
        return answer.equals("Y");
    }
}
