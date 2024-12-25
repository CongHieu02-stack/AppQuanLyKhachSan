package control;
import java.util.ArrayList;

import entity.HoaDon;

/**
 * Giao diện Đối tượng Truy cập Dữ liệu để lấy dữ liệu hóa đơn
 */
public interface InDAO {

    /**
     * Lấy danh sách tất cả các hóa đơn từ nguồn dữ liệu
     * @return ArrayList chứa tất cả các đối tượng HoaDon (hóa đơn)
     */
    ArrayList<HoaDon> getDSHD();

    /**
     * Thiết lập danh sách hóa đơn
     * @param dsHD ArrayList chứa các đối tượng HoaDon cần thiết lập
     */
    void setDSHD(ArrayList<HoaDon> dsHD);
}
