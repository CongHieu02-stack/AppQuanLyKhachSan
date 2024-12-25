package ui;

import java.io.PrintWriter;

public class ThongBaoTimKiemHDUI {
    private PrintWriter screenOutput = null;
    
    public ThongBaoTimKiemHDUI() {
        
    }
    
    public ThongBaoTimKiemHDUI(PrintWriter _screenOutput) {
        screenOutput = _screenOutput;
    }
    
    public void inThongBao(String thongBao) {
        screenOutput.println(thongBao);
    }
}
