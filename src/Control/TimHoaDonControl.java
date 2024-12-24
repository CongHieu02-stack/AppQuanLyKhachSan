package Control;

import Database.ArrayListMockDatabase;
import Entity.HoaDon;

public class TimHoaDonControl {
    private ArrayListMockDatabase ArrayListHD = null;

    public HoaDon timHoaDonTheoMa(String maHD) {
        return ArrayListHD.timHoaDonTheoMa(maHD);
    }
}
