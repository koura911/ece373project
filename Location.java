package system.information;

public class Location {
	private double GPS;
	private String Address;

	public double getGPS() {
		return this.GPS;
	}

	public String getAddress() {
		return this.Address;
	}

	public void setGPS(double GPS) {
		this.GPS = GPS;
	}

	public void setAddress(String Address) {
		this.Address = Address;
	}

	public double calculateDistance(Location location) {
		// TODO should be implemented
		double distance = 0.0;
		
		return distance;
	}
}
