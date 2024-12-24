package Entity;

import java.util.Date;

public class HoaDonGio extends HoaDon {
    private int TimeHD;

    public HoaDonGio() {

    }

    public HoaDonGio(String hoten, String mahd, String maphong, Date ngayhd, float dongia, int sogiohd) {
        super(hoten, mahd, maphong, ngayhd, dongia);
        TimeHD = sogiohd;
    }

    public float TinhHD() {
        if (TimeHD > 24 && TimeHD < 30) {
            return 24 * DonGia;
        } else if (TimeHD > 30) {
            return 0;
        } else {
            return TimeHD * DonGia;
        }
    }
}
