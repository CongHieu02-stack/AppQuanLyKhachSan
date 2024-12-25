package ui;

import java.io.PrintWriter;

public class TongHDOutputUI {
	
	private PrintWriter screenOut;
	
	public TongHDOutputUI(PrintWriter _screenOut) {
		screenOut = _screenOut;
	}
	
	public void inDTTheoLoaiHD(int tongDTTheoGio, int tongDTTheoNgay) {
		screenOut.println("Tong so hoa don theo gio: " + tongDTTheoGio);
		screenOut.println("Tong so hoa don theo ngay: " + tongDTTheoNgay);
	}

}
