package control;

import java.util.ArrayList;

import database.TongHDDAOFile;
import entity.HoaDon;
import entity.HoaDonTheoGio;
import entity.HoaDonTheoNgay;
import ui.TongHDOutputUI;

public class TongHDControl {
	private TongHDDAOFile tongHDDAOFile = null;
	private TongHDOutputUI dtOutputUI = null;
	
	public TongHDControl(TongHDDAOFile tongHDDAOFile, TongHDOutputUI dtOutputUI) {
		this.tongHDDAOFile = tongHDDAOFile;
		this.dtOutputUI = dtOutputUI;
	}
	
	
	public void tinhTongDtTheoLoai() {
		int tongDTTheoGio = 0, tongDTTheoNgay = 0;
		ArrayList<HoaDon> dsHD = tongHDDAOFile.getDSHD();
		
		for (HoaDon hd : dsHD) {
			
			if(hd instanceof HoaDonTheoGio) {
				tongDTTheoGio++;;
			}
			
			if(hd instanceof HoaDonTheoNgay) {
				tongDTTheoNgay++;;
			}
			
			
		}
		
		//in
		dtOutputUI.inDTTheoLoaiHD(tongDTTheoGio, tongDTTheoNgay);
		
	}
	
	
	
}