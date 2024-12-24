package Database;

import Control.ThemDAO;
import Entity.HoaDon;

public class AddHdDAO extends ThemDAO {
    public AddHdDAO() {

    }

    public void ThemHoaDon(HoaDon HD) {
        ArrayListMockDatabase.InsertHoaDon(HD);
    }
}
