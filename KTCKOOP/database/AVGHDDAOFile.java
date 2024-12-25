package database;

import java.io.*;
import java.util.ArrayList;
import entity.HoaDon;
import control.InDAO;

public class AVGHDDAOFile implements InDAO {
    private File fileData = null;
    
    public AVGHDDAOFile(String fileName) {
        this.fileData = new File(fileName);
        if (!fileData.exists()) {
            try {
                fileData.createNewFile();
                setDSHD(new ArrayList<HoaDon>());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    @Override
    public ArrayList<HoaDon> getDSHD() {
        ArrayList<HoaDon> dsHD = new ArrayList<>();
        if (fileData.length() > 0) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileData))) {
                dsHD = (ArrayList<HoaDon>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return dsHD;
    }
    
    @Override
    public void setDSHD(ArrayList<HoaDon> dsHD) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileData))) {
            oos.writeObject(dsHD);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
} 