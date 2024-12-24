package Entity;

import java.util.Date;

public class HoaDonNgay extends HoaDon {
    private int SoNgay;

    public HoaDonNgay() {

    }

    public HoaDonNgay(String hoten, String mahd, String maphong, Date ngayhd, float dongia, int songay) {
        super(hoten, mahd, maphong, ngayhd, dongia);
        SoNgay = songay;
    }

    public float TinhHD() {
        if (SoNgay > 7) {
            return (float) ((7 * DonGia) + (SoNgay - 7) * DonGia * 0.8);
        } else {
            return SoNgay * DonGia;
        }
    }
}
