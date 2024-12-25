package database;

import java.io.*;
import java.util.ArrayList;
import entity.HoaDon;
import control.InDAO;

public class ThemHDDAOFile implements InDAO {
	private File fileData = null;
	
	public ThemHDDAOFile(String fileName) {
		this.fileData = new File(fileName);
		// Create file if it doesn't exist
		if (!fileData.exists()) {
			try {
				fileData.createNewFile();
				// Initialize with empty ArrayList
				writeDataToFile(new ArrayList<HoaDon>());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void addHoaDon(HoaDon hd) {
		ArrayList<HoaDon> dsHD = getDSHD();
		dsHD.add(hd);
		writeDataToFile(dsHD);
	}
	
	@Override
	public ArrayList<HoaDon> getDSHD() {
		ArrayList<HoaDon> dsHD = new ArrayList<>();
		if (fileData.length() == 0) {
			return dsHD;
		}
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileData))) {
			dsHD = (ArrayList<HoaDon>) ois.readObject();
		} catch (EOFException e) {
			// Empty file is ok
			return dsHD;
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return dsHD;
	}
	
	@Override
	public void setDSHD(ArrayList<HoaDon> dsHD) {
		writeDataToFile(dsHD);
	}
	
	private void writeDataToFile(ArrayList<HoaDon> dsHD) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileData))) {
			oos.writeObject(dsHD);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
