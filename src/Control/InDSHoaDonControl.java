package Control;

import java.util.ArrayList;

import Database.InDSHoaDonDAO;
import Entity.HoaDon;
import UI.InDSHoaDonCUI;

public class InDSHoaDonControl {
    private InDSHoaDonCUI indshdCUI = null;
    private InDAO indshdDAO = null;

    public InDSHoaDonControl() {

    }

    public InDSHoaDonControl(InDAO indshddao, InDSHoaDonCUI indshdcui) {
        indshdCUI = indshdcui;
        this.indshdDAO = indshddao;
    }

    public void setInDSHDDAO(InDAO INDAO) {
        this.indshdDAO = INDAO;
    }

    public void inDsHD() {
        ArrayList<HoaDon> dshd = indshdDAO.getAllHd();
        indshdCUI.indshd(dshd);
    }
}
