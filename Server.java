package system.hardware;

import java.util.ArrayList;

import system.information.Date;

public class Server extends Equipment {	
	
	 private String os;
     private String purpose;
     private  Date dateLastBackUp;
     private  ArrayList <Equipment> connDev;
    
     public Server() {
    	
    	os = "unknown";
    	purpose = "unknown";
    	dateLastBackUp = new Date();
    	connDev = new ArrayList <Equipment>();
    	
    }

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public Date getDateLastBackUp() {
		return dateLastBackUp;
	}

	public void setDateLastBackUp(Date dateLastBackUp) {
		this.dateLastBackUp = dateLastBackUp;
	}

	public ArrayList<Equipment> getConnDev() {
		return connDev;
	}

	public void setConnDev(ArrayList<Equipment> connDev) {
		this.connDev = connDev;
	}
   
	public void addDev(Equipment d ){
		for(Equipment e: connDev)
			if(d.getIdNum()==e.getIdNum()) {
				System.out.println(d.getBrand()+" "+d.getModel()+" is already listed as a connected device.");
				return;
			}
		connDev.add(d);
	}
	public void rmvDev( Equipment d){
		int i = 0;
		for(Equipment e: connDev) {
			if(d.getIdNum()==e.getIdNum()) {
				connDev.remove(i);
				System.out.println(d.getBrand()+" "+d.getModel()+" has been removed from connected devices.");
			}
			i++;
		}
		
	}


}
