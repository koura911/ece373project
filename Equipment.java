package system.hardware;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


import system.information.*;

public class Equipment implements Serializable {
	
    private String name;
    private String model;
    private String brand;
    private String serialNumber;
    private int idNum;
    private Date dateInstalled; //format mm dd yy
    private Location location;
    
    public Equipment() {
    	name = "unknown";
    	model = "unknown";
    	brand = "unknown";
    	serialNumber = "unknown";
    	idNum = 0;
    	dateInstalled = new Date();
    	location = new Location();
    	
    	
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public int getIdNum() {
		return idNum;
	}
	public void setIdNum(int idNum) {
		this.idNum = idNum;
	}
	public Date getDateInstalled() {
		return dateInstalled;
	}
	public void setDateInstalled(Date i) {
		this.dateInstalled = i;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
   
	public static void saveData(Equipment e) {
		FileOutputStream fileOut = null;
		ObjectOutputStream objOut = null;
		
		try {
			fileOut = new FileOutputStream("company.ser");
			objOut = new ObjectOutputStream(fileOut);
			objOut.writeObject(e);
			objOut.close();
			fileOut.close();
		}
		
		catch(IOException i) {
			i.printStackTrace();
		}
	}
	
	public static Equipment loadData() {
		FileInputStream fileIn = null;
		ObjectInputStream objIn = null;
		Equipment e1 = null;
		
		try {
			fileIn = new FileInputStream("university.ser");
			objIn = new ObjectInputStream(fileIn);
			e1 = (Equipment) objIn.readObject();
			objIn.close();
			fileIn.close();
		}
		
		catch (IOException i) {
			i.printStackTrace();
		}
		
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return e1;
	}

}
