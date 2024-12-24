package Database;

import java.util.ArrayList;

import Control.InDAO;
import Entity.HoaDon;
import UI.InDSHoaDonCUI;

public class InDSHoaDonDAO implements InDAO {
    public InDSHoaDonDAO() {

    }

    public ArrayList<HoaDon> getAllHd() {
        return ArrayListMockDatabase.getAllHd();
    }

}
