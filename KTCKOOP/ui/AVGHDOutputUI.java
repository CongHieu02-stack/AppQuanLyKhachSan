package ui;

import java.io.PrintWriter;



public class AVGHDOutputUI {
    private PrintWriter screenOut = null;
    
    
    public AVGHDOutputUI(PrintWriter screenOut ) {
        this.screenOut = screenOut;
    }

    
    public void inAVGDtTheoThang(double avg) {
        if (avg == 0) {
            screenOut.println("Khong co hoa don nao trong thang nay!");
        } else {
            screenOut.println("Trung binh tien thue phong trong thang: " + String.format("%.2f", avg));
            screenOut.println("------------------------");
        }
    }
}
