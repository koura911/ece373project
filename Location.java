package system.information;

import java.lang.Math;

public class Location {
	
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


}
