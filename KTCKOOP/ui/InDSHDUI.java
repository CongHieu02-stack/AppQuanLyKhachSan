package ui;
import java.io.PrintWriter;
import java.util.ArrayList;

import entity.HoaDon;
import entity.HoaDonTheoGio;
import entity.HoaDonTheoNgay;


public class InDSHDUI {
    
    private PrintWriter screenOut = null;
	
    
	public InDSHDUI(PrintWriter screenOut ) {
		this.screenOut = screenOut;
	}

    
	public void inDSHD(ArrayList<HoaDon> dsHD) {
		for (HoaDon hoaDon : dsHD) {
			screenOut.println("Ma hoa don: " + hoaDon.getmaHoaDon());
			screenOut.println("Loai hoa don: " + hoaDon.getLoaiHoaDon());
			screenOut.println("Ngay lap: " + hoaDon.getNgayLap());
			screenOut.println("Ten khach hang: " + hoaDon.getTenKhachHang());
			screenOut.println("Ma phong: " + hoaDon.getMaPhong());
			screenOut.println("Don gia: " + hoaDon.getDonGia());
			if (hoaDon instanceof HoaDonTheoGio) {
				screenOut.println("So gio thue: " + ((HoaDonTheoGio)hoaDon).getSoGioThue());
			}
			if (hoaDon instanceof HoaDonTheoNgay) {
				screenOut.println("So ngay thue: " + ((HoaDonTheoNgay)hoaDon).getSoNgayThue()); 
			}
			screenOut.println("Thanh tien: " + hoaDon.tinhThanhTien());
			screenOut.println("------------------------");
		}
	}

	public void inDSHDTrong() {
		screenOut.println("Danh sach hoa don trong!");
	}
}
