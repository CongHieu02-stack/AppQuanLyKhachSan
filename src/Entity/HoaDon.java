package Entity;

import java.util.Date;

public abstract class HoaDon {
    private String Hoten;
    private String MaHoaDon;
    private String MaPhong;
    public float DonGia;
    private Date NgayHoaDon;

    public HoaDon() {

    }

    public HoaDon(String hoten, String mahd, String maphong, Date ngayhd, float dongia) {
        this.Hoten = hoten;
        this.MaHoaDon = mahd;
        this.MaPhong = maphong;
        this.DonGia = dongia;
        this.NgayHoaDon = ngayhd;
    }

    public abstract float TinhHD();

    public String toString() {
        return "Ma Hoa Don la: " + MaHoaDon +
                "\n Ten Khach hang: " + Hoten +
                "\n Ma Phong: " + MaPhong +
                "\n Don gia: " + DonGia
                + "\n Ngay Hoa Don: " + NgayHoaDon;
    }

    public String getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHD(String maHD) {
        this.MaHoaDon = maHD;
    }

    public Date getNgayHD() {
        return NgayHoaDon;
    }

    public void setNgayHD(Date ngayHD) {
        this.NgayHoaDon = ngayHD;
    }

    public String getTenKhach() {
        return Hoten;
    }

    public void setTenKhach(String tenKhach) {
        this.Hoten = tenKhach;
    }

    public String getMaPhong() {
        return MaPhong;
    }

    public void setMaPhong(String maPhong) {
        this.MaPhong = maPhong;
    }

    public double getDonGia() {
        return DonGia;
    }

    public void setDonGia(int donGia) {
        this.DonGia = donGia;
    }
}
