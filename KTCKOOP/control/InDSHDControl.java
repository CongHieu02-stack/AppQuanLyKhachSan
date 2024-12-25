package control;
import java.util.ArrayList;

import database.InDSHDDAOFile;

import entity.HoaDon;
import ui.InDSHDUI;


public class InDSHDControl {
    private InDSHDUI inDSHDUI = null;
	
	private InDAO inDAO = null;
	private InDSHDDAOFile inDSHDDAOFile = null;
	
	
	public InDSHDControl(InDAO inDAO , InDSHDUI inDSHDUI) {
		this.inDAO = inDAO;
		this.inDSHDUI = inDSHDUI;
	}
	
	
	public void setInDSHDDAOFile(InDSHDDAOFile inDSHDDAOFile) {
		this.inDSHDDAOFile = inDSHDDAOFile;
	}

    
	public void inDSHD() {
		ArrayList<HoaDon> dsHD;
		if (inDSHDDAOFile != null) {
			dsHD = inDSHDDAOFile.getDSHD();
		} else {
			dsHD = inDAO.getDSHD();
		}
		
		if (dsHD != null && !dsHD.isEmpty()) {
			inDSHDUI.inDSHD(dsHD);
		} else {
			inDSHDUI.inDSHDTrong();
		}
	}
}
