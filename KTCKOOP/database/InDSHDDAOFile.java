package database;

import java.io.*;
import java.util.ArrayList;
import control.InDAO;
import entity.HoaDon;

public class InDSHDDAOFile implements InDAO {
	private File fileData = null;
	
	public InDSHDDAOFile(String fileName) {
		this.fileData = new File(fileName);
		// Create file if it doesn't exist
		if (!fileData.exists()) {
			try {
				fileData.createNewFile();
				// Initialize with empty ArrayList
				setDSHD(new ArrayList<HoaDon>());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public ArrayList<HoaDon> getDSHD() {
		ArrayList<HoaDon> dsHD = new ArrayList<>();
		
		if (fileData.length() == 0) {
			return dsHD;
		}
		
		try (ObjectInputStream oIS = new ObjectInputStream(new FileInputStream(fileData))) {
			dsHD = (ArrayList<HoaDon>) oIS.readObject();
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
		try (ObjectOutputStream oOS = new ObjectOutputStream(new FileOutputStream(fileData))) {
			oOS.writeObject(dsHD);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

