package system.people;
import system.company.*;

import system.hardware.*;


import java.util.ArrayList;

import javax.swing.JOptionPane;

import system.information.Location;
import system.hardware.Equipment;
import system.hardware.Radio;
import system.information.*;



public class Customer extends Person{

	private Location location;
	private ArrayList<Equipment> equip;
	private int speedUp;
	private int speedDown;
	private double price;
	private double amtDue;
	private String address;
	private Date dueDate = new Date();
	
	
	
	private Company c;
	
	//shouldn't this class have a constructor?
	public Customer() {
		location = new Location();
		equip = new ArrayList<Equipment>();
		speedUp = 0;
		speedDown = 0;
		price = 0.0;
		amtDue = 0.0;
		address = null;
		dueDate.setMonth(1);
		dueDate.setDay(1);
		dueDate.setYear(2017);
	}
	
	//getting methods
	public Location getLoc() {
		return location;
	}
	public ArrayList<Equipment> getEquip(){
		return equip;
	}
	public int getUp() {
		return speedUp;
	}
	public int getDown() {
		return speedDown;
	}
	public double getPrice() {
		return price;
	}
	public double getAmtDue() {
		return amtDue;
	}
	public String getAddress() {
		return address;
	}
	public Date getDueDate() {
		return dueDate;
	}
	
	
	
	
	//setting methods
	public void setLoc(Location l) {
		location = l;
	}
	public void setDueDate(int month, int day, int year) {
		dueDate.setMonth(month);
		dueDate.setDay(day);
		dueDate.setYear(year);
	}
	
	public void setEquip(ArrayList<Equipment> e) {
		equip = e;
	}
	public void setUp(int i) {
		
			speedUp = i;
	
	}
	public void setDown(int i) {
		speedDown = i;
		
	}
	public void setPrice(double d) {
		price = d;
	}
	public void setAmtDue(double d) {
		amtDue = d;
	}
	public void setAddress(String a) {
		address = a;
	}
	
	
	public Radio findAP() {
		//not sure what does in here. 
		//is it suppose to look throught the customer equipment array
		//or a different array in a different class?
		//Radio r1 = new Radio();
		//company equipment list find iteration of radio to see if it is an AP check the distance to it and find the smallest distance.
		Radio r1 = new Radio();
		Radio rTemp = new Radio();
		Location lTemp = new Location();
		
		
		double minDistance =10000.0, tempDist =0.0;
		
		int i;
		for(i=0; i < c.equipmentList.size()-1; i++) {
			if(c.equipmentList.get(i) instanceof Radio) {
					rTemp = (Radio) c.equipmentList.get(i);
				if(rTemp.isAP() == true) {
					lTemp = rTemp.getLocation();
					tempDist = lTemp.calcDistance(this.location);
						if(tempDist < minDistance) {
							minDistance = tempDist;
							r1 = rTemp;
					}
				}
			}
			
			
		}
		return r1;
	}
	
	
}
