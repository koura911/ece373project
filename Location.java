package system.information;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.Math;

public class Location implements Serializable {
	
    private double  gpsLat;//should be entered as degrees decimal
    private double gpsLon;
    private String Address;
    
    public Location() {
    	gpsLat = 0.0;
    	gpsLon = 0.0;
    	Address = "unknown";
    }
    
    
   
    public double getGpsLat() {
		return gpsLat;
	}



	public void setGpsLat(double gpsLat) {
		this.gpsLat = gpsLat;
	}



	public double getGpsLon() {
		return gpsLon;
	}



	public void setGpsLon(double gpsLon) {
		this.gpsLon = gpsLon;
	}



	public String getAddress() {
		return Address;
	}



	public void setAddress(String address) {
		Address = address;
	}



	public  double calcDistance(Location l){
		double theta1 = Math.toRadians(gpsLat), theta2 = Math.toRadians(l.getGpsLat()), delta = Math.toRadians((l.getGpsLon()-gpsLon)), R = 6371e3; // gives d in meters
		double d = Math.acos( Math.sin(theta1)*Math.sin(theta2) + Math.cos(theta1)*Math.cos(theta2) * Math.cos(delta))  * R;
		return d; // returns distance in meters
		
	}

	public static void saveData(Location l) {
		FileOutputStream fileOut = null;
		ObjectOutputStream objOut = null;
		
		try {
			fileOut = new FileOutputStream("company.ser");
			objOut = new ObjectOutputStream(fileOut);
			objOut.writeObject(l);
			objOut.close();
			fileOut.close();
		}
		
		catch(IOException i) {
			i.printStackTrace();
		}
	}
	
	public static Location loadData() {
		FileInputStream fileIn = null;
		ObjectInputStream objIn = null;
		Location l1 = null;
		
		try {
			fileIn = new FileInputStream("company.ser");
			objIn = new ObjectInputStream(fileIn);
			l1 = (Location) objIn.readObject();
			objIn.close();
			fileIn.close();
		}
		
		catch (IOException i) {
			i.printStackTrace();
		}
		
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return l1;
	}
}
