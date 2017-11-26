package system.hardware;

import system.information.*;

public class Equipment {
	
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
   


}
