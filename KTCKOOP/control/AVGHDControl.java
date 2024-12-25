package control;

import java.util.ArrayList;
import java.util.Calendar;
import java.io.PrintWriter;
import java.util.Scanner;

import database.AVGHDDAOFile;
import entity.HoaDon;
import ui.AVGHDOutputUI;


public class AVGHDControl {
    private AVGHDDAOFile avghdDAOFile = null;
    private AVGHDOutputUI avgHDOutputUI = null;
    private PrintWriter screenOut = new PrintWriter(System.out, true);
    private Scanner keyBoardInput = new Scanner(System.in);

    
    public AVGHDControl() {
    }

    
    public AVGHDControl(AVGHDDAOFile avghdDAOFile, AVGHDOutputUI dtOutputUI) {
        this.avghdDAOFile = avghdDAOFile;
        this.avgHDOutputUI = dtOutputUI;
    }

    
    public double tinhAVGTheoThang(int thang, int nam) {
        // Validate input parameters
        if (thang < 1 || thang > 12 || nam < 1900) {
            return 0;
        }

        double tongTien = 0;
        int soHoaDon = 0;
        ArrayList<HoaDon> dsHD = avghdDAOFile.getDSHD();

        // Calculate total and count for the given month
        for (HoaDon hoaDon : dsHD) {
            if (hoaDon.getNgayLap() != null) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(hoaDon.getNgayLap());
                
                // Check if bill is from specified month and year
                if (cal.get(Calendar.MONTH) + 1 == thang && 
                    cal.get(Calendar.YEAR) == nam) {
                    double thanhTien = hoaDon.tinhThanhTien();
                    tongTien += thanhTien;
                    soHoaDon++;
                }
            }
        }

        // Return average, rounded to nearest integer
        return soHoaDon > 0 ? Math.round(tongTien / soHoaDon) : 0;
    }

    public void tinhAVGDtTheoThang() {
        screenOut.print("Nhap thang (1-12): "); screenOut.flush();
        int thang = keyBoardInput.nextInt();
        
        screenOut.print("Nhap nam: "); screenOut.flush();
        int nam = keyBoardInput.nextInt();
        keyBoardInput.nextLine(); // consume newline
        
        double avg = tinhAVGTheoThang(thang, nam);
        avgHDOutputUI.inAVGDtTheoThang(avg);
    }
}
