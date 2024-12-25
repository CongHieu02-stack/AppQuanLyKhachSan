package ui;

import java.io.PrintWriter;

public class ThongBaoThemMoiHDUI {
    private PrintWriter screenOut;
    
    public ThongBaoThemMoiHDUI(PrintWriter screenOut) {
        this.screenOut = screenOut;
    }
    
    public void thongBaoThemMoiHDThanhCong() {
        screenOut.println("Them hoa don thanh cong!");
    }
}
